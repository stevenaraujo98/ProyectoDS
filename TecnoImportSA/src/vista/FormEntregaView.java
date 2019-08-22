/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import modelo.Estado;
import modelo.PedidoAbastecimiento;
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
    private ComboBox<PedidoAbastecimiento> pedido;
    private TextArea observaciones;
    private Button guardar;
    
    public GridPane getRoot(){
        return this.root;
    }
        

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
        Label l1 = new Label("ENVIO");
        Label l2 = new Label("Fecha entrega:");
        Label l3 = new Label("Pedido:");
        Label l4 = new Label("Ruta:");
        GridPane.setConstraints(l1, 1, 0);
        GridPane.setConstraints(l2, 0, 1);
        GridPane.setConstraints(l3, 0, 2);
        GridPane.setConstraints(l4, 0, 3);
        GridPane.setConstraints(fechaEntrega, 1, 1);
        GridPane.setConstraints(pedido, 1, 2);
        GridPane.setConstraints(ruta, 1, 3);
        GridPane.setConstraints(guardar, 1, 4);
        root.getChildren().addAll(l1,l2,l3,l4,fechaEntrega,pedido,ruta,guardar);
    }
    
    public void editCBoxes(){
        pedido.setItems(FXCollections.observableArrayList());
        ruta.setItems(FXCollections.observableArrayList());
        repartidor.setItems(FXCollections.observableArrayList());
        estado.setItems(FXCollections.observableArrayList());
        
    }
    
    public void setActionGuardar(){
        guardar.setOnAction(value -> {
            if(notEmptyFields()){
                //update tableview & push query
            }else{
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Existen campos vacios");
                a.setTitle("Error");
                a.show();
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
