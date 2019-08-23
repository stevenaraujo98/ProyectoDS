/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbmanager;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author SSAM
 */
public class ProcedureTest {
    /**
     * 
     */
    @Test
    public void testNotNullAddValue(){
        Procedure procedure = new Procedure("empleadosByIDLocal").addValue("");
        assertNotNull(procedure);   
    }
    
    /**
     * 
     */
    @Test
    public void testProcedureCorrect(){
        Procedure procedure = new Procedure("empleadosByIDLocal").addValue("Tecno Import S.A.");
        assertTrue(procedure.getStringForm().equals("empleadosByIDLocal (\"Tecno Import S.A.\")"));   
    }
}