/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDateTime;

/**
 *
 * @author 
 */
public class Ruta {
    private int idRta;
    private String destinoRta;
    private LocalDateTime entradaRta;
    private LocalDateTime salidaRta;
    private String vehiculoRta;
    private String detallesRta;

    public int getIdRta() {
        return idRta;
    }

    public void setIdRta(int idRta) {
        this.idRta = idRta;
    }

    public String getDestinoRta() {
        return destinoRta;
    }

    public void setDestinoRta(String destinoRta) {
        this.destinoRta = destinoRta;
    }

    public LocalDateTime getEntradaRta() {
        return entradaRta;
    }

    public void setEntradaRta(LocalDateTime entradaRta) {
        this.entradaRta = entradaRta;
    }

    public LocalDateTime getSalidaRta() {
        return salidaRta;
    }

    public void setSalidaRta(LocalDateTime salidaRta) {
        this.salidaRta = salidaRta;
    }

    public String getVehiculoRta() {
        return vehiculoRta;
    }

    public void setVehiculoRta(String vehiculoRta) {
        this.vehiculoRta = vehiculoRta;
    }

    public String getDetallesRta() {
        return detallesRta;
    }

    public void setDetallesRta(String detallesRta) {
        this.detallesRta = detallesRta;
    }
    
}
