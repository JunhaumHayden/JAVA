package com.github.hayden.junit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;


/**
 * Exemplos de asserções usando a classe {@link org.junit.jupiter.api.Assertions}
 *
 *
 */

public class AssertionsTest {
     @Test
    void testEhMaiorDeIdade() {
        // Arrange
        Pessoa adulto = new Pessoa("Alice", LocalDateTime.now().minusYears(26));
        Pessoa menor = new Pessoa("Bob", LocalDateTime.now().minusYears(15));

        // Act & Assert
        assertTrue(adulto.ehMaiorDeIdade(), "Pessoa com 25 anos deveria ser maior de idade.");
        assertFalse(menor.ehMaiorDeIdade(), "Pessoa com 15 anos não deveria ser maior de idade.");
    }

    @Test
    void testEquals() {
        // Arrange
        Pessoa pessoa1 = new Pessoa("Carlos", LocalDateTime.of(1998, 5, 15, 0, 0));
        Pessoa pessoa2 = new Pessoa("Carlos", LocalDateTime.of(1998, 5, 15, 0, 0));
        Pessoa pessoa3 = new Pessoa("Diana", LocalDateTime.of(2000, 7, 20, 0, 0));

        // Act & Assert
        assertEquals(pessoa1, pessoa2, "Objetos com mesmo nome e nascimento deveriam ser iguais.");
        assertNotEquals(pessoa1, pessoa3, "Objetos com nome ou nascimento diferentes não deveriam ser iguais.");
    }

    @Test
    void testGetIdade() {
        // Arrange
        Pessoa pessoa = new Pessoa("Eduardo", LocalDateTime.now().minusYears(30));

        // Act
        int idade = pessoa.getIdade();

        // Assert
        assertEquals(30, idade, "A idade calculada está incorreta.");
    }

    @Test
    void testHashCode() {
        // Arrange
        Pessoa pessoa1 = new Pessoa("Fábio", LocalDateTime.of(1995, 10, 10, 0, 0));
        Pessoa pessoa2 = new Pessoa("Fábio", LocalDateTime.of(1995, 10, 10, 0, 0));
        Pessoa pessoa3 = new Pessoa("Gabriela", LocalDateTime.of(2001, 3, 20, 0, 0));

        // Act & Assert
        assertEquals(pessoa1.hashCode(), pessoa2.hashCode(), "Objetos iguais deveriam ter o mesmo hashCode.");
        assertNotEquals(pessoa1.hashCode(), pessoa3.hashCode(), "Objetos diferentes deveriam ter hashCodes diferentes.");
    }

    @Test
    void validarValoresDeOperacoes() {

        /* Validando soma */
        int resultado = 10;
        assertEquals(resultado, (5 + 5));

        /* Validando igualdade de valores */
        double valor = 5.0;
        double outroValor = 5.0;
        assertEquals(valor, outroValor);
    }

    @Test
    void validarSeArraysSaoIguais() {

        /* Valida se os arrays são iguais, comparando um a um */
        int[] primeiroLancamento = {10, 20, 30, 40, 50};
        int[] segundoLancamento = {10, 20, 30, 40, 50};
        assertArrayEquals(primeiroLancamento, segundoLancamento);

        /* Utilizando arrays de diferentes tipos, começando por boolean[] */
        boolean[] flags = {true, false, false};
        assertArrayEquals(new boolean[]{true, false, false}, flags);

        /* Utilizando arrays de diferentes tipos, começando por double[] */
        double[] valores = {5.0, 10.5, 50D, 46d};
        assertArrayEquals(new double[]{5.0, 10.5, 50D, 46d}, valores);
    }

    @Test
    void validarSeObjetoEstaNuloOuNao() {

        Pessoa pessoa = null;
        assertNull(pessoa);

        pessoa = new Pessoa("Luciano", LocalDateTime.now());
        assertNotNull(pessoa);
    }

    @Test
    void validarNumerosDeTiposDiferentes() {

        double valor = 5.0;
        double outroValor = 5.0;

        assertEquals(valor, outroValor);
    }

    @Test
    void validarQueValoresSaoDiferentes(){

        int x = 5;
        int y = 6;

        assertNotEquals(5, 6);
    }

    @Test
    void validarQueAlgumaCondicaoEhFalsa() {

        boolean condicao = 5 + 6 == 12;

        assertFalse(condicao);
    }

    @Test
    void validarQueAlgumaCondicaoEhVerdadeira() {

        var condicao = 6 + 6 == 12;

        assertTrue(condicao);
    }
}
