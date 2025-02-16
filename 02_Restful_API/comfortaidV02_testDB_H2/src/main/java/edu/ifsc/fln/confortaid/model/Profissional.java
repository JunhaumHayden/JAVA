package edu.ifsc.fln.confortaid.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "profissional")
@PrimaryKeyJoinColumn(name = "id_usuario")
public class Profissional extends Usuario {
    @Column(nullable = false)
    private String especialidade;

    @Column(unique = true)
    private String registroProfissional;
}