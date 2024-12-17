package dao;

import entidades.RestauranteEntidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
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
 * @author limon
 */
public class RestauranteDAO {
    
    // Instancias para manejar el contexto de persistencia
    private EntityManager entityManager = null;
    private EntityManagerFactory managerFactory = null;
    private EntityTransaction transaction = null;

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
     * Obtiene los datos del restaurante desde la base de datos.
     * Realiza una consulta SQL para recuperar la hora de apertura y cierre del restaurante
     * y devuelve un objeto de tipo {@link RestauranteEntidad} con los datos obtenidos.
     * 
     * @return Un objeto {@link RestauranteEntidad} con la hora de apertura y cierre del restaurante,
     *         o null si no se encuentran los datos.
     */
    public RestauranteEntidad obtenerRestaurante() {
        RestauranteEntidad restaurante = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");

            // Consulta SQL para obtener los datos del restaurante
            String query = "SELECT hora_apertura, hora_cierre FROM restaurante LIMIT 1";  // Ejemplo de consulta
            stmt = conn.prepareStatement(query);

            rs = stmt.executeQuery();

            // Si la consulta devuelve resultados, los procesamos
            if (rs.next()) {
                // Recuperamos las horas de apertura y cierre del restaurante
                Time horaAperturaSQL = rs.getTime("hora_apertura");
                Time horaCierreSQL = rs.getTime("hora_cierre");

                // Convertimos de Time a LocalTime
                LocalTime horaApertura = horaAperturaSQL.toLocalTime();
                LocalTime horaCierre = horaCierreSQL.toLocalTime();

                // Creamos el objeto RestauranteEntidad con los datos obtenidos
                restaurante = new RestauranteEntidad(horaApertura, horaCierre);
            }
        } catch (SQLException e) {
            // Manejo de excepciones
            e.printStackTrace();
        } finally {
            // Cerrar los recursos para evitar filtraciones de memoria
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Retornamos el objeto RestauranteEntidad con los datos
        return restaurante;
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
    
    /**
     * Busca el único restaurante existente en la base de datos.
     * 
     * @return La entidad del restaurante si existe, o null si no hay ningún registro.
     */
    public RestauranteEntidad buscarRestauranteUnico() {
        RestauranteEntidad restaurante = null;
        try {
            // Configurar el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Realizamos una consulta para obtener un único restaurante
            TypedQuery<RestauranteEntidad> query = entityManager.createQuery(
               "SELECT r FROM RestauranteEntidad r", RestauranteEntidad.class);
            query.setMaxResults(1); // Solo queremos un registro

            // Obtener el resultado
            List<RestauranteEntidad> resultados = query.getResultList();
            if (!resultados.isEmpty()) {
                restaurante = resultados.get(0); // Retorna el primer resultado
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al buscar restaurante: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return restaurante;
    }
}
