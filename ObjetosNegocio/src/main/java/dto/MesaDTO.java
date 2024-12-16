/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.MesaEntidad;
import entidades.ReservaEntidad;
import entidades.RestauranteEntidad;
import java.util.List;

/**
 *
 * @author limon
 */
public class MesaDTO {
    
    private String codigoMesa;
    private String tipo;
    private int capacidad;
    private String ubicacion;

    public MesaDTO() {
    }

    public MesaDTO(String tipo, int capacidad, String ubicacion) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    public MesaDTO(String codigoMesa, String tipo, int capacidad, String ubicacion) {
        this.codigoMesa = codigoMesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }
    
    public MesaDTO(MesaEntidad m) {
        this.codigoMesa = m.getCodigoMesa();
        this.tipo = m.getTipo();
        this.capacidad = m.getCapacidad();
        this.ubicacion = m.getUbicacion();
       
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "MesaDTO{" + ", codigoMesa=" + codigoMesa + ", tipo=" + tipo + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion +'}';
    }
    
    
    
    
}
