package entidades;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Representa una reservación en el restaurante.
 */
@Entity
@Table(name = "tblReserva")
public class ReservaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long id;

    @Column(name = "nombreCompleto", length = 100, nullable = false)
    private String nombreCompleto;

    @Column(name = "telefono", length = 10, nullable = false)
    @Convert(converter = TelefonoCifradoConverter.class) // Implementa cifrado para la base de datos
    private String telefono;

    @Column(name = "fechaReserva", nullable = false)
    private Date fechaReserva;

    @Column(name = "horaReserva", nullable = false)
    private Time horaReserva;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "numPersonas", nullable = false)
    private int numPersonas;

    @Column(name = "costoReserva", nullable = false)
    private double costoReserva;

    @Column(name = "estado", nullable = false)
    private String estado; // Activa, Cancelada, Completada

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private ClienteEntidad cliente;

    @ManyToOne
    @JoinColumn(name = "idMesa", nullable = false)
    private MesaEntidad mesa;

    @ManyToOne
    @JoinColumn(name = "idRestaurante", nullable = false)
    private RestauranteEntidad restaurante;


    // Constructor por defecto
    public ReservaEntidad() {
    }

    // Constructor con parámetros
    public ReservaEntidad(Long id, String nombreCompleto, String telefono, Date fechaReserva, 
                          Time horaReserva, String ubicacion, int numPersonas, double costoReserva, 
                          String estado, MesaEntidad mesa) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaReserva = fechaReserva;
        this.horaReserva = horaReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.estado = estado;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ReservaEntidad{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaReserva=" + fechaReserva + ", horaReserva=" + horaReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", estado=" + estado + ", cliente=" + cliente + ", mesa=" + mesa + ", restaurante=" + restaurante + '}';
    }

}
