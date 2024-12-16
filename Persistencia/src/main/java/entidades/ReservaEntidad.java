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
 */
@Entity
@Table(name = "tblreserva")
public class ReservaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único de la reserva.
     * Se genera automáticamente con la estrategia de incremento de la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long id;

    /**
     * Nombre completo del cliente que realiza la reserva.
     */
    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;

    /**
     * Número de teléfono del cliente.
     */
    @Column(name = "telefono", nullable = false)
    private String telefono;

    /**
     * Fecha y hora en que se realizó la reserva.
     */
    @Column(name = "fechaHoraReserva", nullable = false)
    private Calendar fechaHoraReserva;

    /**
     * Ubicación solicitada para la reserva (por ejemplo: Terraza, Ventana, General).
     */
    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    /**
     * Número de personas para las que se realiza la reserva.
     */
    @Column(name = "numPersonas", nullable = false)
    private int numPersonas;

    /**
     * Costo total de la reserva.
     */
    @Column(name = "costoReserva", nullable = false)
    private double costoReserva;

    /**
     * Código de la mesa asignada para la reserva.
     */
    @Column(name = "codigoMesa", nullable = false)
    private String codigoMesa;

    /**
     * Constructor vacío para crear instancias sin parámetros.
     */
    public ReservaEntidad() {
    }

    /**
     * Constructor para crear una reserva sin especificar el código de la mesa.
     * 
     * @param nombreCompleto Nombre del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param fechaHoraReserva Fecha y hora de la reserva.
     * @param ubicacion Ubicación solicitada para la mesa.
     * @param numPersonas Número de personas para la reserva.
     * @param costoReserva Costo total de la reserva.
     */
    public ReservaEntidad(String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
    }

    /**
     * Constructor para crear una reserva con el código de la mesa especificado.
     * 
     * @param nombreCompleto Nombre del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param fechaHoraReserva Fecha y hora de la reserva.
     * @param ubicacion Ubicación solicitada para la mesa.
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
     * Constructor completo para crear una reserva con todos los atributos.
     * 
     * @param id Identificador único de la reserva.
     * @param nombreCompleto Nombre del cliente.
     * @param telefono Número de teléfono del cliente.
     * @param fechaHoraReserva Fecha y hora de la reserva.
     * @param ubicacion Ubicación solicitada para la mesa.
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
     * Representa la reserva como una cadena de texto.
     * 
     * @return Una cadena con los detalles de la reserva.
     */
    @Override
    public String toString() {
        return "ReservaEntidad{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", codigoMesa=" + codigoMesa + '}';
    }
}
