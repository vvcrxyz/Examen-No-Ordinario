/*
 * Interfaz para las operaciones relacionadas con la entidad `MesaEntidad`.
 * Proporciona métodos para gestionar las mesas en un sistema, incluyendo guardar, eliminar,
 * modificar, buscar una mesa por ID y obtener todas las mesas.
 */

package interfaces;

import entidades.MesaEntidad;
import java.util.List;

/**
 * Esta interfaz define el contrato para las operaciones relacionadas con las mesas (`MesaEntidad`).
 * Incluye métodos para guardar, eliminar, modificar, buscar una mesa por su ID y obtener todas las mesas.
 * Las clases que implementen esta interfaz deben proporcionar la lógica específica para estas operaciones.
 *
 * @author limon
 */
public interface IMesa {
    
    /**
     * Guarda una nueva mesa en el sistema.
     * 
     * @param mesa la entidad de la mesa que se va a guardar
     */
    public void guardarMesa(MesaEntidad mesa);

    /**
     * Elimina una mesa del sistema.
     * 
     * @param mesa la entidad de la mesa que se va a eliminar
     */
    public void eliminarMesa(MesaEntidad mesa);

    /**
     * Modifica los detalles de una mesa existente en el sistema.
     * 
     * @param mesa la entidad de la mesa con los datos actualizados
     */
    public void modificarMesa(MesaEntidad mesa);

    /**
     * Recupera una mesa por su ID único.
     * 
     * @param id el identificador único de la mesa
     * @return el objeto `MesaEntidad` que coincide con el ID dado, o null si no se encuentra
     */
    public MesaEntidad buscarUnMesa(Long id);

    /**
     * Recupera todas las mesas del sistema.
     * 
     * @return una lista de todas las entidades `MesaEntidad`
     */
    public List<MesaEntidad> buscarTodasMesas();
}
