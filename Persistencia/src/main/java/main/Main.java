/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import entidades.RestauranteEntidad;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;
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
        
        ///////////////////////////
        ///////////////////////////
       ///CREACION DE CLIENTE A BD///
      ///////////////////////////
     ///////////////////////////
        
//        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
//        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
//        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
//        EntityManager entityManager = managerFactory.createEntityManager();
//        //INICIAMOS LA TRANSACCION
//        entityManager.getTransaction().begin();
//        
//        ClienteEntidad entidad = new ClienteEntidad("Nomar Alberto Limon Quintero", "6441535941");
//        
//        entityManager.persist(entidad );
//
//        //MANDAMOS A EJECUTAR LA TRANSACCION
//        entityManager.getTransaction().commit();
//        //CERRAMOS
//        entityManager.close();
//        managerFactory.close();
        
         ///////////////////////////
        ///////////////////////////
       ///CREACION DE MESA A BD///
      ///////////////////////////
     /////////////////////////// 
     
//     // CREAMOS UNA FACTORY DE ENTITY MANAGERS
//        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
//        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
//        EntityManager entityManager = managerFactory.createEntityManager();
//        //INICIAMOS LA TRANSACCION
//        entityManager.getTransaction().begin();
//        
//        MesaEntidad entidad = new MesaEntidad("VEN-02-001", "Pequeña", 2, "Ventana");
//        
//        entityManager.persist(entidad );
//
//        //MANDAMOS A EJECUTAR LA TRANSACCION
//        entityManager.getTransaction().commit();
//        //CERRAMOS
//        entityManager.close();
//        managerFactory.close();
     
         //////////////////////////////
        //////////////////////////////
       ///CREACION DE RESERVA A BD///
      //////////////////////////////
     //////////////////////////////  
     
//     // CREAMOS UNA FACTORY DE ENTITY MANAGERS
//        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");
//        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
//        EntityManager entityManager = managerFactory.createEntityManager();
//        //INICIAMOS LA TRANSACCION
//        entityManager.getTransaction().begin();
//        
//        ReservaEntidad entidad = new ReservaEntidad("Nomar Alberto Limon Quintero", 
//            "6441535344", LocalDateTime.of(2024, 12, 25, 19, 30), // fechaHoraReserva (25 de diciembre de 2024 a las 19:30)
//                "Mi casa", 4, 250.50, "Activo" );
//        
//        entityManager.persist(entidad );
//
//        //MANDAMOS A EJECUTAR LA TRANSACCION
//        entityManager.getTransaction().commit();
//        //CERRAMOS
//        entityManager.close();
//        managerFactory.close();
     
         //////////////////////////////////
        //////////////////////////////////
       ///CREACION DE RESTAURANTE A BD///
      //////////////////////////////////
     //////////////////////////////////
     
     // Definir las horas de apertura y cierre
        Time horaApertura = Time.valueOf("08:00:00");
        Time horaCierre = Time.valueOf("22:00:00");

        // Creamos una lista de ubicaciones
        // Por ejemplo, "mi casa" es una ubicación en la lista
        List<String> ubicacion = Arrays.asList("mi casa");

        // CREAMOS UNA FACTORY DE ENTITY MANAGERS
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("ConexionJPA");

        // CREAMOS UN OBJETO EM QUE REPRESENTA A LA BD EN CÓDIGO
        EntityManager entityManager = managerFactory.createEntityManager();

        // INICIAMOS LA TRANSACCION
        entityManager.getTransaction().begin();

        // CREAMOS LA ENTIDAD Y LA PERSISTIMOS EN LA BASE DE DATOS
        RestauranteEntidad entidad = new RestauranteEntidad(horaApertura, horaCierre, ubicacion);
        entityManager.persist(entidad);

        // MANDAMOS A EJECUTAR LA TRANSACCION
        entityManager.getTransaction().commit();

        // CERRAMOS
        entityManager.close();
        managerFactory.close();
    }
    
}
