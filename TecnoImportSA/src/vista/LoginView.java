/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.LoginController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author 
 */
public class LoginView {
    
    private final TextField user;
    private final PasswordField pass;
    private final Button login;
    private final Stage stage;
    private final VBox root;
    
    public LoginView(){
        stage = new Stage();
        user = new TextField();
        pass = new PasswordField();
        login = new Button("Iniciar Sesion");
        root = new VBox();
        init();
        styles();
    }
    
    private void init(){
        root.setAlignment(Pos.CENTER); 
        root.setSpacing(20); 
        root.setPadding(new Insets(40, 40, 40, 40)); 
        user.setPromptText("Usuario");
        pass.setPromptText("Contraseña"); 
        Image i = new Image("\\recursos\\tecno import.png", 240, 240, true, true); 
        root.getChildren().addAll(new ImageView(i), user, pass, login);
        stage.setScene(new Scene(root)); 
        login.setOnAction(new LoginController(this)); 
    }
    
    private void styles(){
        root.setBackground(new Background(new BackgroundFill(Color.DARKGRAY, CornerRadii.EMPTY, Insets.EMPTY))); 
    }
    
    public void showLogin(){
        stage.show();
    }

    public String getUser() {
        return user.getText();
    }

    public String getPass() {
        return pass.getText();
    }
    
    public void showMensajeError(){
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText("Error!!!");
        alert.setTitle("Eror"); 
        alert.setContentText("No se pudo iniciar sesión.\nEl usuario o contraseña son incorrectos");
        alert.show();
    }
    
    public void close(){
        stage.close();
    }
    
    public static void open() {
        new LoginView().showLogin();
    }
}
