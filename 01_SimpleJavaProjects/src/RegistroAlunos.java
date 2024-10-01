package java.SimpleJavaCode.src;
import java.util.Scanner;

public class RegistroAlunos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de alunos a serem registrados: ");
        int numAlunos = scanner.nextInt();

        for (int i = 0; i < numAlunos; i++) {
            System.out.println("\nRegistro do Aluno " + (i + 1));
            System.out.print("Número da Matrícula: ");
            int matricula = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("CPF: ");
            String cpf = scanner.next();

            double[] notas = new double[3];
            for (int j = 0; j < 3; j++) {
                System.out.print("Nota " + (j + 1) + ": ");
                notas[j] = scanner.nextDouble();
            }

            Aluno aluno = new Aluno(matricula, nome, cpf, notas);
            aluno.exibirDados();
              
        }

        scanner.close();
    }
}

class Aluno {
    private int matricula;
    private String nome;
    private String cpf;
    private double[] notas;

    public Aluno(int matricula, String nome, String cpf, double[] notas) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.notas = notas;
    }

    public double calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public void exibirDados() {
        System.out.println("\nDados do Aluno:");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.println("Notas: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.println("  Nota " + (i + 1) + ": " + notas[i]);
        }
        System.out.println("Média: " + calcularMedia());
    }
}

