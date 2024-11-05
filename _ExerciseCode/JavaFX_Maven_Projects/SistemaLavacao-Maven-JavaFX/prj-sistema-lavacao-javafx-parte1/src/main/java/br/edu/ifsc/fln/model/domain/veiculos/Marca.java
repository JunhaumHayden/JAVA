
package br.edu.ifsc.fln.model.domain.veiculos;

/**
 * Classe que representa uma marca de veiculos.
 * Ela contém informações sobre a identificação e o nome da marca.
 */
public class Marca 
{
    private int id;
    private String nome;


    
    /**
     * Constructor Padrao incrementa ultimoId e atribuímos esse valor ao atributo id. 
     */
    public Marca() 
    {
    }
    /**
     * Construtor sobregarregado chama o construtor padrão (this()) para gerar o id e, em seguida, atribuímos o nome fornecido ao atributo nome.
     *
     * @param nome Nome de uma marca que será atribuida aos veículos
     * 
     */
    public Marca(String nome) 
    {
        this.nome = nome;
    }

    //Getters e Setters
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
        return "Marca: " + 
                "\n    id= " + id + 
                "\n    Nome= " + nome;
    }

}
