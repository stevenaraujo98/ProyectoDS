/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JordyVillao
 */
public class JefeBodegaControllerTest {
    
    //Prueba que efectivamente el metodo no devuelva nulo para la coleccion
    //de datos del tipo abastecimiento
    @Test
    public void testGetAbastecimientosSinAbastecimientos(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect("SistemaVentasBD", "root", "volksWAGEN1", query);
        assertNotNull(JefeBodegaController.getAbastecimientos());
    }
    
    //Prueba que la lista cargada de estados sea devuelta por la funcion
    //especifica en getEnvios()
    @Test
    public void testGetEnvios(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect("SistemaVentasBD", "root", "volksWAGEN1", query);
        assertTrue(JefeBodegaController.getEstados().size() > 0);
    }
    
    //Prueba que la lista cargada de repartidores devuelta por la funcion
    //tenga una longitud mayor a 0 ya que si existen datos de tipo
    //repartidores en la base
    @Test
    public void testGetTrRepartidores(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect("SistemaVentasBD", "root", "volksWAGEN1", query);
        assertTrue(JefeBodegaController.getRepartidores("").size() > 0);
    }
           
}
