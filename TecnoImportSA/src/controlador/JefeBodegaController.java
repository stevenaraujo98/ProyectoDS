/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbmanager.Procedure;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.*;
import vista.JefeBodegaView;

/**
 *
 * @author 
 */
public class JefeBodegaController {
    private JefeBodegaView bodegaView;
    private Bodega bodega;
    private ArrayList<Repartidor> colaRepartidores;
    
    public JefeBodegaController(JefeBodegaView bodegaView, Bodega bodega){
        this.bodegaView = bodegaView;
        this.bodega = bodega;
        this.colaRepartidores = bodega.getRepartidores();
    }
    
    public static ArrayList<Envio> getEnvios(){
        ArrayList<Envio> envios = new ArrayList();
        Procedure pro = new Procedure("buscarRutas").noArguments();
        try{
            ResultSet rs = ConexionDB.getInstance().executeProcedureResult(pro);
            if(rs == null) return null;
            while(rs.next()){ 
                envios.add(constructEnvio(rs));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return envios;
    }
    
    
    public static Envio constructEnvio(ResultSet rs) throws SQLException{
        Repartidor r = new Repartidor(rs.getString(5), rs.getString(6), rs.getString(7), new Contact("","",""), 0, 0);
        Estado est = new Estado();
        Ruta rut = new Ruta();
        rut.setDestinoRta(rs.getString(2));
        est.setIdEstd(rs.getInt(12));
        est.setNombreEstd(rs.getString(13));
        Envio e = new Envio();
        e.setIdEnv(rs.getInt(1));
        e.setEstadoEnv(est);
        e.setRepartidorEnv(r);
        e.setRutaEnv(rut);
        return e;
    }
    
    public static ArrayList<Envio> getEnviosFiltered(String filter){
        ArrayList<Envio> envios = new ArrayList();
        Procedure pro = new Procedure("buscarRutasFiltradas").addValue(filter);
        try{
            ResultSet rs = ConexionDB.getInstance().executeProcedureResult(pro);
            if(rs == null) return null;
            while(rs.next()){ 
                envios.add(constructEnvio(rs));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return envios;
    }
    
    public static ArrayList<Estado> getEstados(){
        ArrayList<Estado> estados = new ArrayList();
        Procedure pro = new Procedure("obtenerEstados").noArguments();
        try{
            ResultSet rs = ConexionDB.getInstance().executeProcedureResult(pro);
            while(rs.next()){
                estados.add(new Estado(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JefeBodegaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estados;
    }
    
    public static ArrayList<Repartidor> getRepartidores(String filter){
        ArrayList<Repartidor> repartidores = new ArrayList();
        Procedure pro = null;
        if(filter.isEmpty())
            pro = new Procedure("obtenerRepartidores").noArguments();
        else 
            pro = new Procedure("obtenerRepartidoresFiltrar").addValue(filter);
        try{
            ResultSet rs = ConexionDB.getInstance().executeProcedureResult(pro);
            while(rs.next()){
                repartidores.add(new Repartidor(rs.getString(4),rs.getString(5),rs.getString(6),new Contact(rs.getString(9),rs.getString(10),rs.getString(7)),0,0));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JefeBodegaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return repartidores;
    } 
    
    public static ArrayList<PedidoAbastecimiento> getAbastecimientos(){
        ArrayList<PedidoAbastecimiento> abastecimientos = new ArrayList();
        Procedure pro = new Procedure("obtenerAbastecimientos").noArguments();
        try{
            ResultSet rs = ConexionDB.getInstance().executeProcedureResult(pro);
            while(rs.next()){
                abastecimientos.add(new PedidoAbastecimiento(rs.getInt(1),rs.getDate(2).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JefeBodegaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return abastecimientos;
    }
}

