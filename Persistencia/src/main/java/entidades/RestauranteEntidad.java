/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author limon
 */
@Entity
@Table(name = "tblRestaurante")
public class RestauranteEntidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "horaApertura", nullable = false)
    private Time horaApertura;
    
    @Column(name = "horaCierre", nullable = false)
    private Time horaCierre;
   
    @ElementCollection
    @CollectionTable(name = "restaurante_ubicaciones", joinColumns = @JoinColumn(name = "restaurante_id"))
    @Column(nullable = false)
    private List<String> ubicacion;



    public RestauranteEntidad() {
    }

    public RestauranteEntidad(Time horaApertura, Time horaCierre) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    
    
    public RestauranteEntidad(Time horaApertura, Time horaCierre, List<String> ubicacion) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.ubicacion = ubicacion;
    }

    
    
    public RestauranteEntidad(Long id, Time horaApertura, Time horaCierre, List<String> ubicacion) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
        this.ubicacion = ubicacion;

    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Time getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Time horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Time getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Time horaCierre) {
        this.horaCierre = horaCierre;
    }

    @Override
    public String toString() {
        return "RestauranteEntidad{" + "id=" + id + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre +'}';
    }

    
    
}
