package edu.ifsc.ConfortAid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import edu.ifsc.ConfortAid.domain.Agendamento;
import edu.ifsc.ConfortAid.domain.Cliente;
import edu.ifsc.ConfortAid.domain.Profissional;
import edu.ifsc.ConfortAid.service.AgendamentoService;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
     * id: CT003
     * Agendamento com Data/Hora invalida
     * Descricao:
     *      Verificar se o sistema rejeita uma tentativa de agendamento com data ou hora inválida (passada ou fora do horário de atendimento).
     * Pre-condicao: 
     *      Cliente e profissional logados no sistema.
     * Passos: 
     *      Cliente acessa o perfil do profissional.
     *      Seleciona uma data/hora no passado ou fora do horário disponível.
     *      Tenta confirmar o agendamento.
     * Resultado esperado: 
     *      O sistema exibe uma mensagem de erro indicando que o horário selecionado não é válido.
     * 
     */
@SpringBootTest
@ActiveProfiles("test")
public class CT003DataHoraInvalidaTest {
    private Cliente cliente = new Cliente(1, "Alice Silva", "alice.silva@gmail.com");
    private Profissional profissional = new Profissional(11, "Patrícia Lima", "Massoterapia");
    private String stringDataHora = "2024-10-01 09:00"; // Data passada
    private LocalDateTime dataHora = LocalDateTime.parse(this.stringDataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

    /**
     * Testa se o sistema rejeita um agendamento com uma data e horário que já passou.
     * Espera que o método agendarServico lance uma exceção com a mensagem "Não é possível agendar para uma data que já passou.".
     */
    @Test
    public void testAgendamentoDataPassada() {
        AgendamentoService agendamentoService = new AgendamentoService();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoService.agendarServico(this.cliente, this.profissional, this.stringDataHora);
        });

        assertEquals("Não é possível agendar para uma data que já passou.", exception.getMessage());
    }

    /**
     * Verifica se o sistema rejeita um agendamento fora do horário permitido (ex.: entre 8h e 20h).
     * Espera que o método agendarServico lance uma exceção com a mensagem "Horário fora do período de atendimento.".
     */
    @Test
    public void testAgendamentoForaDoHorarioAtendimento() {
        AgendamentoService agendamentoService = new AgendamentoService();

        Cliente cliente = new Cliente(1, "João Silva", "joao@example.com");
        Profissional profissional = new Profissional(1, "Maria Oliveira", "massagem");
        this.stringDataHora = "2024-11-07 22:00"; // Fora do horário de atendimento (exemplo: 8h às 20h)

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoService.agendarServico(cliente, profissional, this.stringDataHora);
        });

        assertEquals("Horário fora do período de atendimento.", exception.getMessage());
    }

    /**
     * Testa um cenário válido para garantir que o sistema aceita um agendamento dentro do horário permitido.
     * Verifica se o objeto Agendamento foi criado corretamente.
     */
    @Test
    public void testAgendamentoHorarioValido() {
        AgendamentoService agendamentoService = new AgendamentoService();

        Cliente cliente = new Cliente(1, "João Silva", "joao@example.com");
        Profissional profissional = new Profissional(1, "Maria Oliveira", "massagem");
        this.stringDataHora = "2024-11-07 10:00"; // Dentro do horário de atendimento
        this.dataHora = LocalDateTime.parse(this.stringDataHora, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        Agendamento agendamento = agendamentoService.agendarServico(cliente, profissional, stringDataHora);

        assertNotNull(agendamento);
        assertEquals(this.dataHora, agendamento.getDataHora());
    }
}


