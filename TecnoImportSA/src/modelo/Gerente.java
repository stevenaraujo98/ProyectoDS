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
public class Gerente extends Usuario{
    
    public Gerente(int id, String nombreUsuario, String clave, Empleado emp) {
        super(id, nombreUsuario, clave, emp);
    }
    
    public boolean save(){
        
        return true;
    }
}
