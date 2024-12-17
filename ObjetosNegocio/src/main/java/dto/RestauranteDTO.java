package dto;

import entidades.RestauranteEntidad;
import java.time.LocalTime;

/**
 * Data Transfer Object (DTO) para representar la información de un restaurante.
 * Se utiliza para transferir los datos de un restaurante entre las capas de la aplicación,
 * evitando que las entidades de la base de datos sean expuestas directamente a la capa de presentación.
 */
public class RestauranteDTO {
    
    private Long id;
    private LocalTime horaApertura;
    private LocalTime horaCierre;

    /**
     * Constructor por defecto.
     * Inicializa un objeto RestauranteDTO sin datos.
     */
    public RestauranteDTO() {
    }

    /**
     * Constructor para crear un objeto RestauranteDTO con las horas de apertura y cierre.
     * 
     * @param horaApertura La hora de apertura del restaurante.
     * @param horaCierre La hora de cierre del restaurante.
     */
    public RestauranteDTO(LocalTime horaApertura, LocalTime horaCierre) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    /**
     * Constructor para crear un objeto RestauranteDTO con ID, hora de apertura y cierre.
     * 
     * @param id El ID del restaurante.
     * @param horaApertura La hora de apertura del restaurante.
     * @param horaCierre La hora de cierre del restaurante.
     */
    public RestauranteDTO(Long id, LocalTime horaApertura, LocalTime horaCierre) {
        this.id = id;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    /**
     * Constructor para convertir un objeto RestauranteEntidad en RestauranteDTO.
     * 
     * @param r El objeto RestauranteEntidad que se va a convertir.
     */
    public RestauranteDTO(RestauranteEntidad r) {
        this.id = r.getId();
        this.horaApertura = r.getHoraApertura();
        this.horaCierre = r.getHoraCierre();
    }

    /**
     * Obtiene el ID del restaurante.
     * 
     * @return El ID del restaurante.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del restaurante.
     * 
     * @param id El ID del restaurante.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la hora de apertura del restaurante.
     * 
     * @return La hora de apertura del restaurante.
     */
    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura del restaurante.
     * 
     * @param horaApertura La hora de apertura del restaurante.
     */
    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     * 
     * @return La hora de cierre del restaurante.
     */
    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre del restaurante.
     * 
     * @param horaCierre La hora de cierre del restaurante.
     */
    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * Representación en formato de texto del objeto RestauranteDTO.
     * 
     * @return Una cadena que describe el objeto RestauranteDTO.
     */
    @Override
    public String toString() {
        return "RestauranteDTO{" + "id=" + id + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + '}';
    }
}
