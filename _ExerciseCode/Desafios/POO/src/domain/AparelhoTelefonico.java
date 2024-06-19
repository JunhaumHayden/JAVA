package domain;

import java.util.Random;

public class AparelhoTelefonico 
{
    public void ligar(String numero)
    {
        System.out.println("Ligando para "+ numero + ".");
        entrandoEmContato(numero);
    }
    
    public void atender()
    {
        System.out.println("Atendendo a chamada.");
    }
    public void iniciarCorreioVoz()
    {
        System.out.println("Iniciando correio de voz.");
    }
    //Metodos auxiliares
     static boolean chamar()
    {
        return new Random().nextInt(3)==1;
    }
    static boolean entrandoEmContato(String numero)
    {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do
        {
            atendeu = chamar();
            continuarTentando =!atendeu;
            if(continuarTentando)
            {
                System.out.println(tentativasRealizadas + " toque.");
                temporizar(2000);  // Pausa de 2 segundos
                tentativasRealizadas++;
            }else
            {
                System.out.println("Chamada estabelecida com sucesso!!!");
            }
        }while(continuarTentando && tentativasRealizadas<3);
        if (atendeu) 
        {
            System.out.println("Contato com " + numero + " na tentativa numero: " + tentativasRealizadas); 
            return true;  
        }else 
        {
            System.out.println("Nao foi possivel contato com o numero " + numero + ", Sem atendimento.");
            return false;
        }

    }
    // Método de temporização
    static void temporizar(int milissegundos) {
        try {
            Thread.sleep(milissegundos);
        } catch (InterruptedException e) {
            System.err.println("Erro na temporização: " + e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
