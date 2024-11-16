package edu.ifsc.rest_DTO_exemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsc.rest_DTO_exemplo.domain.Categoria;
import edu.ifsc.rest_DTO_exemplo.domain.Produto;
import edu.ifsc.rest_DTO_exemplo.dto.ProdutoDTO;
import edu.ifsc.rest_DTO_exemplo.repository.CategoriaRepository;
import edu.ifsc.rest_DTO_exemplo.repository.ProdutoRepository;

/**
 * Terceiro criar a classe que controlará o acesso a classe do dominio do problema
 */
@RequestMapping("/produtos") //para mapear uma URI padrao
@RestController
public class ProdutoController {
    
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    /**
     * Este metodo não contem uma resposta adequada a chamada http
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Produto buscar(@PathVariable int id){
        return produtoRepository.findById(id).get();
    }
    /**
     * Este metodo contem uma resposta adequada para a requisiçao http
     * @param id
     * @return
     */
    @GetMapping("/buscar/{id}")
    public ResponseEntity<ProdutoDTO> buscarOtimizado(@PathVariable int id){
        return produtoRepository.findById(id)
            .map(produto -> {
                var produtoDTO = new ProdutoDTO();
                produtoDTO.setId(produto.getId());
                produtoDTO.setNome(produto.getNome());
                produtoDTO.setDescricaoProduto(produto.getDescricao());
                produtoDTO.setDescricaoCategoria(produto.getCategoria().getDescricao());
                return produtoDTO;
            })
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build()); //o metodo orElse é executado caso diferente de ok no metodo map(). Este é responsavel por alterar a mensagem de retorno de 500 para 404 na requisiçao.
    }

    /**
     * Este metodo insere e retorna o objeto
     * @param produto
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Para alterar o retorno da chamada http de 200 para 201
    public Produto inserir(@RequestBody Produto produto){
        // return produtoRepository.save(produto); // executa um retorno lazy
        produto = produtoRepository.save(produto);
        Optional<Categoria> categoria = categoriaRepository.findById(produto.getCategoria().getId());
        produto.setCategoria(categoria.get());
        return produto;
    }

    @PutMapping("/{id}")
    // public Produto atualizar ////Deixando assim sempre retorna 200 para a chamada http mesmo se atualizar um id que não existe.
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id,@RequestBody Produto produto){ //RequestBody indica que o parametro será retirado do Body da mensagem
        //if(produtoRepository.existsById(id)) { //Deixando assim sempre retorna 200 para a chamada http mesmo se atualizar um id que não existe.
        if(!produtoRepository.existsById(id)) { //Se não existir
            return ResponseEntity.notFound().build(); //retorna not found
        }else {
            produto.setId(id);
            return ResponseEntity.ok(produtoRepository.save(produto));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        if(!produtoRepository.existsById(id)){
            return ResponseEntity.notFound().build(); //build para construir uma mensagem. Altera o codigo de retorno HPPT
        } else{
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        
    }

}
