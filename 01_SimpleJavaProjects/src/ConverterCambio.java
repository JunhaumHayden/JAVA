package java.SimpleJavaCode.src;
import java.util.Scanner;

public class ConverterCambio {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escolha a operação:");
        System.out.println("1 - Reais para Dólares");
        System.out.println("2 - Dólares para Reais");

        int escolha = input.nextInt();

        if (escolha == 1) {
            // Reais para Dólares
            System.out.print("Digite o valor em Reais: R$");
            double valorReais = input.nextDouble();
            double valorDolares = converterReaisParaDolares(valorReais);
            System.out.printf("Correspondente em Dólares: US$%.2f\n", valorDolares);
        } else if (escolha == 2) {
            // Dólares para Reais
            System.out.print("Digite o valor em Dólares: US$");
            double valorDolares = input.nextDouble();
            double valorReais = converterDolaresParaReais(valorDolares);
            System.out.printf("Correspondente em Reais: R$%.2f\n", valorReais);
        } else {
            System.out.println("Escolha inválida. Encerrando o programa.");
        }

        input.close();
    }

    // Função para converter Reais para Dólares
    private static double converterReaisParaDolares(double valorReais) {
        double taxaCambio = 4.10;
        return valorReais / taxaCambio;
    }

    // Função para converter Dólares para Reais
    private static double converterDolaresParaReais(double valorDolares) {
        double taxaCambio = 4.10;
        return valorDolares * taxaCambio;
    }
}
