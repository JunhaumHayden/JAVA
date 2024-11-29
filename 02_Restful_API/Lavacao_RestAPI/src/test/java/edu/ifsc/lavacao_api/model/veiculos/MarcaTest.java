package edu.ifsc.lavacao_api.model.veiculos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MarcaTest {

    @Test
    void deveCriarMarcaComNome() {
        Marca marca = new Marca();
        marca.setId(1);
        marca.setNome("Toyota");

        assertEquals(1, marca.getId());
        assertEquals("Toyota", marca.getNome());
    }

    @Test
    void deveAtualizarONomeDaMarca() {
        Marca marca = new Marca(1, "Ford");
        marca.setNome("Chevrolet");

        assertEquals("Chevrolet", marca.getNome());
    }
}

