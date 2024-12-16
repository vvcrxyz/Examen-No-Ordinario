/*
 * Interfaz para las operaciones relacionadas con la entidad `RestauranteEntidad`.
 * Proporciona métodos para gestionar los restaurantes en un sistema, incluyendo guardar, eliminar,
 * modificar, buscar un restaurante por ID y obtener todos los restaurantes.
 */

package interfaces;

import entidades.RestauranteEntidad;
import java.util.List;

/**
 * Esta interfaz define el contrato para las operaciones relacionadas con los restaurantes (`RestauranteEntidad`).
 * Incluye métodos para guardar, eliminar, modificar, buscar un restaurante por su ID y obtener todos los restaurantes.
 * Las clases que implementen esta interfaz deben proporcionar la lógica específica para estas operaciones.
 *
 * @author limon
 */
public interface IRestaurante {
    
    /**
     * Guarda un nuevo restaurante en el sistema.
     * 
     * @param restaurante la entidad del restaurante que se va a guardar
     */
    public void guardarRestaurante(RestauranteEntidad restaurante);

    /**
     * Elimina un restaurante del sistema.
     * 
     * @param restaurante la entidad del restaurante que se va a eliminar
     */
    public void eliminarRestaurante(RestauranteEntidad restaurante);

    /**
     * Modifica los detalles de un restaurante existente en el sistema.
     * 
     * @param restaurante la entidad del restaurante con los datos actualizados
     */
    public void modificarRestaurante(RestauranteEntidad restaurante);

    /**
     * Recupera un restaurante por su ID único.
     * 
     * @param id el identificador único del restaurante
     * @return el objeto `RestauranteEntidad` que coincide con el ID dado, o null si no se encuentra
     */
    public RestauranteEntidad buscarUnRestaurante(Long id);

    /**
     * Recupera todos los restaurantes del sistema.
     * 
     * @return una lista de todas las entidades `RestauranteEntidad`
     */
    public List<RestauranteEntidad> buscarTodosRestaurantes();
}
