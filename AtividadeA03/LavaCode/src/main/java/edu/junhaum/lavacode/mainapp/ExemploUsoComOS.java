package edu.junhaum.lavacode.mainapp;

import edu.junhaum.lavacode.DataSource.DataSource;
import edu.junhaum.lavacode.domain.ordemServicos.*;


/**
* Classe para verificar a implementação do pacote OrdemServico.<br>
* A classe estancia as OS e vincula um veiculo e adiciona os itens de OS. 
*
* 
* @author  Junhaum Hayden
* @version 1.0
* @since   14/08/2024
* 
*/
public class ExemploUsoComOS 
{
    /**
     * * Cria os dados necessários as OS e realiza as movimentaçoes de testes.
     * 
     * @see  DataSource
     * @see mostraOS
     */
    public static void main(String[] args) 
    {
        DataSource.carregarDados();
        //  // Exemplo de uso
        // printing("\nIniciando Programa...\n");
        // // Exemplo de uso da classe PessoaFisica
        // printing("Instanciando Pessoa Fisicao... \n");
        
        // printing("Numero de Clientes: " + DataSource.getClienteLenth());
        // System.out.println("Listando...");
        // for (int i = 0; i <= DataSource.getClienteLenth(); i++){
        //     System.out.println(DataSource.getCliente(i));
        // }

        // // Exemplo de uso da classe PessoaJuridica
        // printing("Instanciando Pessoa Juridica... \n");
        // printing("Numero de Clientes: " + DataSource.getClienteLenth());
        // System.out.println("Listando...");
        // for (int i = 0; i <= DataSource.getClienteLenth(); i++){
        //     System.out.println(DataSource.getCliente(i));
        // }

        // // Exemplo de uso da classe veiculos
        // printing("Instanciando Veiculos... \n");
        // printing("Numero de Veiculos: " + DataSource.getVeiculosLenth());
        // System.out.println("Listando...");
        // for (int i = 0; i <= DataSource.getVeiculosLenth(); i++){
        //     System.out.println("\n  "+ (i+1) + " : " + DataSource.getVeiculo(i));
        // }
       
        // // Exemplo de uso da classe servico
        // printing("Instanciando servicos... \n");
        // printing("Numero de Servicos: " + DataSource.getServicosLenth());
        // System.out.println("Listando...");
        // for (int i = 0; i <= DataSource.getServicosLenth(); i++){
        //     System.out.println("\n  "+ (i+1) + " : " + DataSource.getServicos(i));
        // }
        

        // Criando uma ordem de serviço
        OrdemDeServico ordemDeServico10 = new OrdemDeServico(0, DataSource.getVeiculo(6)); // 10% de desconto
        OrdemDeServico ordemDeServico20 = new OrdemDeServico(0, DataSource.getVeiculo(4)); 
        OrdemDeServico ordemDeServico30 = new OrdemDeServico(20, DataSource.getVeiculo(6)); 
        OrdemDeServico ordemDeServico40 = new OrdemDeServico(0, DataSource.getVeiculo(8));

        
         // Adicionando itens à ordem de serviço
         ordemDeServico10.addItemOS(new ItemOS("Retorna as 11",
         DataSource.getServicos(6),ordemDeServico10));
         ordemDeServico10.addItemOS(new ItemOS("Retorna as 12",
         DataSource.getServicos(11),ordemDeServico10));
         ordemDeServico10.addItemOS(new ItemOS("Retorna as 13",
         DataSource.getServicos(16),ordemDeServico10));
         ordemDeServico10.addItemOS(new ItemOS("Retorna as 14",
         DataSource.getServicos(21),ordemDeServico10));
         ordemDeServico30.addItemOS(new ItemOS("Retorna as 30",
         DataSource.getServicos(1),ordemDeServico10));
         ordemDeServico20.addItemOS(new ItemOS("Retorna as 20",
         DataSource.getServicos(1),ordemDeServico10));
         ordemDeServico40.addItemOS(new ItemOS("Retorna as 40",
         DataSource.getServicos(1),ordemDeServico10));
         
         
        mostraOS(ordemDeServico40);

         

        
    }
     
     private static void printing(String string)
     {
         System.out.println("*********************");
         System.out.println(string);
         System.out.println("\n----------------\n");
     }

     /**
     * * Funçao que realiza as movimentacoes das OS e imprime os resultados.
     * 
     * @param OrdemDeServico Recebe uma ordem de Serviço
     */
     public static void mostraOS (OrdemDeServico os)
         {

         
        // Calculando o total da ordem de serviço
        os.calcularServico();

        // Exibindo os detalhes da ordem de serviço
        printing("\n\n\n#############################");
        System.out.println("Detalhes da Ordem de Serviço: " + os);

        os.setStatus(EStatus.FECHADA);
        System.out.println("Ordem de Serviço Fechada: \n" + os);
        System.out.println("Detalhes do Cliente: " + os.getVeiculo().getCliente());
        
        
         }
}
