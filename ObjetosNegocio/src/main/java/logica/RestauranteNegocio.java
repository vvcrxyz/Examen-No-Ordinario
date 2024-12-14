package logica;

import dao.RestauranteDAO;
import dto.RestauranteDTO;
import entidades.RestauranteEntidad;
import java.util.ArrayList;
import java.util.List;

/**
 * Lógica de negocio para gestionar restaurantes.
 */
public class RestauranteNegocio {

    private final RestauranteDAO restauranteDAO;

    // Constructor
    public RestauranteNegocio() {
        this.restauranteDAO = new RestauranteDAO();
    }

    // Conversión de RestauranteDTO a RestauranteEntidad
    private RestauranteEntidad convertir(RestauranteDTO dto) {
        RestauranteEntidad entidad = new RestauranteEntidad();
        entidad.setId(dto.getId());
        entidad.setNombre(dto.getNombre());
        entidad.setDireccion(dto.getDireccion());
        entidad.setTelefono(dto.getTelefono());
        entidad.setHoraApertura(dto.getHoraApertura());
        entidad.setHoraCierre(dto.getHoraCierre());
        return entidad;
    }

    // Conversión de RestauranteEntidad a RestauranteDTO
    private RestauranteDTO convertir(RestauranteEntidad entidad) {
        if (entidad == null) {
            return null;
        }
        return new RestauranteDTO(entidad);
    }

    // Guardar un restaurante
    public void guardarRestaurante(RestauranteDTO restaurante) {
        restauranteDAO.guardarRestaurante(convertir(restaurante));
    }

    // Modificar un restaurante
    public void modificarRestaurante(RestauranteDTO restaurante) {
        restauranteDAO.modificarRestaurante(convertir(restaurante));
    }

    // Eliminar un restaurante
    public void eliminarRestaurante(RestauranteDTO restaurante) {
        restauranteDAO.eliminarRestaurante(convertir(restaurante));
    }

    // Buscar un restaurante por ID
    public RestauranteDTO buscarRestaurante(Long id) {
        RestauranteEntidad entidad = restauranteDAO.buscarUnRestaurante(id);
        return convertir(entidad);
    }

    // Buscar todos los restaurantes
    public List<RestauranteDTO> buscarTodosRestaurantes() {
        List<RestauranteEntidad> entidades = restauranteDAO.buscarTodosRestaurantes();
        List<RestauranteDTO> restaurantes = new ArrayList<>();

        for (RestauranteEntidad entidad : entidades) {
            restaurantes.add(convertir(entidad));
        }
        return restaurantes;
    }
}
