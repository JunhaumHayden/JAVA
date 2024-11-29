package edu.ifsc.lavacao_api.service;

import edu.ifsc.lavacao_api.model.veiculos.ETipoCombustivel;
import edu.ifsc.lavacao_api.model.veiculos.Marca;
import edu.ifsc.lavacao_api.model.veiculos.Modelo;
import edu.ifsc.lavacao_api.model.veiculos.Motor;
import edu.ifsc.lavacao_api.repository.ModeloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ModeloServiceTest {

    @InjectMocks
    private ModeloService modeloService;

    @Mock
    private ModeloRepository modeloRepository;

    private Modelo modelo;
    private Marca marca;
    private Motor motor;

    @BeforeEach
    void setUp() {
        // Inicializar os mocks
        MockitoAnnotations.openMocks(this);

        // Criando objetos de teste
        marca = new Marca(1, "Marca A");
        motor = new Motor(1, 200, null, null);
        modelo = new Modelo(1, "Modelo A", marca, motor, null);
    }

    @Test
    void listarTodos() {
        // Configura o comportamento do repositório
        when(modeloRepository.findAll()).thenReturn(Arrays.asList(modelo));

        // Chama o método a ser testado
        var modelos = modeloService.listarTodos();

        // Verifica o resultado
        assertNotNull(modelos);
        assertEquals(1, modelos.size());
        assertEquals("Modelo A", modelos.get(0).getDescricao());

        // Verifica se o método foi chamado
        verify(modeloRepository, times(1)).findAll();
    }

    @Test
    void listarPorId() {
        // Configura o comportamento do repositório
        when(modeloRepository.findById(1)).thenReturn(Optional.of(modelo));

        // Chama o método a ser testado
        var resultado = modeloService.listarPorId(1);

        // Verifica o resultado
        assertNotNull(resultado);
        assertEquals("Modelo A", resultado.getDescricao());

        // Verifica se o método foi chamado
        verify(modeloRepository, times(1)).findById(1);
    }

    @Test
    void criar() {
        // Configura o comportamento do repositório
        when(modeloRepository.save(any(Modelo.class))).thenReturn(modelo);

        // Chama o método a ser testado
        var novoModelo = modeloService.criar(modelo);

        // Verifica o resultado
        assertNotNull(novoModelo);
        assertEquals("Modelo A", novoModelo.getDescricao());

        // Verifica se o método foi chamado
        verify(modeloRepository, times(1)).save(modelo);
    }

    @Test
    void atualizar() {
        // Configura o comportamento do repositório
        when(modeloRepository.findById(1)).thenReturn(Optional.of(modelo));
        when(modeloRepository.save(any(Modelo.class))).thenReturn(modelo);

        // Chama o método a ser testado
        var modeloAtualizado = modeloService.atualizar(1, modelo);

        // Verifica o resultado
        assertNotNull(modeloAtualizado);
        assertEquals("Modelo A", modeloAtualizado.getDescricao());

        // Verifica se o método foi chamado
        verify(modeloRepository, times(1)).findById(1);
        verify(modeloRepository, times(1)).save(modelo);
    }

    @Test
    void excluir() {
        // Configura o comportamento do repositório
        when(modeloRepository.findById(1)).thenReturn(Optional.of(modelo));

        // Chama o método a ser testado
        modeloService.excluir(1);

        // Verifica se o método foi chamado
        verify(modeloRepository, times(1)).findById(1);
        verify(modeloRepository, times(1)).delete(modelo);
    }
}

