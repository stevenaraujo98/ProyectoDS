/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ConexionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public String toString(){
        return this.nombreLcld;
    }
    
    public static Localidad getLocalByID(int id){
        
        return null; 
    }
    
    public static ArrayList<Localidad> getLocales(){
        String query = "select * from Locales";
        ArrayList<Localidad> locales = new ArrayList<>();
        try {
            ResultSet rs = ConexionDB.getInstance().getStatement().executeQuery(query);
            if(rs != null){
                while(rs.next()){
                    Localidad local = null;
                    switch(rs.getInt(5)){
                        case 1:
                            local = new Matriz(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));  
                            break;
                        case 2:
                            local = new Sucursal(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                            break;
                        case 3:
                            local = new Bodega(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
                            break;
                        default:
                            break;
                    }
                    locales.add(local);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Localidad.class.getName()).log(Level.SEVERE, null, ex);
        }
        return locales;
    }
    
    
}
