package edu.ifsc.rest_DTO_exemplo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.ifsc.rest_DTO_exemplo.domain.Categoria;
// Classe que será responsavel pela interaçao com o banco de dados e é propria do JPA.
// Gera uma interface com os objetos 
// JpaRepository é a interface com os metodos para interacao com o banco de dados
// Os paramentros Categoria para montar um DTO pelo framework e Integer é uma referencia para a chave primaria.
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {


    // Metodos que nao sao o padrao do framework devem ser implementado
    // Deve ser um atributo da classe instanciada. neste casso é a classe Categoria onde o metodo retorna uma lista de objetos Categorias buscados pelo atributo Descricao.
    List<Categoria> findByDescricao(String descricao);

    List<Categoria> findByDescricaoContaining(String descricao);

}
