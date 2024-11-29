package edu.ifsc.lavacao_api.service;

import edu.ifsc.lavacao_api.model.veiculos.Modelo;
import edu.ifsc.lavacao_api.repository.ModeloRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModeloService {

    private final ModeloRepository modeloRepository;

    public ModeloService(ModeloRepository modeloRepository) {
        this.modeloRepository = modeloRepository;
    }

    public List<Modelo> listarTodos() {
        return modeloRepository.findAll();
    }

    public Modelo listarPorId(int id) {
        return modeloRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Modelo não encontrado com ID: " + id));
    }

    public Modelo criar(Modelo modelo) {
        return modeloRepository.save(modelo);
    }

    public Modelo atualizar(int id, Modelo modeloAtualizado) {
        Modelo modeloExistente = listarPorId(id);
        modeloExistente.setDescricao(modeloAtualizado.getDescricao());
        modeloExistente.setMarca(modeloAtualizado.getMarca());
        modeloExistente.setMotor(modeloAtualizado.getMotor());
        modeloExistente.setCategoria(modeloAtualizado.getCategoria());
        return modeloRepository.save(modeloExistente);
    }

    public void excluir(int id) {
        Modelo modelo = listarPorId(id);
        modeloRepository.delete(modelo);
    }
}

