/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbmanager.Procedure;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SSAM
 */
public class ConexionDBTest {
    private static final String IP = "192.168.99.100";
    private static final String BASEDATOS = "SistemaVentasBD";
    
    /**
     * Test para verificar que al no enviar usuario y contraseña, devuelva un valor falso al querer cerrar una 
     * base de datos de la cual no hay conexion.
     * Es necesario abrir la conexion con la base de datos para ejecutar el procedure
     */
    @Test
    public void testSuccessfulConect(){
        ConexionDB.getInstance().connect(IP, 3306,BASEDATOS, "", "", "");
        assertFalse(ConexionDB.getInstance().close());
    }    
    
        
    /**
     * Test para verificar que la conexion con la base de datos sea nula en caso de no enviarse usuario y contraseña.
     * Es necesario abrir la conexion con la base de datos para ejecutar el procedure
     */
    @Test
    public void testGetConnection(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect(IP, 3306,BASEDATOS, "", "", query);
        assertNull(ConexionDB.getInstance().getConnection());
    }
    
    
    /**
     * Test para verificar que la respuesta del procedure en caso de ejecutarse con un valor vacío sea verdadera. 
     * Es necesario abrir la conexion con la base de datos para ejecutar el procedure
     */
    @Test
    public void testExecuteProcedure(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect(IP, 3306,BASEDATOS, "root", "root", query);
        Procedure procedure = new Procedure("empleadosByIDLocal").addValue("");
        try {
            assertTrue(ConexionDB.getInstance().executeProcedure(procedure));
        } catch (SQLException ex) {
            Logger.getLogger(AsignacionAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}