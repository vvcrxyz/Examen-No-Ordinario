package logica;

import dao.RestauranteDAO;
import dto.RestauranteDTO;
import entidades.RestauranteEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio para gestionar restaurantes.
 * Esta clase se encarga de realizar las operaciones de negocio relacionadas con los restaurantes, 
 * tales como la creación, modificación, eliminación y consulta de restaurantes.
 * Se comunica con la capa de acceso a datos (DAO) y con la capa de transferencia de datos (DTO).
 */
public class RestauranteNegocio {

    private final RestauranteDAO restauranteDAO;

    // Constructor
    public RestauranteNegocio() {
        this.restauranteDAO = new RestauranteDAO();
    }

    /**
     * Convierte un objeto RestauranteDTO en un objeto RestauranteEntidad.
     * 
     * @param dto El objeto RestauranteDTO a convertir.
     * @return El objeto RestauranteEntidad resultante de la conversión.
     */
    private RestauranteEntidad convertir(RestauranteDTO dto) {
        RestauranteEntidad entidad = new RestauranteEntidad();
        entidad.setId(dto.getId());
        entidad.setHoraApertura(dto.getHoraApertura());
        entidad.setHoraCierre(dto.getHoraCierre());
        return entidad;
    }

    /**
     * Convierte un objeto RestauranteEntidad en un objeto RestauranteDTO.
     * 
     * @param entidad El objeto RestauranteEntidad a convertir.
     * @return El objeto RestauranteDTO resultante de la conversión.
     */
    private RestauranteDTO convertir(RestauranteEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new RestauranteDTO(entidad);
    }

    /**
     * Guarda un nuevo restaurante.
     * 
     * @param restaurante El restaurante a guardar, representado como un RestauranteDTO.
     */
    public void guardarRestaurante(RestauranteDTO restaurante) {
        restauranteDAO.guardarRestaurante(convertir(restaurante));
    }

    /**
     * Modifica un restaurante existente.
     * 
     * @param restaurante El restaurante a modificar, representado como un RestauranteDTO.
     */
    public void modificarRestaurante(RestauranteDTO restaurante) {
        restauranteDAO.modificarRestaurante(convertir(restaurante));
    }

    /**
     * Elimina un restaurante.
     * 
     * @param restaurante El restaurante a eliminar, representado como un RestauranteDTO.
     */
    public void eliminarRestaurante(RestauranteDTO restaurante) {
        restauranteDAO.eliminarRestaurante(convertir(restaurante));
    }
    
    // Método para obtener los datos del restaurante
    public RestauranteEntidad obtenerRestaurante() {
        // Llamamos al método de la capa de acceso a datos (DAO) para obtener los datos
        return restauranteDAO.obtenerRestaurante();
    }

    /**
     * Busca un restaurante por su ID.
     * 
     * @param id El ID del restaurante a buscar.
     * @return Un objeto RestauranteDTO que representa al restaurante encontrado.
     */
    public RestauranteDTO buscarRestaurante(Long id) {
        RestauranteEntidad entidad = restauranteDAO.buscarUnRestaurante(id);
        return convertir(entidad);
    }

    /**
     * Busca todos los restaurantes.
     * 
     * @return Una lista de objetos RestauranteDTO que representan todos los restaurantes.
     */
    public List<RestauranteDTO> buscarTodosRestaurantes() {
        List<RestauranteEntidad> entidades = restauranteDAO.buscarTodosRestaurantes();
        List<RestauranteDTO> restaurantes = new ArrayList<>();

        for (RestauranteEntidad entidad : entidades) {
            restaurantes.add(convertir(entidad));
        }
        return restaurantes;
    }
    
    /**
    * Guarda un nuevo restaurante si no existe, o actualiza el existente.
    * 
    * @param restaurante El restaurante a guardar o actualizar, representado como un RestauranteDTO.
    */
   public void guardarOActualizarRestaurante(RestauranteDTO restaurante) {
       // Verificar si ya existe un restaurante en la base de datos
       RestauranteEntidad existente = restauranteDAO.buscarRestauranteUnico();

       if (existente != null) {
           // Si existe, actualizar los datos
           RestauranteEntidad entidad = convertir(restaurante);
           entidad.setId(existente.getId()); // Asegurarse de conservar el ID existente
           restauranteDAO.modificarRestaurante(entidad);
       } else {
           // Si no existe, guardar como nuevo
           restauranteDAO.guardarRestaurante(convertir(restaurante));
       }
   }
}
