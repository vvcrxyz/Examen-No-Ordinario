package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa una mesa en el restaurante.
 * Esta clase mapea la entidad "Mesa" a la tabla "tblMesa" en la base de datos.
 * 
 * La clase se utiliza para representar las mesas disponibles en un restaurante,
 * incluyendo su código único, tipo (pequeña, mediana, grande), capacidad máxima,
 * y ubicación dentro del restaurante (terrazas, ventanas, área general).
 */
@Entity
@Table(name = "tblMesa")
public class MesaEntidad implements Serializable {

    /**
     * Código único de la mesa (ejemplo: TER-2-001).
     * Se utiliza como clave primaria en la base de datos.
     */
    @Id
    @Column(name = "codigoMesa", length = 20, nullable = false)
    private String codigoMesa; // Código único (ej. TER-2-001)

    /**
     * Tipo de mesa (por ejemplo: Pequeña, Mediana, Grande).
     * Se especifica el tipo de mesa que puede ser asignada.
     */
    @Column(name = "tipo", length = 10, nullable = false)
    private String tipo; // Pequeña, Mediana, Grande

    /**
     * Capacidad máxima de personas que pueden sentarse en la mesa.
     */
    @Column(name = "capacidad", nullable = false)
    private int capacidad; // Número máximo de personas

    /**
     * Ubicación de la mesa dentro del restaurante (por ejemplo: Terraza, Ventana, General).
     */
    @Column(name = "ubicacion", length = 20, nullable = false)
    private String ubicacion; // Terraza, Ventana, General

    /**
     * Constructor vacío para crear instancias sin parámetros.
     * Este constructor es utilizado por el framework de persistencia (JPA).
     */
    public MesaEntidad() {
    }

    /**
     * Constructor con parámetros para inicializar una mesa sin código.
     * Este constructor es útil cuando se desea crear una mesa sin asignar un código único.
     * 
     * @param tipo Tipo de mesa (Pequeña, Mediana, Grande).
     * @param capacidad Capacidad máxima de personas.
     * @param ubicacion Ubicación de la mesa dentro del restaurante.
     */
    public MesaEntidad(String tipo, int capacidad, String ubicacion) {
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Constructor con parámetros para inicializar una mesa con código único.
     * Este constructor se utiliza cuando se necesita especificar todos los atributos de la mesa,
     * incluyendo el código único.
     * 
     * @param codigoMesa Código único de la mesa (ejemplo: TER-2-001).
     * @param tipo Tipo de mesa.
     * @param capacidad Capacidad máxima de personas.
     * @param ubicacion Ubicación de la mesa dentro del restaurante.
     */
    public MesaEntidad(String codigoMesa, String tipo, int capacidad, String ubicacion) {
        this.codigoMesa = codigoMesa;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    /**
     * Obtiene el código único de la mesa.
     * 
     * @return El código de la mesa (ejemplo: TER-2-001).
     */
    public String getCodigoMesa() {
        return codigoMesa;
    }

    /**
     * Establece el código único de la mesa.
     * 
     * @param codigoMesa Código de la mesa a establecer.
     */
    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

    /**
     * Obtiene el tipo de la mesa.
     * 
     * @return El tipo de mesa (Pequeña, Mediana, Grande).
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el tipo de mesa.
     * 
     * @param tipo Tipo de mesa a establecer (Pequeña, Mediana, Grande).
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Obtiene la capacidad máxima de la mesa.
     * 
     * @return La capacidad máxima de personas que pueden sentarse en la mesa.
     */
    public int getCapacidad() {
        return capacidad;
    }

    /**
     * Establece la capacidad máxima de la mesa.
     * 
     * @param capacidad Número máximo de personas a establecer.
     */
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    /**
     * Obtiene la ubicación de la mesa dentro del restaurante.
     * 
     * @return La ubicación de la mesa (por ejemplo: Terraza, Ventana, General).
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Establece la ubicación de la mesa dentro del restaurante.
     * 
     * @param ubicacion Ubicación de la mesa a establecer (por ejemplo: Terraza, Ventana, General).
     */
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    /**
     * Representa la mesa como una cadena de texto.
     * 
     * @return Una cadena con los detalles de la mesa, incluyendo el código, tipo, capacidad y ubicación.
     */
    @Override
    public String toString() {
        return "MesaEntidad{" + "codigoMesa='" + codigoMesa + '\'' + ", tipo='" + tipo + '\'' + ", capacidad=" + capacidad + ", ubicacion='" + ubicacion + '\'' + '}';
    }
}
