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
public class PedidoAbastecimiento extends Pedido{
    
    private Localidad localPdoAbs;
    private ArrayList<InventarioDetalle> productosPdoAbs;
    
    public PedidoAbastecimiento(int idPdo, LocalDateTime fechaPdo) {
        super(idPdo, fechaPdo);
    }

    public Localidad getLocalPdoAbs() {
        return localPdoAbs;
    }

    public void setLocalPdoAbs(Localidad localPdoAbs) {
        this.localPdoAbs = localPdoAbs;
    }

    public ArrayList<InventarioDetalle> getProductosPdoAbs() {
        return productosPdoAbs;
    }

    public void setProductosPdoAbs(ArrayList<InventarioDetalle> productosPdoAbs) {
        this.productosPdoAbs = productosPdoAbs;
    }
    
    public String toString(){
        return this.fechaPdo.toString() + "-" + this.localPdoAbs;
    }
    
}
