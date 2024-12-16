/*
 * Interfaz para las operaciones relacionadas con la entidad `ClienteEntidad`.
 * Proporciona métodos para gestionar los clientes en un sistema, incluyendo guardar,
 * recuperar un cliente por su ID y obtener todos los clientes.
 */

package interfaces;

import entidades.ClienteEntidad;
import java.util.List;

/**
 * Esta interfaz define el contrato para las operaciones relacionadas con los clientes (`ClienteEntidad`).
 * Incluye métodos para guardar un cliente, buscar un cliente por su ID y obtener todos los clientes.
 * Las clases que implementen esta interfaz deben proporcionar la lógica específica para estas operaciones.
 *
 * @autor limon
 */
public interface ICliente {
    
    /**
     * Guarda un cliente nuevo o existente en el sistema.
     * 
     * @param cliente la entidad del cliente que se va a guardar
     */
    public void guardarCliente(ClienteEntidad cliente);

    
    /**
     * Recupera un único cliente por su ID único.
     * 
     * @param id el identificador único del cliente
     * @return el objeto `ClienteEntidad` que coincide con el ID dado, o null si no se encuentra
     */
    public ClienteEntidad buscarUnCliente(Long id);

    
    /**
     * Recupera todos los clientes del sistema.
     * 
     * @return una lista de todas las entidades `ClienteEntidad`
     */
    public List<ClienteEntidad> buscarTodosClientes();
    
}
