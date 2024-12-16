package logica;

import dao.ReservaDAO;
import dto.ReservaDTO;
import entidades.ReservaEntidad;
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
        return new ReservaDTO(entidad);
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
