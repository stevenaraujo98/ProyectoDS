/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author HP
 */
public class Repartidor extends Empleado{
    
    private boolean disponible;
    
    public Repartidor(String dni, String nombres, String apellidos, Contact contact, double sueldo) {
        super(dni, nombres, apellidos, contact, sueldo);
        this.disponible = true;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
      
}
