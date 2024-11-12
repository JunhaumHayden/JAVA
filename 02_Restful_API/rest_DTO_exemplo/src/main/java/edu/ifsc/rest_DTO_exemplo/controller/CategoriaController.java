package edu.ifsc.rest_DTO_exemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsc.rest_DTO_exemplo.domain.Categoria;
import edu.ifsc.rest_DTO_exemplo.repository.CategoriaRepository;

@RestController
public class CategoriaController {
    // Anotation para o Spring instanciar um objeto CategoriaRepository automaticamente.
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Anotation para disponibilizar um endpoint
    @GetMapping("/categorias")
    public List<Categoria> listar(){
        return categoriaRepository.findAll();
    }

    @GetMapping ("/descricao/{id}")
    public Categoria buscar(@PathVariable int id){
        return categoriaRepository.findById(id).get();
    }
    @GetMapping("/categorias/descricao/{descricao}")
    public List<Categoria> pesquisar(@PathVariable String descricao){
        return categoriaRepository.findByDescricao(descricao);
    }

    @GetMapping("/categorias/contem/{descricao}")
    public List<Categoria> contendo(@PathVariable String descricao){
        return categoriaRepository.findByDescricaoContaining(descricao);
    }
    //metodo de envio post para criar um objeto.
    // a URI pode ser usada repetida pois é associada ao metodo Post
    @PostMapping("/categorias")
    public Categoria inserir(@RequestBody Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/categorias/{id}")
    public Categoria atualizar(@PathVariable Integer id,@RequestBody Categoria categoria){ //RequestBody indica que o parametro será retirado do Body da mensagem
        if(categoriaRepository.existsById(id)) {
            categoria.setId(id);
            return categoriaRepository.save(categoria);
        }
        return null;
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        if(!categoriaRepository.existsById(id)){
            return ResponseEntity.notFound().build(); //build para construir uma mensagem. Altera o codigo de retorno HPPT
        } else{
            categoriaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        
    }

}
