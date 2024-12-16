/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import dao.MesaDAO;
import dto.MesaDTO;
import entidades.MesaEntidad;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author limon
 */
public class MesaNegocio {
    
    private final MesaDAO mesaDAO;

    // Constructor
    public MesaNegocio() {
        this.mesaDAO = new MesaDAO();
    }

    // Conversión de ClienteDTO a ClienteEntidad
    private MesaEntidad convertir(MesaDTO dto) {
        MesaEntidad entidad = new MesaEntidad();
        entidad.setId(dto.getId());
        entidad.setCodigoMesa(dto.getCodigoMesa());
        entidad.setTipo(dto.getTipo());
        entidad.setCapacidad(dto.getCapacidad()); 
        entidad.setUbicacion(dto.getUbicacion()); 
        return entidad;
    }

    // Conversión de ClienteEntidad a ClienteDTO
    private MesaDTO convertir(MesaEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new MesaDTO(entidad);
    }

    // Guardar un cliente
    public void guardarMesa(MesaDTO c) {
        mesaDAO.guardarMesa(convertir(c));
    }

    // Modificar un cliente
    public void modificarMesa(MesaDTO c) {
        mesaDAO.modificarMesa(convertir(c));
    }

    // Eliminar un cliente
    public void eliminarMesa(MesaDTO c) {
        mesaDAO.eliminarMesa(convertir(c));
    }

    // Buscar una mesa por ID
    public MesaDTO buscarCliente(Long id) {
        MesaEntidad entidad = mesaDAO.buscarUnaMesa(id);
        return convertir(entidad);
    }

    // Buscar todos los clientes
    public List<MesaDTO> buscarTodasMesas() {
        List<MesaEntidad> entidades = mesaDAO.buscarTodasMesas();
        List<MesaDTO> mesas = new ArrayList<>();

        for (MesaEntidad entidad : entidades) {
            mesas.add(convertir(entidad));
        }
        return mesas;
    }
    
    
}
