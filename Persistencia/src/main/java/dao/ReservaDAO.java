package dao;

import conexion.ConexionBD;
import entidades.ClienteEntidad;
import entidades.MesaEntidad;
import entidades.ReservaEntidad;
import interfaces.IReserva;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 * Esta clase maneja las operaciones de persistencia para la entidad ReservaEntidad
 * en la base de datos utilizando JPA (Java Persistence API). Incluye métodos para
 * guardar, eliminar, modificar, buscar una reserva por ID y obtener todas las reservas.
 */
public class ReservaDAO implements IReserva{
    
    // Instancias para manejar el contexto de persistencia
    private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
    private EntityManager entityManager = null;
    private EntityTransaction transaction = null;

    /**
     * Constructor vacío de la clase ReservaDAO.
     * Inicializa el contexto de persistencia al momento de usar los métodos.
     */
    public ReservaDAO() {
        // Constructor vacío
    }

    /**
     * Crea un EntityManager para realizar operaciones de persistencia.
     * 
     * @return El EntityManager creado.
     */
    private EntityManager createEntityManager() {
        return managerFactory.createEntityManager();
    }

    /**
     * Guarda una reserva en la base de datos.
     * 
     * @param reserva La reserva que se va a guardar.
     */
    public void guardarReserva(ReservaEntidad reserva) {
        try {
            entityManager = createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(reserva);

            // Confirmamos la transacción si todo salió bien
            transaction.commit();
        } catch (Exception e) {
            handleTransactionException(e);
        } finally {
            closeEntityManager();
        }
    }

    /**
     * Elimina una reserva de la base de datos.
     * 
     * @param reserva La reserva que se va a eliminar.
     */
    public void eliminarReserva(ReservaEntidad reserva) {
        try {
            entityManager = createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(reserva) ? reserva : entityManager.merge(reserva));

            // Confirmamos la transacción si todo salió bien
            transaction.commit();
        } catch (Exception e) {
            handleTransactionException(e);
        } finally {
            closeEntityManager();
        }
    }

    /**
     * Modifica una reserva en la base de datos.
     * 
     * @param reserva La reserva que se va a modificar.
     */
    public void modificarReserva(ReservaEntidad reserva) {
        try {
            entityManager = createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(reserva);

            // Confirmamos la transacción si todo salió bien
            transaction.commit();
        } catch (Exception e) {
            handleTransactionException(e);
        } finally {
            closeEntityManager();
        }
    }

    /**
     * Busca una reserva en la base de datos por su ID.
     * 
     * @param id El ID de la reserva a buscar.
     * @return La reserva encontrada, o null si no se encuentra.
     */
    public ReservaEntidad buscarUnaReserva(Long id) {
        try {
            entityManager = createEntityManager();
            return entityManager.find(ReservaEntidad.class, id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            return null;
        } finally {
            closeEntityManager();
        }
    }

    /**
     * Busca todas las reservas por cliente.
     * 
     * @param cliente El cliente para el cual se buscan las reservas.
     * @return Una lista con todas las reservas de ese cliente.
     */
    public List<ReservaEntidad> buscarReservaPorCliente(ClienteEntidad cliente) {
        List<ReservaEntidad> listaReservas = new ArrayList<>();
        try {
            entityManager = createEntityManager();

            String jpql = "SELECT r FROM ReservaEntidad r WHERE r.cliente = :codigo";
            TypedQuery<ReservaEntidad> query = entityManager.createQuery(jpql, ReservaEntidad.class);
            query.setParameter("codigo", cliente);

            listaReservas = query.getResultList();
        } catch (Exception e) {
            System.out.println("Error al buscar las reservas: " + e.getMessage());
        } finally {
            closeEntityManager();
        }
        return listaReservas.isEmpty() ? null : listaReservas;
    }
    
    /**
     * Busca todas las reservas por mesa
     * 
     * @param mesa la mesa en cuesttión
     * @return Una lista con todas las reservas con ese mesa
     * @throws PersistenciaException Si ocurre un error al realizar la consulta.
     */
  
    public List<ReservaEntidad> buscarReservaPorMesa(MesaEntidad mesa) throws Exception {

        EntityManager entityManager = null;

        List<ReservaEntidad> listaReservas = new ArrayList<>();
        
        try {
            entityManager = createEntityManager();

            String jpql = "SELECT r FROM Reserva r " +
                          "WHERE r.mesa = :codigo";
            
            TypedQuery<ReservaEntidad> query = entityManager.createQuery(jpql, ReservaEntidad.class);

            query.setParameter("codigo", mesa);

            listaReservas = query.getResultList();


        } catch (Exception e) {

            System.out.println("Error al buscar las reservas en persistencia" + e);
            
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        if(listaReservas == null || listaReservas.isEmpty())
            return null;
        
        return listaReservas;
        
    }

    /**
     * Busca todas las reservas en la base de datos.
     * 
     * @return Una lista con todas las reservas o null si ocurre un error.
     */
    public List<ReservaEntidad> buscarTodasReservas() {
        try {
            entityManager = createEntityManager();
            TypedQuery<ReservaEntidad> query = entityManager.createQuery("SELECT r FROM ReservaEntidad r", ReservaEntidad.class);
            return query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            return null;
        } finally {
            closeEntityManager();
        }
    }

    /**
     * Maneja las excepciones durante una transacción.
     * 
     * @param e La excepción que ocurrió durante la transacción.
     */
    private void handleTransactionException(Exception e) {
        if (transaction != null && transaction.isActive()) {
            transaction.rollback();
        }
        JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
        e.printStackTrace();
    }

    /**
     * Cierra el EntityManager.
     */
    private void closeEntityManager() {
        if (entityManager != null) {
            entityManager.close();
        }
    }
}
