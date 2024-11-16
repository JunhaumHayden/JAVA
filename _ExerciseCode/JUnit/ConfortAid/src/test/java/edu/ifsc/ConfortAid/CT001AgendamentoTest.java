package edu.ifsc.ConfortAid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.ifsc.ConfortAid.domain.Agendamento;
import edu.ifsc.ConfortAid.domain.Cliente;
import edu.ifsc.ConfortAid.domain.Profissional;
import edu.ifsc.ConfortAid.service.AgendamentoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    /**
     * id: CT001
     * Agendamento de Serviço
     * Descricao:
     *      Testar a criação de um agendamento entre cliente e profissional.
     * Pre-condicao: 
     *      Cliente e profissional logados no sistema.
     * Passos: 
     *      Cliente acessa o perfil do profissional.
     *      Escolhe a data e horário para o atendimento.
     *      Confirma o agendamento.
     * Resultado esperado: 
     *      Agendamento registrado e notificação enviada ao profissional.
     * 
     * @author Carlos Hayden
     */
@SpringBootTest
public class CT001AgendamentoTest {
    private Cliente cliente = new Cliente(1, "Alice Silva", "alice.silva@gmail.com");
    private Profissional profissional = new Profissional(11, "Patrícia Lima", "Massoterapia");
    private String stringDataHora = "2024-11-10 10:00";
    private LocalDateTime dataHora = LocalDateTime.parse(this.stringDataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    @Test
    public void testAgendamentoBemSucedidoClassAgendamento(){    
        Agendamento agendamento = new Agendamento(this.cliente, this.profissional, this.dataHora);

        agendamento.setStatusConfirmar();
        System.out.println(agendamento.getStatus()); // "Confirmado"

        agendamento.setStatusCancelar();
        System.out.println(agendamento.getStatus()); // "Cancelado"

        assertNotNull(agendamento, "O agendamento não deveria ser nulo");
        assertEquals(this.cliente, agendamento.getCliente(), "O cliente do agendamento está incorreto");
        assertEquals(this.profissional, agendamento.getProfissional(), "O profissional do agendamento está incorreto");
        assertEquals(this.dataHora, agendamento.getDataHora(), "A data e hora do agendamento estão incorretas");
        assertEquals("Pendente", agendamento.getStatus(), "O status inicial do agendamento deveria ser 'Pendente'");

    }
    @Test
    public void testAgendamentoBemSucedido() {
        AgendamentoService agendamentoService = new AgendamentoService();
        Agendamento agendamento = agendamentoService.agendarServico(this.cliente, this.profissional, this.stringDataHora);

        assertNotNull(agendamento, "O agendamento não deveria ser nulo");
        assertEquals(this.cliente, agendamento.getCliente(), "O cliente do agendamento está incorreto");
        assertEquals(this.profissional, agendamento.getProfissional(), "O profissional do agendamento está incorreto");
        assertEquals(this.dataHora, agendamento.getDataHora(), "A data e hora do agendamento estão incorretas");
        assertEquals("Pendente", agendamento.getStatus(), "O status inicial do agendamento deveria ser 'Pendente'");
    }
}

