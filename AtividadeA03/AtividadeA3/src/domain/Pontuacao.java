package domain;

public class Pontuacao {
    private int quantidade;

    // Construtor sempre inicializa com zero
    public Pontuacao() {
        this.quantidade = 0;
    }

    //para poder passar uma quantidade de pontos na instanciacao do objeto é necessario ter um construtor que aceite a instanciaçao com um valor como abaixo
    // public Pontuacao(int quantidade) {
    //     this.quantidade = quantidade;
    // }

    // Método para adicionar quantidade
    public void adicionarPontos(int pontos) {
        this.quantidade += pontos;
    }

    // Método para subtrair quantidade
    public void subtrairPontos(int pontos) {
        if (quantidade - pontos >=0) //verificar se ha pontos suficientes para subtrair
        {
            this.quantidade -= pontos;
        }
    }

    // Método para obter saldo
    public int getSaldo() {
        return quantidade;
    }

    @Override
    public String toString() {
        return "Pontuacao [quantidade=" + quantidade + "]";
    }
    


}

