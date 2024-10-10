import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe Transacao representa a entidade do domínio
class Transacao {
    private List<Double> transacoes;
    /*
     * Constructor
     */
    public Transacao(List<Double> transacoes) {
        this.transacoes = transacoes;
    }

    public List<Double> getTransacoes() {
        return transacoes;
    }
}

// Classe AnaliseTransacoesUseCase contém a lógica do caso de uso
class AnaliseTransacoesUseCase {
    public String analisar(Transacao transacao) {
        List<Double> transacoes = transacao.getTransacoes();
        double saldoFinal = 0;
        double maiorDeposito = Double.MIN_VALUE; // Para encontrar o maior depósito
        double maiorRetirada = Double.MAX_VALUE; // Para encontrar a maior retirada
        /*
         * Implemente a condição para a análise das transações
         */
        
        for (Double valor : transacoes) {
            saldoFinal += valor;  // Atualiza o saldo final com base no valor da transação

            // Se for um depósito (valor positivo), atualiza maiorDeposito
            if (valor > 0 && valor > maiorDeposito) {
                maiorDeposito = valor;
            }

            // Se for uma retirada (valor negativo), atualiza maiorRetirada
            if (valor < 0 && valor < maiorRetirada) {
                maiorRetirada = valor;
            }
        }

        // Se não houve depósitos, ajusta maiorDeposito para 0
        if (maiorDeposito == Double.MIN_VALUE) {
            maiorDeposito = 0;
        }

        // Se não houve retiradas, ajusta maiorRetirada para 0
        if (maiorRetirada == Double.MAX_VALUE) {
            maiorRetirada = 0;
        }

        /*
         * // Construindo a saída de forma adequada e como solicitado na descrição do desafio:
         */
        String resultado = String.format("Saldo: %.2f%n", saldoFinal);
        resultado += String.format("Deposito: %.2f%n", maiorDeposito);
        resultado += String.format("Retirada: %.2f%n", maiorRetirada);
        resultado += saldoFinal >= 0 ? "Saldo positivo" : "Saldo negativo";
        return resultado;
    }
}

// Classe principal que funciona como interface de entrada/saída e execução do caso de uso
public class AnaliseTransacoes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Leitura do número de transações
        int numeroTransacoes = scanner.nextInt();

        // Leitura das transações
        List<Double> transacoes = new ArrayList<>();
        for (int i = 0; i < numeroTransacoes; i++) {
            transacoes.add(scanner.nextDouble());
        }

        // Criação da entidade Transacao
        Transacao transacao = new Transacao(transacoes);

        // Criação e execução do caso de uso
        AnaliseTransacoesUseCase useCase = new AnaliseTransacoesUseCase();
        String resultado = useCase.analisar(transacao);

        // Saída do resultado
        System.out.println(resultado);

        scanner.close();
    }
}
