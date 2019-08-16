/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author 
 */
public class ConexionDB {
    /**
     * Instancia de la conexión a la base de datos
     */
    private static ConexionDB instance = new ConexionDB();
    private final String SCHEME = "jdbc:mysql";
    private Connection connection;
    
    private ConexionDB() {
        
    }
    
    /**
     * Devuelve la unica instancia de la clase MyConnection
     * @return MyConnection
     */
    public static ConexionDB getInstance(){
        return instance;
    }
    
    /**
     * Establece una conexión a una base de datos en el localhost:3306
     * @param db - Nombre de la base de datos
     * @param user - Usuario de la base de datos
     * @param pass - Contraseña del usuario de la base de datos
     * @return - True si se logró crear la conexión, false en caso contrario
     */
    public boolean connect(String db, String user, String pass){
        return connect("localhost", 3306, db, user, pass);
    }
    
    /**
     * Establece una conexión a una base de datos
     * @param host - Host al cual se desea la conexión
     * @param port - Puerto donde escuchar las solicitudes
     * @param db - Nombre de la base de datos
     * @param user - Usuario de la base de datos
     * @param pass - Contraseña del usuario de la base de datos
     * @return - True si se logró crear la conexión, false en caso contrario
     */
    public boolean connect(String host, int port, String db, String user, String pass){
        try { 
            URI uri = new URI(SCHEME, null, host, port, "/"+db, null, null);
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(uri.toString(), user, pass);
            return true;
        } catch (ClassNotFoundException | SQLException | URISyntaxException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    /**
     * Cierra la conexión activa a la base de datos
     * @return - True en exito, false en error
     */
    public boolean close() {
        if(connection == null)
            return false;
        try {
            connection.close();
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }
    
    /**
     * 
     * @return
     * @throws SQLException 
     */
    public Statement getStatement() throws SQLException {
        if(connection == null)
            return null;
        return connection.createStatement();
    }

}
