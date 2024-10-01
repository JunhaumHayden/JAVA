package java.SimpleJavaCode.src;
import java.util.Scanner;

class Cliente {
    String nome;
    int tipoVeiculo;
    int tipoServico;
    double valorPago;

    public Cliente(String nome, int tipoVeiculo, int tipoServico, double valorPago) {
        this.nome = nome;
        this.tipoVeiculo = tipoVeiculo;
        this.tipoServico = tipoServico;
        this.valorPago = valorPago;
    }
}

class LavacaoCarros {
    private static final int NUM_TIPOS_VEICULO = 3;
    private static final int NUM_TIPOS_SERVICO = 3;
    private static final double[][] TABELA_VALORES = {
            {30, 50, 70},
            {50, 70, 90},
            {70, 90, 110}
    };

    private Cliente[] clientes;
    private int numAtendimentos;

    public LavacaoCarros(int numAtendimentos) {
        this.numAtendimentos = numAtendimentos;
        this.clientes = new Cliente[numAtendimentos];
    }

    public void realizarAtendimentos() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numAtendimentos; i++) {
            System.out.println("Atendimento " + (i + 1));
            System.out.print("Nome do cliente: ");
            String nome = scanner.next();

            int tipoVeiculo;
            do {
                System.out.print("Tipo do veículo (1 - Pequeno / 2 - Médio / 3 - Grande): ");
                tipoVeiculo = scanner.nextInt();
            } while (tipoVeiculo < 1 || tipoVeiculo > 3);

            int tipoServico;
            do {
                System.out.print("Tipo de serviço (1 - Lavação externa / 2 - Lavação externa + interna / 3 - Lavação externa + interna + cera): ");
                tipoServico = scanner.nextInt();
            } while (tipoServico < 1 || tipoServico > 3);

            double valorPago = calcularValorPago(tipoVeiculo, tipoServico);

            clientes[i] = new Cliente(nome, tipoVeiculo, tipoServico, valorPago);
        }
    }

    private double calcularValorPago(int tipoVeiculo, int tipoServico) {
        return TABELA_VALORES[tipoVeiculo - 1][tipoServico - 1];
    }

    public void mostrarRelatorio() {
        System.out.println("\nRelação Geral dos Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println("Nome: " + cliente.nome +
                    ", Tipo do Veículo: " + cliente.tipoVeiculo +
                    ", Tipo do Serviço: " + cliente.tipoServico +
                    ", Valor Pago: R$" + cliente.valorPago);
        }

        calcularEApresentarPercentuais();
        calcularEApresentarTotalArrecadado();
        identificarMaisAtendido();
    }

    private void calcularEApresentarPercentuais() {
        int[] contagemTipoVeiculo = new int[NUM_TIPOS_VEICULO];
        int[] contagemTipoServico = new int[NUM_TIPOS_SERVICO];
        int totalAtendimentos = clientes.length;

        for (Cliente cliente : clientes) {
            contagemTipoVeiculo[cliente.tipoVeiculo - 1]++;
            contagemTipoServico[cliente.tipoServico - 1]++;
        }

        System.out.println("\nPercentuais dos Atendimentos pelo Tipo do Veículo:");
        for (int i = 0; i < NUM_TIPOS_VEICULO; i++) {
            double percentual = (contagemTipoVeiculo[i] * 100.0) / totalAtendimentos;
            System.out.println("Tipo " + (i + 1) + ": " + percentual + "%");
        }

        System.out.println("\nPercentuais dos Atendimentos pelo Tipo de Serviço:");
        for (int i = 0; i < NUM_TIPOS_SERVICO; i++) {
            double percentual = (contagemTipoServico[i] * 100.0) / totalAtendimentos;
            System.out.println("Tipo " + (i + 1) + ": " + percentual + "%");
        }
    }

    private void calcularEApresentarTotalArrecadado() {
        double totalArrecadado = 0;
        for (Cliente cliente : clientes) {
            totalArrecadado += cliente.valorPago;
        }
        System.out.println("\nValor Total Arrecadado: R$" + totalArrecadado);
    }

    private void identificarMaisAtendido() {
        int[] contagemTipoVeiculo = new int[NUM_TIPOS_VEICULO];
        int[] contagemTipoServico = new int[NUM_TIPOS_SERVICO];

        for (Cliente cliente : clientes) {
            contagemTipoVeiculo[cliente.tipoVeiculo - 1]++;
            contagemTipoServico[cliente.tipoServico - 1]++;
        }

        int tipoVeiculoMaisAtendido = encontrarIndiceMaximo(contagemTipoVeiculo) + 1;
        int tipoServicoMaisAtendido = encontrarIndiceMaximo(contagemTipoServico) + 1;

        System.out.println("\nTipo de Veículo Mais Atendido: " + tipoVeiculoMaisAtendido);
        System.out.println("Tipo de Serviço Mais Atendido: " + tipoServicoMaisAtendido);
    }

    private int encontrarIndiceMaximo(int[] array) {
        int indiceMaximo = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[indiceMaximo]) {
                indiceMaximo = i;
            }
        }
        return indiceMaximo;
    }
}

public class LavaCarro {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de atendimentos que serão processados: ");
        int numAtendimentos = scanner.nextInt();

        LavacaoCarros lavacaoCarros = new LavacaoCarros(numAtendimentos);
        lavacaoCarros.realizarAtendimentos();
        lavacaoCarros.mostrarRelatorio();

        scanner.close();
    }
}

