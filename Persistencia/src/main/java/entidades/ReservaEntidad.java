package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa una reserva en el restaurante.
 * Esta clase mapea la entidad "Reserva" a la tabla "tblreserva" en la base de datos.
 * Cada reserva contiene información sobre el cliente, la mesa asignada, el número de personas,
 * la fecha y hora de la reserva, y el costo total de la misma.
 */
@Entity
@Table(name = "tblreserva")
public class ReservaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la reserva.
     * Este campo se genera automáticamente utilizando la estrategia de incremento de la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long id;

    /**
     * Nombre completo del cliente que realiza la reserva.
     * Este campo no puede ser nulo.
     */
    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    /**
     * Número de teléfono del cliente.
     * Este campo no puede ser nulo.
     */
    @Column(name = "telefono", nullable = false)
    private String telefono;

    /**
     * Fecha y hora en que se realizó la reserva.
     * Este campo no puede ser nulo.
     */
    @Column(name = "fechaHoraReserva", nullable = false)
    private Calendar fechaHoraReserva;

    /**
     * Ubicación solicitada para la reserva.
     * Ejemplos: Terraza, Ventana, General. Este campo no puede ser nulo.
     */
    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    /**
     * Número de personas para las que se realiza la reserva.
     * Este campo no puede ser nulo.
     */
    @Column(name = "numPersonas", nullable = false)
    private int numPersonas;

    /**
     * Costo total de la reserva.
     * Este campo no puede ser nulo.
     */
    @Column(name = "costoReserva", nullable = false)
    private double costoReserva;

    /**
     * Código de la mesa asignada para la reserva.
     * Este campo no puede ser nulo.
     */
    @Column(name = "codigoMesa", nullable = false)
    private String codigoMesa;

    /**
     * Constructor vacío para crear instancias sin parámetros.
     * Este constructor es necesario para la persistencia en JPA.
     */
    public ReservaEntidad() {
    }

    /**
     * Constructor que inicializa todos los campos de la reserva.
     * 
     * @param nombreCompleto Nombre completo del cliente que realiza la reserva.
     * @param telefono Número de teléfono del cliente.
     * @param fechaHoraReserva Fecha y hora de la reserva.
     * @param ubicacion Ubicación solicitada para la reserva.
     * @param numPersonas Número de personas para la reserva.
     * @param costoReserva Costo total de la reserva.
     * @param codigoMesa Código de la mesa asignada.
     */
    public ReservaEntidad(String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, String codigoMesa) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.codigoMesa = codigoMesa;
    }

    /**
     * Constructor con todos los parámetros, incluyendo el id de la reserva.
     * 
     * @param id Identificador único de la reserva.
     * @param nombreCompleto Nombre completo del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param fechaHoraReserva Fecha y hora de la reserva.
     * @param ubicacion Ubicación solicitada para la reserva.
     * @param numPersonas Número de personas para la reserva.
     * @param costoReserva Costo total de la reserva.
     * @param codigoMesa Código de la mesa asignada.
     */
    public ReservaEntidad(Long id, String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, String codigoMesa) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.codigoMesa = codigoMesa;
    }

    // Getters y Setters

    /**
     * Obtiene el identificador único de la reserva.
     * 
     * @return El identificador de la reserva.
     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del cliente.
     * 
     * @return El nombre completo del cliente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return El número de teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

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

    public void setFechaHoraReserva(Calendar fechaHoraReserva) {
        this.fechaHoraReserva = fechaHoraReserva;
    }

    /**
     * Obtiene la ubicación solicitada para la reserva.
     * 
     * @return La ubicación solicitada para la reserva.
     */
    public String getUbicacion() {
        return ubicacion;
    }

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

    public void setNumPersonas(int numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * Obtiene el costo total de la reserva.
     * 
     * @return El costo total de la reserva.
     */
    public double getCostoReserva() {
        return costoReserva;
    }

    public void setCostoReserva(double costoReserva) {
        this.costoReserva = costoReserva;
    }

    /**
     * Obtiene el código de la mesa asignada.
     * 
     * @return El código de la mesa asignada para la reserva.
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }
    
    /**
     * Representa la reserva como una cadena de texto.
     * 
     * @return Una cadena con los detalles de la reserva.
     */
    @Override
    public String toString() {
        return "ReservaEntidad{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", codigoMesa=" + codigoMesa + '}';
    }
}
