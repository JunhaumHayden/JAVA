package main;
import domain.*;
import java.util.Scanner;

public class iPhone {
    private ReprodutorMusical reprodutorMusical = new ReprodutorMusical();
    private AparelhoTelefonico aparelhoTelefonico = new AparelhoTelefonico();
    private NavegadorInternet navegadorInternet = new NavegadorInternet();

    public static void main(String[] args) {
        iPhone iphone = new iPhone();
        iphone.menu();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n\nEscolha uma opção:");
            System.out.println("1: Tocar música");
            System.out.println("2: Pausar música");
            System.out.println("3: Selecionar música");
            System.out.println("4: Ligar");
            System.out.println("5: Atender");
            System.out.println("6: Iniciar correio de voz");
            System.out.println("7: Exibir página da web");
            System.out.println("8: Adicionar nova aba");
            System.out.println("9: Atualizar página");
            System.out.println("0: Sair");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha

            switch (opcao) {
                case 1:
                    reprodutorMusical.tocar();
                    break;
                case 2:
                    reprodutorMusical.pausar();
                    break;
                case 3:
                    System.out.println("Digite o nome da música:");
                    String musica = scanner.nextLine();
                    reprodutorMusical.selecionarMusica(musica);
                    break;
                case 4:
                    System.out.println("Digite o número para ligar:");
                    String numero = scanner.nextLine();
                    aparelhoTelefonico.ligar(numero);
                    break;
                case 5:
                    aparelhoTelefonico.atender();
                    break;
                case 6:
                    aparelhoTelefonico.iniciarCorreioVoz();
                    break;
                case 7:
                    System.out.println("Digite o URL:");
                    String url = scanner.nextLine();
                    navegadorInternet.exibirPagina(url);
                    break;
                case 8:
                    navegadorInternet.adicionarNovaAba();
                    break;
                case 9:
                    navegadorInternet.atualizarPagina();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
