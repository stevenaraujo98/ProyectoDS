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
public abstract class Persona {
    protected String dni;
    protected String nombres;
    protected String apellidos;
    protected Contact contacto;

    public Persona(String dni, String nombres, String apellidos, Contact contacto) {
        this.dni = dni;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contacto = contacto;
    }
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Contact getContacto() {
        return contacto;
    }

    public void setContacto(Contact contacto) {
        this.contacto = contacto;
    }
    
    @Override
    public String toString(){
        return this.nombres + " " + this.apellidos;
    }
}
