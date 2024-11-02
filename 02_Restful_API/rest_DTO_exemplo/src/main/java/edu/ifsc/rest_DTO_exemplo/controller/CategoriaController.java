package edu.ifsc.rest_DTO_exemplo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping ("/descricao")
    public Categoria descricao(int id){
        return categoriaRepository.findById(id).get();
    }
}
