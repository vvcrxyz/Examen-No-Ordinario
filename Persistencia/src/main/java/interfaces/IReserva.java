/*
 * Interfaz para las operaciones relacionadas con la entidad `ReservaEntidad`.
 * Proporciona métodos para gestionar las reservas en un sistema, incluyendo guardar, eliminar,
 * modificar, buscar una reserva por ID y obtener todas las reservas.
 */

package interfaces;

import entidades.ReservaEntidad;
import java.util.List;

/**
 * Esta interfaz define el contrato para las operaciones relacionadas con las reservas (`ReservaEntidad`).
 * Incluye métodos para guardar, eliminar, modificar, buscar una reserva por su ID y obtener todas las reservas.
 * Las clases que implementen esta interfaz deben proporcionar la lógica específica para estas operaciones.
 *
 * @autor limon
 */
public interface IReserva {
    
    /**
     * Guarda una nueva reserva en el sistema.
     * 
     * @param reserva la entidad de la reserva que se va a guardar
     */
    public void guardarReserva(ReservaEntidad reserva);

    /**
     * Elimina una reserva del sistema.
     * 
     * @param reserva la entidad de la reserva que se va a eliminar
     */
    public void eliminarReserva(ReservaEntidad reserva);

    /**
     * Modifica los detalles de una reserva existente en el sistema.
     * 
     * @param reserva la entidad de la reserva con los datos actualizados
     */
    public void modificarReserva(ReservaEntidad reserva);

    /**
     * Recupera una reserva por su ID único.
     * 
     * @param id el identificador único de la reserva
     * @return el objeto `ReservaEntidad` que coincide con el ID dado, o null si no se encuentra
     */
    public ReservaEntidad buscarUnReserva(Long id);

    /**
     * Recupera todas las reservas del sistema.
     * 
     * @return una lista de todas las entidades `ReservaEntidad`
     */
    public List<ReservaEntidad> buscarTodasReservas();
}
