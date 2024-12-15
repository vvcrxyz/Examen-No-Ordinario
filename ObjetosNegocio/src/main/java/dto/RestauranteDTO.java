/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.RestauranteEntidad;
import java.sql.Time;

/**
 *
 * @author limon
 */
public class RestauranteDTO {
    
    private Long id;
    private Time horaApertura;
    private Time horaCierre;

    public RestauranteDTO() {
    }

    public RestauranteDTO(Time horaApertura, Time horaCierre) {
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }

    public RestauranteDTO(Long id, Time horaApertura, Time horaCierre) {
        this.id = id;
        this.horaApertura = horaApertura;
        this.horaCierre = horaCierre;
    }
    
    public RestauranteDTO(RestauranteEntidad r) {
        this.id = r.getId();
        this.horaApertura = r.getHoraApertura();
        this.horaCierre = r.getHoraCierre();
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
        return "RestauranteDTO{" + "id=" + id + ", horaApertura=" + horaApertura + ", horaCierre=" + horaCierre + '}';
    }
    
    
}

