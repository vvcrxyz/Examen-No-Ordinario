package logica;

import dao.ClienteDAO;
import dto.ClienteDTO;
import entidades.ClienteEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio para gestionar clientes.
 */
public class ClienteNegocio {

    private final ClienteDAO clienteDAO;

    // Constructor
    public ClienteNegocio() {
        this.clienteDAO = new ClienteDAO();
    }

    // Conversión de ClienteDTO a ClienteEntidad
    private ClienteEntidad convertir(ClienteDTO dto) {
        ClienteEntidad entidad = new ClienteEntidad();
        entidad.setId(dto.getId());
        entidad.setNombreCompleto(dto.getNombreCompleto());
        entidad.setTelefono(dto.getTelefono()); 
        return entidad;
    }

    // Conversión de ClienteEntidad a ClienteDTO
    private ClienteDTO convertir(ClienteEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new ClienteDTO(entidad);
    }

    // Guardar un cliente
    public void guardarCliente(ClienteDTO c) {
        clienteDAO.guardarCliente(convertir(c));
    }

    // Modificar un cliente
    public void modificarCliente(ClienteDTO c) {
        clienteDAO.modificarCliente(convertir(c));
    }

    // Eliminar un cliente
    public void eliminarCliente(ClienteDTO c) {
        clienteDAO.eliminarCliente(convertir(c));
    }

    // Buscar un cliente por ID
    public ClienteDTO buscarCliente(Long id) {
        ClienteEntidad entidad = clienteDAO.buscarUnCliente(id);
        return convertir(entidad);
    }

    // Buscar todos los clientes
    public List<ClienteDTO> buscarTodosClientes() {
        List<ClienteEntidad> entidades = clienteDAO.buscarTodosClientes();
        List<ClienteDTO> clientes = new ArrayList<>();

        for (ClienteEntidad entidad : entidades) {
            clientes.add(convertir(entidad));
        }
        return clientes;
    }
    
    public List<ClienteDTO> buscarClientes() {
        List<ClienteDTO> carreras = new ArrayList<>();
        List<ClienteEntidad> bE = new ArrayList<>();
        bE = clienteDAO.buscarTodosClientes();
        
        if (carreras != null) {
            for (ClienteEntidad y : bE) {
                ClienteDTO x = new ClienteDTO(y);
                carreras.add(x);
            }
            return carreras;
        } else { 
            return null;
        }
    }
}
