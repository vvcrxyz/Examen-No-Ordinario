package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa a un cliente que realiza reservas en el restaurante.
 */
@Entity
@Table(name = "tblCliente")
public class ClienteEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long id;

    @Column(name = "nombreCompleto", length = 100, nullable = false)
    private String nombreCompleto;

    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @Column(name = "telefono",  nullable = false)
    private String telefono;

    // Constructor por defecto
    public ClienteEntidad() {
    }

    public ClienteEntidad(String nombreCompleto, String email, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
    }

    // Constructor con parámetros
    public ClienteEntidad(Long id, String nombreCompleto, String email, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.telefono = telefono;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClienteEntidad{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", email=" + email + ", telefono=" + telefono + '}';
    }
}
