package edu.ifsc.fln.confortaid.controller;

import edu.ifsc.fln.confortaid.model.Agendamento;
import edu.ifsc.fln.confortaid.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @GetMapping
    public List<Agendamento> listarTodos() {
        return agendamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable Integer id) {
        return agendamentoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Agendamento criar(@RequestBody Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(@PathVariable Integer id, @RequestBody Agendamento agendamentoAtualizado) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamento.setDataHora(agendamentoAtualizado.getDataHora());
                    agendamento.setServico(agendamentoAtualizado.getServico());
                    return ResponseEntity.ok(agendamentoRepository.save(agendamento));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Integer id) {
        return agendamentoRepository.findById(id)
                .map(agendamento -> {
                    agendamentoRepository.delete(agendamento);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
