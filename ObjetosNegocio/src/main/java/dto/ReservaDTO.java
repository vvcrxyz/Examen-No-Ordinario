package dto;

import entidades.ReservaEntidad;
import java.util.Calendar;

/**
 * Data Transfer Object (DTO) para representar la información de una reserva.
 * Se utiliza para transferir los datos de una reserva entre las capas de la aplicación,
 * evitando que las entidades de la base de datos sean expuestas directamente a la capa de presentación.
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
     * Constructor por defecto.
     * Inicializa un objeto ReservaDTO sin datos.
     */
    public ReservaDTO() {
    }

    /**
     * Constructor para crear un objeto ReservaDTO con los detalles de la reserva.
     * 
     * @param nombreCompleto El nombre completo del cliente que realiza la reserva.
     * @param telefono El teléfono del cliente.
     * @param fechaHoraReserva La fecha y hora de la reserva.
     * @param ubicacion La ubicación donde se realizará la reserva.
     * @param numPersonas El número de personas que asistirán a la reserva.
     * @param costoReserva El costo de la reserva.
     * @param codigoMesa El código de la mesa reservada.
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
     * Constructor para crear un objeto ReservaDTO con todos los detalles, incluido el ID.
     * 
     * @param id El ID de la reserva.
     * @param nombreCompleto El nombre completo del cliente que realiza la reserva.
     * @param telefono El teléfono del cliente.
     * @param fechaHoraReserva La fecha y hora de la reserva.
     * @param ubicacion La ubicación donde se realizará la reserva.
     * @param numPersonas El número de personas que asistirán a la reserva.
     * @param costoReserva El costo de la reserva.
     * @param codigoMesa El código de la mesa reservada.
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

    /**
     * Constructor para convertir un objeto ReservaEntidad en ReservaDTO.
     * 
     * @param r El objeto ReservaEntidad que se va a convertir.
     */
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

    /**
     * Obtiene el ID de la reserva.
     * 
     * @return El ID de la reserva.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID de la reserva.
     * 
     * @param id El ID de la reserva.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del cliente que realizó la reserva.
     * 
     * @return El nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del cliente que realizó la reserva.
     * 
     * @param nombreCompleto El nombre completo del cliente.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el teléfono del cliente que realizó la reserva.
     * 
     * @return El teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente que realizó la reserva.
     * 
     * @param telefono El teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Obtiene la fecha y hora de la reserva.
     * 
     * @return La fecha y hora de la reserva.
     */
    public Calendar getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    /**
     * Establece la fecha y hora de la reserva.
     * 
     * @param fechaHoraReserva La fecha y hora de la reserva.
     */
    public void setFechaHoraReserva(Calendar fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    /**
     * Obtiene la ubicación de la reserva.
     * 
     * @return La ubicación de la reserva.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la reserva.
     * 
     * @param ubicacion La ubicación de la reserva.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el número de personas para la reserva.
     * 
     * @return El número de personas para la reserva.
     */
    public int getNumPersonas() {
        return numPersonas;
    }

    /**
     * Establece el número de personas para la reserva.
     * 
     * @param numPersonas El número de personas para la reserva.
     */
    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * Obtiene el costo de la reserva.
     * 
     * @return El costo de la reserva.
     */
    public double getCostoReserva() {
        return costoReserva;
    }

    /**
     * Establece el costo de la reserva.
     * 
     * @param costoReserva El costo de la reserva.
     */
    public void setCostoReserva(double costoReserva) {
        this.costoReserva = costoReserva;
    }

    /**
     * Obtiene el código de la mesa reservada.
     * 
     * @return El código de la mesa reservada.
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    /**
     * Establece el código de la mesa reservada.
     * 
     * @param codigoMesa El código de la mesa reservada.
     */
    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    /**
     * Representación en formato de texto del objeto ReservaDTO.
     * 
     * @return Una cadena que describe el objeto ReservaDTO.
     */
    @Override
    public String toString() {
        return "ReservaDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", codigoMesa=" + codigoMesa + '}';
    }
}
