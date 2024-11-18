package com.github.hayden.junit;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.DisplayName.class)

// @TestMethodOrder(MethodOrderer.OrderAnnotation.class) // Odenando a execuçao dos testes pela Annotation @Order
// @TestMethodOrder(MethodOrderer.MethodName.class) // Odenando a execuçao dos testes pela Annotation @Order
public class EscolhendoAOrdemTeste {

    //@Order(4) // para o metodo OrderAnnotation.class
    @DisplayName("Teste que valida se o usuário foi criado")
    @Test
    void validaFluxoA() {
        Assertions.assertTrue(true, "Os objetos deveriam ser a mesma instância");
    }

    //@Order(3) // para o metodo OrderAnnotation.class
    @DisplayName("B")
    @Test
    void validaFluxoB() {
        Assertions.assertTrue(true);
    }

    //@Order(2) // para o metodo OrderAnnotation.class
    @DisplayName("C")
    @Test
    void validaFluxoC() {
        Assertions.assertTrue(true);
    }

    //@Order(1) // para o metodo OrderAnnotation.class
    @DisplayName("D")
    @Test
    void validaFluxoD() {
        Assertions.assertTrue(true);
    }
}