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
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import modelo.Admin;
import modelo.Categoria;
import modelo.Producto;
import modelo.Vendedor;
import vista.basescreen.BaseView;
import vista.basescreen.ItemView;

/**
 *
 * @author
 */
public class VendedorView extends BaseView{
    
    private Vendedor vendedor;
    
    public VendedorView(Vendedor vendedor){
        this.vendedor = vendedor;
        init();
        logOut();
    }
    
    private void init(){
        this.setTitleHome("VENDEDOR");
        this.setSubtitleHome(vendedor.getNombreUsuario()); 
        this.getMenu().addItemView(new ItemView("Venta", 
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().addItemView(new ItemView("Cotizacion",  
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().setOnAction(e -> {
            switch(this.getMenu().getItemSelected()){
                case 0:
                    this.setTitle("Venta");
                    this.setCenter(panelVenta()); 
                    break;
                case 1:
                    this.setTitle("Cotizacion");
                    this.setCenter(new Label("Cotizacion")); 
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
    
    private Pane panelVenta(){
        Button search = new Button("Buscar"); 
        TextField bynombre = new TextField();
        bynombre.setPromptText("Nombre del producto"); 
        TextField bydescrip = new TextField();
        bydescrip.setPromptText("Descripcion del producto"); 
        ComboBox<Categoria> categorias = new ComboBox<>();
        llenarCombo(categorias);
        HBox top = new HBox(10, bynombre, bydescrip, new Label("Categoria"), categorias, search);
        top.setPadding(new Insets(30, 30, 30, 30)); 
        return top;
    }
    
    private void llenarCombo(ComboBox<Categoria> categorias){
        String query = "select * from categorias";
        try {
            ResultSet result = ConexionDB.getInstance().getStatement().executeQuery(query);
            if(result != null){
                while(result.next()){
                    Categoria c = new Categoria(result.getInt(1), result.getString(2), result.getString(3)); 
                    categorias.getItems().add(c);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendedorView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private Pane homeView(){
        
        
        return null;
    }
    
    private Pane itemProducto(Producto p) {
        CheckBox select = new CheckBox();
        HBox item = new HBox();
        return null;
    }
    
    private class ItemProducto extends HBox{
        private Producto producto;
        private CheckBox check;
        
        ItemProducto(Producto p){
            this.producto = p;
            initialize();
        }
        
        private void initialize(){
            
        }
    }
}
