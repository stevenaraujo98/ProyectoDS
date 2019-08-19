/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.basescreen;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import modelo.Envio;


/**
 *
 * @author 
 */
public class InfoEntregaView extends BorderPane{
    
    private TableView<Envio> table;
    private TextField buscar;
    private Button nuevo;
    private Button editar;
    private Button eliminar;
    
    public InfoEntregaView(){
        super();
        table = new TableView();
        buscar = new TextField();
        nuevo = new Button("Nuevo");
        editar = new Button("Editar");
        eliminar  = new Button("Eliminar seleccionados");
        init();
    }
    
    public void init(){
        buscar.setPromptText("Buscar");
        this.setTop(new VBox(new Label("Buscar:"), buscar));
        this.setCenter(table);
        this.setRight(new VBox(nuevo, eliminar));
        
    }
    
    
    public void fillTable(ArrayList<Envio> envios){
        TableColumn id = new TableColumn("ID");
        TableColumn fecha0 = new TableColumn("FECHA REGISTRO");
        TableColumn fecha1 = new TableColumn("FECHA ENTREGA");
        TableColumn pedido = new TableColumn("PEDIDO");
        TableColumn ruta = new TableColumn("RUTA");
        TableColumn repartidor = new TableColumn("Repartidor");
        TableColumn estado = new TableColumn("ESTADO");
        TableColumn observaciones = new TableColumn("OBSERVACIONES");        
        table.getColumns().addAll(id, fecha0, fecha1, pedido, ruta, estado, observaciones);
        
        id.setCellValueFactory(new PropertyValueFactory<Envio,String>("idEnv"));
        fecha0.setCellValueFactory(new PropertyValueFactory<Envio,String>("fechaRegistroEnv"));
        fecha1.setCellValueFactory(new PropertyValueFactory<Envio,String>("fechaEntregaEnv"));
        pedido.setCellValueFactory(new PropertyValueFactory<Envio,String>("pedidoEnv"));
        ruta.setCellValueFactory(new PropertyValueFactory<Envio,String>("rutaEnv"));
        repartidor.setCellValueFactory(new PropertyValueFactory<Envio,String>("repartidorEnv"));
        observaciones.setCellValueFactory(new PropertyValueFactory<Envio,String>("observacionesEnv"));
        
        table.setItems(FXCollections.observableArrayList(envios));
    }
    
    public void setActionNuevo(){
        
    }
    
    public void setActionEditar(){
        
    }
    
    public void setActionEliminar(){
        
    }
    
    public void setOnKeyPressedBuscar(){
        buscar.setOnKeyPressed(kEvent -> {
            if(!buscar.getText().isEmpty()){
                String filter = buscar.getText();
                //fillTable();
                return;
            }
            //fillTable();
        });
    }
            
}
