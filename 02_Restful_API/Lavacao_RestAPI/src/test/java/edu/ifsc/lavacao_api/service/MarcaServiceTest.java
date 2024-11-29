package edu.ifsc.lavacao_api.service;

import edu.ifsc.lavacao_api.model.veiculos.Marca;
import edu.ifsc.lavacao_api.repository.MarcaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MarcaServiceTest {

    @InjectMocks
    private MarcaService marcaService;

    @Mock
    private MarcaRepository marcaRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void listarTodas_DeveRetornarListaDeMarcas() {
        when(marcaRepository.findAll()).thenReturn(Arrays.asList(
                new Marca(1, "Toyota"),
                new Marca(2, "Honda")
        ));

        var marcas = marcaService.listarTodas();

        assertEquals(2, marcas.size());
        assertEquals("Toyota", marcas.get(0).getNome());
        verify(marcaRepository, times(1)).findAll();
    }

    @Test
    void buscarPorId_DeveRetornarMarcaQuandoEncontrada() {
        Marca marca = new Marca(1, "Toyota");
        when(marcaRepository.findById(1)).thenReturn(Optional.of(marca));

        var resultado = marcaService.buscarPorId(1);

        assertTrue(resultado.isPresent());
        assertEquals("Toyota", resultado.get().getNome());
        verify(marcaRepository, times(1)).findById(1);
    }

    @Test
    void criarMarca_DeveSalvarNovaMarcaQuandoNaoDuplicada() {
        Marca novaMarca = new Marca(0, "Ford");
        when(marcaRepository.findByNome("Ford")).thenReturn(null);
        when(marcaRepository.save(novaMarca)).thenReturn(new Marca(1, "Ford"));

        var marcaSalva = marcaService.criarMarca(novaMarca);

        assertNotNull(marcaSalva);
        assertEquals("Ford", marcaSalva.getNome());
        verify(marcaRepository, times(1)).findByNome("Ford");
        verify(marcaRepository, times(1)).save(novaMarca);
    }

    @Test
    void criarMarca_DeveLancarExcecaoSeMarcaDuplicada() {
        Marca marcaExistente = new Marca(1, "Toyota");
        when(marcaRepository.findByNome("Toyota")).thenReturn(Collections.singletonList(marcaExistente)); // Retorna lista com uma marca

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            marcaService.criarMarca(new Marca(0, "Toyota"));
        });

        assertEquals("Marca já existe com o nome: Toyota", exception.getMessage());
        verify(marcaRepository, never()).save(any());
    }
}

