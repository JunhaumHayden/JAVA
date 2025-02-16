package edu.ifsc.fln.confortaid.service;

import edu.ifsc.fln.confortaid.model.Agendamento;
import edu.ifsc.fln.confortaid.model.Cliente;
import edu.ifsc.fln.confortaid.model.Profissional;
import edu.ifsc.fln.confortaid.model.Servico;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Service
public class AgendamentoService {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Agendamento agendar(Cliente cliente, Servico servico, String horario) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime horarioDateTime = LocalDateTime.parse(horario, formatter);

        validarHorario(horarioDateTime);

        if (verificarHorarioOcupado(servico.getProfissional(), horarioDateTime)) {
            throw new IllegalArgumentException("Horário já ocupado pelo profissional.");
        }

        Agendamento agendamento = new Agendamento();
        agendamento.setCliente(cliente);
        agendamento.setServico(servico);
        agendamento.setDataHora(horarioDateTime);
        agendamento.setStatus(Agendamento.Status.PENDENTE);

        entityManager.persist(agendamento);
        return agendamento;
    }

    @Transactional
    public Agendamento reagendar(Agendamento agendamento, String novoHorario) {
        validarStatusParaReagendamento(agendamento);

        LocalDateTime novoHorarioDateTime = LocalDateTime.parse(novoHorario, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));

        validarHorario(novoHorarioDateTime);

        if (verificarHorarioOcupado(agendamento.getServico().getProfissional(), novoHorarioDateTime)) {
            throw new IllegalArgumentException("Horário já ocupado para esse profissional.");
        }

        agendamento.setDataHora(novoHorarioDateTime);
        agendamento.setStatus(Agendamento.Status.PENDENTE);

        entityManager.merge(agendamento);
        return agendamento;
    }

    @Transactional
    public void cancelarAgendamento(Agendamento agendamento) {
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento não pode ser nulo.");
        }

        if (Objects.equals(agendamento.getStatus(), Agendamento.Status.CANCELADO)) {
                    throw new IllegalArgumentException("Agendamento já está cancelado.");
                }

        agendamento.setStatus(Agendamento.Status.CANCELADO);
        entityManager.merge(agendamento);
    }

    @Transactional
    public void alterarStatus(Agendamento agendamento, Agendamento.Status novoStatus) {
        if (agendamento == null) {
            throw new IllegalArgumentException("Agendamento não pode ser nulo.");
        }

        if (Objects.equals(agendamento.getStatus(), Agendamento.Status.CANCELADO)) {
                    throw new IllegalArgumentException("Não é possível alterar o status de um agendamento cancelado.");
                }

        agendamento.setStatus(novoStatus);
        entityManager.merge(agendamento);
    }


    private boolean verificarHorarioOcupado(Profissional profissional, LocalDateTime horario) {
        List<Agendamento> agendamentos = entityManager.createQuery(
                        "SELECT a FROM Agendamento a WHERE a.servico.profissional = :profissional AND a.dataHora = :horario", Agendamento.class)
                .setParameter("profissional", profissional)
                .setParameter("horario", horario)
                .getResultList();

        return !agendamentos.isEmpty();
    }

    private void validarHorario(LocalDateTime horarioDateTime) {
        if (horarioDateTime.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Não é possível agendar para uma data que já passou.");
        }

        int hora = horarioDateTime.getHour();
        if (hora < 8 || hora > 20) {
            throw new IllegalArgumentException("Horário fora do período de atendimento.");
        }
    }

    private void validarStatusParaReagendamento(Agendamento agendamento) {
        if (agendamento == null) {
            throw new IllegalArgumentException("O objeto Agendamento não pode ser nulo.");
        }

        if (Objects.equals(agendamento.getStatus(), Agendamento.Status.CANCELADO)) {
            throw new IllegalArgumentException("Não é possível reagendar um agendamento cancelado.");
        }
    }
}



