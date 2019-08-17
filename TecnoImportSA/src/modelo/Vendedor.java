/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * 
 */
public class Vendedor extends Usuario{
    
    public Vendedor(int id, String nombreUsuario, String clave, Empleado emp) {
        super(id, nombreUsuario, clave, emp);
    }
    
}
