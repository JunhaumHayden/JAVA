package edu.ifsc.rest_DTO_exemplo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifsc.rest_DTO_exemplo.domain.Categoria;
// Classe que será responsavel pela interaçao com o banco de dados.
// Gera uma interface com os objetos 
// JpaRepository é a interface com os metodos para interacao com o banco de dados.
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {

}
