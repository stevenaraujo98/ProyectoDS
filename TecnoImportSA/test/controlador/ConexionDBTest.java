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
    /**
     * 
     */
    @Test
    public void testSuccessfulConect(){
        ConexionDB.getInstance().connect("192.168.99.100", 3306,"SistemaVentasBD", "", "", "");
        assertFalse(ConexionDB.getInstance().close());
    }    
    
        
    /**
     * 
     */
    @Test
    public void testGetConnection(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect("192.168.99.100", 3306,"SistemaVentasBD", "", "", query);
        assertNull(ConexionDB.getInstance().getConnection());
    }
    
    
    /**
     * 
     */
    @Test
    public void testExecuteProcedure(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect("192.168.99.100", 3306,"SistemaVentasBD", "root", "root", query);
        Procedure procedure = new Procedure("empleadosByIDLocal").addValue("Tecno Import S.A.");
        try {
            assertTrue(ConexionDB.getInstance().executeProcedure(procedure));
        } catch (SQLException ex) {
            Logger.getLogger(AsignacionAdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}