/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JordyVillao
 */
public class FormEntregaViewTest {
    
   //Se asegura que apenas creado una forma para crear una entrega
    //esta no tenga datos predefinidos
   @Test
   public void testFormEntregaViewFields(){
       FormEntregaView view = new FormEntregaView();
       assertFalse(view.notEmptyFields());
   }  
    
}
