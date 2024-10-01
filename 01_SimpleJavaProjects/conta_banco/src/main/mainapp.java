package main;
import java.util.Scanner;
import domain.*;

public class mainapp 
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int conta = 1144;
        String agencia = "253614";
        String nomecliente;
        double saldo = 0;

        System.out.println("Por favor, digite o número da Agência!");
         agencia = scanner.nextLine();
        System.out.println("Por favor, digite o número da conta!");
        conta = scanner.nextInt();
        System.out.println("Por favor, digite o nome do cliente!");
        nomecliente = scanner.nextLine();
        System.out.println("Por favor, digite o saldo inicial!");
        saldo = scanner.nextDouble();

        BankAccount novaConta = new BankAccount(conta, agencia, nomecliente, saldo);

        // Exibição da mensagem final
        System.out.println(novaConta);


    }

}
