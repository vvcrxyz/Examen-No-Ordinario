package logica;

import conexion.ConexionBD;
import dao.MesaDAO;
import dto.MesaDTO;
import entidades.MesaEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Lógica de negocio para gestionar mesas en el sistema de reservas.
 * Esta clase maneja las operaciones relacionadas con las mesas,
 * incluyendo la conversión entre objetos DTO y entidades, y la comunicación
 * con la capa de acceso a datos a través de la clase MesaDAO.
 */
public class MesaNegocio {
    
    private final MesaDAO mesaDAO;

    /**
     * Constructor de la clase MesaNegocio.
     * Inicializa el objeto MesaDAO necesario para realizar las operaciones de base de datos.
     */
    public MesaNegocio() {
        this.mesaDAO = new MesaDAO();
    }

    /**
     * Convierte un objeto MesaDTO a un objeto MesaEntidad.
     * 
     * @param dto El objeto MesaDTO a convertir.
     * @return El objeto MesaEntidad correspondiente.
     */
    private MesaEntidad convertir(MesaDTO dto) {
        MesaEntidad entidad = new MesaEntidad();
        entidad.setCodigoMesa(dto.getCodigoMesa());
        entidad.setTipo(dto.getTipo());
        entidad.setCapacidad(dto.getCapacidad()); 
        entidad.setUbicacion(dto.getUbicacion()); 
        return entidad;
    }

    /**
     * Convierte un objeto MesaEntidad a un objeto MesaDTO.
     * 
     * @param entidad El objeto MesaEntidad a convertir.
     * @return El objeto MesaDTO correspondiente.
     */
    private MesaDTO convertir(MesaEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new MesaDTO(entidad);
    }

    /**
     * Guarda una mesa en la base de datos.
     * 
     * @param c El objeto MesaDTO que representa la mesa a guardar.
     */
    public void guardarMesa(MesaDTO c) {
        mesaDAO.guardarMesa(convertir(c));
    }

    /**
     * Modifica una mesa en la base de datos.
     * 
     * @param c El objeto MesaDTO que representa la mesa a modificar.
     */
    public void modificarMesa(MesaDTO c) {
        mesaDAO.modificarMesa(convertir(c));
    }

    /**
     * Elimina una mesa de la base de datos.
     * 
     * @param c El objeto MesaDTO que representa la mesa a eliminar.
     */
    public void eliminarMesa(MesaDTO c) {
        mesaDAO.eliminarMesa(convertir(c));
    }

    /**
     * Busca una mesa por su ID en la base de datos.
     * 
     * @param id El ID de la mesa a buscar.
     * @return Un objeto MesaDTO correspondiente a la mesa encontrada, o null si no se encuentra.
     */
    public MesaDTO buscarCliente(Long id) {
        MesaEntidad entidad = mesaDAO.buscarUnaMesa(id);
        return convertir(entidad);
    }

    /**
     * Busca todas las mesas en la base de datos y las devuelve como una lista de objetos MesaDTO.
     * 
     * @return Una lista de objetos MesaDTO que representan todas las mesas encontradas.
     */
    public List<MesaDTO> buscarTodasMesas() {
        List<MesaEntidad> entidades = mesaDAO.buscarTodasMesas();
        List<MesaDTO> mesas = new ArrayList<>();

        for (MesaEntidad entidad : entidades) {
            mesas.add(convertir(entidad));
        }
        return mesas;
    }
    
    /**
     * Busca una mesa disponible en función de la ubicación, número de personas y hora de reserva.
     * 
     * @param ubicacion La ubicación de la mesa.
     * @param numPersonas El número de personas que requiere la mesa.
     * @param fechaHora La fecha y hora en la que se desea realizar la reserva.
     * @return Un objeto MesaDTO correspondiente a una mesa disponible, o null si no se encuentra ninguna mesa disponible.
     */
    public MesaDTO buscarMesaDisponible(String ubicacion, int numPersonas, LocalDateTime fechaHora) {
        // Lista de mesas disponibles
        List<MesaDTO> mesasDisponibles = obtenerMesasPorUbicacionYCapacidad(ubicacion, numPersonas);

        // Verificar la disponibilidad de las mesas
        for (MesaDTO mesa : mesasDisponibles) {
            boolean estaDisponible = verificarDisponibilidadMesa(mesa, fechaHora);
            if (estaDisponible) {
                return mesa; // Retorna la primera mesa disponible encontrada
            }
        }

        // Si no se encuentra ninguna mesa disponible
        return null;
    }
    
    /**
     * Obtiene las mesas filtradas por ubicación y capacidad desde la base de datos.
     * 
     * @param ubicacion La ubicación de las mesas a buscar.
     * @param numPersonas El número de personas que se espera en la mesa.
     * @return Una lista de objetos MesaDTO que representan las mesas filtradas.
     */
    private List<MesaDTO> obtenerMesasPorUbicacionYCapacidad(String ubicacion, int numPersonas) {
        // Consulta a la base de datos para obtener las mesas filtradas
        String query = "SELECT * FROM Mesas WHERE ubicacion = ? AND capacidad >= ?";
        List<MesaDTO> mesas = new ArrayList<>();
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, ubicacion);
            stmt.setInt(2, numPersonas);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                MesaDTO mesa = new MesaDTO(
                    rs.getString("codigoMesa"),
                    rs.getString("tipo"),
                    rs.getInt("capacidad"),
                    rs.getString("ubicacion")
                );

                mesas.add(mesa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mesas;
    }
    
    /**
     * Verifica si una mesa está disponible en una fecha y hora específicas.
     * 
     * @param mesa El objeto MesaDTO que representa la mesa a verificar.
     * @param fechaHora La fecha y hora de la reserva que se desea comprobar.
     * @return true si la mesa está disponible, false si ya tiene una reserva en ese horario.
     */
    private boolean verificarDisponibilidadMesa(MesaDTO mesa, LocalDateTime fechaHora) {
        // Consulta a la base de datos para verificar si la mesa tiene reservas en conflicto
        String query = "SELECT COUNT(*) AS total FROM Reservas WHERE idMesa = ? AND fechaHoraReserva = ?";
        boolean disponible = false;
        ConexionBD conexionBD = new ConexionBD();
        try (Connection conn = conexionBD.crearConexion();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setString(1, mesa.getCodigoMesa());
            stmt.setTimestamp(2, Timestamp.valueOf(fechaHora));

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int total = rs.getInt("total");
                disponible = (total == 0); // Si no hay reservas, la mesa está disponible
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return disponible;
    }
    
    private static final AtomicInteger contador = new AtomicInteger(0);

    /**
     * Genera un número único de tres dígitos para identificar las mesas.
     * 
     * @return Un número único de tres dígitos en formato de cadena.
     */
    public static String obtenerNumeroUnico() {
        // Incrementa el contador y garantiza que esté dentro del rango de tres dígitos.
        int numero = contador.incrementAndGet();
        if (numero > 999) {
            contador.set(0); // Reinicia si supera 999.
            numero = contador.incrementAndGet();
        }
        return String.format("%03d", numero); // Asegura formato de tres dígitos.
    }

}
