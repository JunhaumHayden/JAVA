package java.SimpleJavaCode.src;
// Ler duas matrizes A e B de números inteiros com N linhas e N colunas, onde N deve ser lido no início do programa. Construir uma matriz C de mesma dimensão, sendo que C é formada pelo produto dos elementos da matriz A e B.
Apresentar as matrizes A, B e C.

// Obs.: as matrizes A e B podem ser geradas aleatoriamente.

import java.util.Random;
import java.util.Scanner;

public class MultiplicacaoMatrizes 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor de N para as dimensões das matrizes: ");
        int N = scanner.nextInt();

        // Criar matrizes A e B com valores aleatórios
        int[][] A = gerarMatrizAleatoria(N);
        int[][] B = gerarMatrizAleatoria(N);

        // Criar matriz C
        int[][] C = new int[N][N];

        // Calcular a matriz C multiplicando A e B
        for (int i = 0; i < N; i++) 
        {
            for (int j = 0; j < N; j++) {
                C[i][j] = A[i][j] * B[i][j];
            }
        }

        // Exibir matrizes A, B e C
        System.out.println("Matriz A:");
        exibirMatriz(A);

        System.out.println("\nMatriz B:");
        exibirMatriz(B);

        System.out.println("\nMatriz C (Produto de A e B):");
        exibirMatriz(C);

       
    }

    // Função para gerar uma matriz aleatória com valores inteiros
    private static int[][] gerarMatrizAleatoria(int dimensao) {
        int[][] matriz = new int[dimensao][dimensao];
        Random random = new Random();

        for (int i = 0; i < dimensao; i++) 
        {
            for (int j = 0; j < dimensao; j++) {
                matriz[i][j] = random.nextInt(10); // Valores aleatórios entre 0 e 9
            }
        }

        return matriz;
    }

    // Função para exibir uma matriz
    private static void exibirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) 
        {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
