package edu.ifsc.rest_DTO_exemplo.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Camda de protecao do que irá ser exposto na API
 */
@Getter
@Setter
public class ProdutoDTO {
    private Integer id;
    private String nome;
    private String descricaoProduto;
    private String descricaoCategoria;
}
