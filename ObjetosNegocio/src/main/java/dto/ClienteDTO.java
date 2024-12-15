/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entidades.ClienteEntidad;

/**
 *
 * @author limon
 */
public class ClienteDTO {
    
    private Long id;
    private String nombreCompleto;
    private String telefono;

    public ClienteDTO() {
    }

    public ClienteDTO(String nombreCompleto,  String telefono) {
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public ClienteDTO(Long id, String nombreCompleto, String telefono) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
    }

    public ClienteDTO(ClienteEntidad c) {
        this.id = c.getId();
        this.nombreCompleto = c.getNombreCompleto();
        this.telefono = c.getTelefono();
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }    

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "ClienteDTO{" + "id=" + id + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + '}';
    }
    
    
}
