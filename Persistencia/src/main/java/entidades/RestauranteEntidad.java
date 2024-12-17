package entidades;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa a un restaurante que tiene horas de apertura y cierre.
 * Esta clase es una entidad que mapea la tabla `tblRestaurante` en la base de datos.
 * Contiene la información sobre el horario de apertura y cierre del restaurante.
 * 
 * @author limon
 */
@Entity
@Table(name = "tblRestaurante")
public class RestauranteEntidad implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "horaApertura", nullable = false, columnDefinition = "TIME")
    private LocalTime horaApertura;

    @Column(name = "horaCierre", nullable = false, columnDefinition = "TIME")
    private LocalTime horaCierre;

    // Constructor por defecto
    public RestauranteEntidad() {
    }

    /**
     * Constructor con parámetros para crear un restaurante con las horas de apertura y cierre.
     * 
     * @param horaApertura la hora de apertura del restaurante
     * @param horaCierre la hora de cierre del restaurante
     */
    public RestauranteEntidad(LocalTime horaApertura, LocalTime horaCierre) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    /**
     * Constructor con parámetros para crear un restaurante con ID, hora de apertura y cierre.
     * 
     * @param id el ID del restaurante
     * @param horaApertura la hora de apertura del restaurante
     * @param horaCierre la hora de cierre del restaurante
     */
    public RestauranteEntidad(Long id, LocalTime horaApertura, LocalTime horaCierre) {
        this.id = id;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    // Getters y Setters

    /**
     * Obtiene el ID del restaurante.
     * 
     * @return el ID del restaurante
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el ID del restaurante.
     * 
     * @param id el ID del restaurante
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene la hora de apertura del restaurante.
     * 
     * @return la hora de apertura del restaurante
     */
    public LocalTime getHoraApertura() {
        return horaApertura;
    }

    /**
     * Establece la hora de apertura del restaurante.
     * 
     * @param horaApertura la hora de apertura del restaurante
     */
    public void setHoraApertura(LocalTime horaApertura) {
        this.horaApertura = horaApertura;
    }

    /**
     * Obtiene la hora de cierre del restaurante.
     * 
     * @return la hora de cierre del restaurante
     */
    public LocalTime getHoraCierre() {
        return horaCierre;
    }

    /**
     * Establece la hora de cierre del restaurante.
     * 
     * @param horaCierre la hora de cierre del restaurante
     */
    public void setHoraCierre(LocalTime horaCierre) {
        this.horaCierre = horaCierre;
    }

    /**
     * Método toString para representar la entidad `RestauranteEntidad` en formato String.
     * 
     * @return una representación en String de la entidad
     */
    @Override
    public String toString() {
        return "RestauranteEntidad{" + "id=" + id + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + '}';
    }
}
