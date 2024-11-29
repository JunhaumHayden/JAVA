package edu.ifsc.lavacao_api.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LivroDTO {
    private String titulo;
    private String autor;
    private String editora;
    private Double preco;
}

