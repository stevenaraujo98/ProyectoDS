/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.ArrayList;
import modelo.*;
import vista.JefeBodegaView;

/**
 *
 * @author 
 */
public class JefeBodegaController {
    private JefeBodegaView bodegaView;
    private Bodega bodega;
    private ArrayList<Repartidor> colaRepartidores;
    
    public JefeBodegaController(JefeBodegaView bodegaView, Bodega bodega){
        this.bodegaView = bodegaView;
        this.bodega = bodega;
        this.colaRepartidores = bodega.getRepartidores();
    }
    
}
