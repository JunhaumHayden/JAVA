package edu.ifsc.lavacao_api.repository;

import edu.ifsc.lavacao_api.model.veiculos.Modelo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
