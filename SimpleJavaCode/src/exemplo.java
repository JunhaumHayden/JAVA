package java.SimpleJavaCode.src;
import java.util.Scanner;

public class exemplo 
{
    public static void main(String[] args) 
    {

        Scanner scan = new Scanner(System.in);


        System.out.println("Digite seu nome completo: ");
        String nameFull = scan.nextLine();  
        System.out.println("O nome completo é: " + nameFull);

        System.out.println("Digite seu primeiro nome: ");
        String nameFirst = scan.next();
        System.out.println("O primeiro nome é: " + nameFirst);

        System.out.println("Digite a idade: ");
        int age = scan.nextInt();
        System.out.println("a idade é: " + age);


        String name01, name02;
        System.out.print("Nome 01: ");
        name01 = scan.next();
        System.out.print("Nome 02: ");
        name02 = scan.next();

        if (name01.equals(name02))
        System.out.println("Os nomes são iguais");
        else
        System.out.println("Os nomes são diferentes");

        double valor = 2.90;
        System.out.println(valor);
        float valorr = 2.90f;
        System.out.print(valorr);

    }

    
    
}
