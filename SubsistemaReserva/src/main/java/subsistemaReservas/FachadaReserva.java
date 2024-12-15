package subsistemaReservas;

import interfaces.IReserva;
import logica.ReservaNegocio;
import dto.ReservaDTO;
import java.util.List;

public class FachadaReserva implements IReserva {
    private final ReservaNegocio negocio;

    public FachadaReserva() {
        this.negocio = new ReservaNegocio();
    }

    
    public void guardarReserva(ReservaDTO reserva) {
        negocio.guardarReserva(reserva);
    }

    
    public void modificarReserva(ReservaDTO reserva) {
        negocio.modificarReserva(reserva);
    }

    
    public void eliminarReserva(ReservaDTO reserva) {
        negocio.eliminarReserva(reserva);
    }

    
    public ReservaDTO buscarReserva(Long id) {
        return negocio.buscarReserva(id);
    }

    
    public List<ReservaDTO> buscarTodasReservas() {
        return negocio.buscarTodasReservas();
    }
}
