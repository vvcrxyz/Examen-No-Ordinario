/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.MesaEntidad;
import java.util.List;

/**
 *
 * @author limon
 */
public interface IMesa {
    
    public void guardarMesa(MesaEntidad mesa);

 
    public void eliminarMesa(MesaEntidad mesa);


    public void modificarMesa(MesaEntidad mesa);


    public MesaEntidad buscarUnMesa(Long id);


    public List<MesaEntidad> buscarTodasMesas();
    
}
