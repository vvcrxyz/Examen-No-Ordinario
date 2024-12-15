package entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
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
    private String telefono;

    @Column(name = "fechaHoraReserva", nullable = false)
    private LocalDateTime fechaHoraReserva; // Cambiado a LocalDateTime

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

    public ReservaEntidad(String nombreCompleto, String telefono, LocalDateTime fechaHoraReserva, 
                          String ubicacion, int numPersonas, double costoReserva, String estado) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.estado = estado;
    }

    public ReservaEntidad(String nombreCompleto, String telefono, LocalDateTime fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, String estado, ClienteEntidad cliente, MesaEntidad mesa, RestauranteEntidad restaurante) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.estado = estado;
        this.cliente = cliente;
        this.mesa = mesa;
        this.restaurante = restaurante;
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

    public LocalDateTime getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(LocalDateTime fechaHoraReserva) {
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "ReservaEntidad{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + 
               ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + 
               ", costoReserva=" + costoReserva + ", estado=" + estado + ", cliente=" + cliente + ", mesa=" + mesa + 
               '}';
    }
}
