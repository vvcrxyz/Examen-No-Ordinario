package logica;

import dao.ReservaDAO;
import dto.ReservaDTO;
import entidades.ReservaEntidad;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase de negocio para gestionar las reservas.
 * Realiza las conversiones entre DTO y Entidad, y delega operaciones al DAO.
 */
public class ReservaNegocio {

    private final ReservaDAO reservaDAO;

    // Constructor
    public ReservaNegocio() {
        this.reservaDAO = new ReservaDAO();
    }

    // Conversión de ReservaDTO a ReservaEntidad
    private ReservaEntidad convertir(ReservaDTO dto) {
        if (dto == null) {
            throw new IllegalArgumentException("El objeto ReservaDTO no puede ser nulo.");
        }
        ReservaEntidad entidad = new ReservaEntidad();
        entidad.setId(dto.getId());
        entidad.setNombreCompleto(dto.getNombreCompleto());
        entidad.setTelefono(dto.getTelefono());
        entidad.setFechaHoraReserva(dto.getFechaHoraReserva());
        entidad.setUbicacion(dto.getUbicacion());
        entidad.setNumPersonas(dto.getNumPersonas());
        entidad.setCostoReserva(dto.getCostoReserva());
        return entidad;
    }

    // Conversión de ReservaEntidad a ReservaDTO
    private ReservaDTO convertir(ReservaEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new ReservaDTO(entidad);
    }

    // Guardar una reserva
    public void guardarReserva(ReservaDTO reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva a guardar no puede ser nula.");
        }
        reservaDAO.guardarReserva(convertir(reserva));
    }

    // Modificar una reserva
    public void modificarReserva(ReservaDTO reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva a modificar no puede ser nula.");
        }
        reservaDAO.modificarReserva(convertir(reserva));
    }

    // Eliminar una reserva
    public void eliminarReserva(ReservaDTO reserva) {
        if (reserva == null) {
            throw new IllegalArgumentException("La reserva a eliminar no puede ser nula.");
        }
        reservaDAO.eliminarReserva(convertir(reserva));
    }

    // Buscar una reserva por ID
    public ReservaDTO buscarReserva(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID de la reserva no puede ser nulo.");
        }
        ReservaEntidad entidad = reservaDAO.buscarUnaReserva(id);
        return convertir(entidad);
    }

    // Buscar todas las reservas
    public List<ReservaDTO> buscarTodasReservas() {
        List<ReservaEntidad> entidades = reservaDAO.buscarTodasReservas();
        List<ReservaDTO> reservas = new ArrayList<>();
        for (ReservaEntidad entidad : entidades) {
            reservas.add(convertir(entidad));
        }
        return reservas;
    }

}