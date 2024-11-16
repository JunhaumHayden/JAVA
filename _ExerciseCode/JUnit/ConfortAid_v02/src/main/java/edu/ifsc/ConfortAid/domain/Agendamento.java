package edu.ifsc.ConfortAid.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.time.LocalDateTime;

@Data //Inclui automaticamente os métodos getters, setters, toString, equals, e hashCode. Porém, aqui especificamos que equals e hashCode serão personalizados com @EqualsAndHashCode.
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //Permite que você escolha quais campos serão utilizados nos métodos equals e hashCode.
public class Agendamento {

    @EqualsAndHashCode.Include //Indica que o campo id será o único considerado na comparação de igualdade e no cálculo do hash.
    private int id; // ID único do agendamento
    private Cliente cliente;
    private Profissional profissional;
    private LocalDateTime dataHora;
    @Setter(value = lombok.AccessLevel.NONE) // Impede a geração automática do setStatus
    private String status = "Pendente"; // Status do agendamento: "Confirmado", "Cancelado", etc.

    public Agendamento(Cliente cliente, Profissional profissional, LocalDateTime dataHora) {
        this.cliente = cliente;
        this.profissional = profissional;
        this.dataHora = dataHora;
    }

    // Métodos para confirmar, cancelar e reagendar o serviço
    public void setStatusConfirmar() {
        this.status = "Confirmado";
    }

    public void setStatusCancelar() {
        this.status = "Cancelado";
    }

    public void setStatusReagendado() {
        this.status = "Reagendado";
    }
    
}

