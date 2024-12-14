/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entidades.ClienteEntidad;
import entidades.RestauranteEntidad;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

/**
 *
 * @author limon
 */
public class RestauranteDAO {
    
    // Instancias para manejar el contexto de persistencia
    EntityManager entityManager = null;
    EntityManagerFactory managerFactory = null;
    EntityTransaction transaction = null;


    public RestauranteDAO() {
        // Constructor vacío
    }


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
                System.out.println("cierras");
                entityManager.close();
            }
        }

    }


    public List<RestauranteEntidad> buscarTodosRestaurantes() {

        try {
            // Construimos el EntityManager
            managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
            entityManager = managerFactory.createEntityManager();

            // Buscamos las entidades en la base de datos
            TypedQuery<RestauranteEntidad> query = entityManager.createQuery("SELECT a FROM RestauranteEntidad a", RestauranteEntidad.class);

            // Regresamos la entidad
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
