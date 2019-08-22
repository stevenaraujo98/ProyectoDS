/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author 
 */
public class Venta {
    private int idVnt;
    private LocalDateTime fechaVnt;
    private double total;
    private List<DetalleVenta> detallesVnt;
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getIdVnt() {
        return idVnt;
    }

    public void setIdVnt(int idVnt) {
        this.idVnt = idVnt;
    }

    public LocalDateTime getFechaVnt() {
        return fechaVnt;
    }

    public void setFechaVnt(LocalDateTime fechaVnt) {
        this.fechaVnt = fechaVnt;
    }

    public List<DetalleVenta> getDetallesVnt() {
        return detallesVnt;
    }

    public void setDetallesVnt(List<DetalleVenta> detallesVnt) {
        this.detallesVnt = detallesVnt;
    }    
}