/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.RestauranteEntidad;
import java.sql.Time;

/**
 *
 * @author limon
 */
public class RestauranteDTO {
    
    private Long id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Time horaApertura;
    private Time horaCierre;

    public RestauranteDTO() {
    }

    public RestauranteDTO(String nombre, String direccion, String telefono, Time horaApertura, Time horaCierre) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public RestauranteDTO(Long id, String nombre, String direccion, String telefono, Time horaApertura, Time horaCierre) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    public RestauranteDTO(RestauranteEntidad r) {
        this.id = r.getId();
        this.nombre = r.getNombre();
        this.direccion = r.getDireccion();
        this.telefono = r.getTelefono();
        this.horaApertura = r.getHoraApertura();
        this.horaCierre = r.getHoraCierre();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Time getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Time getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Time horaCierre) {
        this.horaCierre = horaCierre;
    }

    @Override
    public String toString() {
        return "RestauranteDTO{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + '}';
    }
    
    
}

