package java.PrjVendas.src.domain;

public class Estoque {
    private int quantidade;
    private int qtdMaxima;
    private int qtdMinima;


    public Estoque(int quantidade, int qtdMaxima, int qtdMinima) {
        this.quantidade = quantidade;
        this.qtdMaxima = qtdMaxima;
        this.qtdMinima = qtdMinima;
    }


    public int getQuantidade() {
        return quantidade;
    }


    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }


    public int getQtdMaxima() {
        return qtdMaxima;
    }


    public void setQtdMaxima(int qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }


    public int getQtdMinima() {
        return qtdMinima;
    }


    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    

    

}
