package domain;

public class Modelo {
    private static int ultimoId = 0; // atributo para implementar autoincremento
    private int id;
    private String descricao;
    private Marca marca; // Adicionando referência para a classe Marca


    // Construtor padrão
    public Modelo() {
        this.id = ++ultimoId; //Autoincremento do Id
    }

    // Construtor sobrecarregado
    public Modelo(String descricao) {
        this(); //Chama o construtor padrão para gerar o id
        this.descricao = descricao;
    }

    // Getters e Setters
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

    public Marca getMarca(){
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    @Override
    public String toString() {
        return "Metodo toString da classe Modelo\nMODELO: \n    id= " + id + " descricao= " + descricao + " marca= " + marca;
    }
}

