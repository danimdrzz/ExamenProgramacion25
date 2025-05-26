package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/examenprogramacion";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public static Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
        }
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }

    public static Connection obtenerConexion() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
