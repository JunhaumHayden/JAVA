package br.edu.ifsc.fln;

import org.junit.jupiter.api.Test;

import br.edu.ifsc.fln.model.domain.Calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    @Test
    void testAdd() {
        Calculator calculator = new Calculator();
        int result = calculator.add(5, 3);
        assertEquals(8, result, "5 + 3 deve ser 8");
    }

    @Test
    void testSubtract() {
        Calculator calculator = new Calculator();
        int result = calculator.subtract(10, 4);
        assertEquals(6, result, "10 - 4 deve ser 6");
    }
}
