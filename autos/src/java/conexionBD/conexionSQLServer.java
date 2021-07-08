/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package conexionBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PROFESOR
 */
public class conexionSQLServer {

    // Parametros necesarios
    private static String ipAddress = "localhost"; //nota: localhost= 127.0.0.1
    private static String dbName = "proyecto4";
    private static String user = "sa";
    private static String password = "root";
    private static String service = "1433";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:sqlserver://" + ipAddress + ":" + service + ";databaseName=" + dbName;
        return DriverManager.getConnection(url, user, password);
    }

    public static void main(String[] args) throws SQLException {
        Connection con = conexionSQLServer.getConnection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
}
