/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import modelo.Admin;
import modelo.Gerente;
import modelo.JefeBodega;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Kenny Camba
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        ConexionDB.getInstance().connect("SistemaVentasBD", "root", "root", query);
    }
    
    /**
     * Test que veirfica que un usuario que ingrese sus credenciales correctamente 
     * no recibe una respuesta null por parte del sistema
     */
    @Test
    public void usuarioCorrectoNotNull(){
        LoginController login = new LoginController(null);
        assertNotNull(login.validarUsuario("kennyCamba", "admin11_10"));
    }
    
    
    /**
     * Verifica que el usuario que se logea tenga los permisos requeridos de acuerdo
     * a su tipo de usuario: Administrador
     */
    @Test
    public void tipoUsuarioAdminCorrecto(){
        LoginController login = new LoginController(null);
        assertTrue(login.validarUsuario("kennyCamba", "admin11_10") instanceof Admin);
    }
    
    /**
     * Verifica que el usuario que se logea tenga los permisos requeridos de acuerdo
     * a su tipo de usuario: Jefe de Bodega
     */
    @Test
    public void tipoUsuarioJefeBodegaCorrecto(){
        LoginController login = new LoginController(null);
        assertTrue(login.validarUsuario("jordi", "jefeb1") instanceof JefeBodega);
        ConexionDB.getInstance().close();
    }
}
