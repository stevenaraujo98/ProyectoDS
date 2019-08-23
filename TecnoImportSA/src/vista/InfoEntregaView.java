/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.JefeBodegaController;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import modelo.*;


/**
 *
 * @author 
 */
public class InfoEntregaView extends BorderPane{
    
    private TableView<Envio> table;
    private TextField buscar;
    private Button nuevo;
    private Button editar;
    private ComboBox<Estado> estados;
    
    public InfoEntregaView(){
        super();
        table = new TableView();
        buscar = new TextField();
        nuevo = new Button("Nuevo");
        editar = new Button("Cambiar estado");
        estados = new ComboBox<>();
        init();
    }
    
    public void init(){
        buscar.setPromptText("Buscar");
        this.setTop(new VBox(new Label("Buscar:"), buscar));
        this.setCenter(table);
        this.setRight(new VBox(nuevo, editar, estados));
        setOnKeyPressedBuscar();
        setActionEditar();
        setActionNuevo();
        fillTable(JefeBodegaController.getEnvios());
        fillEstados();
        
    }
    
    
    public void fillTable(List<Envio> envios){
        table.getColumns().clear();
        table.getItems().clear();
        TableColumn<Envio, String> id = new TableColumn("ID");
        TableColumn<Envio, String> ruta = new TableColumn("RUTA");
        TableColumn<Envio, String> repartidor = new TableColumn("REPARTIDOR");
        TableColumn<Envio, String> estado = new TableColumn("ESTADO");
        table.getColumns().addAll(id, ruta, repartidor, estado);
        
        id.setCellValueFactory(new PropertyValueFactory<Envio,String>("idEnv"));
        ruta.setCellValueFactory(new PropertyValueFactory<Envio,String>("rutaEnv"));
        repartidor.setCellValueFactory(new PropertyValueFactory<Envio,String>("repartidorEnv"));
        estado.setCellValueFactory(new PropertyValueFactory<Envio,String>("estadoEnv"));
        
        table.setItems(FXCollections.observableArrayList(envios));
    }
    
    public void setActionNuevo(){
        nuevo.setOnAction(value -> {
            FormEntregaView form = new FormEntregaView();
            Stage secondStage = new Stage();
            secondStage.setScene(new Scene(form.getRoot()));
            secondStage.showAndWait();
        });
        
    }
    
    public void setActionEditar(){
        editar.setOnAction(value -> {
            if(table.getSelectionModel().getSelectedItem() == null ){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("Error!!!");
                alert.setTitle("Error"); 
                alert.setContentText("No ha seleccionado un envio");
                alert.show();
            }
        });
    }
    
    
    public void setOnKeyPressedBuscar(){
        buscar.setOnKeyPressed(kEvent -> {
            if(!buscar.getText().isEmpty()){
                String filter = buscar.getText();
                fillTable(JefeBodegaController.getEnviosFiltered(filter));
            }else{
                fillTable(JefeBodegaController.getEnvios());
            }
            
        });
    }
    
    public void fillEstados(){
        estados.setItems(FXCollections.observableArrayList(JefeBodegaController.getEstados()));
    }
            
}
