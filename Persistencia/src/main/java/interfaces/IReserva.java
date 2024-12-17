/*
 * Interfaz para las operaciones relacionadas con la entidad `ReservaEntidad`.
 * Proporciona métodos para gestionar las reservas en un sistema, incluyendo guardar, eliminar,
 * modificar, buscar una reserva por ID y obtener todas las reservas.
 */

package interfaces;

import entidades.ClienteEntidad;
import entidades.MesaEntidad;
import entidades.ReservaEntidad;
import java.util.List;

/**
 * Esta interfaz define el contrato para las operaciones relacionadas con las reservas (`ReservaEntidad`).
 * Incluye métodos para guardar, eliminar, modificar, buscar una reserva por su ID y obtener todas las reservas.
 * Las clases que implementen esta interfaz deben proporcionar la lógica específica para estas operaciones.
 *
 * @author limon
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
     * Busca todas las reservas por mesa
     * 
     * @param mesa la mesa en cuesttión
     * @return Una lista con todas las reservas con ese mesa
     *
     */
    public List<ReservaEntidad> buscarReservaPorMesa(MesaEntidad mesa) throws Exception;
    
    /**
     * Busca todas las reservas por cliente
     * 
     * @param cliente el cliente en cuesttión
     * @return Una lista con todas las reservas con ese cliente
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
    public List<ReservaEntidad> buscarReservaPorCliente(ClienteEntidad cliente);
    /**
     * Recupera todas las reservas del sistema.
     * 
     * @return una lista de todas las entidades `ReservaEntidad`
     */
    public List<ReservaEntidad> buscarTodasReservas();
}
