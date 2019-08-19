/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import controlador.ConexionDB;
import dbmanager.Procedure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author
 */
public class Usuario extends Empleado {
    
    protected int id;
    protected String nombreUsuario;
    protected String clave;    

    public Usuario(String nombreUsuario, String clave, Empleado emp) {
        super(emp.dni, emp.nombres, emp.apellidos, 
                new Contact(emp.direccion, emp.correo, emp.telefono), emp.sueldo);
        this.nombreUsuario = nombreUsuario;
        this.clave = clave;
    }
    
    public Usuario(int id, String nombreUsuario, String clave, Empleado emp) {
        this(nombreUsuario, clave, emp);
        this.id = id;
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

    public int getId() {
        return id;
    }
    
    public static Usuario getUsuario(String user, String pass){
        Procedure pro = new Procedure("login").addValue(user).addValue(pass); 
        try { 
            ResultSet rs = ConexionDB.getInstance().executeProcedureResult(pro);
            if(rs == null) return null;
            if(rs.next()){
                int id_user = rs.getInt(1);
                Procedure pro2 = new Procedure("empleadoByUserID").addValue(id_user); 
                ResultSet rs2 = ConexionDB.getInstance().executeProcedureResult(pro2);
                if(rs2 == null) return null;
                Empleado e = null;
                if(rs2.next())
                    e = new Empleado(rs2.getString(1), rs2.getString(2), rs2.getString(3),
                            new Contact(rs2.getString(4), rs2.getString(5), rs2.getString(6)), rs2.getDouble(7));
                if(e != null){
                    return selectReuturn(rs2.getInt(8), id_user, rs.getString(2), rs.getString(3), e); 
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    private static Usuario selectReuturn(int type, int id, String user, String pass, Empleado e){
        switch(type){
            case 1:
                return new Admin(id, user, pass, e);
            case 2:
                return new Gerente(id, user, pass, e);
            case 3:
                return new Vendedor(id, user, pass, e);
            case 4:
                return new JefeBodega(id, user, pass, e);
            default:
                return null;
        }
    }
}
