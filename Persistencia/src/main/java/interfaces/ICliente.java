/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.ClienteEntidad;
import java.util.List;

/**
 *
 * @author limon
 */
public interface ICliente {
    
    public void guardarCliente(ClienteEntidad cliente);

 
    public void eliminarCliente(ClienteEntidad cliente);


    public void modificarCliente(ClienteEntidad cliente);


    public ClienteEntidad buscarUnCliente(Long id);


    public List<ClienteEntidad> buscarTodosClientes();
    
}
