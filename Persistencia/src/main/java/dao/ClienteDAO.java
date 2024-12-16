package dao;

import conexion.ConexionBD;
import entidades.ClienteEntidad;
import interfaces.ICliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 * Esta clase implementa la interfaz ICliente y maneja las operaciones de persistencia
 * para la entidad ClienteEntidad en la base de datos utilizando JPA (Java Persistence API).
 * Incluye métodos para guardar un cliente, buscar un cliente por su ID y buscar todos los clientes.
 */
public class ClienteDAO implements ICliente {

    // Instancias para manejar el contexto de persistencia
    private EntityManager entityManager = null;
    private EntityManagerFactory managerFactory = null;
    private EntityTransaction transaction = null;

    /**
     * Constructor vacío de la clase ClienteDAO.
     * Inicializa el contexto de persistencia al momento de usar los métodos.
     */
    public ClienteDAO() {
        // Constructor vacío
    }

    /**
     * Guarda un cliente en la base de datos.
     * 
     * @param cliente El cliente que se va a guardar.
     */
    public void guardarCliente(ClienteEntidad cliente) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();
            transaction = entityManager.getTransaction();
            transaction.begin();

            // Persistimos la entidad en la base de datos
            entityManager.persist(cliente);

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
     * Busca un cliente en la base de datos por su ID.
     * 
     * @param id El ID del cliente a buscar.
     * @return El cliente encontrado, o null si no se encuentra.
     */
    public ClienteEntidad buscarUnCliente(Long id) {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos la entidad ClienteEntidad en la base de datos por su ID
            ClienteEntidad cliente = entityManager.find(ClienteEntidad.class, id);

            // Regresamos el cliente encontrado
            return cliente;
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
     * Busca todos los clientes en la base de datos.
     * 
     * @return Una lista con todos los clientes o null si ocurre un error.
     */
    public List<ClienteEntidad> buscarTodosClientes() {
        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Creamos la consulta para obtener todos los clientes
            TypedQuery<ClienteEntidad> query = entityManager.createQuery("SELECT a FROM ClienteEntidad a", ClienteEntidad.class);

            // Regresamos la lista de clientes encontrados
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
