/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 *
 * @author limon
 */
public class MesaNegocio {
    
    private final MesaDAO mesaDAO;

    // Constructor
    public MesaNegocio() {
        this.mesaDAO = new MesaDAO();
    }

    // Conversión de ClienteDTO a ClienteEntidad
    private MesaEntidad convertir(MesaDTO dto) {
        MesaEntidad entidad = new MesaEntidad();
        entidad.setCodigoMesa(dto.getCodigoMesa());
        entidad.setTipo(dto.getTipo());
        entidad.setCapacidad(dto.getCapacidad()); 
        entidad.setUbicacion(dto.getUbicacion()); 
        return entidad;
    }

    // Conversión de ClienteEntidad a ClienteDTO
    private MesaDTO convertir(MesaEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new MesaDTO(entidad);
    }

    // Guardar un cliente
    public void guardarMesa(MesaDTO c) {
        mesaDAO.guardarMesa(convertir(c));
    }

    // Modificar un cliente
    public void modificarMesa(MesaDTO c) {
        mesaDAO.modificarMesa(convertir(c));
    }

    // Eliminar un cliente
    public void eliminarMesa(MesaDTO c) {
        mesaDAO.eliminarMesa(convertir(c));
    }

    // Buscar una mesa por ID
    public MesaDTO buscarCliente(Long id) {
        MesaEntidad entidad = mesaDAO.buscarUnaMesa(id);
        return convertir(entidad);
    }

    // Buscar todos los clientes
    public List<MesaDTO> buscarTodasMesas() {
        List<MesaEntidad> entidades = mesaDAO.buscarTodasMesas();
        List<MesaDTO> mesas = new ArrayList<>();

        for (MesaEntidad entidad : entidades) {
            mesas.add(convertir(entidad));
        }
        return mesas;
    }
    
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
