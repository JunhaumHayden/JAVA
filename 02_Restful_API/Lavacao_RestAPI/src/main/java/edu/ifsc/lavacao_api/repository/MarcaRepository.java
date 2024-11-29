package edu.ifsc.lavacao_api.repository;

import edu.ifsc.lavacao_api.model.veiculos.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MarcaRepository extends JpaRepository<Marca, Integer> { //// O objeto tratado pelo framework e o tipo de dado de referencia para a chave primaria desse objeto.
    List<Marca> findByNome(String nome);
    List<Marca> findByNomeContaining(String nome);

    void deleteById(int id);


}
