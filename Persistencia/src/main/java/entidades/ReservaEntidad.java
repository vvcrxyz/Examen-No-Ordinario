package entidades;

import java.io.Serializable;
import java.sql.Date;
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
 *
 * @author limon
 */
@Entity
@Table(name = "tblReserva")
public class ReservaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long id;

    @Column(name = "fechaHoraReserva", nullable = false)
    private Date fechaHoraReserva; 

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "numPersonas", nullable = false)
    private int numPersonas;

    @Column(name = "costoReserva", nullable = false)
    private double costoReserva;

    @ManyToOne
    @JoinColumn(name = "idCliente", nullable = false)
    private ClienteEntidad cliente;

    @ManyToOne
    @JoinColumn(name = "idMesa", nullable = false)
    private MesaEntidad mesa;


    // Constructor por defecto
    public ReservaEntidad() {
    }

    public ReservaEntidad(Date fechaHoraReserva, 
                          String ubicacion, int numPersonas, double costoReserva) {
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
    }

    public ReservaEntidad(Date fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, ClienteEntidad cliente, MesaEntidad mesa) {
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.cliente = cliente;
        this.mesa = mesa;
    }
   
    

    public ReservaEntidad(Long id, Date fechaHoraReserva, String ubicacion, int numPersonas, double costoReserva, ClienteEntidad cliente, MesaEntidad mesa) {
        this.id = id;
        this.fechaHoraReserva = fechaHoraReserva;
        this.ubicacion = ubicacion;
        this.numPersonas = numPersonas;
        this.costoReserva = costoReserva;
        this.cliente = cliente;
        this.mesa = mesa;
    }


    

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaHoraReserva() {
        return fechaHoraReserva;
    }

    public void setFechaHoraReserva(Date fechaHoraReserva) {
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

    @Override
    public String toString() {
        return "ReservaEntidad{" + "id=" + id + ", fechaHoraReserva=" + fechaHoraReserva + ", ubicacion=" + ubicacion + ", numPersonas=" + numPersonas + ", costoReserva=" + costoReserva + ", cliente=" + cliente + ", mesa=" + mesa + '}';
    }



    
}
