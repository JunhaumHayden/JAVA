// A partir da classe abaixo implemente as seguintes regras de negócio:
// 1) repor a quantidade de produto sem ultrapassar a quantidade máxima.
// 2) retirar uma quantidade sem que seja maior que a quantidade atual.
 
// Implemente uma aplicação principal (main) para criar objetos produtos e manipular o estoque dos mesmos a partir dos métodos repor e retirar.
// Se desejar, insira vários produtos numa lista e faça um menu de opções para manipular os objetos da lista. Sugestão: inserir novo produto; repor produto; retirar produto; mostrar quantidade atual; listar todos.


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import domain.Produto;

public class MainApp 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        List<Produto> estoque = new ArrayList<>();

        int opcao;

        do
        {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao)
            {
                case 1:
                    inserirNovoProduto(scanner, estoque);
                    break;
                case 2:
                    reporProduto(scanner, estoque);
                    break;
                    case 3:
                    retirarProduto(scanner, estoque);
                    break;
                case 4:
                    mostrarQuantidadeAtual(scanner, estoque);
                    break;
                case 5:
                    listarTodos(estoque);
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            
            }
        } while (opcao != 0);
        scanner.close();
    }

    private static void exibirMenu()
    {
        System.out.println("\nMenu: ");
        System.out.println("1 - Inserir novo produto");
        System.out.println("2 - Repor produto");
        System.out.println("3 - Retirar produto");
        System.out.println("4 - Mostrar quantidade atual de um produto");
        System.out.println("5 - Listar todos os produtos");
        System.out.println("0 - Sair");
    }

    private static void inserirNovoProduto(Scanner scanner, List<Produto> estoque)
    {
        System.out.print("Código: ");
        int codigo = scanner.nextInt();
        scanner.nextLine(); //Limpas o buffer

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        System.out.print("Quantidade Atual: ");
        int quantidadeAtual = scanner.nextInt();

        System.out.print("Quantidade Máxima: ");
        int quantidadeMaxiama = scanner.nextInt();

        Produto produto = new Produto(codigo, descricao, valor, quantidadeAtual, quantidadeMaxiama);
        estoque.add(produto);
        System.out.println("Novo produto inserido com sucesso.");
    }

    private static void reporProduto(Scanner scanner, List<Produto> estoque) {
        System.out.print("Digite o código do produto que deseja repor: ");
        int codigo = scanner.nextInt();
        System.out.print("Quantidade a repor: ");
        int quantidade = scanner.nextInt();
    
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) { // Verifica se o código do produto coincide
                produto.repor(quantidade);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
    
    private static void retirarProduto(Scanner scanner, List<Produto> estoque) {
        System.out.print("Digite o código do produto que deseja retirar: ");
        int codigo = scanner.nextInt();
        System.out.print("Quantidade a retirar: ");
        int quantidade = scanner.nextInt();
    
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) { // Verifica se o código do produto coincide
                produto.retirada(quantidade);
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }
    
    private static void mostrarQuantidadeAtual(Scanner scanner, List<Produto> estoque) {
        System.out.print("Digite o código do produto: ");
        int codigo = scanner.nextInt();
    
        for (Produto produto : estoque) {
            if (produto.getCodigo() == codigo) { // Verifica se o código do produto coincide
                System.out.println("Quantidade atual do produto: " + produto.obterQuantidadeAtual());
                return;
            }
        }
        System.out.println("Produto não encontrado.");
    }

    private static void listarTodos(List<Produto> estoque) 
    {
        System.out.println("Lista de Produtos:");
        for (Produto produto : estoque) 
        {
            System.out.println(produto);
        }
    }
}
