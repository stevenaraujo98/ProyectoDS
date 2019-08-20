/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import modelo.*;
import vista.basescreen.*;

/**
 *
 * @author 
 */
public class JefeBodegaView extends BaseView{
    private Bodega bodega;
    
    public JefeBodegaView(Bodega bodega){
        this.bodega = bodega;
        init();
        logOut();
    }
    
    private void init(){
        this.setTitleHome("JefeBodega");
        this.setSubtitleHome(bodega.getJefeBodega().getNombreUsuario()); 
        this.getMenu().addItemView(new ItemView("Envios", 
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().addItemView(new ItemView("Pedidos",  
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().addItemView(new ItemView("Repartidores",  
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().setOnAction(e -> {
            switch(this.getMenu().getItemSelected()){
                case 0:
                    this.setTitle("Envios");
                    this.setCenter(new InfoEntregaView()); 
                    break;
                case 1:
                    this.setTitle("Pedidos");
                    this.setCenter(new Label("Pedidos"));
                case 2:
                    this.setTitle("Repartidores");
                    this.setCenter(new Label("Repartidores"));
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
}
