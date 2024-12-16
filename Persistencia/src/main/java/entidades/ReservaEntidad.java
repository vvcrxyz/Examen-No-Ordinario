package entidades;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author limon
 */
@Entity
@Table(name = "tblreserva")
public class ReservaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long id;
    
    @Column(name = "nombreCompleto", nullable = false)
    private String nombreCompleto;
    
    @Column(name = "telefono", nullable = false)
    private String telefono;
    
    @Column(name = "fechaHoraReserva", nullable = false)
    private Calendar fechaHoraReserva; 

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "numPersonas", nullable = false)
    private int numPersonas;

    @Column(name = "costoReserva", nullable = false)
    private double costoReserva;

    @Column(name = "codigoMesa", nullable = false)
    private String codigoMesa;

    public ReservaEntidad() {
    }

    public ReservaEntidad(String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
    }

    public ReservaEntidad(String nombreCompleto, String telefono, Calendar fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, String codigoMesa) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.codigoMesa = codigoMesa;
    }

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

    @Override
    public String toString() {
        return "ReservaEntidad{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", codigoMesa=" + codigoMesa + '}';
    }

    
    
}
