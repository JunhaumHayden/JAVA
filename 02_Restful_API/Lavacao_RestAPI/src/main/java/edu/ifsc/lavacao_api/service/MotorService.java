package edu.ifsc.lavacao_api.service;

import edu.ifsc.lavacao_api.model.veiculos.Motor;
import edu.ifsc.lavacao_api.repository.MotorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorService {

    private final MotorRepository motorRepository;

    public MotorService(MotorRepository motorRepository) {
        this.motorRepository = motorRepository;
    }

    public List<Motor> listarTodos() {
        return motorRepository.findAll();
    }

    public Motor buscarPorId(int id) {
        return motorRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Motor não encontrado com o ID: " + id));
    }

    public Motor salvarMotor(Motor motor) {
        if (motorRepository.findByPotencia(motor.getPotencia()).isPresent()) {
            throw new IllegalArgumentException("Motor já existe com o potencia: " + motor.getPotencia());
        }
        return motorRepository.save(motor);
    }

    public Motor atualizarMotor(int id, Motor motorAtualizado) {
        Motor motorExistente = buscarPorId(id);
        motorExistente.setPotencia(motorAtualizado.getPotencia());
        motorExistente.setPotencia(motorAtualizado.getPotencia());
        return motorRepository.save(motorExistente);
    }

    public void excluirMotor(int id) {
        Motor motor = buscarPorId(id);
        motorRepository.delete(motor);
    }
}

