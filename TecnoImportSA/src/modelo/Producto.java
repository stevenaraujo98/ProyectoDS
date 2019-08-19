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
    private double precioActualPrdct;
    private Categoria categoria;

    public Producto(int idPrdct, String nombrePrdct, String descripcionPrdct, double precioActualPrdct, Categoria c) {
        this.idPrdct = idPrdct;
        this.nombrePrdct = nombrePrdct;
        this.descripcionPrdct = descripcionPrdct;
        this.precioActualPrdct = precioActualPrdct;
        this.categoria = c;
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

    public double getPrecioActualPrdct() {
        return precioActualPrdct;
    }

    public void setPrecioActualPrdct(double precioActualPrdct) {
        this.precioActualPrdct = precioActualPrdct;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" + "idPrdct=" + idPrdct + ", nombrePrdct=" + nombrePrdct + ", descripcionPrdct=" + descripcionPrdct + ", precioActualPrdct=" + precioActualPrdct + ", categoria=" + categoria + '}';
    }
        
}
