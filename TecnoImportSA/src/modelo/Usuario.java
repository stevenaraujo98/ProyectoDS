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
public class Usuario {
    
    private String nombreUsuario;
    private String clave;
    private Privilegios privilegio;
    

    public Usuario(String nombreUsuario, String clave, Privilegios p) {
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
        this.privilegio = p;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Privilegios getPrivilegio() {
        return privilegio;
    }

    public void setPrivilegio(Privilegios privilegio) {
        this.privilegio = privilegio;
    }
    
    public enum Privilegios{admin, consult, common, nothing}
}
