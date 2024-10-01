package java.SimpleJavaCode.src;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Trabalho02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Item03 - Os dados dos clientes deverão ser armazenados em vetores.
        List<String> nomes = new ArrayList<>();
        List<Integer> tiposVeiculo = new ArrayList<>();
        List<Integer> tiposServico = new ArrayList<>();
        List<Double> valoresPagos = new ArrayList<>();

        // item01 - solicitar no início a quantidade de atendimentos que serão processados.

        System.out.print("Digite a quantidade de atendimentos que serão processados: ");
        int numAtendimentos = scanner.nextInt();

        //item02 - A cada atendimento deverão ser solicitados:

        for (int i = 0; i < numAtendimentos; i++) {
           cadastrarNovoAtendimento(scanner, nomes, tiposVeiculo, tiposServico, valoresPagos); 
        }
        // item04 - Ao final, apresentar
        System.out.println("\n\n*********EXEMPLOS DE USO******\n\n");
        mostrarRelatorio(nomes, tiposVeiculo, tiposServico, valoresPagos);
        calcularEApresentarPercentuais(tiposVeiculo, tiposServico, "Tipo do Veículo");
        calcularEApresentarPercentuais(tiposVeiculo, tiposServico, "Tipo de Serviço");
        exibirRelatorios(nomes, tiposVeiculo, tiposServico, valoresPagos);
        System.out.println("\n########################\n\n");

        // Itens adicionais:

        int opcao;
        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next(); // Limpar o buffer
        }
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    mostrarRelatorio(nomes, tiposVeiculo, tiposServico, valoresPagos);
                    break;
                case 2:
                    calcularEApresentarPercentuais(tiposVeiculo, tiposServico, "Tipo do Veículo");
                    break;
                case 3:
                    calcularEApresentarPercentuais(tiposVeiculo, tiposServico, "Tipo de Serviço");
                    break;
                    case 4:
                    exibirRelatorios(nomes, tiposVeiculo, tiposServico, valoresPagos);
                    break;
                case 5:
                    cadastrarNovoAtendimento(scanner, nomes, tiposVeiculo, tiposServico, valoresPagos);
                    break;
                case 0:
                    System.out.println("O programa será finalizado!\n\nVolte Sempre!");
                    break;
                default:
                    System.out.println("Opção incorreta!!!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // ****Funcoes do menu principal****
    // Para listar todos os clientes cadastrados
    private static void mostrarRelatorio(List<String> nomes, List<Integer> tiposVeiculo,
                                         List<Integer> tiposServico, List<Double> valoresPagos) {
        System.out.println("\nRelação Geral dos Clientes:");
        for (int i = 0; i < nomes.size(); i++) {
            System.out.println("Nome: " + nomes.get(i) +
                    ", Tipo do Veículo: " + getDescricaoTipoVeiculo(tiposVeiculo.get(i)) +
                    ", Tipo do Serviço: " + getDescricaoTipoServico(tiposServico.get(i)) +
                    ", Valor Pago: R$" + valoresPagos.get(i));
        }
    }

    // Para calcular o percentual de atendimento - Recebe como ultimo argumento o tipo que se deseja calcular "Tipo do Veículo" ou "Tipo de Serviço" 
    private static void calcularEApresentarPercentuais(List<Integer> tiposVeiculo, List<Integer> tiposServico,
                                                       String descricaoTipo) {
        int[] contagemTipos = new int[3];

        for (int i = 0; i < tiposVeiculo.size(); i++) {
            if (descricaoTipo.equals("Tipo do Veículo")) {
                contagemTipos[tiposVeiculo.get(i) - 1]++;
            } else if (descricaoTipo.equals("Tipo de Serviço")) {
                contagemTipos[tiposServico.get(i) - 1]++;
            }
        }

        int totalAtendimentos = tiposVeiculo.size();

        System.out.println("\nPercentuais dos Atendimentos pelo " + descricaoTipo + ":");
        for (int i = 0; i < 3; i++) {
            double percentual = (contagemTipos[i] * 100.0) / totalAtendimentos;
            if (descricaoTipo.equals("Tipo do Veículo")) {
                System.out.println(descricaoTipo + ": " + getDescricaoTipoVeiculo(i + 1) + ": " + percentual + "%");
            } else if (descricaoTipo.equals("Tipo de Serviço")) {
                System.out.println(descricaoTipo + ": " + getDescricaoTipoServico(i + 1) + ": " + percentual + "%");
            }
            
        }
    }

    // Para apresenta relatorio gerencial
    private static void exibirRelatorios(List<String> nomes, List<Integer> tiposVeiculo,
                                     List<Integer> tiposServico, List<Double> valoresPagos) {
        System.out.println("\n###########  Relatotio de atividade  #############\n\n");
        calcularEApresentarTotalArrecadado(valoresPagos);
        identificarMaisAtendido(tiposVeiculo, tiposServico);
    }

    // Para realizar novo cadastro de clientes
    private static void cadastrarNovoAtendimento(Scanner scanner, List<String> nomes,
                                                 List<Integer> tiposVeiculo, List<Integer> tiposServico, List<Double> valoresPagos) {

        System.out.println("Atendimento " + (nomes.size() + 1));
        System.out.print("Nome do cliente: ");
        nomes.add(scanner.next());

        int tipoVeiculo;
    do {
        System.out.print("Tipo do veículo (1 - Pequeno / 2 - Médio / 3 - Grande): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next(); // Limpar o buffer
        }
        tipoVeiculo = scanner.nextInt();
    } while (tipoVeiculo < 1 || tipoVeiculo > 3);
    tiposVeiculo.add(tipoVeiculo);

    int tipoServico;
    do {
        System.out.print("Tipo de serviço (1 - Lavação externa / 2 - Lavação externa + interna / 3 - Lavação externa + interna + cera): ");
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            scanner.next(); // Limpar o buffer
        }
        tipoServico = scanner.nextInt();
    } while (tipoServico < 1 || tipoServico > 3);
    tiposServico.add(tipoServico);

        valoresPagos.add(calcularValorPago(tipoVeiculo, tipoServico));
        //realizarAtendimento(scanner, nomes, tiposVeiculo, tiposServico, valoresPagos);
        System.out.println("Novo atendimento cadastrado!");
    }

    // **** Funcoes auxiliares****
    // Para determinar o valor de acordo com o tipo veiculo x servico
    private static double calcularValorPago(int tipoVeiculo, int tipoServico) {
        double[][] tabelaValores = {
                {30, 50, 70},
                {50, 70, 90},
                {70, 90, 110}
        };

        return tabelaValores[tipoVeiculo - 1][tipoServico - 1];
    }
    //Para calcular o total arrecadado
    private static void calcularEApresentarTotalArrecadado(List<Double> valoresPagos) {
        double totalArrecadado = 0;
        for (double valor : valoresPagos) {
            totalArrecadado += valor;
        }
        System.out.println("\nValor Total Arrecadado: R$" + totalArrecadado);
    }
    //Para ordenar pelo maior atendimento
    private static void identificarMaisAtendido(List<Integer> tiposVeiculo, List<Integer> tiposServico) {
        int[] contagemTipoVeiculo = new int[3];
        int[] contagemTipoServico = new int[3];

        for (int i = 0; i < tiposVeiculo.size(); i++) {
            contagemTipoVeiculo[tiposVeiculo.get(i) - 1]++;
            contagemTipoServico[tiposServico.get(i) - 1]++;
        }

        int tipoVeiculoMaisAtendido = encontrarIndiceMaximo(contagemTipoVeiculo) + 1;
        int tipoServicoMaisAtendido = encontrarIndiceMaximo(contagemTipoServico) + 1;

        System.out.println("\nTipo de Veículo Mais Atendido: " + getDescricaoTipoVeiculo(tipoVeiculoMaisAtendido));
        System.out.println("Tipo de Serviço Mais Atendido: " + getDescricaoTipoServico(tipoServicoMaisAtendido));
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
    // Retornar a descricao do tipo de veiculo
    private static String getDescricaoTipoVeiculo(int tipoVeiculo) {
        switch (tipoVeiculo) {
            case 1:
                return "Pequeno";
            case 2:
                return "Médio";
            case 3:
                return "Grande";
            default:
                return "";
        }
    }
    // Retornar a descricao do tipo de servico
    private static String getDescricaoTipoServico(int tipoServico) {
        switch (tipoServico) {
            case 1:
                return "Lavação externa";
            case 2:
                return "Lavação externa + interna";
            case 3:
                return "Lavação externa + interna + cera";
            default:
                return "";
        }
    }
    // Exibe as opcoes do menu
    private static void exibirMenu() {
        System.out.println("\nMENU:");
        System.out.println("1 - Relação Geral dos Clientes");
        System.out.println("2 - Percentuais dos Atendimentos pelo Tipo do Veículo");
        System.out.println("3 - Percentuais dos Atendimentos pelo Tipo de Serviço");
        System.out.println("4 - Relatórios");
        System.out.println("5 - Cadastrar novo atendimento");
        System.out.println("0 - Sair do programa");
    }
  
}
