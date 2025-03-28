package edu.ifsc.fln.confortaid;

import edu.ifsc.fln.confortaid.controller.AvaliacaoController;
import edu.ifsc.fln.confortaid.model.Avaliacao;
import edu.ifsc.fln.confortaid.repository.AvaliacaoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AvaliacaoControllerTest {

    @Mock
    private AvaliacaoRepository avaliacaoRepository;

    @InjectMocks
    private AvaliacaoController avaliacaoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarTodos() {
        List<Avaliacao> avaliacoes = Collections.singletonList(new Avaliacao());
        when(avaliacaoRepository.findAll()).thenReturn(avaliacoes);

        List<Avaliacao> response = avaliacaoController.listarTodos();

        assertEquals(avaliacoes, response);
    }

    @Test
    void testBuscarPorId() {
        Avaliacao avaliacao = new Avaliacao();
        when(avaliacaoRepository.findById(1)).thenReturn(Optional.of(avaliacao));

        ResponseEntity<Avaliacao> response = avaliacaoController.buscarPorId(1);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(avaliacao, response.getBody());
    }

    @Test
    void testBuscarPorIdNotFound() {
        when(avaliacaoRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Avaliacao> response = avaliacaoController.buscarPorId(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCriar() {
        Avaliacao avaliacao = new Avaliacao();
        when(avaliacaoRepository.save(avaliacao)).thenReturn(avaliacao);

        ResponseEntity<Avaliacao> response = avaliacaoController.criar(avaliacao);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(avaliacao, response.getBody());
    }

    @Test
    void testAtualizar() {
        Avaliacao avaliacao = new Avaliacao();
        Avaliacao updatedAvaliacao = new Avaliacao();
        when(avaliacaoRepository.findById(1)).thenReturn(Optional.of(avaliacao));
        when(avaliacaoRepository.save(avaliacao)).thenReturn(updatedAvaliacao);

        ResponseEntity<Avaliacao> response = avaliacaoController.atualizar(1, updatedAvaliacao);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedAvaliacao, response.getBody());
    }

    @Test
    void testAtualizarNotFound() {
        Avaliacao updatedAvaliacao = new Avaliacao();
        when(avaliacaoRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Avaliacao> response = avaliacaoController.atualizar(1, updatedAvaliacao);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testExcluir() {
        Avaliacao avaliacao = new Avaliacao();
        when(avaliacaoRepository.findById(1)).thenReturn(Optional.of(avaliacao));
        doNothing().when(avaliacaoRepository).delete(avaliacao);

        ResponseEntity<Void> response = avaliacaoController.excluir(1);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        verify(avaliacaoRepository, times(1)).delete(avaliacao);
    }

    @Test
    void testExcluirNotFound() {
        when(avaliacaoRepository.findById(1)).thenReturn(Optional.empty());

        ResponseEntity<Void> response = avaliacaoController.excluir(1);

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
