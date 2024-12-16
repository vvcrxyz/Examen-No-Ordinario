package dto;

import entidades.ClienteEntidad;

/**
 * Data Transfer Object (DTO) para representar la información de un cliente.
 * Utilizada para transferir los datos de un cliente entre capas de la aplicación, 
 * evitando que las entidades sean expuestas directamente a la capa de presentación.
 */
public class ClienteDTO {
    
    private Long id;
    private String nombreCompleto;
    private String telefono;

    /**
     * Constructor por defecto.
     * Inicializa un objeto ClienteDTO sin datos.
     */
    public ClienteDTO() {
    }

    /**
     * Constructor para crear un objeto ClienteDTO con nombre y teléfono.
     * 
     * @param nombreCompleto El nombre completo del cliente.
     * @param telefono El teléfono del cliente.
     */
    public ClienteDTO(String nombreCompleto,  String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    /**
     * Constructor para crear un objeto ClienteDTO con ID, nombre y teléfono.
     * 
     * @param id El ID del cliente.
     * @param nombreCompleto El nombre completo del cliente.
     * @param telefono El teléfono del cliente.
     */
    public ClienteDTO(Long id, String nombreCompleto, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    /**
     * Constructor para convertir un objeto ClienteEntidad a ClienteDTO.
     * 
     * @param c El objeto ClienteEntidad que se va a convertir.
     */
    public ClienteDTO(ClienteEntidad c) {
        this.id = c.getId();
        this.nombreCompleto = c.getNombreCompleto();
        this.telefono = c.getTelefono();
    }
    
    /**
     * Obtiene el ID del cliente.
     * 
     * @return El ID del cliente.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del cliente.
     * 
     * @param id El ID del cliente.
     */
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

    /**
     * Establece el nombre completo del cliente.
     * 
     * @param nombreCompleto El nombre completo del cliente.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }    

    /**
     * Obtiene el teléfono del cliente.
     * 
     * @return El teléfono del cliente.
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del cliente.
     * 
     * @param telefono El teléfono del cliente.
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Representación en formato de texto del objeto ClienteDTO.
     * 
     * @return Una cadena que describe el objeto ClienteDTO.
     */
    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + '}';
    }
}
