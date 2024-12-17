package logica;

import dao.ClienteDAO;
import dto.ClienteDTO;
import entidades.ClienteEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio para gestionar clientes en el sistema de reservas.
 * Esta clase maneja las operaciones relacionadas con los clientes,
 * incluyendo la conversión entre objetos DTO y entidades, y la comunicación
 * con la capa de acceso a datos a través de la clase ClienteDAO.
 */
public class ClienteNegocio {

    private final ClienteDAO clienteDAO;

    /**
     * Constructor de la clase ClienteNegocio.
     * Inicializa el objeto ClienteDAO necesario para realizar las operaciones de base de datos.
     */
    public ClienteNegocio() {
        this.clienteDAO = new ClienteDAO();
    }

    /**
     * Convierte un objeto ClienteDTO a un objeto ClienteEntidad.
     * 
     * @param dto El objeto ClienteDTO a convertir.
     * @return El objeto ClienteEntidad correspondiente.
     */
    private ClienteEntidad convertir(ClienteDTO dto) {
        ClienteEntidad entidad = new ClienteEntidad();
        entidad.setId(dto.getId());
        entidad.setNombreCompleto(dto.getNombreCompleto());
        entidad.setTelefono(dto.getTelefono()); 
        return entidad;
    }

    /**
     * Convierte un objeto ClienteEntidad a un objeto ClienteDTO.
     * 
     * @param entidad El objeto ClienteEntidad a convertir.
     * @return El objeto ClienteDTO correspondiente.
     */
    private ClienteDTO convertir(ClienteEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new ClienteDTO(entidad);
    }

    /**
     * Guarda un cliente en la base de datos.
     * 
     * @param c El objeto ClienteDTO que representa al cliente a guardar.
     */
    public void guardarCliente(ClienteDTO c) {
        clienteDAO.guardarCliente(convertir(c));
    }

    /**
     * Busca un cliente por su ID en la base de datos.
     * 
     * @param id El ID del cliente a buscar.
     * @return Un objeto ClienteDTO correspondiente al cliente encontrado, o null si no se encuentra.
     */
    public ClienteDTO buscarCliente(Long id) {
        ClienteEntidad entidad = clienteDAO.buscarUnCliente(id);
        return convertir(entidad);
    }

    /**
     * Busca todos los clientes en la base de datos y los devuelve como una lista de objetos ClienteDTO.
     * 
     * @return Una lista de objetos ClienteDTO que representan todos los clientes encontrados.
     */
    public List<ClienteDTO> buscarTodosClientes() {
        List<ClienteEntidad> entidades = clienteDAO.buscarTodosClientes();
        List<ClienteDTO> clientes = new ArrayList<>();

        for (ClienteEntidad entidad : entidades) {
            clientes.add(convertir(entidad));
        }
        return clientes;
    }

    /**
     * Busca todos los clientes en la base de datos y los devuelve como una lista de objetos ClienteDTO.
     * 
     * @return Una lista de objetos ClienteDTO que representan todos los clientes encontrados, 
     *         o null si no se encuentran clientes.
     */
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
