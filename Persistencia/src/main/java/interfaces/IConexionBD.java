package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Interfaz que define los métodos para la conexión a la base de datos.
 * Contiene un método abstracto para crear una conexión a la base de datos.
 *
 * @author limon
 */
public interface IConexionBD {

    /**
     * Crea una conexión a la base de datos.
     * 
     * @return un objeto `Connection` que representa la conexión a la base de datos
     * @throws SQLException si ocurre un error al intentar establecer la conexión
     */
    public Connection crearConexion() throws SQLException;
}
