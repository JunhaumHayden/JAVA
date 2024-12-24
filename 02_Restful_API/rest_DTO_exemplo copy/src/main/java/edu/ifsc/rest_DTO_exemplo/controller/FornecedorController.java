package edu.ifsc.rest_DTO_exemplo.controller;

import edu.ifsc.rest_DTO_exemplo.domain.Categoria;
import edu.ifsc.rest_DTO_exemplo.domain.Fornecedor;
import edu.ifsc.rest_DTO_exemplo.domain.Fornecedor;
import edu.ifsc.rest_DTO_exemplo.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorRepository fornecedorRepository;
    @GetMapping
    public List<Fornecedor> listar() {
        return fornecedorRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> pesquisar(@PathVariable Integer id) {
        return fornecedorRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Para retornar o codigo http 
    public Fornecedor inserir(@RequestBody Fornecedor fornecedor) {
        fornecedor = fornecedorRepository.save(fornecedor);
        return fornecedor;
    }
//------------------------------------->
    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Integer id,@RequestBody Fornecedor fornecedor){ //RequestBody indica que o parametro será retirado do Body da mensagem
        //if(fornecedorRepository.existsById(id)) { //Deixando assim sempre retorna 200 para a chamada http mesmo se atualizar um id que não existe.
        if(!fornecedorRepository.existsById(id)) { //Se não existir
            return ResponseEntity.notFound().build(); //retorna not found
        }else {
            fornecedor.setId(id);
            return ResponseEntity.ok(fornecedorRepository.save(fornecedor));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        if(!fornecedorRepository.existsById(id)){
            return ResponseEntity.notFound().build(); //build para construir uma mensagem. Altera o codigo de retorno HPPT
        } else{
            fornecedorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }
}
