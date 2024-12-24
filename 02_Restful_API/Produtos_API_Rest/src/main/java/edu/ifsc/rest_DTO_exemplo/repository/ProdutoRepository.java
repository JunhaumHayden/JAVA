package edu.ifsc.rest_DTO_exemplo.repository;
/**
 * Segundo cria-se esta classe que representará 
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ifsc.rest_DTO_exemplo.domain.Produto;



 @Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
