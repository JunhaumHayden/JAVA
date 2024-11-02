/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package br.edu.ifsc.testes;

import br.edu.ifsc.fln.tds.tso.teste.ml.mavenproject1.Compra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Professor
 */
public class CompraTest {
    
    public CompraTest() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void freteGratisTest() {
        Compra c = new Compra();
        c.setValor(150.0);
        assertTrue(c.freteGratis());
        
        c.setValor(150.1);
        assertTrue(c.freteGratis());
        
        c.setValor(149.9);
        assertFalse(c.freteGratis());
        
        c.setValor(200.0);
        assertTrue(c.freteGratis());
        
        c.setValor(-100.0);
        assertFalse(c.freteGratis());
    }
}
