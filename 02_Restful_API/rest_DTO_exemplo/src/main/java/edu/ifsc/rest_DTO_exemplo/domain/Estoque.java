package edu.ifsc.rest_DTO_exemplo.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Data
@EqualsAndHashCode(of={"id"})
@Entity
public class Estoque {
    @Id
    @Column(name="id_produto") // para esse caso existo o campo no banco e nao existe na classe
    private int id;
    @Getter // para manter o encapsulamento sem a criacao do setter
    private int quantidade;
    @Column(name="qtd_maxima")
    private int quantidadeMaxima;
    @Column(name="qtd_minima")
    private int quantidadeMinima;
    @Enumerated(EnumType.STRING)
    private ESituacao situacao = ESituacao.ATIVO;

    @OneToOne
    @MapsId // Mapeia o id do produto com o id do estoque, fazendo com que sejam iguais
    @JoinColumn(name="id_produto")
    private Produto produto;

    public void repor(int quantidade){
        if (this.situacao != ESituacao.ATIVO){
            throw new IllegalArgumentException("Estoque inativo");
        }
        if (this.quantidade + quantidade > this.quantidadeMaxima){
            throw new IllegalArgumentException("Quantidade execede o estoque");
        }
        this.quantidade += quantidade;
    }

    public void retirada(int quantidade){
        if (this.situacao != ESituacao.ATIVO){
            throw new IllegalArgumentException("Estoque inativo");
        }
        if (this.quantidade - quantidade < this.quantidadeMinima){
            throw new IllegalArgumentException("Quantidade execede o estoque");
        }
        this.quantidade -= quantidade;
    }

}
