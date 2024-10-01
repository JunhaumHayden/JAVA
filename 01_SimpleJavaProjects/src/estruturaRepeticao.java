package java.SimpleJavaCode.src;
import java.util.Scanner;

public class estruturaRepeticao 
{
  public static void main(String[] args) 
    {

        Scanner scan = new Scanner(System.in);

        int count = 0;
        for (;count < 10;)
        {
            System.out.println("Valor de count: " + count);
            count +=2;
        }
    }    
}
