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
    private static final String IP = "192.168.99.100";
    private static final String BASEDATOS = "SistemaVentasBD";
    private static final String QUERY = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
     
    
    //Prueba que efectivamente el metodo no devuelva nulo para la coleccion
    //de datos del tipo abastecimiento
    @Test
    public void testGetAbastecimientosSinAbastecimientos(){
        ConexionDB.getInstance().connect(IP, 3306,BASEDATOS, "root", "root", QUERY);
        assertNotNull(JefeBodegaController.getAbastecimientos());
    }
    
    //Prueba que la lista cargada de estados sea devuelta por la funcion
    //especifica en getEnvios()
    @Test
    public void testGetEnvios(){
        ConexionDB.getInstance().connect(IP, 3306,BASEDATOS, "root", "root", QUERY);
        assertTrue(JefeBodegaController.getEstados().size() > 0);
    }
    
    //Prueba que la lista cargada de repartidores devuelta por la funcion
    //tenga una longitud mayor a 0 ya que si existen datos de tipo
    //repartidores en la base
    @Test
    public void testGetTrRepartidores(){
        ConexionDB.getInstance().connect(IP, 3306,BASEDATOS, "root", "root", QUERY);
        assertTrue(JefeBodegaController.getRepartidores("").size() > 0);
    }
           
}
