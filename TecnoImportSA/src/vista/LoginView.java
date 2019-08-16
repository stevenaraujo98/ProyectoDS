/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class LoginView extends VBox{
    
    private TextField user;
    private PasswordField pass;
    private Button login;
    private Stage stage;
    
    public LoginView(){
        stage = new Stage();
        user = new TextField();
        pass = new PasswordField();
        login = new Button("Iniciar Sesion");
        init();
    }
    
    private void init(){
        this.setAlignment(Pos.CENTER); 
        this.setSpacing(15); 
        this.setPadding(new Insets(20, 20, 20, 20)); 
        this.getChildren().addAll(user, pass, login);
    }
    
    
}
