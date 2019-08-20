/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.ConexionDB;
import dbmanager.Procedure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    private VBox listado;
    
    public VendedorView(Vendedor vendedor){
        this.vendedor = vendedor;
        this.setCenter(this.homeView()); 
        init();
        logOut();
    }
    
    private void init(){
        this.setTitleHome("VENDEDOR");
        this.setSubtitleHome(vendedor.getNombreUsuario()); 
        this.getMenu().addItemView(new ItemView("Productos", 
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().addItemView(new ItemView("Venta",  
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().addItemView(new ItemView("Cotizacion",  
                    new Image(AdminView.class.getResourceAsStream("/recursos/icons/user.png"), 30, 30, true, true)));
        this.getMenu().setOnAction(e -> {
            switch(this.getMenu().getItemSelected()){
                case 0:
                    this.setTitle("Productos");
                    this.setCenter(panelVenta()); 
                    break;
                case 1:
                    this.setTitle("Venta");
                    this.setCenter(new Label("Cotizacion")); 
                    break;
                case 2:
                    this.setTitle("Cotizacion");
                    this.setCenter(new Label("Cotizacion")); 
                    break;
                default:
                    break;
            }
        });
        this.setOnHomeAction(e -> this.setCenter(this.homeView()));
     }
    
    private void logOut() {
        this.setOnLogOutAction(e -> {
            this.close();
            LoginView.open();
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
        listado = new VBox(10);
        HBox top = new HBox(10, bynombre, bydescrip, new Label("Categoria"), categorias, search);
        VBox content = new VBox(20, top, listado);
        content.setPadding(new Insets(30, 30, 30, 30)); 
        itemProducto(search, bynombre, bydescrip, categorias);
        return content;
    }
    
    private void llenarCombo(ComboBox<Categoria> categorias){
        String query = "select * from Categorias";
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
        VBox vista = new VBox(40);
        vista.setPadding(new Insets(30, 30, 30, 30)); 
        vista.setAlignment(Pos.CENTER); 
        System.out.println(vendedor.getIdLocal());
        System.out.println(vendedor.getNombres());
        try {
            ResultSet result = ConexionDB.getInstance(). 
                    executeProcedureResult(new Procedure("localByID").addValue(vendedor.getIdLocal()));
            if(result != null && result.next()){ 
                Text local = new Text(result.getString(1));
                local.setFont(Font.font(local.getFont().getFamily(), FontWeight.BOLD, 70));
                Text dir = new Text("Dirección: " + result.getString(2));
                dir.setFont(Font.font(local.getFont().getFamily(), FontWeight.BOLD, 30));
                Text enc = new Text("Encargado: " + result.getString(3) + " " + result.getString(4)); 
                enc.setFont(Font.font(local.getFont().getFamily(), FontWeight.BOLD, 30));
                Text tipo = new Text(result.getString(5));
                tipo.setFont(Font.font(local.getFont().getFamily(), FontWeight.BOLD, 30));
                vista.getChildren().addAll(local, tipo, dir, enc);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(VendedorView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return vista;
    }
    
    
    private void itemProducto(Button search, TextField nombre, TextField des, ComboBox<Categoria> categorias){
        search.setOnAction(e->{
            listado.getChildren().clear();
            try {
                String np = nombre.getText();
                String descr = des.getText();
                Categoria c = categorias.getValue();
                int id_c = 0;
                if(np.isEmpty()) np = "#&#";
                if(descr.isEmpty()) descr = "#&#";
                if(c != null) id_c = c.getIdCat();
                Procedure p = new Procedure("buscarProductos").addValue(vendedor.getIdLocal())
                        .addValue(np).addValue(descr).addValue(id_c);
                ResultSet rs = ConexionDB.getInstance().executeProcedureResult(p);
                addElements(rs);
            } catch (SQLException ex) {
                Logger.getLogger(VendedorView.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    private void addElements(ResultSet rs) throws SQLException{
        if(rs != null){
            while(rs.next()){
                Categoria c = new Categoria(rs.getInt(6), rs.getString(7), rs.getString(8));
                Producto p = new Producto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), c);
                listado.getChildren().add(new ItemProducto(p, rs.getInt(5)));
            }
        }
    }
    
    private class ItemProducto extends HBox{
        private Producto producto;
        private CheckBox check;
        private TextField cant;
        private TextField precio;
        private int cantidad;
        
        ItemProducto(Producto p, int cantidad){
            super(10);
            this.producto = p;
            this.check = new CheckBox();
            this.cant = new TextField();
            this.precio = new TextField();
            this.cantidad = cantidad;
            initialize();
        }
        
        private void initialize(){
            cant.setPromptText("Cantidad");
            cant.setMaxWidth(50);
            cant.setText(cantidad + "");
            cant.setDisable(true); 
            precio.setPromptText("precio");
            precio.setText("$ " + producto.getPrecioActualPrdct()); 
            precio.setDisable(true); 
            precio.setMaxWidth(75);
            Label nombre = new Label(producto.getNombrePrdct());
            nombre.setTooltip(new Tooltip(producto.getDescripcionPrdct())); 
            this.getChildren().addAll(check, new Label(""+producto.getIdPrdct()), cant, nombre, precio); 
        }
    }
}
