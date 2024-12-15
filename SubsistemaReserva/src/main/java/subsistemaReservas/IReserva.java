/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package subsistemaReservas;

import dto.ReservaDTO;
import java.util.List;

/**
 *
 * @author limon
 */
public interface IReserva {
    
    void guardarReserva(ReservaDTO reserva);
    void modificarReserva(ReservaDTO reserva);
    void eliminarReserva(ReservaDTO reserva);
    ReservaDTO buscarReserva(Long id);
    List<ReservaDTO> buscarTodasReservas();

}
