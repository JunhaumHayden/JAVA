package edu.ifsc.ConfortAid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ifsc.ConfortAid.domain.Agendamento;
import edu.ifsc.ConfortAid.domain.Cliente;
import edu.ifsc.ConfortAid.domain.Profissional;
import edu.ifsc.ConfortAid.service.AgendamentoService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
public class CT002CancelamentoTest {
    @Test
    public void testCancelarAgendamento() {

        AgendamentoService agendamentoService = new AgendamentoService();
        Cliente cliente = new Cliente(1, "Alice Silva", "alice.silva@gmail.com");
        Profissional profissional = new Profissional(11, "Patrícia Lima", "Massoterapia");

        // Ajustar a hora para 10:00
        LocalDateTime dataHoraAjustada = LocalDateTime.now().plusDays(1).withHour(10).withMinute(0); // Amanhã

        // Formatar a data/hora ajustada
        String dataHoraHorarioAtendimento = dataHoraAjustada.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        
        // Criando um agendamento
        Agendamento agendamento = agendamentoService.agendarServico(cliente, profissional, dataHoraHorarioAtendimento);

        // Cancelando o agendamento
        agendamentoService.cancelarAgendamento(agendamento);

        assertEquals("Cancelado", agendamento.getStatus(), "O status do agendamento deveria ser 'Cancelado'");
    }

}
