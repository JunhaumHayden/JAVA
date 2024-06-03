import java.text.NumberFormat;
import java.text.ParseException;

public class ExemploExcecao 
{
    public static void main(String[] args) 
    {
        ExemploRunTimeException();  
        ExemploException();
    }

    private static void ExemploRunTimeException()
    //  RunTimeException determina que a excecao precisa ocorrer para ser tratada.
    // IDE não apresenta sugestoes apresentendo erro somente na execução.
    // O metodo valueOf(String s) throws (dispara a excecao) NumberFormatException.
    // class NumberFormatException extends IllegalArgumentException
    // e a class IllegalArgumentException extends RuntimeException
    {
        Number valor = Double.valueOf("a1.75");
        System.out.println(valor);
    }
    public static void ExemploException()
    //  Exception determina que a excecao precisa ser tratada antes de ocorrer. 
    // ou seja, IDE indica erro e segere tratar utilizando try / catch
    // Number valor = NumberFormat.getInstance().parse("a1.75");
    // System.out.println(valor);
    // O metodo parse(String source) throws ParseException
    // e a class ParseException extends Exception
    {
        Number valor;
        try {
            valor = NumberFormat.getInstance().parse("a1.75");
            System.out.println(valor);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        
    }
}
