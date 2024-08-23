package edu.junhaum.lavacode.report;

import java.util.Date;
import java.text.SimpleDateFormat;

import edu.junhaum.lavacode.domain.ordemServicos.EStatus;
import edu.junhaum.lavacode.domain.ordemServicos.ItemOS;
import edu.junhaum.lavacode.domain.ordemServicos.OrdemDeServico;

public class ImpressaoOS {
    private OrdemDeServico imprimirEstaOS;

    // Construtor
    public ImpressaoOS(OrdemDeServico imprimirEstaOS) {
        this.imprimirEstaOS = imprimirEstaOS;
    }

    // Getters and Settenrs
    public OrdemDeServico getImprimirEstaOS() {
        return imprimirEstaOS;
    }

    public void setImprimirEstaOS(OrdemDeServico imprimirEstaOS) {
        this.imprimirEstaOS = imprimirEstaOS;
    }
    // 
    public String imprimirOS() {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        StringBuilder geraos = new StringBuilder();
        Date dataAtual = new Date();

        // Cabeçalho do cupom fiscal
        geraos.append("+++++++++++++++++++++++++++++++++++++").append("\n");
        geraos.append("    LAVACODE LAVACAO SA     ").append("\n");
        geraos.append("  Rua dos Anzois Carapulça, 1350     ").append("\n\n\n");
        geraos.append("       CUPOM FISCAL     ").append("\n");
        geraos.append("-------------------------------------").append("\n");

        // Data, hora e número da OS
        geraos.append("NUM OS  : ").append(imprimirEstaOS.getNumero()).append("\n");
        geraos.append("SITUAÇÃO: ").append(imprimirEstaOS.getStatus()).append("\n");
        geraos.append("DATA OS : ").append(sdfData.format(imprimirEstaOS.getAgenda().getTime())).append("  ")
              .append(sdfHora.format(imprimirEstaOS.getAgenda())).append("\n");
        geraos.append("CLIENTE : ").append(imprimirEstaOS.getVeiculo().getCliente().getNome()).append("\n");
        geraos.append("VEICULO : ").append(imprimirEstaOS.getVeiculo().getPlaca()).append("\n");
        geraos.append("          ").append(imprimirEstaOS.getVeiculo().getModelo().getMarca().getNome()).append(" ").append(imprimirEstaOS.getVeiculo().getModelo().getDescricao()).append(" ").append(imprimirEstaOS.getVeiculo().getCor().getNome()).append("\n");
        geraos.append("-------------------------------------").append("\n");

        // Itens da Ordem de Serviço
        geraos.append("DESCRICAO            ").append("VALOR           ").append("OS                   ").append("OBS").append("\n");
        for (ItemOS item : imprimirEstaOS.getItens()) {
            geraos.append(item.getServico().getDescricao()).append(" - R$")
                  .append(String.format("%.2f", item.getValorServico())).append(" - ");
            geraos.append("OS: ").append(item.getOrdemDeServico().getNumero()).append(" - ");
            geraos.append("Observação: ").append(item.getObservacao()).append("\n");
        }
        geraos.append("-------------------------------------").append("\n");

        // Total e desconto
        double totalServico = 0.0;
        for (ItemOS item : imprimirEstaOS.getItens()) {
            totalServico += item.getValorServico();
        }
        geraos.append("Subtotal: R$ ").append(String.format("%.2f", totalServico)).append("\n");
        geraos.append("Desconto: R$ ").append(String.format("%.2f", imprimirEstaOS.getDesconto())).append("\n");

        // Total final
        if (imprimirEstaOS.getStatus() == EStatus.FECHADA)
        {
            geraos.append("Total   : R$ ").append(String.format("%.2f", imprimirEstaOS.getTotal())).append("\n");
        }else{ 
            double totalFinal = imprimirEstaOS.getTotal() - imprimirEstaOS.getDesconto();
            geraos.append("Total a ser pago: R$ ").append(String.format("%.2f", totalFinal)).append("\n");
        }
        int totalPontos = 0;
            for (ItemOS item : imprimirEstaOS.getItens()) {
                totalPontos += item.getServico().getPontos();
            }
        geraos.append("-------------------------------------").append("\n");
        geraos.append("Veja os pontos adquiridos nessa OS").append("\n").append("--Pontução--: ").append(totalPontos).append("\n");
        geraos.append("-------------------------------------").append("\n");
        geraos.append(sdfData.format(dataAtual)).append(" ")
              .append(sdfHora.format(dataAtual)).append(" ").append("Caixa: 03").append(" ").append("Oper: Katia").append("\n\n\n");
        geraos.append("+++++++++++++++++++++++++++++++++++++").append("\n");

        return geraos.toString();
    }


}

