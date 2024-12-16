package dto;

import entidades.MesaEntidad;
import entidades.ReservaEntidad;
import entidades.RestauranteEntidad;
import java.util.List;

/**
 * Esta clase es un Data Transfer Object (DTO) para representar los datos de una mesa en un restaurante.
 * Los objetos de esta clase se utilizan para transferir información de las mesas entre las capas de la aplicación, 
 * como la capa de presentación o lógica de negocio, y la capa de acceso a datos (DAO).
 */
public class MesaDTO {
    
    private String codigoMesa;
    private String tipo;
    private int capacidad;
    private String ubicacion;

    /**
     * Constructor por defecto.
     * Crea un objeto MesaDTO sin inicializar sus atributos.
     */
    public MesaDTO() {
    }

    /**
     * Constructor para crear un objeto MesaDTO con tipo, capacidad y ubicación.
     * 
     * @param tipo Tipo de la mesa (por ejemplo, "interior", "exterior").
     * @param capacidad Número de personas que puede acomodar la mesa.
     * @param ubicacion Descripción de la ubicación de la mesa (por ejemplo, "esquina").
     */
    public MesaDTO(String tipo, int capacidad, String ubicacion) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Constructor para crear un objeto MesaDTO con código, tipo, capacidad y ubicación.
     * 
     * @param codigoMesa El código único que identifica la mesa.
     * @param tipo Tipo de la mesa.
     * @param capacidad Número de personas que puede acomodar la mesa.
     * @param ubicacion Ubicación de la mesa dentro del restaurante.
     */
    public MesaDTO(String codigoMesa, String tipo, int capacidad, String ubicacion) {
        this.codigoMesa = codigoMesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }
    
    /**
     * Constructor que convierte una entidad MesaEntidad a un objeto MesaDTO.
     * 
     * @param m Objeto MesaEntidad que representa una mesa en la base de datos.
     * Este constructor se utiliza cuando se quiere crear un objeto MesaDTO a partir de una entidad MesaEntidad.
     */
    public MesaDTO(MesaEntidad m) {
        this.codigoMesa = m.getCodigoMesa();
        this.tipo = m.getTipo();
        this.capacidad = m.getCapacidad();
        this.ubicacion = m.getUbicacion();
    }

    // Métodos getter y setter

    /**
     * Obtiene el código único de la mesa.
     * 
     * @return El código de la mesa.
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    /**
     * Establece el código único de la mesa.
     * 
     * @param codigoMesa El código único de la mesa.
     */
    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    /**
     * Obtiene el tipo de mesa.
     * 
     * @return El tipo de la mesa.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de mesa.
     * 
     * @param tipo El tipo de la mesa (por ejemplo, "interior", "exterior").
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la capacidad de la mesa.
     * 
     * @return El número de personas que puede acomodar la mesa.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad de la mesa.
     * 
     * @param capacidad El número de personas que puede acomodar la mesa.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la ubicación de la mesa dentro del restaurante.
     * 
     * @return La ubicación de la mesa.
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa.
     * 
     * @param ubicacion La ubicación de la mesa dentro del restaurante.
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Devuelve una representación en forma de cadena del objeto MesaDTO.
     * Este método se utiliza para mostrar los atributos del objeto en formato de texto.
     * 
     * @return Una cadena con la representación de los atributos del objeto.
     */
    @Override
    public String toString() {
        return "MesaDTO{" + ", codigoMesa=" + codigoMesa + ", tipo=" + tipo + ", capacidad=" + capacidad + ", ubicacion=" + ubicacion +'}';
    }
}
