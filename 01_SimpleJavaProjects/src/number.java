package java.SimpleJavaCode.src;
import java.util.Scanner;

public class number 
{
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);

        boolean flag01 = false;
        String nameUser, passwdUser;

        do
        {
            System.out.println("Informe um Usuario: ");
            nameUser = scan.next();

            System.out.println("Informe uma Senha: ");
            passwdUser = scan.next();

            if (nameUser.equalsIgnoreCase(passwdUser))
            {
                System.out.println("Senhas iguais, tente novamente!: ");
            }
            else 
            {
                flag01 = true;
                System.out.println("Valor valido: ");
            }

        }
        while (!flag01);


    }
}
