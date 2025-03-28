package edu.ifsc.fln.confortaid;

import edu.ifsc.fln.confortaid.controller.AgendamentoController;
import edu.ifsc.fln.confortaid.model.Agendamento;
import edu.ifsc.fln.confortaid.service.AgendamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AgendamentoControllerTest {

    @Mock
    private AgendamentoService agendamentoService;

    @InjectMocks
    private AgendamentoController agendamentoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    void testGetAllAgendamentos() {
//        List<Agendamento> agendamentos = Collections.singletonList(new Agendamento());
//        when(agendamentoService.getAllAgendamentos()).thenReturn(agendamentos);
//
//        ResponseEntity<List<Agendamento>> response = agendamentoController.agendamentoRepository.findAll();
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(agendamentos, response.getBody());
//    }
//
//    @Test
//    void testGetAllAgendamentos() {
//        List<Agendamento> agendamentos = Collections.singletonList(new Agendamento());
//        when(agendamentoService.getAllAgendamentos()).thenReturn(agendamentos);
//
//        ResponseEntity<List<Agendamento>> response = agendamentoController.getAllAgendamentos();
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(agendamentos, response.getBody());
//    }
//
//    @Test
//    void testCreateAgendamento() {
//        Agendamento agendamento = new Agendamento();
//        when(agendamentoService.createAgendamento(any(Agendamento.class))).thenReturn(agendamento);
//
//        ResponseEntity<Agendamento> response = agendamentoController.createAgendamento(agendamento);
//
//        assertEquals(201, response.getStatusCodeValue());
//        assertEquals(agendamento, response.getBody());
//    }
//
//    @Test
//    void testDeleteAgendamento() {
//        Long id = 1L;
//        doNothing().when(agendamentoService).deleteAgendamento(id);
//
//        ResponseEntity<Void> response = agendamentoController.deleteAgendamento(id);
//
//        assertEquals(204, response.getStatusCodeValue());
//        verify(agendamentoService, times(1)).deleteAgendamento(id);
//    }
}
