class Produto
{
    public int codigo;
    public String descricao;
    public double valor;
    public int qtdAtual;
    public int qtdMaxima;

    // Construtor
    public Produto(int codigo, String descricao, double valor, int qtdAtual, int qtdMaxima)
    {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
        this.qtdAtual = qtdAtual;
        this.qtdMaxima = qtdMaxima;
    }

// Getters e Setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

// Métodos para repor e retirar quantidade, e obter a quantidade atual
    /**
     * @param quantidade
     */
    public void repor(int quantidade)
    {
        if (qtdAtual + quantidade <= qtdMaxima)
        {
            qtdAtual += quantidade;
            System.out.println("Reposição realizada com sucesso");
        }
        else
        {
            System.out.println("Erro!! : Quantidade excede o limite maximo");
        }
    }

    public void retirada(int quantidade)
    {
        if (quantidade <= qtdAtual)
        {
            qtdAtual -= quantidade;
            System.out.println("Retirada realizada com sucesso!");
        }
        else
        {
            System.out.println("Erro!! Quantidade solicitada excede a quantidade em estoque");
        }
    }

    public int obterQuantidadeAtual()
    {
        return qtdAtual;
    }

    public String toString()
    {
        return "Código: " + codigo + " ,Descrição: " + descricao + " , Valor: " + valor + " ,Quantidade Atual: " + qtdAtual;
    }
}
