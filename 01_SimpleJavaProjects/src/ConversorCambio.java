package java.SimpleJavaCode.src;
import java.util.Scanner;

public class ConversorCambio
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha a operação:");
        System.out.println("1 - Reais para Dólares");
        System.out.println("2 - Dólares para Reais");

        int suaEscolha = input.nextInt();


        if (suaEscolha == 1)
        {
            //reais para dolares
            System.out.print("Digite o valor em Reais: R$");
            double valorReais = input.nextDouble();
            double valorDolares = converterReaisParaDolares(valorReais);
            System.out.printf("Correspondente em dolares: US$%.2f\n", valorDolares);
        }
        else if (suaEscolha == 2)
        {
            System.out.print("Digite o valor em Dolares: US$");
            double valorDolares = input.nextDouble();
            double valorReais = converterDolaresparaReais(valorDolares);
            System.out.printf("Correspondente em Reais: R$%2.f\n", valorReais);
        }
        else
        {
            System.out.println("Escolha Inválida\nprograma será encerrado");
        }
        input.close();
    }
    //Funcao para converter Reais em Dolares
    private static double converterReaisParaDolares(double valorReais)
    {
        double taxaCambio = 4.10;
        return valorReais / taxaCambio;
    }
    //Funcao para converter Dolares em Reais
    private static double converterDolaresparaReais(double valorDolares)
    {
        double taxaCambio = 4.10;
        return valorDolares / taxaCambio;
    }
}




