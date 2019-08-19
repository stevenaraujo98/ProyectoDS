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
public class Categoria {
    private int idCat;
    private String nombreCat;
    private String descripcionCat;

    public Categoria(int idCat, String nombreCat, String descripcionCat) {
        this.idCat = idCat;
        this.nombreCat = nombreCat;
        this.descripcionCat = descripcionCat;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNombreCat() {
        return nombreCat;
    }

    public void setNombreCat(String nombreCat) {
        this.nombreCat = nombreCat;
    }

    public String getDescripcionCat() {
        return descripcionCat;
    }

    public void setDescripcionCat(String descripcionCat) {
        this.descripcionCat = descripcionCat;
    }

    @Override
    public String toString() {
        return this.nombreCat;
    }
    
    
}
