/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.ReservaEntidad;
import java.util.Calendar;

/**
 *
 * @author limon
 */
public class ReservaDTO {
    
    private Long id;
    private String nombreCompleto;
    private String telefono;
    private Calendar fechaHoraReserva;
    private String ubicacion;
    private int numPersonas;
    private double costoReserva;
    private String codigoMesa;

    public ReservaDTO() {
    }

    public ReservaDTO(String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, String codigoMesa) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.codigoMesa = codigoMesa;
    }

    public ReservaDTO(Long id, String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva,String codigoMesa) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.codigoMesa = codigoMesa;
    }



    
    
    public ReservaDTO(ReservaEntidad r) {
        this.id = r.getId();
        this.nombreCompleto = r.getNombreCompleto();
        this.telefono = r.getTelefono();
        this.fechaHoraReserva = r.getFechaHoraReserva();
        this.ubicacion = r.getUbicacion();
        this.numPersonas = r.getNumPersonas();
        this.costoReserva = r.getCostoReserva();    
        this.codigoMesa = r.getCodigoMesa();
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
    
    public Calendar getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Calendar fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
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

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    @Override
    public String toString() {
        return "ReservaDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", codigoMesa=" + codigoMesa + '}';
    }
    
     
}
