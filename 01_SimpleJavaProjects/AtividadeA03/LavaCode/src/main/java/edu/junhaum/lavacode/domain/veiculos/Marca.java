
package edu.junhaum.lavacode.domain.veiculos;

/**
 * Classe que representa uma marca de veiculos.
 * Ela contém informações sobre a identificação e o nome da marca.
 */
public class Marca 
{
    private static int ultimoId = 0; // atributo para implementar autoincremento
    private int id;
    private String nome;


    
    /**
     * Constructor Padrao incrementa ultimoId e atribuímos esse valor ao atributo id. 
     */
    private Marca() 
    {
    this.id = ++ultimoId; //Autoincremento do Id
    }
    /**
     * Construtor sobregarregado chama o construtor padrão (this()) para gerar o id e, em seguida, atribuímos o nome fornecido ao atributo nome.
     *
     * @param nome Nome de uma marca que será atribuida aos veículos
     * 
     */
    public Marca(String nome) 
    {
        this(); //Chama o construtor padrão para gerar o id
        this.nome = nome;
    }

    //Getters e Setters
    public int getUltimoId() {
        return ultimoId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //O método toString() para fornecer uma representação de string da instância da classe Marca.
    @Override
    public String toString()
    {
        return "Marca: " + 
                "\n    id= " + id + 
                "\n    Nome= " + nome;
    }

}
