import java.util.Scanner;

// Classe Produto
class Produto {
    private String nome;
    private int quantidadeEstoque;

    //Constructor
    public Produto(String nome, int quantidadeEstoque) {
        this.nome = nome;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
}

// Interface EstoqueStrategy:
interface EstoqueStrategy {
    String verificar(Produto produto);
}

/**
 * Classe VerificarEstoqueStrategy que implementa a interface EstoqueStrategy 
*/ 
class VerificarEstoqueStrategy implements EstoqueStrategy {

    /**
     * Atributo com o limite mínimo de estoque (Neste caso é fixado em 10)
     */ 
    private static final int LIMITE_MINIMO = 10;

    /**
     *  Metodo para Definir o limite mínimo de estoque:
     * Implementação da lógica para verificar o estoque do produto
     * 
     */ 
    @Override
    public String verificar(Produto produto) {
    if (produto.getQuantidadeEstoque() < LIMITE_MINIMO) {
        return "Alerta: Estoque baixo de " + produto.getNome();
    } else {
        return "Estoque de " + produto.getNome() + " esta em nivel adequado";
    }
        
    }
}
    
// Classe principal
public class VerificacaoEstoque {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Leitura do nome do produto e quantidade em estoque
        String nomeProduto = scanner.nextLine();
        int quantidadeEstoque = scanner.nextInt();

        // Criação da entidade Produto
        Produto produto = new Produto(nomeProduto, quantidadeEstoque);

        // Criação e execução da estratégia de verificação de estoque
        EstoqueStrategy estoqueStrategy = new VerificarEstoqueStrategy(); 
        String resultado = estoqueStrategy.verificar(produto);

        System.out.println(resultado);

        scanner.close();
    }
}