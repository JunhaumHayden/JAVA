package java.SimpleJavaCode.src;
//Desenvolva um pequeno sistema para cálculo de figuras geométricas planas.
//As opções devem ser: Quadrado, Triângulo e Circunferência.
// O menu de opções pode ter o seguinte layout :

// GEOMETRIA PLANA
// MENU PRINCIPAL:
// 1- QUADRADO
// 2- TRIÂNGULO
// 3- CIRCUNFERÊNCIA
// 4- SAIR
// OPÇÃO => ___

// Caso a opção do programa seja a 1, 2 ou 3, deverá chamar um procedimento (void) para ler e calcular a figura em questão.
// Caso a opção do programa seja a opção 4, emitir a mensagem "O programa será finalizado!" e encerrar o programa.
// Caso a opção seja diferente de uma delas, emitir a mensagem "Opção incorreta!!!" e reapresentar o menu principal.
// Então, vc deverá ter o programa principal (que é o main) e 3 subprogramas (SEM parâmetros e SEM retorno)



import java.util.InputMismatchException;
import java.util.Scanner;

public class calculofigurasgeometricas 
{
    public static void main(String[] args) 
    {
        Scanner data_in = new Scanner(System.in);

        int opcao = 0;
        do 
        {
            exibirMenu();
            try 
            {
                System.out.print("Escolha uma Opção => ");
                opcao = data_in.nextInt();

                switch (opcao) 
                {
                    case 1:
                        calcularAreaQuadrado();
                        break;
                    case 2:
                        calcularAreaTriangulo();
                        break;
                    case 3:
                        calcularAreaCircunferencia();
                        break;
                    case 4:
                        System.out.println("O programa será finalizado!");
                        break;
                    default:
                        System.out.println("Opção incorreta!!!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número inteiro válido.");
                data_in.nextLine(); // Limpar o buffer de entrada
            }
        } while (opcao != 4);

        data_in.close();
        // A prática de fechar recursos é importante para evitar vazamentos de recursos e garantir que os recursos sejam liberados quando não são mais necessários. Em particular, ao lidar com entrada e saída de dados em Java, é uma boa prática fechar os objetos Scanner ou outros recursos de entrada/saída quando você terminar de usá-los.
    }

    // Subprograma para exibir o menu principal
    private static void exibirMenu() 
    {
        System.out.println("\nGEOMETRIA PLANA");
        System.out.println("MENU PRINCIPAL:");
        System.out.println("1- QUADRADO");
        System.out.println("2- TRIÂNGULO");
        System.out.println("3- CIRCUNFERÊNCIA");
        System.out.println("4- SAIR");
    }

    // Subprograma para calcular a área do quadrado
    private static void calcularAreaQuadrado() 
    {
        Scanner data_in = new Scanner(System.in);
        System.out.print("Digite o lado do quadrado: ");
        double lado = data_in.nextDouble();
        double area = lado * lado;
        System.out.println("Área do quadrado: " + area);
    }

    // Subprograma para calcular a área do triângulo
    private static void calcularAreaTriangulo() 
    {
        Scanner data_in = new Scanner(System.in);
        System.out.print("Digite a base do triângulo: ");
        double base = data_in.nextDouble();
        System.out.print("Digite a altura do triângulo: ");
        double altura = data_in.nextDouble();
        double area = (base * altura) / 2;
        System.out.println("Área do triângulo: " + area);
    }

    // Subprograma para calcular a área da circunferência
    private static void calcularAreaCircunferencia() 
    {
        Scanner data_in = new Scanner(System.in);
        System.out.print("Digite o raio da circunferência: ");
        double raio = data_in.nextDouble();
        double area = Math.PI * raio * raio;
        System.out.println("Área da circunferência: " + area);
    }


}
