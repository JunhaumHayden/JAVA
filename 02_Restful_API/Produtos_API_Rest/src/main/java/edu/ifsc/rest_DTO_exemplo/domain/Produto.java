package edu.ifsc.rest_DTO_exemplo.domain;
/**
 * Primeiro cria-se a classe que representará o objeto do dominio do problema
 */

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
/**
 * Essa anotação, quando aplicada à classe, instrui o Lombok a gerar automaticamente métodos "getter" para todos os campos não estáticos dessa classe.
No caso da classe Produto, ela cria métodos como getId(), getNome(), getDescricao(), getPreco() e getCategoria().
 */
@Getter

/**
 * O @Setter import lombok.Getter é utilizado para que o Lombok gere automaticamente métodos "setter" para todos os campos não estáticos da classe.
Para Produto, ele cria métodos como setId(Integer id), setNome(String nome), setDescricao(String descricao), setPreco(BigDecimal preco) e setCategoria(Categoria categoria).
Esses métodos permitem modificar os valores dos campos da instância da classe Produto.
 */
@Setter

/**
 * Essa anotação configura o Lombok para gerar métodos equals() e hashCode() que serão baseados apenas no campo id.
Com isso, dois objetos Produto serão considerados iguais se seus campos id forem iguais, independente dos valores dos outros campos.
Essa abordagem é útil para evitar comparações excessivas de campos, especialmente em entidades onde o id é um identificador único no banco de dados.
 */
@EqualsAndHashCode(of={"id"})
/**
 *  @Entity importado de jakarta.persistence.Entity para mapear esta classe com o banco de dados
 */
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    /**
     * Anotaçao import jakarta.persistence.ManyToOne para definir a multiplicidade entre as classes (no caso de produto para categoria)
     */
    @ManyToOne
    /**
     * Anotaçao import jakarta.persistence.JoinColumn para definir a coluna que servirá de chave estrangeira  entre as classes (no caso de produto para categoria)
     */

    @JoinColumn(name="id_categoria")
    private Categoria categoria;


    public Produto() {

    }


}
