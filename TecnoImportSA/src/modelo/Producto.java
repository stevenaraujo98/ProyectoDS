/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author 
 */
public class Producto {
    private int idPrdct;
    private String nombrePrdct;
    private String descripcionPrdct;
    private String garantiaPrdct;
    private double precioActualPrdct;

    public Producto(int idPrdct, String nombrePrdct, String descripcionPrdct, String garantiaPrdct, double precioActualPrdct) {
        this.idPrdct = idPrdct;
        this.nombrePrdct = nombrePrdct;
        this.descripcionPrdct = descripcionPrdct;
        this.garantiaPrdct = garantiaPrdct;
        this.precioActualPrdct = precioActualPrdct;
    }

    
    
    public int getIdPrdct() {
        return idPrdct;
    }

    public void setIdPrdct(int idPrdct) {
        this.idPrdct = idPrdct;
    }

    public String getNombrePrdct() {
        return nombrePrdct;
    }

    public void setNombrePrdct(String nombrePrdct) {
        this.nombrePrdct = nombrePrdct;
    }

    public String getDescripcionPrdct() {
        return descripcionPrdct;
    }

    public void setDescripcionPrdct(String descripcionPrdct) {
        this.descripcionPrdct = descripcionPrdct;
    }

    public String getGarantiaPrdct() {
        return garantiaPrdct;
    }

    public void setGarantiaPrdct(String garantiaPrdct) {
        this.garantiaPrdct = garantiaPrdct;
    }

    public double getPrecioActualPrdct() {
        return precioActualPrdct;
    }

    public void setPrecioActualPrdct(double precioActualPrdct) {
        this.precioActualPrdct = precioActualPrdct;
    }
    
    
    
}
