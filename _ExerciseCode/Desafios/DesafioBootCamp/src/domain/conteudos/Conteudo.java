package domain.conteudos;
//Classe Abstrata
/**
* <h2>Conteudo</h2>
* A Classe Conteudo é a classe mãe.
* <p>
* <b>Note:</b> Leia atentamente a documentação desta classes
* para desfrutar dos recursos oferecidos pelo autor
*
* @author  Carlos Hayden
* @version 1.0
* @since   30/05/2024
*/
public abstract class Conteudo

{
    //protected modificador de acesso para que apenas classes filhas tenham acesso.
    //static modificador de classe para poder acessar fora da classe.
    //final para indicar uma constante.
    //Inicialização da Variável: Atribui o valor 10 à variável XP_PADRAO. O sufixo d indica que o número é um literal double.
    protected static final double XP_PADRAO = 10d; 
    
    private String titulo;
    private String descricao;

    //metodos
    public abstract double calcularXp();

    public static double getXpPadrao() {
        return XP_PADRAO;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
}
}
