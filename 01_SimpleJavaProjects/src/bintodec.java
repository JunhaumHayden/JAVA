package java.SimpleJavaCode.src;
/*
Aluno: Carlos Benedito hayden de Albuquerque Junior
Turma: CTDS 2023-2

Desenvolva um programa para ler 8 dígitos binários armazenando-os em um vetor com 8 posições e apresente o valor decimal correspondente.
Obs.: os dígitos binários podem ser gerados randomicamente.

*/


import java.util.Random;
import java.util.Scanner;

public class bintodec {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int[] vetorBinario = new int[8];

        System.out.println("-----------------------------------------------------------------\nDigite em binário (do mais significativo para o menos significativo) \nou pressione Enter para gerar randomicamente\n***********************************\n\n");

        // Ler dígitos binários ou gerar randomicamente
        for (int i = 0; i < 8; i++) {
            System.out.println("Digite o número binário da " + (8 - i) + "° posição ou pressione Enter para gerar randomicamente:");
            String entrada = input.nextLine().trim();
            

            if (entrada.isEmpty()) {
                
                vetorBinario[i] = random.nextInt(2); // Gera 0 ou 1 randomicamente
                
            } else if (entrada.matches("[01]")) {
                vetorBinario[i] = Integer.parseInt(entrada);
            } else {
                System.out.println("Entrada inválida. Digite apenas 0 ou 1.");
                i--; // Decrementa o índice para ler novamente
            }
        }

        // Apresentar o valor decimal correspondente
        int valorDecimal = 0;
        for (int i = 0; i < 8; i++) {
            valorDecimal += vetorBinario[i] * Math.pow(2, 7 - i);
        }

        System.out.print("Dígitos binários: ");
        for (int binario : vetorBinario) {
            System.out.print(binario);
        }

        System.out.println("\nValor decimal correspondente: " + valorDecimal);

        input.close();
    }
}
