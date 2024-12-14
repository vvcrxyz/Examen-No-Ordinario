/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import entidades.ClienteEntidad;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author limon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
        EntityManager entityManager = managerFactory.createEntityManager();
        //INICIAMOS LA TRANSACCION
        entityManager.getTransaction().begin();
        
        ClienteEntidad entidad = new ClienteEntidad("Nomar Alberto Limon Quintero", "nomar@gmail.com", "6441535360");
        
        entityManager.persist(entidad );

        //MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();
        //CERRAMOS
        entityManager.close();
        managerFactory.close();
        
    }
    
}
