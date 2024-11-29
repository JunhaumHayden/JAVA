package edu.ifsc.lavacao_api.repository;

import edu.ifsc.lavacao_api.model.veiculos.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MotorRepository extends JpaRepository<Motor, Integer> {
    Optional<Motor> findByPotencia(Integer potencia); // Consulta personalizada pela potencia do motor
}

