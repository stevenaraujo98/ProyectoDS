/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import modelo.Estado;
import modelo.Pedido;
import modelo.Repartidor;
import modelo.Ruta;

/**
 *
 * @author
 */
public class FormEntregaView {
    private GridPane root;
    private DatePicker fechaEntrega;
    private ComboBox<Estado> estado;
    private ComboBox<Ruta> ruta;
    private ComboBox<Repartidor> repartidor;
    private ComboBox<Pedido> pedido;
    private TextArea observaciones;
    private Button guardar;
    private boolean b;

    public FormEntregaView() {
        this.root = new GridPane();
        this.fechaEntrega = new DatePicker();
        this.estado = new ComboBox<>();
        this.ruta = new ComboBox();
        this.repartidor = new ComboBox();
        this.pedido = new ComboBox();
        this.observaciones = new TextArea();
        this.guardar = new Button("Guardar");
        init();
        setActionGuardar();
        editCBoxes();
    }
    
    public void init(){
        root.setPadding(new Insets(10,10,10,10));
        root.setVgap(8);
        root.setHgap(10);
        GridPane.setConstraints(new Label("ENVIO"), 1, 0);
        GridPane.setConstraints(new Label("Fecha entrega:"), 0, 1);
        GridPane.setConstraints(new Label("Pedido:"), 0, 2);
        GridPane.setConstraints(new Label("Ruta:"), 0, 3);
        GridPane.setConstraints(fechaEntrega, 1, 1);
        GridPane.setConstraints(pedido, 1, 2);
        GridPane.setConstraints(ruta, 1, 3);
        GridPane.setConstraints(guardar, 1, 4);
    }
    
    public void editCBoxes(){
        //usar metodo para tener datos
        ObservableList<Pedido> pe = FXCollections.observableArrayList();
        ObservableList<Ruta> ru = FXCollections.observableArrayList();
        ObservableList<Repartidor> re = FXCollections.observableArrayList();
        ObservableList<Estado> es = FXCollections.observableArrayList();
        
        pedido.setItems(pe);
        ruta.setItems(FXCollections.observableArrayList());
        repartidor.setItems(FXCollections.observableArrayList());
        estado.setItems(FXCollections.observableArrayList());
        
    }
    
    public void setActionGuardar(){
        guardar.setOnAction(value -> {
            if(notEmptyFields()){
                //update tableview & push query
                b = true;                
            }else{
                b = false;
            } 
        });
    }
    
    public boolean notEmptyFields(){
        return fechaEntrega.getValue()!= null 
                && pedido.getSelectionModel().getSelectedItem()!= null
                && ruta.getSelectionModel().getSelectedItem()!= null
                && repartidor.getSelectionModel().getSelectedItem()!= null
                && estado.getSelectionModel().getSelectedItem()!= null
                && !observaciones.getText().isEmpty();
    }
    
    
    
    
}
