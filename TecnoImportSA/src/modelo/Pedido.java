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
public abstract class Pedido {
    private int idPdo;
    private LocalDateTime fechaPdo;

    public Pedido(int idPdo, LocalDateTime fechaPdo) {
        this.idPdo = idPdo;
        this.fechaPdo = fechaPdo;
    }
    
}
