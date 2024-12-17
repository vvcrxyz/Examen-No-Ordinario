package logica;

import dao.ReservaDAO;
import dto.ClienteDTO;
import dto.MesaDTO;
import dto.ReservaDTO;
import entidades.ClienteEntidad;
import entidades.MesaEntidad;
import entidades.ReservaEntidad;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Clase de negocio para gestionar las reservas en el sistema.
 * Esta clase se encarga de realizar la conversión entre objetos DTO (Data Transfer Object)
 * y entidades, y delega las operaciones correspondientes al DAO (Data Access Object).
 */
public class ReservaNegocio {

    private final ReservaDAO reservaDAO;

    /**
     * Constructor de la clase ReservaNegocio.
     * Inicializa el objeto ReservaDAO necesario para realizar las operaciones de base de datos.
     */
    public ReservaNegocio() {
        this.reservaDAO = new ReservaDAO();
    }

    /**
     * Convierte un objeto ReservaDTO a un objeto ReservaEntidad.
     * 
     * @param dto El objeto ReservaDTO que se va a convertir.
     * @return El objeto ReservaEntidad correspondiente.
     * @throws IllegalArgumentException Si el objeto DTO es nulo.
     */
    private ReservaEntidad convertir(ReservaDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El objeto ReservaDTO no puede ser nulo.");
        }

        ReservaEntidad entidad = new ReservaEntidad();
        entidad.setId(dto.getId());
        entidad.setNombreCompleto(dto.getNombreCompleto());
        entidad.setTelefono(dto.getTelefono());
        
        // Convertir la fecha a Calendar para la entidad
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dto.getFechaHoraReserva().getTime());
        entidad.setFechaHoraReserva(calendar);

        entidad.setUbicacion(dto.getUbicacion());
        entidad.setNumPersonas(dto.getNumPersonas());
        entidad.setCostoReserva(dto.getCostoReserva());
        entidad.setCodigoMesa(dto.getCodigoMesa());

        return entidad;
    }

    /**
     * Convierte un objeto ReservaEntidad a un objeto ReservaDTO.
     * 
     * @param entidad El objeto ReservaEntidad que se va a convertir.
     * @return El objeto ReservaDTO correspondiente.
     */
    private ReservaDTO convertir(ReservaEntidad entidad) {
        if (entidad == null) {
            return null;
        }

        // Extraer la información de la entidad y pasarla al constructor de ReservaDTO
        // Usamos el código de la mesa de la entidad, que ahora es parte de la relación con MesaEntidad
        String codigoMesa = null;
        if (entidad.getCodigoMesa()!= null) {
            codigoMesa = entidad.getCodigoMesa(); // Obtén el código de la mesa
        }

        // Crear y devolver el DTO con los datos extraídos de la entidad
        return new ReservaDTO(
            entidad.getId(),
            entidad.getNombreCompleto(),
            entidad.getTelefono(),
            entidad.getFechaHoraReserva(),
            entidad.getUbicacion(),
            entidad.getNumPersonas(),
            entidad.getCostoReserva(),
            codigoMesa
        );
    }

    /**
     * Guarda una reserva en la base de datos.
     * 
     * @param reserva El objeto ReservaDTO que representa la reserva a guardar.
     * @throws IllegalArgumentException Si la reserva es nula.
     */
    public void guardarReserva(ReservaDTO reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva a guardar no puede ser nula.");
        }
        reservaDAO.guardarReserva(convertir(reserva));
    }

    /**
     * Modifica una reserva en la base de datos.
     * 
     * @param reserva El objeto ReservaDTO que representa la reserva a modificar.
     * @throws IllegalArgumentException Si la reserva es nula.
     */
    public void modificarReserva(ReservaDTO reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva a modificar no puede ser nula.");
        }
        reservaDAO.modificarReserva(convertir(reserva));
    }

    /**
     * Elimina una reserva de la base de datos.
     * 
     * @param reserva El objeto ReservaDTO que representa la reserva a eliminar.
     * @throws IllegalArgumentException Si la reserva es nula.
     */
    public void eliminarReserva(ReservaDTO reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva a eliminar no puede ser nula.");
        }
        reservaDAO.eliminarReserva(convertir(reserva));
    }

    /**
     * Busca una reserva por su ID en la base de datos.
     * 
     * @param id El ID de la reserva a buscar.
     * @return Un objeto ReservaDTO correspondiente a la reserva encontrada.
     * @throws IllegalArgumentException Si el ID es nulo.
     */
    public ReservaDTO buscarReserva(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la reserva no puede ser nulo.");
        }
        ReservaEntidad entidad = reservaDAO.buscarUnaReserva(id);
        return convertir(entidad);
    }
    
    /**
     * Busca reservas de un cliente dentro de un rango de fechas.
     * 
     * @param nombreCliente Nombre del cliente.
     * @param fechaInicio Fecha de inicio del rango.
     * @param fechaFin Fecha de fin del rango.
     * @return Una lista de objetos ReservaDTO que representan las reservas filtradas.
     */
    public List<ReservaDTO> buscarReservasPorClienteYFechas(String nombreCliente, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        // Obtener todas las reservas
        List<ReservaDTO> todasReservas = buscarTodasReservas();
        List<ReservaDTO> reservasFiltradas = new ArrayList<>();

        for (ReservaDTO reserva : todasReservas) {
            // Convertir fechaHoraReserva de Calendar a LocalDateTime
            LocalDateTime fechaHoraReserva = reserva.getFechaHoraReserva().toInstant()
                                                    .atZone(ZoneId.systemDefault())
                                                    .toLocalDateTime();

            // Filtrar por nombre del cliente y rango de fechas
            if (reserva.getNombreCompleto().equalsIgnoreCase(nombreCliente) &&
                (fechaHoraReserva.isAfter(fechaInicio) || fechaHoraReserva.isEqual(fechaInicio)) &&
                (fechaHoraReserva.isBefore(fechaFin) || fechaHoraReserva.isEqual(fechaFin))) {
                reservasFiltradas.add(reserva);
            }
        }
        return reservasFiltradas;
    }

    /**
     * Busca todas las reservas asociadas a un cliente.
     * 
     * @param cliente El cliente cuyas reservas se van a buscar.
     * @return Una lista de objetos ReservaDTO correspondientes a las reservas del cliente.
     */
    public List<ReservaDTO> buscarReservasPorCliente(ClienteDTO cliente)  {
        List<ReservaDTO> reservasEncontradas = new ArrayList<>();
        List<ReservaEntidad> reservasEntidad = new ArrayList<>();

        ClienteEntidad clienteFiltro = new ClienteEntidad(cliente.getId(), cliente.getTelefono(), cliente.getNombreCompleto());

        try {
            // Se guarda la reserva a través del DAO
            reservasEntidad = reservaDAO.buscarReservaPorCliente(clienteFiltro);
        } catch (Exception ex) {
            // Se maneja el error de persistencia
            System.out.println("Error al buscar las reservas: " + ex.getMessage());
        }

        // Verifica si no se encontraron reservas
        if (reservasEntidad == null || reservasEntidad.isEmpty()) {
            return null;
        }

        // Convierte las entidades a DTO
        for (ReservaEntidad reserva : reservasEntidad) {
            ReservaDTO reservaD = new ReservaDTO(
                reserva.getNombreCompleto(), 
                reserva.getTelefono(), 
                reserva.getFechaHoraReserva(), 
                reserva.getUbicacion(), 
                reserva.getNumPersonas(), 
                reserva.getCostoReserva(), 
                reserva.getCodigoMesa()
            );

            reservasEncontradas.add(reservaD);  // Añade la reservaDTO a la lista
        }

        return reservasEncontradas;
    }
    
    /**
     * Busca todas las reservas asociadas a una mesa.
     * 
     * @param mesa La mesa cuyas reservas se van a buscar.
     * @return Una lista de objetos ReservaDTO correspondientes a las reservas de la mesa.
     * @throws Exception Si ocurre un error en la lógica del negocio al procesar la reserva.
     */
    public List<ReservaDTO> buscarReservasPorMesa(MesaDTO mesa) throws Exception {
        
        List<ReservaDTO> reservasEncontradas = new ArrayList<>();
        List<ReservaEntidad> reservasEntidad = new ArrayList<>();

        MesaEntidad mesaFiltro = new MesaEntidad();
        mesaFiltro.setCodigoMesa(mesa.getCodigoMesa());
        mesaFiltro.setCapacidad(mesa.getCapacidad());
        mesaFiltro.setTipo(mesa.getTipo());
        mesaFiltro.setUbicacion(mesa.getUbicacion());

        try {
            // Se guarda la reserva a través del DAO
            reservasEntidad = reservaDAO.buscarReservaPorMesa(mesaFiltro);
            reservasEntidad.toString();
        } catch (Exception ex) {
            // Se maneja el error de persistencia
            System.out.println("Error al buscar las reservas");
        }
        
        if(reservasEntidad == null)
            return null;
        
        for(ReservaEntidad reserva : reservasEntidad){
            ReservaDTO reservaDTO = new ReservaDTO(reserva.getNombreCompleto(), reserva.getTelefono(), reserva.getFechaHoraReserva(), reserva.getUbicacion(), reserva.getNumPersonas(), reserva.getCostoReserva(), reserva.getCodigoMesa());
            reservasEncontradas.add(reservaDTO);
        }
        
        return reservasEncontradas;
    }

    /**
     * Busca todas las reservas en la base de datos y las devuelve como una lista de objetos ReservaDTO.
     * 
     * @return Una lista de objetos ReservaDTO que representan todas las reservas encontradas.
     */
    public List<ReservaDTO> buscarTodasReservas() {
        List<ReservaEntidad> entidades = reservaDAO.buscarTodasReservas();
        List<ReservaDTO> reservas = new ArrayList<>();
        for (ReservaEntidad entidad : entidades) {
            reservas.add(convertir(entidad));
        }
        return reservas;
    }
}
