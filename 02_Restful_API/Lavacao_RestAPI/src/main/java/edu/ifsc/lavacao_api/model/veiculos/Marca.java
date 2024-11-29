
package edu.ifsc.lavacao_api.model.veiculos;

 /**
 * Classe que representa uma marca de veiculos.
 * Ela contém informações sobre a identificação e o nome da marca.
 * @author Carlos Hayden
 * @version 1.0
 * @since   26/11/2024
 */

import jakarta.persistence.*;
import lombok.*;

@Entity // Marca a classe como uma entidade JPA
@Data // Gera automaticamente getters, setters, toString, etc.
@AllArgsConstructor //construtor que receba todos os campos
@NoArgsConstructor //construtor sem argumentos
@EqualsAndHashCode(of={"id"})
public class Marca {
    @Id // Define a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Annotation para o JPA Gerenciar automaticamente esse atributo com a estrategia IDENTITY Configura auto incremento repassando ao banco o controle do id
    private int id;
    @Column(nullable = false, unique = true) // Não nulo e único
    private String nome;
}

