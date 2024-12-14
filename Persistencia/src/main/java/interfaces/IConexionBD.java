package interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Clase con los metodos abstractos para la conexionDB
 *
 * @author eduar
 */
public interface IConexionBD {

    public Connection crearConexion() throws SQLException;
}
