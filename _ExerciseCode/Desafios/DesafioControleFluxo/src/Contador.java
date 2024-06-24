package java._ExerciseCode.Desafios.DesafioControleFluxo.src;
// Contador.java
import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) 
    {
        Scanner terminal = new Scanner(System.in);
        while (true) 
        {
            try {
                System.out.println("Digite o primeiro parâmetro (ou 0 para sair):");
                int parametroUm = terminal.nextInt();
                if (parametroUm == 0) break;

                System.out.println("Digite o segundo parâmetro (ou 0 para sair):");
                int parametroDois = terminal.nextInt();
                if (parametroDois == 0) break;

                // Chamando o método contendo a lógica de contagem
                contar(parametroUm, parametroDois);

            } catch (ParametrosInvalidosException e) {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Os parâmetros devem ser números inteiros.");
                terminal.next(); // Limpa o buffer do scanner
            }
        }

        terminal.close();
        System.out.println("Programa encerrado.\nVolte sempre que precisar!!!");
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        // Validar se parametroUm é MAIOR que parametroDois e lançar a exceção
        if (parametroUm > parametroDois) {
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        int contagem = parametroDois - parametroUm;
        // Realizar o for para imprimir os números com base na variável contagem
        for (int i = 1; i <= contagem; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
