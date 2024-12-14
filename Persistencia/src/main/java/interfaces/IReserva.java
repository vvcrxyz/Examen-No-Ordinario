/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.ReservaEntidad;
import java.util.List;

/**
 *
 * @author limon
 */
public interface IReserva {
    
    public void guardarReserva(ReservaEntidad reserva);

 
    public void eliminarReserva(ReservaEntidad reserva);


    public void modificarReserva(ReservaEntidad reserva);


    public ReservaEntidad buscarUnReserva(Long id);


    public List<ReservaEntidad> buscarTodasReservas();
}
