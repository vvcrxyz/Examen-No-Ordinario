package dao;

import entidades.RestauranteEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 * Clase que maneja las operaciones de persistencia de la entidad `RestauranteEntidad`.
 * Proporciona métodos para guardar, eliminar, modificar y buscar restaurantes en la base de datos.
 * Utiliza JPA (Java Persistence API) para interactuar con la base de datos.
 *
 * @autor limon
 */
public class RestauranteDAO {
    
    // Instancias para manejar el contexto de persistencia
    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;

    // Constructor vacío
    public RestauranteDAO() {
    }

    /**
     * Guarda un nuevo restaurante en la base de datos.
     * 
     * @param restaurante el restaurante que se desea guardar
     */
    public void guardarRestaurante(RestauranteEntidad restaurante) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(restaurante);

            // Todo salió bien, se confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // En caso de error, se hace rollback de la transacción
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
     * Elimina un restaurante de la base de datos.
     * 
     * @param restaurante el restaurante que se desea eliminar
     */
    public void eliminarRestaurante(RestauranteEntidad restaurante) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(restaurante) ? restaurante : entityManager.merge(restaurante));

            // Todo salió bien, se confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // En caso de error, se hace rollback de la transacción
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
     * Modifica los datos de un restaurante en la base de datos.
     * 
     * @param restaurante el restaurante con los datos actualizados
     */
    public void modificarRestaurante(RestauranteEntidad restaurante) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(restaurante);

            // Todo salió bien, se confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // En caso de error, se hace rollback de la transacción
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
     * Busca un restaurante en la base de datos por su ID.
     * 
     * @param id el ID del restaurante que se desea buscar
     * @return el restaurante con el ID proporcionado, o null si no se encuentra
     */
    public RestauranteEntidad buscarUnRestaurante(Long id) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos la entidad en la base de datos
            RestauranteEntidad restaurante = entityManager.find(RestauranteEntidad.class, id);

            // Regresamos la entidad
            return restaurante;
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

    /**
     * Busca todos los restaurantes en la base de datos.
     * 
     * @return una lista de todos los restaurantes en la base de datos
     */
    public List<RestauranteEntidad> buscarTodosRestaurantes() {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos las entidades en la base de datos
            TypedQuery<RestauranteEntidad> query = entityManager.createQuery("SELECT a FROM RestauranteEntidad a", RestauranteEntidad.class);

            // Regresamos la lista de restaurantes
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
