package edu.ifsc.rest_DTO_exemplo.controller;

import edu.ifsc.rest_DTO_exemplo.domain.Produto;
import edu.ifsc.rest_DTO_exemplo.repository.CategoriaRepository;
import edu.ifsc.rest_DTO_exemplo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todos os produtos
    @GetMapping
    public List<Produto> listar() {
        return produtoRepository.findAll();
    }

    // Buscar produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Integer id) {
        return produtoRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar um novo produto
    @PostMapping
    public Produto inserir(@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

    // Atualizar um produto existente
    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Integer id, @RequestBody Produto produtoAtualizado) {
        return produtoRepository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setDescricao(produtoAtualizado.getDescricao());
            produto.setPreco(produtoAtualizado.getPreco());
            produto.setCategoria(produtoAtualizado.getCategoria());
            Produto produtoSalvo = produtoRepository.save(produto);
            return ResponseEntity.ok(produtoSalvo);
        }).orElse(ResponseEntity.notFound().build());
    }

    // Deletar um produto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}

