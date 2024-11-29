package edu.ifsc.lavacao_api.controller;

import java.util.List;
import java.util.Optional;

import edu.ifsc.lavacao_api.model.veiculos.Marca;
import edu.ifsc.lavacao_api.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MarcaController {
    // Anotation para o Spring instanciar um objeto MarcaRepository automaticamente.
    @Autowired
    private MarcaRepository marcaRepository;

    // Anotation para disponibilizar um endpoint
    @GetMapping("/marcas")
    public List<Marca> listar(){
        return marcaRepository.findAll();
    }

    @GetMapping ("/nome/{id}")
    public Marca buscar(@PathVariable int id){
        return marcaRepository.findById(id).get();
    }
    @GetMapping("/marcas/nome/{nome}")
    public List<Marca> pesquisar(@PathVariable String nome){
        return marcaRepository.findByNome(nome);
    }

    @GetMapping("/marcas/contem/{nome}")
    public List<Marca> contendo(@PathVariable String nome){
        return marcaRepository.findByNomeContaining(nome);
    }
    //metodo de envio post para criar um objeto.
    // a URI pode ser usada repetida pois é associada ao metodo Post
    @PostMapping("/marcas")
    public Marca inserir(@RequestBody Marca marca){
        return marcaRepository.save(marca);
    }

    @PutMapping("/marcas/{id}")
    public Marca atualizar(@PathVariable Integer id,@RequestBody Marca marca){ //RequestBody indica que o parametro será retirado do Body da mensagem
        if(marcaRepository.existsById(id)) {
            marca.setId(id);
            return marcaRepository.save(marca);
        }
        return null;
    }

    @DeleteMapping("/marcas/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id){
        if(!marcaRepository.existsById(id)){
            return ResponseEntity.notFound().build(); //build para construir uma mensagem. Altera o codigo de retorno HPPT
        } else{
            marcaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }

    }

}

