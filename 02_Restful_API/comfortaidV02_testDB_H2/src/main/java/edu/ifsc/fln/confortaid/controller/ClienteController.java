package edu.ifsc.fln.confortaid.controller;

import edu.ifsc.fln.confortaid.model.Cliente;
import edu.ifsc.fln.confortaid.model.ClienteDTO;
import edu.ifsc.fln.confortaid.model.Profissional;
import edu.ifsc.fln.confortaid.model.ProfissionalDTO;
import edu.ifsc.fln.confortaid.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<ClienteDTO> criar(@RequestBody Cliente cliente) {
        Cliente novoCliente = clienteRepository.save(cliente);
        ClienteDTO clienteDTO = convertToDTO(novoCliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizar(@PathVariable Integer id, @RequestBody Cliente clienteAtualizado) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    cliente.setNome(clienteAtualizado.getNome());
                    cliente.setEmail(clienteAtualizado.getEmail());
                    cliente.setCpf(clienteAtualizado.getCpf());
                    cliente.setTelefone(clienteAtualizado.getTelefone());
                    cliente.setCep(clienteAtualizado.getCep());
                    cliente.setNascimento(clienteAtualizado.getNascimento());
                    cliente.setNumeroEndereco(clienteAtualizado.getNumeroEndereco());
                    cliente.setComplementoEndereco(clienteAtualizado.getComplementoEndereco());
                    Cliente atualizado = clienteRepository.save(cliente);
                    return ResponseEntity.ok(convertToDTO(atualizado));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluir(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> {
                    clienteRepository.delete(cliente);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/dto")
    public List<ClienteDTO> listarDTO() {
        return clienteRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<ClienteDTO> buscarPorIdDTO(@PathVariable Integer id) {
        return clienteRepository.findById(id)
                .map(cliente -> ResponseEntity.ok(convertToDTO(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    private ClienteDTO convertToDTO(Cliente cliente) {
        return new ClienteDTO(
                cliente.getId(),
                cliente.getNome(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getCep(),
                cliente.getNumeroEndereco(),
                cliente.getComplementoEndereco(),
                cliente.getCpf(),
                cliente.getNascimento()
        );
    }
}

