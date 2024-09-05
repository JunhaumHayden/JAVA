package edu.junhaum.lavacode.mainapp;

import edu.junhaum.lavacode.DataSource.DataSource;
import edu.junhaum.lavacode.domain.ordemServicos.*;
import edu.junhaum.lavacode.exceptions.ExceptionLavacao;
import edu.junhaum.lavacode.report.ImpressaoOS;
import edu.junhaum.lavacode.report.Relatorio;


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
     * @see DataSource
     * @see mostraOS
     */
    public static void main(String[] args) 
    {
        DataSource.carregarDados();
        
        


        // Criando uma ordem de serviço
        try{
            OrdemDeServico ordemDeServico10 = new OrdemDeServico(10, DataSource.getVeiculo(6)); // 10% de desconto
            OrdemDeServico ordemDeServico20 = new OrdemDeServico(0, DataSource.getVeiculo(4)); 
            OrdemDeServico ordemDeServico30 = new OrdemDeServico(20, DataSource.getVeiculo(5)); // 20% de desconto
            OrdemDeServico ordemDeServico40 = new OrdemDeServico(0, DataSource.getVeiculo(8));
            // Adicionando itens à ordem de serviço
            ordemDeServico10.addItemOS(new ItemOS("Notas de Observacao 11",
            DataSource.getServicos(6)));
            ordemDeServico10.addItemOS(new ItemOS("Notas de Observacao 12",
            DataSource.getServicos(11)));
            ordemDeServico10.addItemOS(new ItemOS("Notas de Observacao 13",
            DataSource.getServicos(16)));
            ordemDeServico10.addItemOS(new ItemOS("Notas de Observacao 14",
            DataSource.getServicos(21)));
            ordemDeServico30.addItemOS(new ItemOS("Notas de Observacao 30",
            DataSource.getServicos(1)));
            ordemDeServico20.addItemOS(new ItemOS("Notas de Observacao 20",
            DataSource.getServicos(1)));
            ordemDeServico40.addItemOS(new ItemOS("Notas de Observacao 40",
            DataSource.getServicos(1)));
            //Exibindo 
            mostraOS(ordemDeServico30);
            mostraOS(ordemDeServico10);
        } catch (ExceptionLavacao e) {
            System.out.println(e.getMessage());
        }
        
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
     * @param OrdemDeServico Recebe um objeto do tipo ordem de Serviço
     * @return void
     */
     public static void mostraOS (OrdemDeServico os){
            // Instanciando um cupom
            ImpressaoOS cupom = new ImpressaoOS(os);
            Relatorio relatorio = new Relatorio(os.getVeiculo().getCliente());

            // Exibindo os detalhes da ordem de serviço
            try{
                printing("Inicando OS...\n\nDetalhes da Ordem de Serviço: ");
                System.out.println(cupom.imprimirOS());

                printing("Adicionando um servico: ");
                os.addItemOS(new ItemOS("Novo Servico solicitado pelo cliente",
                DataSource.getServicos(23)));
                
                os.addItemOS(new ItemOS("  ",
                DataSource.getServicos(13)));
                
                System.out.println(cupom.imprimirOS());

                printing("Detalhamento dos Dados do Cliente referente a OS: ");
                System.out.println("Detalhes do Cliente: ");
                System.out.println(relatorio.imprimirCliente());
                printing("Alterando Status da OS:");
                os.setStatus(EStatus.FECHADA);
                printing("Ordem de Serviço Fechada: ");
                System.out.println(cupom.imprimirOS());
                printing("Detalhamento dos Dados do Cliente após fechar a OS: ");
                System.out.println("Detalhes do Cliente: ");
                System.out.println(relatorio.imprimirCliente());
            } catch (ExceptionLavacao e) {
                System.out.println(e.getMessage());
            }
            
        }
}
