import java.util.InputMismatchException;
import java.util.Scanner;

/**
    * <h1>Tratamento de Exceções</h1>
    * Tratando exceçoes no Java com as principais tecnicas
    * <p>
    * Este código garantirá que o usuário insira as informações corretas antes de prosseguir, repetindo a solicitação em caso de erro e permitindo a correção imediata das entradas.
    * <b>Note:</b> Leia atentamente a documentação desta classes
    * para desfrutar dos recursos oferecidos pelo autor
    *</p>
    * @author  Carlos Hayden
    * @version 1.0
    * @since   01/06/2024
*/

public class AboutMe 
    /**
        * <h1> Metodo AboutMe </h1>
        * Este método é utilizado para simular erros simples para analise.
        * Serão pedidos 4 informações, 2 strings e 2 numericos
    */
{
    private static Scanner scanner =  new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        /** 
            * <h2> Variáveis de Entrada </h2>
            * Declare as variáveis fora do loop while para que possam ser usadas após o loop.
        */
        String nome = null;
        String sobrenome = null;
        int idade = 0;
        double altura = 0;
        /**
            * <h2> Loop while </h2>
            * Usado um loop while com uma variável @pa `flag` para controlar a repetição do pedido de informações.
            * No início do loop, captura-se todas as entradas do usuário.
        */
        boolean flag = false;
        while (!flag)
        {
            /**
            * <h2> Try </h2>
            * A instrução `try` permite que definir um bloco de código para ser testado.
            * Nele contém o bloco de código com a execução esperada
            * Neste exemplo, Solicita e lê as informações do usuário.
            * Se todas as informações forem capturadas com sucesso, define `flag` como true para sair do loop.
            */
            try 
            {
                System.out.println("Informe um nome: ");
                nome = scanner.nextLine();
                System.out.println("Informe um sobrenome: ");
                sobrenome = scanner.nextLine();
                System.out.println("Informe a idade: ");
                idade = scanner.nextInt();
                //int idade = Integer.valueOf(scanner.nextInt());
                System.out.println("Informe a altura: ");
                altura = scanner.nextDouble();
                //double altura = Double.valueOf(scanner.nextDouble());
                // Se chegou até aqui, a entrada é válida
                flag = true;
            }
            /**
            * <h2> Catch </h2>
            * A instrução `catch` permite definir um bloco de código a ser executado, caso ocorra um erro no bloco `try`. 
            * O bloco de codigo que captura as excecoes de fluxos não previsto.
            * Precisa-se saber qual a excecao ocorre.
            * No exemplo teve-se a exceção `InputMismatchException`
            * Exiba uma mensagem de erro e use scanner.nextLine() para limpar o buffer do scanner, permitindo que o loop repita e solicite as informações novamente.
            */
            catch (InputMismatchException e)
            {
                System.out.println("Os campos 'idade' e 'altura' precisam ser numéricos. Por favor, tente novamente.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
        /**
            * <h2> Saída do Loop</h2>
            * Após o loop, exibir as informações coletadas.
         */
        System.out.println("O nome é: " + nome + " " + sobrenome );
        System.out.println("Idade de: " + idade);
        System.out.println("Altura de: " + altura + "cm ");
    }
}
