package edu.ifsc.lavacao_api.repository;

import edu.ifsc.lavacao_api.model.veiculos.Marca;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MarcaRepositoryTest {

    @Autowired
    private MarcaRepository marcaRepository;

    @Test
    void deveSalvarEMarcarUmaMarca() {
        // Criar uma nova Marca
        Marca marca = new Marca();
        marca.setNome("Toyota");

        // Salvar no banco
        Marca marcaSalva = marcaRepository.save(marca);

        // Verificar se foi salvo com ID
        assertNotNull(marcaSalva.getId());
        assertEquals("Toyota", marcaSalva.getNome());
    }

    @Test
    void deveBuscarUmaMarcaPorId() {
        // Criar e salvar uma marca
        Marca marca = new Marca();
        marca.setNome("Ford");
        Marca marcaSalva = marcaRepository.save(marca);

        // Buscar pelo ID
        Optional<Marca> marcaEncontrada = marcaRepository.findById(marcaSalva.getId());

        // Verificar se foi encontrada
        assertTrue(marcaEncontrada.isPresent());
        assertEquals("Ford", marcaEncontrada.get().getNome());
    }

    @Test
    void deveDeletarUmaMarca() {
        // Criar e salvar uma marca
        Marca marca = new Marca();
        marca.setNome("Chevrolet");
        Marca marcaSalva = marcaRepository.save(marca);

        // Deletar a marca
        marcaRepository.deleteById(marcaSalva.getId());

        // Verificar se foi removida
        Optional<Marca> marcaEncontrada = marcaRepository.findById(marcaSalva.getId());
        assertFalse(marcaEncontrada.isPresent());
    }
}

