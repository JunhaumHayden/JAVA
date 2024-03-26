import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import domain.Aluno;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Aluno> listaAlunos = new ArrayList<>();

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

            Aluno estudante = new Aluno(matricula, nome, cpf, notas);
            estudante.exibirDados();
            
            listaAlunos.add(estudante); //Adicionar em uma lista

            imprimir(listaAlunos);

        }



        scanner.close();
    }
    //Imprimir a lista
    public static void imprimir(List<Aluno> lista) {
        for (Aluno a: lista) {
            System.out.println("Aluno: " + a);
            a.exibirDados();
        }
    }
}