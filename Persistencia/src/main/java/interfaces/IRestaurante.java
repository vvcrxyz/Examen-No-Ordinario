/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import entidades.RestauranteEntidad;
import java.util.List;

/**
 *
 * @author limon
 */
public interface IRestaurante {
    
    public void guardarRestaurante(RestauranteEntidad restaurante);

 
    public void eliminarRestaurante(RestauranteEntidad restaurante);


    public void modificarRestaurante(RestauranteEntidad restaurante);


    public RestauranteEntidad buscarUnRestaurante(Long id);


    public List<RestauranteEntidad> buscarTodosRestaurantes();
    
}
