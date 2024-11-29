package edu.ifsc.lavacao_api.model.veiculos;

import edu.ifsc.lavacao_api.model.ECategoria;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModeloTest {

    @Test
    void deveCriarModeloComDescricaoMarcaEMotor() {
        Marca marca = new Marca(1, "Honda");
        Motor motor = new Motor(1, 120, ETipoCombustivel.FLEX, new Modelo());

        Modelo modelo = new Modelo();
        modelo.setId(1);
        modelo.setDescricao("Civic");
        modelo.setMarca(marca);
        modelo.setMotor(motor);
        modelo.setCategoria(ECategoria.MEDIO);

        assertEquals(1, modelo.getId());
        assertEquals("Civic", modelo.getDescricao());
        assertEquals(marca, modelo.getMarca());
        assertEquals(motor, modelo.getMotor());
        assertEquals(ECategoria.MEDIO, modelo.getCategoria());
    }

    @Test
    void deveAtualizarACategoriaDoModelo() {
        Modelo modelo = new Modelo();
        modelo.setCategoria(ECategoria.PEQUENO);
        modelo.setCategoria(ECategoria.GRANDE);

        assertEquals(ECategoria.GRANDE, modelo.getCategoria());
    }
}

