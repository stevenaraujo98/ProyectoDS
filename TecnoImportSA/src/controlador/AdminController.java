/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbmanager.Procedure;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import modelo.Categoria;
import modelo.Localidad;
import modelo.Producto;
import modelo.Stock;
import vista.AdminView;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;

/**
 *
 * @author 
 */
public class AdminController implements Initializable{
    private AdminView adminview;
    @FXML
    private AnchorPane root;
    @FXML
    private ComboBox<Localidad> locales;
    @FXML
    private TableView stocks;
    @FXML
    private TableColumn<Stock, Integer> idProducto;
    @FXML
    private TableColumn<Stock, Integer> cantidad;
    @FXML
    private TableColumn<Stock, String> producto;
    @FXML
    private TableColumn<Stock, Double> precio;
    @FXML
    private TableColumn<Stock, Categoria> categoria;
    
    public void setAdminView(AdminView a){
        this.adminview = a;
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        stocks.setEditable(true); 
        stocks.setOnMouseClicked(e -> {
            double x;
            double y;
            if(e.getButton() == MouseButton.SECONDARY){
                x = e.getScreenX();
                y = e.getScreenY();
                ContextMenu menu = new ContextMenu();
                MenuItem update = new MenuItem("Modificar");
                MenuItem delete = new MenuItem("Eliminar");
                menu.show(adminview.getStage(), x, y); 
                menu.show(root, x, y);
                menu.getItems().addAll(update, delete);
                update.setOnAction(null);
                delete.setOnAction(null); 
            }
        }); 
        
        for(Localidad l: Localidad.getLocales()){
            locales.getItems().add(l);
        }
        
        loadTable();
    }
    
    private void loadTable(){
        idProducto.setCellValueFactory((TableColumn.CellDataFeatures<Stock, Integer> param) -> new SimpleObjectProperty<>(param.getValue().getProducto().getIdPrdct()));
        cantidad.setCellValueFactory(new PropertyValueFactory<>("cant"));
        producto.setCellValueFactory((TableColumn.CellDataFeatures<Stock, String> param) -> new SimpleObjectProperty<>(param.getValue().getProducto().getNombrePrdct()));
        precio.setCellValueFactory((TableColumn.CellDataFeatures<Stock, Double> param) -> new SimpleObjectProperty<>(param.getValue().getProducto().getPrecioActualPrdct()));
        categoria.setCellValueFactory((TableColumn.CellDataFeatures<Stock, Categoria> param) -> new SimpleObjectProperty<>(param.getValue().getProducto().getCategoria()));
        locales.setOnAction(e->{
            Localidad loc = locales.getSelectionModel().getSelectedItem();
            Procedure p = new Procedure("productoPorLocal").addValue(loc.getIdLcld());
            try {
                loadList(ConexionDB.getInstance().executeProcedureResult(p));
            } catch (SQLException ex) {
                Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }); 
    } 
    
    private void loadList(ResultSet rs) throws SQLException{
        ObservableList<Stock> list = FXCollections.observableArrayList();
        if(rs != null){
            while(rs.next()){
                Categoria c = new Categoria(rs.getInt(5), rs.getString(6), rs.getString(7));
                Producto p = new Producto(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getDouble(2), c);
                list.add(new Stock(p, rs.getInt(8)));
            }
        }
        stocks.setItems(list); 
    }
    
    
    public void crearNuevoRegistro(){
        //funcionalidad en construccion 
    }
    
    public void registrarRegistroExistente(){
        //funcionalidad en construccion
    }
    
    public void consultarRegistroExistente(){
        //funcionalidad en construccion
    }
    
    public void eliminarRegistroExistente(){
        //funcionalidad en construccion
    }
    
    public List<Producto> consultarProducto(String nombre){
        Procedure proc = new Procedure("productosPorNombre").addValue(nombre); 
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            ResultSet result = ConexionDB.getInstance().executeProcedureResult(proc);
            if(result != null){
                while(result.next()){
                    Categoria c = new Categoria(result.getInt(5), result.getString(6), result.getString(7));
                    Producto prod = new Producto(result.getInt(1), result.getString(2), 
                                result.getString(3), result.getDouble(4), c); 
                    productos.add(prod);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }
    
    public void updateStock(int idProd, Localidad loc, int newCant){
        try {
            ConexionDB.getInstance().executeProcedure(new Procedure("updateStock") 
                    .addValue(idProd).addValue(loc.getIdLcld()).addValue(newCant));
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addProducto(int idProd, Localidad loc, int newCant){
        try {
            ConexionDB.getInstance().executeProcedure(new Procedure("addProductoLocal") 
                    .addValue(idProd).addValue(loc.getIdLcld()).addValue(newCant));
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
