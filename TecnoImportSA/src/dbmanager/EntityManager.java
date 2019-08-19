/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import controlador.ConexionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;

/**
 *
 * @author JordyVillao
 */
public class EntityManager {
    private ArrayList<Empleado> empleados;
    private ArrayList<Vendedor> vendedores;
    private ArrayList<JefeBodega> jefesBodegas;
    private ArrayList<Gerente> gerentes;
    private ArrayList<Admin> admins;
    private ArrayList<Repartidor> repartidores;
    private ArrayList<Producto> productos;
    private ArrayList<Venta> ventas;
    private ArrayList<Cotizacion> cotizaciones;
    private ArrayList<InventarioDetalle> inventarios;
    private ArrayList<Categoria> categorias;
    private ArrayList<Matriz> matrices;
    private ArrayList<Sucursal> sucursales; 
    private ArrayList<Bodega> bodegas;
    private ArrayList<Ruta> rutas;
    private ArrayList<Envio> envios;
    private EntityManager instance = new EntityManager();
    
    private EntityManager(){
        
    }
    
    
    
    
    
    
    
}
