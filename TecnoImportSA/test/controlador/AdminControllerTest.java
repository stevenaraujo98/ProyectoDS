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
 * @author Kenny Camba
 */
public class AdminControllerTest {
    
    public AdminControllerTest() {
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect("SistemaVentasBD", "root", "root", query);
    }
    
    /**
     * Test para verificar que las consultas por nombre de un producto que exite en el stock 
     * tenga como resultado una colección no vacía de productos que coincidan con el parámetro
     * de búsqueda.
     * Es necesario abrir la conexion con la base de datos para poder relizar la consulta
     */
    @Test
    public void consultatProductoNoEmpty(){
        AdminController admin = new AdminController();
        assertFalse(admin.consultarProducto("Xiaomi Redmi Note 7").isEmpty());
    }
    
    /**
     * Comprueba si el elemento en primera psicion de la lista obtenida
     * es igual al producto solicitado
     */
    @Test
    public void consultatProductoEquals(){
        AdminController admin = new AdminController();
        assertTrue(admin.consultarProducto("Xiaomi Redmi Note 7").get(0).getNombrePrdct().equals("Xiaomi Redmi Note 7")); 
        ConexionDB.getInstance().close();
    }
    
}
