package dao;

import entidades.ReservaEntidad;
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
public class ReservaDAO {
    
    // Instancias para manejar el contexto de persistencia
    private EntityManager entityManager = null;
    private EntityManagerFactory managerFactory = null;
    private EntityTransaction transaction = null;

    /**
     * Constructor vacío de la clase ReservaDAO.
     * Inicializa el contexto de persistencia al momento de usar los métodos.
     */
    public ReservaDAO() {
        // Constructor vacío
    }

    /**
     * Guarda una reserva en la base de datos.
     * 
     * @param reserva La reserva que se va a guardar.
     */
    public void guardarReserva(ReservaEntidad reserva) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(reserva);

            // Confirmamos la transacción si todo salió bien
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // Si ocurre un error, se hace rollback de la transacción
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            }
            e.printStackTrace(); // Imprime la traza del error en la consola
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }

    /**
     * Elimina una reserva de la base de datos.
     * 
     * @param reserva La reserva que se va a eliminar.
     */
    public void eliminarReserva(ReservaEntidad reserva) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(reserva) ? reserva : entityManager.merge(reserva));

            // Confirmamos la transacción si todo salió bien
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // Si ocurre un error, se hace rollback de la transacción
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            }
            e.printStackTrace(); // Imprime la traza del error en la consola
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }

    /**
     * Modifica una reserva en la base de datos.
     * 
     * @param reserva La reserva que se va a modificar.
     */
    public void modificarReserva(ReservaEntidad reserva) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(reserva);

            // Confirmamos la transacción si todo salió bien
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // Si ocurre un error, se hace rollback de la transacción
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            }
            e.printStackTrace(); // Imprime la traza del error en la consola
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
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
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos la entidad en la base de datos
            ReservaEntidad reserva = entityManager.find(ReservaEntidad.class, id);

            // Regresamos la reserva encontrada
            return reserva;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            return null;
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                System.out.println("Cerrando el EntityManager");
                entityManager.close();
            }
        }
    }

    /**
     * Busca todas las reservas en la base de datos.
     * 
     * @return Una lista con todas las reservas o null si ocurre un error.
     */
    public List<ReservaEntidad> buscarTodasReservas() {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Creamos la consulta para obtener todas las reservas
            TypedQuery<ReservaEntidad> query = entityManager.createQuery("SELECT a FROM ReservaEntidad a", ReservaEntidad.class);

            // Regresamos la lista de reservas encontradas
            return query.getResultList();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            return null;
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }
}
