/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public abstract class Localidad {
    protected int idLcld;
    protected String nombreLcld;
    protected String direccionLcld;
    protected String Telefono;
    protected Admin admin;
    protected ArrayList<InventarioDetalle> inventario;
    protected ArrayList<Empleado> empleados;
            
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
    
    public Admin getAdmin(){
        return this.admin;
    }
    
    public void setAdmin(Admin a){
        this.admin = a;
    }
    
    
}
