package com.github.hayden.junit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ExceptionsTeste {

     @Test
    void testAssertThrows() {
        // Testando uma exceção esperada
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("Parâmetro inválido");
        });

        // Verificando a mensagem da exceção
        assertEquals("Parâmetro inválido", exception.getMessage());
    }

    //Metodo que lança a excecao
    @Test
    void validarCenarioDeExcecaoNaTransferencia() {
        Conta contaOrigem = new Conta("123456", 0);
        Conta contaDestino = new Conta("456548", 100);

        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();

        Assertions.assertThrows(IllegalArgumentException.class,() -> transferenciaEntreContas.transfere(contaOrigem, contaDestino, -1)); // utilizamos uma funcao lambda para apontar para a operacao com a excecao (No caso transferir valor negativo)
    }
    
    //Metodo que nao lanca a excecao
    @Test
    void validarCenarioDeNaoExcecaoNaTransferencia() {
        Conta contaOrigem = new Conta("123456", 0);
        Conta contaDestino = new Conta("456548", 100);

        TransferenciaEntreContas transferenciaEntreContas = new TransferenciaEntreContas();

        Assertions.assertDoesNotThrow(() -> transferenciaEntreContas.transfere(contaOrigem, contaDestino, 20));
    }

    @Test
    void testAssertDoesNotThrow() {
        // Testando que nenhuma exceção é lançada
        assertDoesNotThrow(() -> {
            int resultado = 10 / 2; // Operação válida
            // int resultado = 10 / 0; // Operação inválida
            assertEquals(5, resultado);
        }, "Uma exceção foi lançada, pois divisão por zero lança uma exceção");
    }

    //Exemplo combinado
    @Test
    void testExceptions() {
        // Validando uma exceção esperada
        assertThrows(ArithmeticException.class, () -> {
            int resultado = 10 / 0; // Gera ArithmeticException
        }, "Divisão por zero deveria lançar uma exceção.");

        // Garantindo que nenhuma exceção ocorre
        assertDoesNotThrow(() -> {
            int resultado = 10 / 2; // Operação válida
            assertEquals(5, resultado);
        }, "Nenhuma exceção deveria ser lançada.");
    }
}