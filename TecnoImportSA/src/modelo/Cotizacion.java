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
public class Cotizacion {
    private int idCtz;
    private LocalDateTime fechaCtz;
    private double totalCtz;
    private List<DetalleVenta> detallesCtz;

    public int getIdCtz() {
        return idCtz;
    }

    public void setIdCtz(int idCtz) {
        this.idCtz = idCtz;
    }

    public LocalDateTime getFechaCtz() {
        return fechaCtz;
    }

    public void setFechaCtz(LocalDateTime fechaCtz) {
        this.fechaCtz = fechaCtz;
    }

    public double getTotalCtz() {
        return totalCtz;
    }

    public void setTotalCtz(double totalCtz) {
        this.totalCtz = totalCtz;
    }

    public List<DetalleVenta> getDetallesCtz() {
        return detallesCtz;
    }

    public void setDetallesCtz(List<DetalleVenta> detallesCtz) {
        this.detallesCtz = detallesCtz;
    }
    
    
}
