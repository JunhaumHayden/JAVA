/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ifsc.testes;

import ifsc.junittestes.Compra;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bpvelloso
 */
public class CompraTest {
    
    public CompraTest() {
    }
    
   
    @Test
    public void freteGratisTest() {
        Compra compra = new Compra();
        assertTrue(compra.freteGratis(150.0));
    }
}
