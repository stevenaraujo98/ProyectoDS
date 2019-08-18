/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.Admin;
import modelo.Usuario;
import vista.AdminView;
import vista.LoginView;


public class LoginController implements EventHandler<ActionEvent>{

    private LoginView login;
    
    public LoginController(LoginView login){
        this.login = login;
    }

    @Override
    public void handle(ActionEvent event) {
        Usuario usuario = this.validarUsuario(login.getUser(), login.getPass());
        if(usuario != null){
            System.out.println("Hola " + usuario.getNombres() + " " + usuario.getClass());
            login.close();
            if(usuario instanceof Admin){
                AdminView admin = new AdminView((Admin)usuario);
                admin.show();
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
