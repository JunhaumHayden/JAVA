package java.SimpleJavaCode.src;
/*Faça um programa para ler um número inteiro e gerar a tabuada (de 1 até 10) desse número.

Exemplo: 5
Saída:
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50
Após gerar a tabuada, o programa deverá perguntar: "Deseja a tabuada de outro número (S/N)?", que só deve aceitar S/N/s/n. Caso a resposta seja afirmativa, repetir o processo anterior.
*/

import java.util.Scanner;

public class tabuada 
{
 
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);

        int tabNumber;
        boolean flag01 = false;
        String answer;
        do
        {
            System.out.println("Informe um numero: ");
            tabNumber = scan.nextInt();
            System.out.println("A Tabuada de "+ tabNumber + " é: ");
            for (int i = 0; i <= 10; i++)
                {
                    System.out.println(tabNumber + " x " + i + " = " + (tabNumber * i));
                }
            System.out.println("Deseja a tabuada de outro número (S/N)?: ");
            answer = scan.next();
            if (answer.equalsIgnoreCase("s"))
                {
                    System.out.println("repetindo... ");
                }
            else if(answer.equalsIgnoreCase("n"))
                {
                    flag01 = true;
                    System.out.println("programa será Encerrado... ");
                }
            
            else 
                {
                    flag01 = true;
                    System.out.println("Entrada Inválida!!!");
                    System.out.println("Programa será encerrado por falha de inconsistencia de dados...");
                }            
                       
        }
        while(!flag01);
    }
    
}
