/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Envio {
    private int idEnv;
    private Pedido pedidoEnv;
    private LocalDateTime fechaRegistroEnv;
    private LocalDateTime fechaEntregaEnv;
    private Estado estadoEnv;
    private String observacionesEnv;
    private Ruta rutaEnv;
    private Repartidor repartidorEnv;

    public int getIdEnv() {
        return idEnv;
    }

    public void setIdEnv(int idEnv) {
        this.idEnv = idEnv;
    }
    
    public Pedido getPedidoEnv() {
        return pedidoEnv;
    }
    
    public void setPedidoEnv(Pedido pedido){
        this.pedidoEnv = pedido; 
    }

    public LocalDateTime getFechaRegistroEnv() {
        return fechaRegistroEnv;
    }

    public void setFechaRegistroEnv(LocalDateTime fechaRegistroEnv) {
        this.fechaRegistroEnv = fechaRegistroEnv;
    }

    public LocalDateTime getFechaEntregaEnv() {
        return fechaEntregaEnv;
    }

    public void setFechaEntregaEnv(LocalDateTime fechaEntregaEnv) {
        this.fechaEntregaEnv = fechaEntregaEnv;
    }

    public Estado getEstadoEnv() {
        return estadoEnv;
    }

    public void setEstadoEnv(Estado estadoEnv) {
        this.estadoEnv = estadoEnv;
    }

    public String getObservacionesEnv() {
        return observacionesEnv;
    }

    public void setObservacionesEnv(String observacionesEnv) {
        this.observacionesEnv = observacionesEnv;
    }

    public Ruta getRutaEnv() {
        return rutaEnv;
    }

    public void setRutaEnv(Ruta rutaEnv) {
        this.rutaEnv = rutaEnv;
    }

    public Repartidor getRepartidorEnv() {
        return repartidorEnv;
    }

    public void setRepartidorEnv(Repartidor repartidorEnv) {
        this.repartidorEnv = repartidorEnv;
    }
    
    
    
}
