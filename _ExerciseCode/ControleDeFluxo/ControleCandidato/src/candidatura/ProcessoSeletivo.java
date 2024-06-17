package candidatura;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;   

public class ProcessoSeletivo 
{
    public static void main(String[] args) 
    {
        System.out.println("Processo Seletivo");
        selecaoCandidatos();
    }

    //Metodos auxiliares
    //Método para simular o valor pretendido. Escolhendo um valor aleatório entre 1800 e 2200
    static double valorpretendido()
    {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }
    //Metodo para imprimir uma lista de candidatos
    static void imprimirSelecionados( List<String> selecionados)
    {
        System.out.println("A lista de candidatos selecionados é: ");
        for (int i = 0; i < selecionados.size(); i++) {
            System.out.println("O candidato nº " + (i + 1) + " é " + selecionados.get(i));
        }    
    }
    //Metodo para simular o atendimento de uma ligacao
    static boolean atender()
    {
        return new Random().nextInt(3)==1;
    }

    
    static void selecaoCandidatos()
    {
        String [] candidatos = {"Ana","Bia","Clara","Dani","Emmy","Fabi","Gestrudes","Helga","Ilma","Julia"};
        int quantidadeSelecionados = 0;
        int candidatoAtual = 0;
        // Criando uma lista dinâmica de strings de candidatos selecionados
        List<String> candidatosSelecionados = new ArrayList<>();
        double salarioBase = 2000.0;
        while (quantidadeSelecionados < 5 && candidatoAtual < candidatos.length) 
        {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorpretendido();
            System.out.println("O candidato " + candidato + " solicitou o salario de " + salarioPretendido);
            boolean atendeu = analisarCandidato(salarioPretendido, candidato);
            if (salarioBase >= salarioPretendido && atendeu) 
            {
                System.out.println("O candidato " + candidato + " Foi Selecionado!\n");
                candidatosSelecionados.add(candidato);
                quantidadeSelecionados++;
            }else if (salarioBase >= salarioPretendido && !atendeu) 
            {
                System.out.println("O candidato " + candidato + " Foi Selecionado, mas nao atendeu a ligacao!\n");
            }
            candidatoAtual++;   
        }
        imprimirSelecionados(candidatosSelecionados);
    }

    static boolean analisarCandidato(double salarioPretendido, String candidato)
    {
        double salarioBase = 2000.00;
        if (salarioBase > salarioPretendido)
        {
            System.out.println("Ligar para o candidato");
            boolean atendeu = entrandoEmContato(candidato);
            if (atendeu) 
            {
                return true;
            }else
            {
                return false;
            }
        } else if(salarioBase == salarioPretendido)
        {
            System.out.println("Ligar para o candidato com contra proposta\n");
            boolean atendeu = entrandoEmContato(candidato);
            if (atendeu) 
            {
                return true;
            }else
            {
                return false;
            }
        }else 
        {
            System.out.println("Aguardando o resultado dos demais candidatos\n");
            return false;
        }
    }

    static boolean entrandoEmContato(String candidato)
    {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do
        {
            atendeu = atender();
            continuarTentando =!atendeu;
            if(continuarTentando)
            {
                tentativasRealizadas++;
            }else
            {
                System.out.println("Contato Realizado com sucesso!!!");
            }
        }while(continuarTentando && tentativasRealizadas<3);
        if (atendeu) 
        {
            System.out.println("Conseguimos contato com " + candidato + " na tentativa numero: " + tentativasRealizadas); 
            return true;  
        }else 
        {
            System.out.println("Nao foi possivel contato com o candidato " + candidato + ", numero maximo de tentativas");
            return false;
        }

    }



    
} 