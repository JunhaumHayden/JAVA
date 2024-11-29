package edu.ifsc.lavacao_api.model.veiculos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Classe Representa a motor de uma marca.
 * @Entity para tornar a classe uma entidade do JPA
 *
 * @author  Carlos Hayden
 * @version 1.0
 * @since   26/11/2024
 *
 */

@Entity // Marca a classe como uma entidade JPA
@Data // Gera automaticamente getters, setters, toString, etc.
@AllArgsConstructor //construtor que receba todos os campos
@NoArgsConstructor //construtor sem argumentos
@EqualsAndHashCode(of={"id"})
public class Motor {
    @Id // Define a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura auto incremento repassando ao banco o controle do id
    private int id;
    private int potencia;
    @Enumerated(EnumType.STRING)
    private ETipoCombustivel tipoCombustivel;
    @OneToOne
    @MapsId
    @JoinColumn(name = "id_modelo")
    @JsonIgnoreProperties("motor")
    private Modelo modelo;
// todo Implementar validações: Por exemplo, garantir que o Motor só seja salvo se associado a um Modelo válido.
}
