package edu.ifsc.livro_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity // Marca a classe como uma entidade JPA
@Data   // Gera automaticamente getters, setters, toString, etc.
@AllArgsConstructor //construtor que receba todos os campos
@NoArgsConstructor //construtor sem argumentos

public class Livro {

    @Id // Define a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura auto incremento
    private int id;

    private int isbn;
    private String titulo;
    private String autor;
    private String editora;
    private Double preco;


    // Método para reajustar o preço
    public void reajustarPreco(int taxa) {
        if (taxa <= 0) {
            throw new IllegalArgumentException("A taxa de reajuste deve ser maior que zero.");
        }
        this.preco += this.preco * taxa / 100.0;
    }
}

