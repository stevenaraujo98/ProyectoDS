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
public class Empleado extends Persona {
    
    protected double sueldo;
    
    public Empleado(String dni, String nombres, String apellidos, Contact contact, double sueldo) {
        super(dni, nombres, apellidos, contact.getDireccion(), contact.getCorreo(), contact.getTelefono());
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
}
