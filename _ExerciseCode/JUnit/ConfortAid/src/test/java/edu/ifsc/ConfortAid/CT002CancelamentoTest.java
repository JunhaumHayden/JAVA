package edu.ifsc.ConfortAid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import edu.ifsc.ConfortAid.domain.Agendamento;
import edu.ifsc.ConfortAid.domain.Cliente;
import edu.ifsc.ConfortAid.domain.Profissional;
import edu.ifsc.ConfortAid.service.AgendamentoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
    /**
     * id: CT002
     * Cancelamento de Agendamento
     * Descricao:
     *      Verificar a possibilidade de cancelamento de um agendamento.
     * Pre-condicao: 
     *      Agendamento existente entre cliente e profissional.
     * Passos: 
     *      Cliente acessa o agendamento.
     *      Clica em “Cancelar”.
     * Resultado esperado: 
     *      Agendamento é removido e ambas as partes são notificadas.
     * 
     * @author Carlos Hayden
     */
@SpringBootTest
@ActiveProfiles("test")
public class CT002CancelamentoTest {
    @Test
    public void testCancelarAgendamento() {

        AgendamentoService agendamentoService = new AgendamentoService();
        Cliente cliente = new Cliente(1, "Alice Silva", "alice.silva@gmail.com");
        Profissional profissional = new Profissional(11, "Patrícia Lima", "Massoterapia");

        String stringDataHora = "2024-11-10 10:00";

        // Criando um agendamento
        Agendamento agendamento = agendamentoService.agendarServico(cliente, profissional, stringDataHora);

        // Cancelando o agendamento
        agendamentoService.cancelarAgendamento(agendamento);

        assertEquals("Cancelado", agendamento.getStatus(), "O status do agendamento deveria ser 'Cancelado'");
    }

}
