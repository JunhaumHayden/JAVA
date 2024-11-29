package edu.ifsc.livro_api.controller;

import edu.ifsc.livro_api.datasource.LivroDataSource;
import edu.ifsc.livro_api.domain.Livro;
import edu.ifsc.livro_api.dto.LivroDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroDataSource livroDataSource;

//    // Inicializar lista com dados mock
//    @PostMapping("/iniciar")
//    public ResponseEntity<Void> criarLista() {
//        livroDataSource.criarLista();
//        return ResponseEntity.ok().build();
//    }

    // Adicionar um livro
    @PostMapping
    public ResponseEntity<Livro> adicionar(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroDataSource.adicionar(livro));
    }

    // Retornar todos os livros
    @GetMapping
    public ResponseEntity<List<Livro>> getAll() {
        return ResponseEntity.ok(livroDataSource.getAll());
    }

    // Retornar livro por ISBN
    @GetMapping("/isbn/{isbn}")
    public ResponseEntity<Optional<Livro>> getPorIsbn(@PathVariable int isbn) {
        return ResponseEntity.ok(livroDataSource.getPorIsbn(isbn));
    }

    // Retornar livros por autor
    @GetMapping("/autor/{autor}")
    public ResponseEntity<List<Livro>> getPorAutor(@PathVariable String autor) {
        return ResponseEntity.ok(livroDataSource.getPorAutor(autor));
    }

    // Retornar livro por título
    @GetMapping("/titulo/{titulo}")
    public ResponseEntity<Optional<Livro>> getPorTitulo(@PathVariable String titulo) {
        return ResponseEntity.ok(livroDataSource.getPorTitulo(titulo));
    }

    // Retornar DTO por ISBN
    @GetMapping("/isbn/{isbn}/dto")
    public ResponseEntity<LivroDTO> getPorIsbnDTO(@PathVariable int isbn) {
        return ResponseEntity.ok(livroDataSource.getPorIsbnDTO(isbn));
    }

    // Retornar todos os livros como DTOs
    @GetMapping("/dto")
    public ResponseEntity<List<LivroDTO>> getAllDTO() {
        return ResponseEntity.ok(livroDataSource.getAllDTO());
    }

    // Reajustar preço de um livro pelo ID
    @PutMapping("/{id}/reajustar/{taxa}")
    public ResponseEntity<Void> reajustarPrecoPorId(@PathVariable int id, @PathVariable int taxa) {
        livroDataSource.reajustarPrecoPorId(id, taxa);
        return ResponseEntity.ok().build();
    }

    // Reajustar preço de todos os livros
    @PutMapping("/reajustar/{taxa}")
    public ResponseEntity<Void> reajustarPreco(@PathVariable int taxa) {
        livroDataSource.reajustarPreco(taxa);
        return ResponseEntity.ok().build();
    }
}

