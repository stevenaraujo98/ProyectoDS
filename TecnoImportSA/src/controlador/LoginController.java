/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Admin;
import modelo.Bodega;
import modelo.Gerente;
import modelo.JefeBodega;
import modelo.Usuario;
import modelo.Vendedor;
import vista.AdminView;
import vista.GerenteView;
import vista.JefeBodegaView;
import vista.LoginView;
import vista.VendedorView;


public class LoginController implements EventHandler<ActionEvent>{

    private LoginView login;
    
    public LoginController(LoginView login){
        this.login = login;
    }

    @Override
    public void handle(ActionEvent event) {
        Usuario usuario = this.validarUsuario(login.getUser(), login.getPass());
        if(usuario != null){
            login.close();
            if(usuario instanceof Admin){
                AdminView admin = new AdminView((Admin)usuario);
                admin.show();
            }else if(usuario instanceof JefeBodega){
                Bodega b = new Bodega(1,"Bodega1", "prosperina","2222333");
                b.setJefeBodega((JefeBodega)usuario);
                JefeBodegaView jefebv = new JefeBodegaView(b);
                jefebv.show();
            }else if(usuario instanceof Vendedor){
                VendedorView v = new VendedorView((Vendedor)usuario);
                v.show();
            }else if(usuario instanceof Gerente){
                GerenteView g = new GerenteView((Gerente)usuario);
                g.show();
            }
        }else
            login.showMensajeError();
    }
    
    /**
     * Valida las credenciales de un usuario
     * @param nombre - usuario
     * @param contrasenia - contraseña del usuario
     * @return null si las credenciales son incorrectas o si no existe el usuario
     */
    public Usuario validarUsuario(String nombre, String contrasenia){
        if(nombre.isEmpty() || contrasenia.isEmpty())
            return null;
        return Usuario.getUsuario(nombre, contrasenia); 
    }
}
