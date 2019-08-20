/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConexionDB;
import controlador.JefeBodegaController;
import dbmanager.Procedure;
import javafx.application.Application;
import javafx.stage.Stage;
import modelo.Envio;

/**
 *
 * @author 
 */
public class Main extends Application{
    @Override
    public void init(){
        String query = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        //ConexionDB.getInstance().connect("SistemaVentasBD", "root", "root", query);
        ConexionDB.getInstance().connect("SistemaVentasBD", "root", "root", query);
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        LoginView login = new LoginView();
        login.showLogin();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
    @Override
    public void stop(){
        ConexionDB.getInstance().close();
    }
    
}
