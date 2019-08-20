/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Kenny Camba
 */
public class Stock{
    private int cant;
    private int idPrdct;
    private String nombrePrdct;
    private String descripcionPrdct;
    private double precioActualPrdct;
    private Categoria categoria;

    public Stock(Producto p, int cant){
        this.idPrdct = p.getIdPrdct();
        this.nombrePrdct = p.getNombrePrdct();
        this.descripcionPrdct = p.getDescripcionPrdct();
        this.precioActualPrdct = p.getPrecioActualPrdct();
        this.categoria = p.getCategoria();
        this.cant = cant;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
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

}
