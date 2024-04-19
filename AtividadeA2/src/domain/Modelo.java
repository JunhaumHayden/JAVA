package domain;

public class Modelo {
    private static int ultimoId = 0; // atributo para implementar autoincremento
    private int id;
    private String descricao;
    private Marca marca; // Adicionando referência para a classe Marca
    private Ecategoria categoria;
    private Motor motor = new Motor(id, null); //Para configurar uma composicao precisa instanciar no momento da criacao


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

    public Ecategoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Ecategoria categoria) {
        this.categoria = categoria;
    }

    public Motor getMotor(){
        return motor;
    }
    //Para configurar uma composicao precisa instanciar no momento da criacao de maineira que nao e aceitavel realizar alteracao posterior
   // public void setMotor(Motor motor) {
   //     this.motor = motor;
   // }


    @Override
    public String toString() {
        return "Metodo toString da classe Modelo\nMODELO: \n    id= " + id + " descricao= " + descricao + " marca= " + marca + " Categoria= " + categoria + " motor= " + motor;
    }
}

