package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa una mesa en el restaurante.
 */
@Entity
@Table(name = "tblMesa")
public class MesaEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMesa")
    private Long id;

    @Column(name = "codigoMesa", length = 20, nullable = false, unique = true)
    private String codigoMesa; // Código único (ej. TER-2-001)

    @Column(name = "tipo", length = 10, nullable = false)
    private String tipo; // Pequeña, Mediana, Grande

    @Column(name = "capacidad", nullable = false)
    private int capacidad; // Número máximo de personas

    @Column(name = "ubicacion", length = 20, nullable = false)
    private String ubicacion; // Terraza, Ventana, General

    
  

    public MesaEntidad() {
    }

    public MesaEntidad(String codigoMesa, String tipo, int capacidad, String ubicacion) {
        this.codigoMesa = codigoMesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "MesaEntidad{" + "id=" + id + ", codigoMesa=" + codigoMesa + ", tipo=" + tipo + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion + '}';
    }
}
