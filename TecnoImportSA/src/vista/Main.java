/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConexionDB;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class Main extends Application{
    @Override
    public void init(){
        ConexionDB.getInstance().connect("SistemaVentasBD", "root", "root");
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(null)); 
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
    
}
