/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author 
 */
public class Bodega extends Localidad{
    private JefeBodega jefeBodega;

    public Bodega(int idLcld, String nombreLcld, String direccionLcld, String telefono) {
        super(idLcld, nombreLcld, direccionLcld, telefono);
    }
    
    public JefeBodega getJefeBodega(){
        return this.jefeBodega;
    }
    
    public void setJefeBodega(JefeBodega j){
        this.jefeBodega = j;
    }
    
    public ArrayList<Repartidor> getRepartidores(){
        ArrayList<Repartidor> repartidores = new ArrayList<>();
        for(Empleado e: empleados){
            if(e instanceof Repartidor){
                repartidores.add((Repartidor)e);
            }
        }
        return repartidores;
    }    
}
