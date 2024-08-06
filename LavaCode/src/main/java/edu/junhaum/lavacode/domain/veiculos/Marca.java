
package edu.junhaum.lavacode.domain.veiculos;

/**
 * Classe de marcas.
 * Esta classe representa uma marca de veiculos.
 * Ela contém informações sobre a identificação e o nome da marca.
 */
public class Marca 
{
    private static int ultimoId = 0; // atributo para implementar autoincremento
    private int id;
    private String nome;


    //Constructor. incrementa ultimoId e atribuímos esse valor ao atributo id.
    public Marca() 
    {
    this.id = ++ultimoId; //Autoincremento do Id
    }

    //Construtor sobregarregado chama o construtor padrão (this()) para gerar o id e, em seguida, atribuímos o nome fornecido ao atributo nome.
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

    public void setId(int id) {
        this.id = id;
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
        return "Metodo toString da classe Marca\nMarca: " + "\n    id= " + id + ",\n    Nome= " + nome;
    }

}
