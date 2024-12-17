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
 * Esta clase es una entidad que mapea la tabla `tblCliente` en la base de datos.
 * Contiene los detalles del cliente como el nombre completo, teléfono e ID.
 * 
 * @author limon 
 */
@Entity
@Table(name = "tblCliente")
public class ClienteEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * El identificador único del cliente. 
     * Se genera automáticamente con la estrategia de incremento de la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private Long id;

    /**
     * El nombre completo del cliente.
     * Este campo es obligatorio y tiene un máximo de 100 caracteres.
     */
    @Column(name = "nombreCompleto", length = 100, nullable = false)
    private String nombreCompleto;

    /**
     * El número de teléfono del cliente.
     * Este campo es obligatorio.
     */
    @Column(name = "telefono", nullable = false)
    private String telefono;

    /**
     * Constructor por defecto para la clase `ClienteEntidad`.
     * Este constructor es utilizado por JPA para la creación de instancias sin parámetros.
     */
    public ClienteEntidad() {
    }

    /**
     * Constructor con parámetros para crear un cliente.
     * 
     * @param nombreCompleto el nombre completo del cliente
     * @param telefono el número de teléfono del cliente
     */
    public ClienteEntidad(String nombreCompleto, String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    /**
     * Constructor con parámetros para crear un cliente con ID.
     * 
     * @param id el ID del cliente
     * @param nombreCompleto el nombre completo del cliente
     * @param telefono el número de teléfono del cliente
     */
    public ClienteEntidad(Long id, String nombreCompleto, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    // Getters y Setters

    /**
     * Obtiene el ID del cliente.
     * 
     * @return el ID del cliente
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param id el ID del cliente
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre completo del cliente.
     * 
     * @return el nombre completo del cliente
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Establece el nombre completo del cliente.
     * 
     * @param nombreCompleto el nombre completo del cliente
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Obtiene el número de teléfono del cliente.
     * 
     * @return el número de teléfono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el número de teléfono del cliente.
     * 
     * @param telefono el número de teléfono del cliente
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Método toString para representar la entidad `ClienteEntidad` en formato String.
     * 
     * @return una representación en String de la entidad, que incluye el ID, nombre y teléfono del cliente
     */
    @Override
    public String toString() {
        return "ClienteEntidad{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + '}';
    }
}
