package edu.ifsc.ConfortAid.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import edu.ifsc.ConfortAid.domain.Agendamento;
import edu.ifsc.ConfortAid.domain.Cliente;
import edu.ifsc.ConfortAid.domain.Profissional;

public class AgendamentoService {
    private List<Agendamento> agendamentos;

    public AgendamentoService() {
        this.agendamentos = new ArrayList<>();
    }

    public AgendamentoService(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }

    /**
     * Método para agendar um serviço.
     * 
     * @param cliente       O cliente solicitante.
     * @param profissional  O profissional que realizará o serviço.
     * @param horario       Data e horário do agendamento no formato "yyyy-MM-dd HH:mm".
     * @return O objeto Agendamento criado.
     */
    public Agendamento agendarServico(Cliente cliente, Profissional profissional, String horario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime horarioDateTime = LocalDateTime.parse(horario, formatter);

        // Verificar se a data já passou
        if (horarioDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível agendar para uma data que já passou.");
        }

        // Verificar se o horário está fora do período de atendimento (ex.: 8h às 20h)
        int hora = horarioDateTime.getHour();
        if (hora < 8 || hora > 20) {
            throw new IllegalArgumentException("Horário fora do período de atendimento.");
        }

        // Verificar conflitos de horário
        if (verificarHorarioOcupado(profissional, horarioDateTime)) {
            throw new IllegalArgumentException("Horário já ocupado pelo profissional.");
        }

        // Criar e salvar o agendamento
        Agendamento agendamento = new Agendamento(cliente, profissional, horarioDateTime);
        agendamentos.add(agendamento);

        return agendamento;
    }

    /**
     * Método para reagendar um serviço.
     * 
     * @param agendamento Objeto Agendamento existente.
     * @param novoHorario String Novo horário no formato "yyyy-MM-dd HH:mm".
     * @return O objeto Agendamento atualizado.
     */
    public Agendamento reagendarServico(Agendamento agendamento, String novoHorario) {
        if (agendamento == null) {
            throw new IllegalArgumentException("O objeto Agendamento não pode ser nulo.");
        }

        LocalDateTime novoHorarioDateTime = LocalDateTime.parse(novoHorario, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        // Verificar se a nova data já passou
        if (novoHorarioDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível reagendar para uma data que já passou.");
        }

        // Verificar se o horário está fora do período de atendimento
        int hora = novoHorarioDateTime.getHour();
        if (hora < 8 || hora > 20) {
            throw new IllegalArgumentException("Horário fora do período de atendimento.");
        }

        // Verificar conflitos de horário
        if (verificarHorarioOcupado(agendamento.getProfissional(), novoHorarioDateTime)) {
            throw new IllegalArgumentException("Horário já ocupado para esse profissional.");
        }

        // Atualizar o horário do agendamento
        agendamento.setDataHora(novoHorarioDateTime);
        agendamento.setStatusReagendado();

        return agendamento;
    }

    /**
     * Método para cancelar um agendamento.
     * 
     * @param agendamento Objeto do tipo Agendamento a ser cancelado.
     */
    public void cancelarAgendamento(Agendamento agendamento) {
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento não pode ser nulo.");
        }

        // Verifica se o agendamento existe na lista
        boolean removido = agendamentos.removeIf(a -> a.equals(agendamento)); // método removeIf para verificar a igualdade de objetos diretamente na lista de agendamentos.
        agendamento.setStatusCancelar();

        if (!removido) {
            throw new IllegalArgumentException("Agendamento não encontrado.");
        }
    }
       

    /**
     * Verifica se um horário está ocupado para um determinado profissional.
     * 
     * @param profissional O profissional.
     * @param horario       O horário no formato "yyyy-MM-dd HH:mm".
     * @return true se o horário estiver ocupado, false caso contrário.
     */
    private boolean verificarHorarioOcupado(Profissional profissional, LocalDateTime horario) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getProfissional().getId() == profissional.getId() &&
                agendamento.getDataHora().equals(horario)) {
                return true;
            }
        }
        return false;
    }
}


