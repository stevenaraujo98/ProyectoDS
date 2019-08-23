/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import modelo.Gerente;
import vista.basescreen.BaseView;
import vista.basescreen.ItemView;

/**
 *
 * @author SSAM
 */
public class GerenteView extends BaseView{
    
    private Gerente gerente;
    FXMLLoader loader;
    
    public GerenteView(Gerente gerente){
        this.gerente = gerente;
        init();
        logOut();
    }
    
    private void init(){
        this.setTitleHome("GERENTE");
        this.setSubtitleHome(gerente.getNombreUsuario()); 
        this.getMenu().addItemView(new ItemView("Asignar Administrador", 
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().setOnAction(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                int value = GerenteView.this.getMenu().getItemSelected();
                if(value == 0){
                     GerenteView.this.setTitle("Asignar Administrador");
                        loader = new FXMLLoader(GerenteView.this.getClass().getResource("/vista/AsignacionAdmin.fxml"));
                        {
                            try {
                                GerenteView.this.setCenter(loader.load());
                            }catch (IOException ex) {
                                Logger.getLogger(GerenteView.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                }
            }
        }); 
    }
    
    private void logOut() {
        this.setOnLogOutAction(e -> {
            this.close();
            LoginView.open();
        });
    }
}
