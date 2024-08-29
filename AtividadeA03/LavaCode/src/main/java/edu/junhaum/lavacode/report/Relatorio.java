package edu.junhaum.lavacode.report;

import java.util.Date;

import edu.junhaum.lavacode.domain.clientes.Cliente;
import edu.junhaum.lavacode.domain.clientes.PessoaFisica;
import edu.junhaum.lavacode.domain.clientes.PessoaJuridica;
import edu.junhaum.lavacode.domain.veiculos.Veiculos;

import java.text.SimpleDateFormat;


public class Relatorio {
    private Cliente imprimirEsteCliente;

    // Construtor
    public Relatorio (Cliente cliente) {
        this.imprimirEsteCliente = cliente;
    }

    // Getters and Settenrs
    public Cliente getImprimirCliente() {
        return imprimirEsteCliente;
    }

    public void setImprimirCliente(Cliente imprimirCliente) {
        this.imprimirEsteCliente = imprimirCliente;
    }
    
    // 
    public String imprimirCliente() 
    {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        StringBuilder geraos = new StringBuilder();
        Date dataAtual = new Date();

        // Cabeçalho do cupom fiscal
        geraos.append("+++++++++++++++++++++++++++++++++++++").append("\n");
        geraos.append("    LAVACODE LAVACAO SA     ").append("\n");
        geraos.append("  Rua dos Anzois Carapulça, 1350     ").append("\n\n\n");
        geraos.append("    Relatorio de Cliente     ").append("\n");
        geraos.append("-------------------------------------").append("\n");

        // Data, hora e número da OS
        geraos.append("NOME          : ").append(imprimirEsteCliente.getNome()).append("\n");
        geraos.append("TELEFONE      : ").append(imprimirEsteCliente.getCelular()).append("\n");
        geraos.append("EMAIL         : ").append(imprimirEsteCliente.getEmail()).append("\n");
        geraos.append("DATA CADASTRO : ").append(sdfData.format(imprimirEsteCliente.getDataCadastro())).append("  ")
              .append(sdfHora.format(imprimirEsteCliente.getDataCadastro())).append("\n");
        geraos.append("PONTOS ACUMULADOS: ").append(imprimirEsteCliente.getPontuacao().getSaldo()).append("\n");
        // Imprimindo de acordo com a instancia do cliente
        if (imprimirEsteCliente instanceof PessoaFisica)
        {
            geraos.append("CPF           : "+ ((PessoaFisica)imprimirEsteCliente).getCpf()).append("\n");
            if (((PessoaFisica)imprimirEsteCliente).getVeiculos().size() == 0) 
            {
                geraos.append("    Veiculos: Sem Veiculos Cadastrados").append("\n");
            } 
            else {
                geraos.append("-------------------------------------").append("\n");
                geraos.append("            VEICULO                  ").append("\n");
                for (Veiculos veiculo : ((PessoaFisica)imprimirEsteCliente).getVeiculos() )
                {
                    geraos.append("PLACA: ").append(veiculo.getPlaca()).append("\n");
                    geraos.append("       ").append(veiculo.getModelo().getMarca().getNome()).append(" ").append(veiculo.getModelo().getDescricao()).append(" ").append(veiculo.getCor().getNome()).append("\n");
                    geraos.append("CATEGORIA  : ").append(veiculo.getModelo().getCategoria().getDescricao()).append("\n");
                    geraos.append("OBSERVACOES: ").append(veiculo.getObservacoes()).append("\n\n");
                } 
            }
        }else{
                geraos.append("CNPJ       : "+ ((PessoaJuridica)imprimirEsteCliente).getCnpj()).append("\n");
                if (((PessoaJuridica)imprimirEsteCliente).getVeiculos().size() == 0) 
                {
                    geraos.append("    Veiculos: Sem Veiculos Cadastrados").append("\n");
                } 
                else {
                    geraos.append("-------------------------------------").append("\n");
                    geraos.append("            VEICULO                  ").append("\n");
                    for (Veiculos veiculo : ((PessoaJuridica)imprimirEsteCliente).getVeiculos() )
                    {
                        geraos.append("PLACA: ").append(veiculo.getPlaca()).append("\n");
                        geraos.append(veiculo.getModelo().getMarca().getNome()).append(" ").append(veiculo.getModelo().getDescricao()).append(" ").append(veiculo.getCor().getNome()).append("\n");
                        geraos.append(veiculo.getModelo().getCategoria().getDescricao()).append("\n");
                        geraos.append("OBSERVACOES: ").append(veiculo.getObservacoes()).append("\n\n");
                        
                    } 
                }
            }
        geraos.append("-------------------------------------").append("\n");
        geraos.append(sdfData.format(dataAtual)).append(" ")
              .append(sdfHora.format(dataAtual)).append(" ").append("Caixa: 03").append(" ").append("Oper: Katia").append("\n\n\n");
        geraos.append("+++++++++++++++++++++++++++++++++++++").append("\n");

        return geraos.toString();
    }
}
