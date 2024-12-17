package dto;

import entidades.MesaEntidad;
import entidades.ReservaEntidad;
import java.util.Calendar;

/**
 * Data Transfer Object (DTO) for representing the information of a reservation.
 * It is used to transfer reservation data between application layers,
 * preventing the direct exposure of database entities to the presentation layer.
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

    /**
     * Default constructor.
     * Initializes a ReservaDTO object without any data.
     */
    public ReservaDTO() {
    }

    /**
     * Constructor with parameters.
     * Initializes a ReservaDTO with the provided data.
     * 
     * @param nombreCompleto   Full name of the client who made the reservation.
     * @param telefono         Phone number of the client who made the reservation.
     * @param fechaHoraReserva Date and time of the reservation.
     * @param ubicacion        Location of the reservation.
     * @param numPersonas      Number of people for the reservation.
     * @param costoReserva     Cost of the reservation.
     * @param codigoMesa       Code of the table reserved.
     */
    public ReservaDTO(String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, String codigoMesa) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.codigoMesa = codigoMesa;
    }

    /**
     * Constructor with parameters.
     * Initializes a ReservaDTO with the provided data, including the reservation ID.
     * 
     * @param id               ID of the reservation.
     * @param nombreCompleto   Full name of the client who made the reservation.
     * @param telefono         Phone number of the client who made the reservation.
     * @param fechaHoraReserva Date and time of the reservation.
     * @param ubicacion        Location of the reservation.
     * @param numPersonas      Number of people for the reservation.
     * @param costoReserva     Cost of the reservation.
     * @param codigoMesa       Code of the table reserved.
     */
    public ReservaDTO(Long id, String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, String codigoMesa) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.codigoMesa = codigoMesa;
    }

    // Getter and Setter methods

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

    /**
     * Provides a string representation of the ReservaDTO object.
     * 
     * @return A string describing the ReservaDTO object.
     */
    @Override
    public String toString() {
        return "ReservaDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", codigoMesa=" + codigoMesa + '}';
    }
}
