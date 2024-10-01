package java.SimpleJavaCode.src;
import java.util.Scanner;


public class aluno {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.print("Informe a quantidade de alunos (N): ");
        int N = input.nextInt();

        String[] nomes = new String[N];
        double[] notas1 = new double[N];
        double[] notas2 = new double[N];
        double[] notas3 = new double[N];
        double[] medias = new double[N];
        int aprovados = 0;
        int emRecuperacao = 0;
        int reprovados = 0;
        double maiorMedia = 0;
        String alunoMaiorMedia = "";

        for (int i = 0; i < N; i++) {
            System.out.print("Informe o nome do aluno " + (i + 1) + ": ");
            nomes[i] = input.next();
            System.out.print("Informe a nota 1 do aluno " + nomes[i] + ": ");
            notas1[i] = input.nextDouble();
            System.out.print("Informe a nota 2 do aluno " + nomes[i] + ": ");
            notas2[i] = input.nextDouble();
            System.out.print("Informe a nota 3 do aluno " + nomes[i] + ": ");
            notas3[i] = input.nextDouble();

            // Validar as notas para estar no intervalo de 0 a 10
            if (notas1[i] < 0 || notas1[i] > 10 || notas2[i] < 0 || notas2[i] > 10 || notas3[i] < 0 || notas3[i] > 10) {
                System.out.println("Notas fora do intervalo de 0 a 10. Por favor, insira notas válidas.");
                i--;
                continue;
            }

            // Calcula a média ponderada
            medias[i] = (notas1[i] + (notas2[i] * 3) + (notas3[i] * 5)) / 9;

            // Verifica a situação do aluno
            String situacao;
            if (medias[i] >= 6) {
                situacao = "Aprovado";
                aprovados++;
            } else if (medias[i] >= 4) {
                situacao = "Em recuperação";
                emRecuperacao++;
            } else {
                situacao = "Reprovado";
                reprovados++;
            }

            // Verifica a maior média
            if (medias[i] > maiorMedia) {
                maiorMedia = medias[i];
                alunoMaiorMedia = nomes[i];
            }

            System.out.println("Aluno: " + nomes[i]);
            System.out.println("Média: " + medias[i]);
            System.out.println("Situação: " + situacao);
        }

        // Calcula os percentuais de alunos aprovados, em recuperação e reprovados
        double percentualAprovados = (double) aprovados / N * 100;
        double percentualEmRecuperacao = (double) emRecuperacao / N * 100;
        double percentualReprovados = (double) reprovados / N * 100;

        System.out.println("Média geral da turma: " + calcularMediaGeral(medias));
        System.out.printf("Percentual de Aprovados: %.2f%%\n", percentualAprovados);
        System.out.printf("Percentual de Em Recuperação: %.2f%%\n", percentualEmRecuperacao);
        System.out.printf("Percentual de Reprovados: %.2f%%\n", percentualReprovados);
        System.out.println("Maior média: " + maiorMedia + " do aluno " + alunoMaiorMedia);

        input.close();
    }

    public static double calcularMediaGeral(double[] medias) {
        double soma = 0;
        for (double media : medias) {
            soma += media;
        }
        return soma / medias.length;
    }
}
