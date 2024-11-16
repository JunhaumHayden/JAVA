package edu.ifsc.ConfortAid.domain;

public class Profissional {

    private int id;
    private String nome;
    private String especialidade;

    public Profissional(int id, String nome, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.especialidade = especialidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }
}


