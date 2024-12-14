/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.ReservaEntidad;
import java.sql.Time;
import java.util.Date;

/**
 *
 * @author limon
 */
public class ReservaDTO {
    
    Long id;
    String nombreCompleto;
    String telefono;
    Date fechaReserva;
    Time horaReserva;
    String ubicacion;
    int numPersonas;
    private double costoReserva;

    public ReservaDTO() {
    }

    public ReservaDTO(String nombreCompleto, String telefono, Date fechaReserva, Time horaReserva, String ubicacion, int numPersonas, double costoReserva) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
    }
    
    

    public ReservaDTO(Long id, String nombreCompleto, String telefono, Date fechaReserva, Time horaReserva, String ubicacion, int numPersonas, double costoReserva) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
    }
    
    public ReservaDTO(ReservaEntidad r) {
        this.id = r.getId();
        this.nombreCompleto = r.getNombreCompleto();
        this.telefono = r.getTelefono();
        this.fechaReserva = r.getFechaReserva();
        this.horaReserva = r.getHoraReserva();
        this.ubicacion = r.getUbicacion();
        this.numPersonas = r.getNumPersonas();
        this.costoReserva = r.getCostoReserva();        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public Time getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Time horaReserva) {
        this.horaReserva = horaReserva;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumPersonas() {
        return numPersonas;
    }

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    public double getCostoReserva() {
        return costoReserva;
    }

    public void setCostoReserva(double costoReserva) {
        this.costoReserva = costoReserva;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + '}';
    }


    
    
}
