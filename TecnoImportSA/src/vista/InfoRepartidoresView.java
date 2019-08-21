/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.JefeBodegaController;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.Envio;
import modelo.Repartidor;

/**
 *
 * @author
 */
public class InfoRepartidoresView extends BorderPane{
    private TableView<Repartidor> table;
    private TextField buscar;
    
    public InfoRepartidoresView(){
        super();
        table = new TableView();
        buscar = new TextField();
        init();
    }
    
    public void init(){
        buscar.setPromptText("Buscar");
        this.setTop(new VBox(new Label("Buscar:"), buscar));
        this.setCenter(table);
        setOnKeyPressedBuscar();
        fillTable(JefeBodegaController.getRepartidores(""));
    }
    
    public void fillTable(ArrayList<Repartidor> repartidores){
        table.getColumns().clear();
        table.getItems().clear();
        TableColumn<Repartidor, String> dni = new TableColumn("DNI");
        TableColumn<Repartidor, String> nombres = new TableColumn("NOMBRES");
        TableColumn<Repartidor, String> apellidos = new TableColumn("APELLIDOS");
        TableColumn<Repartidor, String> telefono = new TableColumn("CONTACTO");
        TableColumn<Repartidor, String> disponible = new TableColumn("DISPONIBLE");
        table.getColumns().addAll(dni,nombres,apellidos,telefono,disponible);
        
        dni.setCellValueFactory(new PropertyValueFactory<Repartidor,String>("dni"));
        nombres.setCellValueFactory(new PropertyValueFactory<Repartidor,String>("nombres"));
        apellidos.setCellValueFactory(new PropertyValueFactory<Repartidor,String>("apellidos"));
        telefono.setCellValueFactory(new PropertyValueFactory<Repartidor,String>("telefono"));
        disponible.setCellValueFactory(new PropertyValueFactory<Repartidor,String>("disponible"));
        
        table.setItems(FXCollections.observableArrayList(repartidores));
    }
     public void setOnKeyPressedBuscar(){
        buscar.setOnKeyPressed(kEvent -> {
            if(!buscar.getText().isEmpty()){
                String filter = buscar.getText();
                System.out.println(filter);
                fillTable(JefeBodegaController.getRepartidores(filter));
            }else{
                fillTable(JefeBodegaController.getRepartidores(""));
            }
            
        });
    }
}
