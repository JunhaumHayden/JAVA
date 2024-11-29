package edu.ifsc.lavacao_api.model.veiculos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import edu.ifsc.lavacao_api.model.ECategoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe que representa um modelo de veiculos.
 * Ela contém informações sobre a identificação e o nome da marca.
 * @author Carlos Hayden
 * @version 1.0
 * @since   26/11/2024
 */

@Entity // Marca a classe como uma entidade JPA
@Data // Gera automaticamente getters, setters, toString, etc.
@AllArgsConstructor //construtor que receba todos os campos
@NoArgsConstructor //construtor sem argumentos
@EqualsAndHashCode(of={"id"})
public class Modelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura auto incremento repassando ao banco o controle do id
    private int id;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "id_marca", nullable = false)
    private Marca marca;

    @OneToOne(mappedBy = "modelo", cascade = CascadeType.ALL, orphanRemoval = true) //garante que as operações em Modelo sejam propagadas para Motor, remove o Motor automaticamente quando o Modelo é excluído.
    @JsonIgnoreProperties("modelo")
    private Motor motor = new Motor();

    @Enumerated(EnumType.STRING)
    private ECategoria categoria;
}

