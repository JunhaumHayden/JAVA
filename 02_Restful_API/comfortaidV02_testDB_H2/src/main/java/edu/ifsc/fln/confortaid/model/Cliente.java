package edu.ifsc.fln.confortaid.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Cliente extends Usuario {
    @Column(nullable = false, unique = true)
    private String cpf;
    private LocalDate nascimento;
}

