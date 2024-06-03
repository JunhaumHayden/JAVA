import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExcecao 
{
    public static void main(String[] args) 
    {
        Exececao01();  
        
        //Exececao02();
            
        
    }

    private static void Exececao01() 
    {
        Number valor = Double.valueOf("a1.75");
            System.out.println(valor);
    }
    // public static void Exececao02()
    // {
    //     Number valor = Double.valueOf("a1.75");

    //     valor = NumberFormat.getInstance().parse("a1.75");
        
    //     System.out.println(valor);
    // }
}
