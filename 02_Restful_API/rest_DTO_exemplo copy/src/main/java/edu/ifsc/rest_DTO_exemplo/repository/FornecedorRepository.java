package edu.ifsc.rest_DTO_exemplo.repository;

import edu.ifsc.rest_DTO_exemplo.domain.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

}
