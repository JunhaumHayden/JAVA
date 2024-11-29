package edu.ifsc.lavacao_api.controller;

import edu.ifsc.lavacao_api.model.veiculos.Modelo;
import edu.ifsc.lavacao_api.service.ModeloService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    private final ModeloService modeloService;

    public ModeloController(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping
    public ResponseEntity<List<Modelo>> listarTodos() {
        List<Modelo> modelos = modeloService.listarTodos();
        return ResponseEntity.ok(modelos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Modelo> listarPorId(@PathVariable int id) {
        Modelo modelo = modeloService.listarPorId(id);
        return ResponseEntity.ok(modelo);
    }

    @PostMapping
    public ResponseEntity<Modelo> criar(@RequestBody Modelo modelo) {
        Modelo novoModelo = modeloService.criar(modelo);
        return ResponseEntity.status(201).body(novoModelo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Modelo> atualizar(@PathVariable int id, @RequestBody Modelo modelo) {
        Modelo modeloAtualizado = modeloService.atualizar(id, modelo);
        return ResponseEntity.ok(modeloAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id) {
        modeloService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}

