/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

/**
 *
 * @author Aluno
 */
public enum ECategoria {
    PEQUENO(1, "pequeno"), MEDIO(2, "medio"), GRANDE(3, "grande"), MOTO(4, "moto"), PADRAO(5, "padrao");
    
    private int id;
    private String descricao;

    private ECategoria() {
    }

    private ECategoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    private ECategoria(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}

    
