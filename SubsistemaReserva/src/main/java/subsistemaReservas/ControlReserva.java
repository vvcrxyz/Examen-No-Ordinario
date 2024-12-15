package subsistemaReservas;


import dto.ReservaDTO;
import java.util.List;

public class ControlReserva {
    private final FachadaReserva fachada;

    public ControlReserva() {
        this.fachada = new FachadaReserva();
    }

    public void agregarReserva(ReservaDTO reserva) {
        try {
            fachada.guardarReserva(reserva);
        } catch (Exception e) {
            System.err.println("Error al agregar reserva: " + e.getMessage());
        }
    }

    public void actualizarReserva(ReservaDTO reserva) {
        try {
            fachada.modificarReserva(reserva);
        } catch (Exception e) {
            System.err.println("Error al actualizar reserva: " + e.getMessage());
        }
    }

    public void eliminarReserva(ReservaDTO reserva) {
        try {
            fachada.eliminarReserva(reserva);
        } catch (Exception e) {
            System.err.println("Error al eliminar reserva: " + e.getMessage());
        }
    }

    public ReservaDTO obtenerReserva(Long id) {
        try {
            return fachada.buscarReserva(id);
        } catch (Exception e) {
            System.err.println("Error al buscar reserva: " + e.getMessage());
            return null;
        }
    }

    public List<ReservaDTO> listarReservas() {
        try {
            return fachada.buscarTodasReservas();
        } catch (Exception e) {
            System.err.println("Error al listar reservas: " + e.getMessage());
            return null;
        }
    }
}
