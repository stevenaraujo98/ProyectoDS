/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author JordyVillao
 */
public abstract class Localidad {
    private int idLcld;
    private String nombreLcld;
    private String direccionLcld;
    private String Telefono;
    //private Admin admin;
    //private Inventario inventario;

    public Localidad(int idLcld, String nombreLcld, String direccionLcld, String Telefono) {
        this.idLcld = idLcld;
        this.nombreLcld = nombreLcld;
        this.direccionLcld = direccionLcld;
        this.Telefono = Telefono;
    }

    public int getIdLcld() {
        return idLcld;
    }

    public void setIdLcld(int idLcld) {
        this.idLcld = idLcld;
    }

    public String getNombreLcld() {
        return nombreLcld;
    }

    public void setNombreLcld(String nombreLcld) {
        this.nombreLcld = nombreLcld;
    }

    public String getDireccionLcld() {
        return direccionLcld;
    }

    public void setDireccionLcld(String direccionLcld) {
        this.direccionLcld = direccionLcld;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
}
