package br.edu.ifsc.fln.model.domain;

public class Marca {

    private int id;
    private String nome;
    
    // Construtor
    public Marca(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Marca() {
    }

    // Getters e Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Marca other = (Marca) obj;
        if (id != other.id)
            return false;
        return true;
    }
}
