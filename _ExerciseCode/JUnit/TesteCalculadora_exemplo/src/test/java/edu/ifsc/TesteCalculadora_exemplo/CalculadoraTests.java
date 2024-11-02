package edu.ifsc.TesteCalculadora_exemplo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CalculadoraTests {

	@Test
    @DisplayName("Soma de inteiros")
    public void testSoma() {
        int resultado = Calculadora.soma(3, 3);
        assertEquals(5, resultado, "A soma de 2 e 3 deveria ser 5");
    }

    @Test
    @DisplayName("Soma de Float")
    public void testSomaFloat() {
        float resultado = Calculadora.somaFloat(2.5f, 3.5f);
        assertEquals(6.0f, resultado, 0.001, "A soma de 2.5 e 3.5 deveria ser 6.0");
    }

    @Test
    @DisplayName("Soma Long")
    public void testSomaLong() {
        long resultado = Calculadora.somaLong(1000L, 2000L);
        assertEquals(3000L, resultado, "A soma de 1000 e 2000 deveria ser 3000");
    }
}
