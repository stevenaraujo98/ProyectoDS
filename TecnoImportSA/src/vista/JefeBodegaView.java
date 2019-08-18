/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author 
 */
public class JefeBodegaView {
    private final TabPane root;
    private final Tab entregasTab; 
    private final Tab rutasTab; 
    private final Tab pedidosTab;
    private final BorderPane paneEnTb;
    private final BorderPane paneRuTb;
    private final BorderPane panePeTb;
    private final TableView entregasTbl;
    private final Button nuevaEntrega;
    
    
    public JefeBodegaView(){
        root = new TabPane();
        entregasTab = new Tab("Envios");
        rutasTab = new Tab("Rutas");
        pedidosTab = new Tab("Pedidos");
        paneEnTb = new BorderPane();
        paneRuTb = new BorderPane();
        panePeTb = new BorderPane();
        entregasTbl = new TableView();
        nuevaEntrega = new Button("Nuevo envio");
        
    }
    
    public void init(){
        root.getTabs().add(entregasTab);
        root.getTabs().add(rutasTab);
        root.getTabs().add(pedidosTab);
    }
    
    public void initEntregas(){
        paneEnTb.setCenter(entregasTbl);
        paneEnTb.setRight(nuevaEntrega);
        entregasTab.setContent(paneEnTb);
    }
    
    public void initRutas(){
        
    }
    
    public void initPedidos(){
        
    }
}
