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
public class Estado {
    private int idEstd;
    private String nombreEstd;
    private String descripcionEstd;

    public Estado(int idEstd, String nombreEstd) {
        this.idEstd = idEstd;
        this.nombreEstd = nombreEstd;
    }
    
    public Estado(){
        
    }
    
    public int getIdEstd() {
        return idEstd;
    }

    public void setIdEstd(int idEstd) {
        this.idEstd = idEstd;
    }

    public String getNombreEstd() {
        return nombreEstd;
    }

    public void setNombreEstd(String nombreEstd) {
        this.nombreEstd = nombreEstd;
    }

    public String getDescripcionEstd() {
        return descripcionEstd;
    }

    public void setDescripcionEstd(String descripcionEstd) {
        this.descripcionEstd = descripcionEstd;
    }
    
    public String toString(){
        return this.nombreEstd;
    }
    
}
