package edu.ifsc.rest_DTO_exemplo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
@Data
@EqualsAndHashCode(of={"id"})
@Entity
public class Fornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "fornecedor")
    private List<Produto> produtos = new ArrayList<>();
}
