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
    
    private Long id;
    private String codigoMesa;
    private String tipo;
    private int capacidad;
    private String ubicacion;
    private RestauranteEntidad restaurante;
    private List<ReservaEntidad> reservaciones;

    public MesaDTO() {
    }

    public MesaDTO(String codigoMesa, String tipo, int capacidad, String ubicacion, RestauranteEntidad restaurante, List<ReservaEntidad> reservaciones) {
        this.codigoMesa = codigoMesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.restaurante = restaurante;
        this.reservaciones = reservaciones;
    }

    public MesaDTO(Long id, String codigoMesa, String tipo, int capacidad, String ubicacion, RestauranteEntidad restaurante, List<ReservaEntidad> reservaciones) {
        this.id = id;
        this.codigoMesa = codigoMesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.restaurante = restaurante;
        this.reservaciones = reservaciones;
    }
    
    public MesaDTO(MesaEntidad m) {
        this.id = m.getId();
        this.codigoMesa = m.getCodigoMesa();
        this.tipo = m.getTipo();
        this.capacidad = m.getCapacidad();
        this.ubicacion = m.getUbicacion();
       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public RestauranteEntidad getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(RestauranteEntidad restaurante) {
        this.restaurante = restaurante;
    }

    public List<ReservaEntidad> getReservaciones() {
        return reservaciones;
    }

    public void setReservaciones(List<ReservaEntidad> reservaciones) {
        this.reservaciones = reservaciones;
    }

    @Override
    public String toString() {
        return "MesaDTO{" + "id=" + id + ", codigoMesa=" + codigoMesa + ", tipo=" + tipo + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + ", restaurante=" + restaurante + ", reservaciones=" + reservaciones + '}';
    }
    
    
    
    
}
