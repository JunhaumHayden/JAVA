package edu.junhaum.lavacode.domain.ordemServicos;

import edu.junhaum.lavacode.exceptions.ExceptionLavacao;
import edu.junhaum.lavacode.domain.veiculos.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
* <h1>OrdemDeServico</h1>
* Classe para representar uma ordem de serviço no sistema de lavação.
* 
* @author Junhaum Hayden
* @version 1.0
* @since 07/08/2024
*/
public class OrdemDeServico {
    private String numero;
    private Double total;
    private float desconto;
    private Date agenda;
    private EStatus status;
    private List<ItemOS> itens;
    private Veiculos veiculo;
    private static final Random random = new Random();

    //construtor padrao
    /**
     * Instancia a lista de itens que irá compor a OS e o estado para Aberta 
     * @see gerarNumeroOrdem
     * 
     * 
     */
    private OrdemDeServico() {
        this.itens = new ArrayList<>();
        this.status = EStatus.ABERTA;
        this.numero = gerarNumeroOrdem();
        this.agenda = new Date();
    }

    //construtor sobrecarregado
    /**
     * Cria uma nova OS
     *
     * @param Desconto Pode haver um valor de desconto na OS
     * @param veiculo veiculo vinculado a OS
     * 
     */
    public OrdemDeServico(float desconto, Veiculos veiculo) {
        this();
        this.desconto = desconto;
        this.veiculo = veiculo;
    }

    // Getters e Setters
    public String getNumero() {
        return numero;
    }

    public Double getTotal() {
        return total;
    }

    public float getDesconto() {
        return desconto;
    }

    public void setDesconto(float desconto) throws ExceptionLavacao {
        if (this.status == EStatus.FECHADA) {
            throw new ExceptionLavacao("OS Fechada não pode ser alterada.");
        }
        this.desconto = desconto;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda)throws ExceptionLavacao {
        if (this.status == EStatus.FECHADA) {
            throw new ExceptionLavacao("OS Fechada não pode ser alterada.");
        }
        this.agenda = agenda;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) throws ExceptionLavacao {
        if (this.status == EStatus.FECHADA) {
            throw new ExceptionLavacao("OS Fechada não pode ser alterada.");
        }
        if (status == EStatus.FECHADA){
            int totalPontos = 0;
            for (ItemOS item : itens) {
                totalPontos += item.getServico().getPontos();
            }
            this.veiculo.getCliente().getPontuacao().adicionarPontos(totalPontos);
            double totalServico = 0.0;
            for (ItemOS item : itens) {
                totalServico += item.getValorServico();
            }
            this.total = totalServico - (desconto);

        }
        this.status = status;
    }

    public List<ItemOS> getItens() {
        return itens;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) throws ExceptionLavacao {
        if (this.status == EStatus.FECHADA) {
            throw new ExceptionLavacao("OS Fechada não pode ser alterada.");
        }
        if (this.veiculo != null) {
            throw new ExceptionLavacao("OS já esta vinculada ao veiculo " + this.getVeiculo().getPlaca());
        }
        this.veiculo = veiculo;
    }

    // Métodos
    public double calcularServico() {
        double totalServico = 0.0;
        for (ItemOS item : itens) {
            totalServico += item.getValorServico();
        }
        this.total = totalServico;
        return this.total;
    }

    public void addItemOS(ItemOS itemOS) throws ExceptionLavacao {
        if (this.status == EStatus.FECHADA) {
            throw new ExceptionLavacao("OS Fechada não pode ser alterada.");
        }
        itemOS.setOrdemDeServico(this); // Vincula a ordem de serviço ao item
        this.itens.add(itemOS);
        calcularServico();
    }

    public void removeItemOS(ItemOS itemOS) throws ExceptionLavacao {
        if (this.status == EStatus.FECHADA) {
            throw new ExceptionLavacao("OS Fechada não pode ser alterada.");
        }
        this.itens.remove(itemOS);
        calcularServico();
    }

    /**
     * Gerador de numero de OS
     * Gera a parte da data e hora no formato yyyy/MM/dd-H:mm.
     * Gera um número único de 5 dígitos usando um Random.
     * Combina a data/hora com o número único para formar o número completo da ordem de serviço.
     * @param null
     * @return Retorna uma String formando um numero unico de cada OS.
     * 
     */
    private String gerarNumeroOrdem() {
        String dataHora = new SimpleDateFormat("yyyy.MMdd-HHmmss").format(new Date());
        String numeroUnico;
        numeroUnico = String.format("%05d", random.nextInt(100000));
        return dataHora + "/" + numeroUnico;
    }
    public void interarSobreItensOS(){
        for (ItemOS itemOS : itens){
            itemOS.toString();
        }
    }

    @Override
    public String toString() {
        return  "\nORDEM DE SERVICO:" + 
                "\n  numero: " + numero +
                "\n  Total da OS: R$" + total +
                "\n     desconto:" + desconto +
                "\n     agenda:" + agenda +
                "\n     status:" + status +
                "\n     ITENS:" +   getItens() 
                +
                "\nVeiculo=" + veiculo +
                "\n\n";
    }
}

