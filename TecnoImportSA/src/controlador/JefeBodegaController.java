/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dbmanager.Procedure;
import java.sql.ResultSet;
import java.util.ArrayList;
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
        Procedure pro = new Procedure("buscarRutas").addValue("");
        try{
            ResultSet rs = ConexionDB.getInstance().executeProcedureResult(pro);
            if(rs == null) return null;
            while(rs.next()){
                Repartidor r = new Repartidor(rs.getString(5), rs.getString(6), rs.getString(7), null, 0, 0);
                Estado est = new Estado();
                Ruta rut = new Ruta();
                rut.setDestinoRta(rs.getString(2));
                est.setIdEstd(1);
                est.setNombreEstd(rs.getString(12));
                Envio e = new Envio();
                e.setEstadoEnv(est);
                e.setRepartidorEnv(r);
                e.setRutaEnv(rut);
                envios.add(e);
            }
        }catch(Exception ex){
            
        }
        return envios;
    }
}
