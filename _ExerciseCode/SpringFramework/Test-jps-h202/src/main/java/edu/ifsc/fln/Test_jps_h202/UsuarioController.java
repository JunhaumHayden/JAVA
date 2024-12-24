package edu.ifsc.fln.Test_jps_h202;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
