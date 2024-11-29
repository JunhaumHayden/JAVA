package edu.ifsc.lavacao_api.service;

import edu.ifsc.lavacao_api.model.veiculos.Marca;
import edu.ifsc.lavacao_api.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;

    public List<Marca> listarTodas() {
        return marcaRepository.findAll();
    }

    public Optional<Marca> buscarPorId(int id) {
        return marcaRepository.findById(id);
    }

    public Marca criarMarca(Marca marca) {
        // Verificar duplicidade
        if (marcaRepository.findByNome(marca.getNome()) != null) {
            throw new IllegalArgumentException("Já existe uma marca com esse nome.");
        }
        return marcaRepository.save(marca);
    }

    public Marca atualizarMarca(int id, Marca novaMarca) {
        return marcaRepository.findById(id).map(marca -> {
            marca.setNome(novaMarca.getNome());
            return marcaRepository.save(marca);
        }).orElseThrow(() -> new RuntimeException("Marca não encontrada"));
    }

    public void excluirMarca(int id) {
        marcaRepository.deleteById(id);
    }
}

