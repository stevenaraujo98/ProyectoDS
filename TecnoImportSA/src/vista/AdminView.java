/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import modelo.Admin;
import vista.basescreen.BaseView;
import vista.basescreen.ItemView;

/**
 *
 * @author 
 */
public class AdminView extends BaseView{
    private Admin admin;
    
    public AdminView(Admin admin){
        this.admin = admin;
        init();
        logOut();
    }
    
    private void init(){
        this.setTitleHome("ADMINISTRADOR");
        this.setSubtitleHome(admin.getNombreUsuario()); 
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
                    this.setCenter(new Label("Usuaros")); 
                    break;
                default:
                    break;
            }
        }); 
    }
    
    private void logOut() {
        this.setOnLogOutAction(e -> {
            this.close();
        });
    }
}
