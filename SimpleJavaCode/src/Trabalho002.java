package java.SimpleJavaCode.src;
import java.util.Scanner;

public class Trabalho002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de atendimentos que serão processados: ");
        int numAtendimentos = scanner.nextInt();

        String[] nomes = new String[numAtendimentos];
        int[] tiposVeiculo = new int[numAtendimentos];
        int[] tiposServico = new int[numAtendimentos];
        double[] valoresPagos = new double[numAtendimentos];

        realizarAtendimentos(scanner, numAtendimentos, nomes, tiposVeiculo, tiposServico, valoresPagos);
        mostrarRelatorio(numAtendimentos, nomes, tiposVeiculo, tiposServico, valoresPagos);

        scanner.close();
    }

    private static void realizarAtendimentos(Scanner scanner, int numAtendimentos, String[] nomes,
                                             int[] tiposVeiculo, int[] tiposServico, double[] valoresPagos) {
        for (int i = 0; i < numAtendimentos; i++) {
            System.out.println("Atendimento " + (i + 1));
            System.out.print("Nome do cliente: ");
            nomes[i] = scanner.next();

            do {
                System.out.print("Tipo do veículo (1 - Pequeno / 2 - Médio / 3 - Grande): ");
                tiposVeiculo[i] = scanner.nextInt();
            } while (tiposVeiculo[i] < 1 || tiposVeiculo[i] > 3);

            do {
                System.out.print("Tipo de serviço (1 - Lavação externa / 2 - Lavação externa + interna / 3 - Lavação externa + interna + cera): ");
                tiposServico[i] = scanner.nextInt();
            } while (tiposServico[i] < 1 || tiposServico[i] > 3);

            valoresPagos[i] = calcularValorPago(tiposVeiculo[i], tiposServico[i]);
        }
    }

    private static double calcularValorPago(int tipoVeiculo, int tipoServico) {
        double[][] tabelaValores = {
                {30, 50, 70},
                {50, 70, 90},
                {70, 90, 110}
        };

        return tabelaValores[tipoVeiculo - 1][tipoServico - 1];
    }

    private static void mostrarRelatorio(int numAtendimentos, String[] nomes, int[] tiposVeiculo,
                                         int[] tiposServico, double[] valoresPagos) {
        System.out.println("\nRelação Geral dos Clientes:");
        for (int i = 0; i < numAtendimentos; i++) {
            System.out.println("Nome: " + nomes[i] +
                    ", Tipo do Veículo: " + tiposVeiculo[i] +
                    ", Tipo do Serviço: " + tiposServico[i] +
                    ", Valor Pago: R$" + valoresPagos[i]);
        }

        calcularEApresentarPercentuais(numAtendimentos, tiposVeiculo, tiposServico);
        calcularEApresentarTotalArrecadado(numAtendimentos, valoresPagos);
        identificarMaisAtendido(numAtendimentos, tiposVeiculo, tiposServico);
    }

    private static void calcularEApresentarPercentuais(int numAtendimentos, int[] tiposVeiculo, int[] tiposServico) {
        int[] contagemTipoVeiculo = new int[3];
        int[] contagemTipoServico = new int[3];
        int totalAtendimentos = numAtendimentos;

        for (int i = 0; i < numAtendimentos; i++) {
            contagemTipoVeiculo[tiposVeiculo[i] - 1]++;
            contagemTipoServico[tiposServico[i] - 1]++;
        }

        System.out.println("\nPercentuais dos Atendimentos pelo Tipo do Veículo:");
        for (int i = 0; i < 3; i++) {
            double percentual = (contagemTipoVeiculo[i] * 100.0) / totalAtendimentos;
            System.out.println("Tipo " + (i + 1) + ": " + percentual + "%");
        }

        System.out.println("\nPercentuais dos Atendimentos pelo Tipo de Serviço:");
        for (int i = 0; i < 3; i++) {
            double percentual = (contagemTipoServico[i] * 100.0) / totalAtendimentos;
            System.out.println("Tipo " + (i + 1) + ": " + percentual + "%");
        }
    }

    private static void calcularEApresentarTotalArrecadado(int numAtendimentos, double[] valoresPagos) {
        double totalArrecadado = 0;
        for (int i = 0; i < numAtendimentos; i++) {
            totalArrecadado += valoresPagos[i];
        }
        System.out.println("\nValor Total Arrecadado: R$" + totalArrecadado);
    }

    private static void identificarMaisAtendido(int numAtendimentos, int[] tiposVeiculo, int[] tiposServico) {
        int[] contagemTipoVeiculo = new int[3];
        int[] contagemTipoServico = new int[3];

        for (int i = 0; i < numAtendimentos; i++) {
            contagemTipoVeiculo[tiposVeiculo[i] - 1]++;
            contagemTipoServico[tiposServico[i] - 1]++;
        }

        int tipoVeiculoMaisAtendido = encontrarIndiceMaximo(contagemTipoVeiculo) + 1;
        int tipoServicoMaisAtendido = encontrarIndiceMaximo(contagemTipoServico) + 1;

        System.out.println("\nTipo de Veículo Mais Atendido: " + tipoVeiculoMaisAtendido);
        System.out.println("Tipo de Serviço Mais Atendido: " + tipoServicoMaisAtendido);
    }

    private static int encontrarIndiceMaximo(int[] array) {
        int indiceMaximo = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[indiceMaximo]) {
                indiceMaximo = i;
            }
        }
        return indiceMaximo;
    }
}
