/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
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
        String query = "select e.cedula,e.nombres,e.apellidos,e.telefono,e.salario,t.nombre from empleados e, tipo_empleado t where e.tipo_empleado = t.id_tipo";
        try {
            ResultSet rs = ConexionDB.getInstance().getStatement().executeQuery(query);
            if(rs != null){
                while(rs.next()){
                    String texto = "Cedula: "+rs.getString(1)+" Nombres: "+rs.getString(2)+" Apellidos: "+rs.getString(3)+" "
                            + "Telefono: "+rs.getString(4)+" Salario: "+rs.getDouble(5)+" Tipo Empleado: " + rs.getString(6);
                    lista.getChildren().add(new Text(texto));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
