/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbmanager.Procedure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Admin;
import modelo.Categoria;
import modelo.Localidad;
import modelo.Producto;
import vista.AdminView;

/**
 *
 * @author 
 */
public class AdminController {
    private AdminView adminview;
    private Admin admin;
    
    public AdminController(AdminView adminview, Admin admin){
        this.adminview = adminview;
        this.admin = admin;
    }
    
    public void crearNuevoRegistro(){
        //funcionalidad en construccion 
    }
    
    public void registrarRegistroExistente(){
        //funcionalidad en construccion
    }
    
    public void consultarRegistroExistente(){
        //funcionalidad en construccion
    }
    
    public void eliminarRegistroExistente(){
        //funcionalidad en construccion
    }
    
    public ArrayList<Producto> consultarProducto(String nombre){
        Procedure proc = new Procedure("productosPorNombre").addValue(nombre); 
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            ResultSet result = ConexionDB.getInstance().executeProcedureResult(proc);
            if(result != null){
                while(result.next()){
                    Categoria c = new Categoria(result.getInt(5), result.getString(6), result.getString(7));
                    Producto producto = new Producto(result.getInt(1), result.getString(2), 
                                result.getString(3), result.getDouble(4), c); 
                    productos.add(producto);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return productos;
    }
    
    public void updateStock(int idProd, Localidad loc, int newCant){
        try {
            ConexionDB.getInstance().executeProcedure(new Procedure("updateStock") 
                    .addValue(idProd).addValue(loc.getIdLcld()).addValue(newCant));
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addProducto(int idProd, Localidad loc, int newCant){
        try {
            ConexionDB.getInstance().executeProcedure(new Procedure("addProductoLocal") 
                    .addValue(idProd).addValue(loc.getIdLcld()).addValue(newCant));
        } catch (SQLException ex) {
            Logger.getLogger(AdminController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
