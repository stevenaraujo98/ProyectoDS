/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import modelo.Gerente;
import vista.basescreen.BaseView;
import vista.basescreen.ItemView;

/**
 *
 * @author SSAM
 */
public class GerenteView extends BaseView{
    
    private Gerente gerente;
    private VBox listado;
    
    public GerenteView(Gerente gerente){
        this.gerente = gerente;
        init();
        logOut();
    }
    
    private void init(){
        this.setTitleHome("GERENTE");
        this.setSubtitleHome(gerente.getNombreUsuario()); 
        this.getMenu().addItemView(new ItemView("Inventarios", 
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().addItemView(new ItemView("Usuarios",  
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().setOnAction(e -> {
            switch(this.getMenu().getItemSelected()){
                case 0:
                    this.setTitle("Inventarios");
                    this.setCenter(new Label("Inventarios")); 
                    break;
                case 1:
                    this.setTitle("Usuarios");
                    this.setCenter(listUsers());  
                    break;
                default:
                    break;
            }
        }); 
    }
    
    private void logOut() {
        this.setOnLogOutAction(e -> {
            this.close();
            LoginView.open();
        });
    }
    
    private Pane listUsers(){
        VBox lista = new VBox(10);
        lista.setPadding(new Insets(30, 30, 30, 30)); 
        lista.getChildren().add(new Text("Usuario ..."));

        return lista;
    }
}
