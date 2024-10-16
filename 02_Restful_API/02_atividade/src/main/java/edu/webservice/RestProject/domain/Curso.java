package edu.webservice.RestProject.domain;

public class Curso {
    private final long id;
    private final String nome;

    public Curso(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
