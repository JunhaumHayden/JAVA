package java._ExerciseCode.TerminalAndArgs.src;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class ScanneMe 
{
        //criando o objeto scanner
       /**
     * <h1> criando o objeto scanner </h1>
     * Para evitar o aviso de que o Scanner nunca é fechado e para garantir que os recursos associados ao Scanner sejam liberados corretamente, deve-se fechar o Scanner ao final de seu uso. Isso pode ser feito chamando o método `close()` no objeto Scanner. Uma abordagem comum é usar um bloco try-with-resources, que garante que o Scanner será fechado automaticamente quando o bloco for concluído.
     * Serão pedidas 4 informações, 2 strings e 2 numéricas
     */
    public static void main(String[] args) 
    {
        /**
         * <h2> Try-with-resources:  </h2>
         * Utiliza um bloco try-with-resources para inicializar o Scanner. Isso garante que o Scanner será fechado automaticamente ao final do bloco try, mesmo que uma exceção ocorra.
         * <h2> Fechamento automático: </h2>
         * O try-with-resources cuida do fechamento do Scanner, portanto, não é necessário chamá-lo explicitamente.
         */
        try (Scanner scanner = new Scanner(System.in)) 
        { // Try-with-resources
            System.out.println("Informe um nome: ");
            String nome = scanner.nextLine();
            System.out.println("Informe um sobrenome: ");
            String sobrenome = scanner.nextLine();
            System.out.println("Informe a idade: ");
            int idade = scanner.nextInt();
            System.out.println("Informe a altura: ");
            double altura = scanner.nextDouble();

            System.out.println("O nome é: " + nome + " " + sobrenome );
            System.out.println("Idade de: " + idade);
            System.out.println("Altura de: " + altura + "cm ");
        } catch (InputMismatchException e) 
        {
            System.out.println("Os campos precisam ser numéricos");
        }
    }
        
        
    
}
