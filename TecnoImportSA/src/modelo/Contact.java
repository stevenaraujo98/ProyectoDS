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
public class Contact {
    private String direccion;
    private String correo;
    private String telefono;

    public Contact(String direccion, String correo, String telefono) {
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Contact(String correo, String telefono) {
        this.correo = correo;
        this.telefono = telefono;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    @Override
    public String toString(){
        return this.correo + " " + this.telefono;
    }
}
