package edu.ifsc.ConfortAid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import edu.ifsc.ConfortAid.domain.Cliente;
import edu.ifsc.ConfortAid.domain.Profissional;
import edu.ifsc.ConfortAid.service.AgendamentoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


    /**
     * ID CT004
     * Agendamento para Horário Já Ocupado
     * Descricao: 
     *      Testar se o sistema bloqueia a criação de agendamento em horário onde o profissional já tem compromisso.
     * Pre-condicao:
     *      Cliente e profissional logados e profissional com agendamento já existente no horário.
     * Passos:
     *      Cliente tenta agendar um atendimento para um horário já ocupado pelo profissional.
     * Resultado esperado: 
     *      O sistema impede o agendamento e exibe uma mensagem de alerta sobre o horário indisponível.
     * 
     */
@SpringBootTest
@ActiveProfiles("test")
public class CT004HorarioOcupadoTest {



    @Test
    public void testAgendamentoHorarioOcupado() {
        AgendamentoService agendamentoService = new AgendamentoService();

        Cliente cliente1 = new Cliente(1, "João Silva", "joao@example.com");
        Cliente cliente2 = new Cliente(2, "Ana Costa", "ana@example.com");
        Profissional profissional = new Profissional(1, "Maria Oliveira", "massagem");
        String horario = "2024-11-07 10:00";

        // Primeiro agendamento bem-sucedido
        agendamentoService.agendarServico(cliente1, profissional, horario);

        // Tentativa de agendamento no mesmo horário
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoService.agendarServico(cliente2, profissional, horario);
        });

        assertEquals("Horário já ocupado pelo profissional.", exception.getMessage());
    }
}
