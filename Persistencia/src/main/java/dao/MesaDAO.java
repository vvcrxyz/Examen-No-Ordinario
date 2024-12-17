package dao;

import entidades.MesaEntidad;
import interfaces.IMesa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 * Clase que maneja las operaciones de persistencia de la entidad `MesaEntidad`.
 * Proporciona métodos para guardar, eliminar, modificar, y buscar mesas en la base de datos.
 * Utiliza JPA (Java Persistence API) para interactuar con la base de datos.
 *
 * @author limon limon
 */
public class MesaDAO implements IMesa {
    
    // Instancias para manejar el contexto de persistencia
    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;

    // Constructor vacío
    public MesaDAO() {
    }

    /**
     * Guarda una nueva mesa en la base de datos.
     * 
     * @param mesa la mesa que se desea guardar
     */
    @Override
    public void guardarMesa(MesaEntidad mesa) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(mesa);

            // Todo salió bien, se confirma la transacción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                // En caso de error, se hace rollback de la transacción
                transaction.rollback();
                JOptionPane.showMessageDialog(null, "Error en Persistencia = " + e.getMessage());
            }
            // Imprime la traza del error en la consola
        } finally {
            if (entityManager != null) {
                // Cerramos el EntityManager
                entityManager.close();
            }
        }
    }

    /**
     * Elimina una mesa de la base de datos.
     * 
     * @param mesa la mesa que se desea eliminar
     */
    @Override
    public void eliminarMesa(MesaEntidad mesa) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Eliminamos la entidad de la base de datos
            entityManager.remove(entityManager.contains(mesa) ? mesa : entityManager.merge(mesa));

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
     * Modifica los datos de una mesa en la base de datos.
     * 
     * @param mesa la mesa con los datos actualizados
     */
    public void modificarMesa(MesaEntidad mesa) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Actualizamos la entidad en la base de datos
            entityManager.merge(mesa);

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
     * Busca las mesas por seccion.
     * 
     * @param ubicacion la seccion
     * @return Una lista de objetos `Mesa` que cumplen con los criterios de disponibilidad. Si no se encuentran mesas
     *         disponibles, se devuelve una lista vacía.
     * @throws PersistenciaException
     */
    public List<MesaEntidad> buscarMesasPorUbicacion(String ubicacion) throws Exception{
    
        EntityManager entityManager = null;
        List<MesaEntidad> mesasDisponibles = null;

        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            String jpql = "SELECT m FROM tblMesa m " +
                          "WHERE m.ubicacion = :ubicacion";
            
            
            TypedQuery<MesaEntidad> query = entityManager.createQuery(jpql, MesaEntidad.class);
            query.setParameter("ubicacion", ubicacion);


            mesasDisponibles = query.getResultList();


        } catch (Exception e) {

            
        } finally {
            if (entityManager != null) {
                entityManager.close(); // Cierra el EntityManager.
            }
        }
        
        return mesasDisponibles;
        
    }

    /**
     * Busca una mesa en la base de datos por su ID.
     * 
     * @param id el ID de la mesa que se desea buscar
     * @return la mesa con el ID proporcionado, o null si no se encuentra
     */
    public MesaEntidad buscarUnaMesa(Long id) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos la entidad en la base de datos
            MesaEntidad mesa = entityManager.find(MesaEntidad.class, id);

            // Regresamos la entidad
            return mesa;
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
     * Busca todas las mesas en la base de datos.
     * 
     * @return una lista de todas las mesas en la base de datos
     */
    public List<MesaEntidad> buscarTodasMesas() {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos las entidades en la base de datos
            TypedQuery<MesaEntidad> query = entityManager.createQuery("SELECT a FROM MesaEntidad a", MesaEntidad.class);

            // Regresamos la lista de mesas
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
