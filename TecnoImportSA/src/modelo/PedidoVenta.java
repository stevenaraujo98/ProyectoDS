/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class PedidoVenta extends Pedido{
    private ArrayList<Producto> productosPdoVnt;
    private double recargoPdoVnt;

    public PedidoVenta(int idPdo, LocalDateTime fechaPdo) {
        super(idPdo, fechaPdo);
    }
    
    
}
