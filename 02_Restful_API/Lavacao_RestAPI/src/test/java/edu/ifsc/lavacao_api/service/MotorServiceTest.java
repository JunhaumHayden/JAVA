package edu.ifsc.lavacao_api.service;

import edu.ifsc.lavacao_api.model.ECategoria;
import edu.ifsc.lavacao_api.model.veiculos.Motor;
import edu.ifsc.lavacao_api.model.veiculos.Modelo;
import edu.ifsc.lavacao_api.model.veiculos.ETipoCombustivel;
import edu.ifsc.lavacao_api.repository.MotorRepository;
import edu.ifsc.lavacao_api.repository.ModeloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MotorServiceTest {

    @Mock
    private MotorRepository motorRepository;

    @Mock
    private ModeloRepository modeloRepository;

    @InjectMocks
    private MotorService motorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveSalvarMotorAssociadoAoModelo() {
        Modelo modelo = new Modelo(1, "Modelo A", null, null, ECategoria.MEDIO);
        Motor motor = new Motor(0, 150, ETipoCombustivel.GASOLINA, modelo);

        when(modeloRepository.findById(1)).thenReturn(Optional.of(modelo));
        when(motorRepository.save(motor)).thenReturn(motor);

        Motor motorSalvo = motorService.salvarMotor(motor);

        assertNotNull(motorSalvo);
        assertEquals(modelo, motorSalvo.getModelo());
        assertEquals(ETipoCombustivel.GASOLINA, motorSalvo.getTipoCombustivel());
        verify(motorRepository, times(1)).save(motor);
    }

    @Test
    void deveExcluirMotorQuandoModeloForExcluido() {
        Modelo modelo = new Modelo(1, "Modelo A", null, null, ECategoria.MEDIO);
        Motor motor = new Motor(1, 150, ETipoCombustivel.GASOLINA, modelo);

        when(modeloRepository.findById(1)).thenReturn(Optional.of(modelo));
        doNothing().when(motorRepository).deleteById(1);

        motorService.excluirMotor(1);

        verify(motorRepository, times(1)).deleteById(1);
    }
}

