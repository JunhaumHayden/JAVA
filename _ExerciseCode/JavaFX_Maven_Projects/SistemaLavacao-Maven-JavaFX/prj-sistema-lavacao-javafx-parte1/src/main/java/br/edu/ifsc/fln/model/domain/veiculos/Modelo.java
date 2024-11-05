package br.edu.ifsc.fln.model.domain.veiculos;

import br.edu.ifsc.fln.model.domain.Ecategoria;

public class Modelo {
    private static int ultimoId = 0; // atributo para implementar autoincremento
    private int id;
    private String descricao;
    private Marca marca; // Adicionando referência para a classe Marca
    private Ecategoria categoria;
    private Motor motor = new Motor(id, null); //Para configurar uma composicao precisa instanciar no momento da criacao


    /**
     * Gera automaticamente um ID unico a cada nova instancia da classe e atribui. 
     * @param id Autoincremento do Id.
     * 
     * 
     */
    private Modelo() {
        this.id = ++ultimoId; 
    }
    /**
     * Construtor sobregarregado chama o construtor padrão (this()) para gerar o id e, em seguida, o nome da marca e uma descricao do Modelo.
     *
     * @param descricao Adiciona uma descriçao do modelo do veiculo
     * @param marca Vincula a marca.
     * 
     */
    public Modelo(String descricao, Marca marca) {
        this(); 
        this.descricao = descricao;
        this.marca = marca;
    }
    /**
     * Construtor sobregarregado 2 para exercitar uma chamada a outro construtor sobrecarregado.
     *
     * @param marca Nome completo do cliente.
     * @param descricao Adiciona uma descriçao caso necessário.
     * @param categoria Selecao de categotia referenteao modelo.
     * @param potencia Adiciona a pontencia do Moto.
     * @param EtipoCombustivel Selecao do tipo de Combistivel.
     * 
     */
    public Modelo(String descricao, Marca marca, Ecategoria categoria, int potencia, EtipoCombustivel tipoCombustivel) 
    {
        this(descricao, marca);
        this.categoria = categoria;
        this.motor.setPotencia(potencia);
        this.motor.setTipoCombustivel(tipoCombustivel);
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
    //Para configurar uma composicao precisa instanciar no momento da criacao de maneira que nao e aceitavel realizar alteracao posterior
   // public void setMotor(Motor motor) {
   //     this.motor = motor;
   // }


    @Override
    public String toString() {
        return  "\n    " + descricao + 
                "\n" + marca.getNome() + 
                "\n    Categoria= " + categoria + 
                "\n" + motor;
    }
}

