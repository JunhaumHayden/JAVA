package edu.ifsc.ConfortAid;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import edu.ifsc.ConfortAid.domain.Agendamento;
import edu.ifsc.ConfortAid.domain.Cliente;
import edu.ifsc.ConfortAid.domain.Profissional;
import edu.ifsc.ConfortAid.service.AgendamentoService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

     /**
     *  
     * id: CT006
     * Reagendamento de Serviço
     * Descricao:
     *      Verificar a funcionalidade de reagendamento, permitindo que o cliente altere a data ou horário do agendamento.
     * Pre-condicao: 
     *      Agendamento prévio entre cliente e profissional.
     * Passos: 
     *      Cliente acessa o agendamento e escolhe a opção de reagendar.
     *      Seleciona nova data/hora disponível.
     *      Confirma a alteração.
     * Resultado esperado: 
     *      O agendamento é atualizado e ambos são notificados sobre a alteração.
     * 
     */
@SpringBootTest
@ActiveProfiles("test")
public class CT005ReagendamentoTest {

    private Cliente cliente = new Cliente(1, "Alice Silva", "alice.silva@gmail.com");
    private Profissional profissional = new Profissional(11, "Patrícia Lima", "Massoterapia");
    private LocalDateTime dataHora = LocalDateTime.now().plusDays(1); // Amanhã

     /**
     * Metodo para teste de reagendamento de datas passadas
     * Descricao:
     *      Tenta reagendar para uma data passada.
     * Resultado esperado: 
     *      O teste espera uma mensagem de erro de "Data inválida para reagendamento".
     * 
     */

     @Test
     public void testReagendamentoDataPassada() {
        AgendamentoService agendamentoService = new AgendamentoService();

        // Obter a data e hora atual
        LocalDateTime agora = LocalDateTime.now();
    
        // Configurar horários baseados na data atual
        String horarioPassado = agora.minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); // Ontem
    
        // Criar agendamento no horário original
        Agendamento agendamento = agendamentoService.agendarServico(this.cliente, this.profissional, this.dataHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    
        // Tentar reagendar para uma data passada
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoService.reagendarServico(agendamento, horarioPassado);
        });
    
        // Verificar mensagem de erro
        assertEquals("Não é possível reagendar para uma data que já passou.", exception.getMessage());
    }

     /**
     * Metodo para teste de reagendamento de Horario ocupado
     * Descricao:
     *      Simula um reagendamento para um horário já ocupado. Utilizamos uma classe anônima para sobrescrever o método isDisponivel e forçar a indisponibilidade do horário
     * Resultado esperado: 
     *      Esperando uma mensagem "Horário indisponível para reagendamento".
     * 
     */
    @Test
    public void testReagendamentoParaHorarioOcupado() {
        AgendamentoService agendamentoService = new AgendamentoService();

        Cliente cliente2 = new Cliente(2, "Ana Costa", "ana@example.com");

        String horarioOcupado = this.dataHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String horarioNovo = this.dataHora.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); // proximo dia

        agendamentoService.agendarServico(cliente, profissional, horarioOcupado);

        Agendamento agendamento2 = agendamentoService.agendarServico(cliente2, profissional, horarioNovo);

        // Tentar reagendar para horário já ocupado
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            agendamentoService.reagendarServico(agendamento2, horarioOcupado);
        });

        assertEquals("Horário já ocupado para esse profissional.", exception.getMessage());
    }

     /**
     * Metodo para teste de reagendamento com sucesso
     * Descricao:
     *      Realiza um reagendamento bem-sucedido para uma nova data e hora válida.
     * Resultado esperado: 
     *      Valida que o status do agendamento muda para "Reagendado" e que o horário foi atualizado corretamente.
     * 
     */

    @Test
    public void testReagendamentoBemSucedido() {
        AgendamentoService agendamentoService = new AgendamentoService();

        String horarioOriginal = this.dataHora.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        String novoHorario = this.dataHora.plusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")); // proximo dia

        Agendamento agendamento = agendamentoService.agendarServico(cliente, profissional, horarioOriginal);

        // Reagendar para novo horário
        agendamentoService.reagendarServico(agendamento, novoHorario);

        assertEquals("Reagendado", agendamento.getStatus());
        assertEquals(LocalDateTime.parse(novoHorario, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")), agendamento.getDataHora());
    }
}

