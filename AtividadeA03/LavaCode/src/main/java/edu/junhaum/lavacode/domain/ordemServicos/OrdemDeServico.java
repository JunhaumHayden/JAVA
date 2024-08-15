package edu.junhaum.lavacode.domain.ordemServicos;

import edu.junhaum.lavacode.domain.veiculos.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


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

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda) {
        this.agenda = agenda;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        if (status == EStatus.FECHADA){
            int totalPontos = 0;
            for (ItemOS item : itens) {
                totalPontos += item.getServico().getPontos();
            }
            this.veiculo.getCliente().getPontuacao().adicionarPontos(totalPontos);

        }
        this.status = status;
    }

    public List<ItemOS> getItens() {
        return itens;
    }

    public Veiculos getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculos veiculo) {
        this.veiculo = veiculo;
    }

    // Métodos
    public double calcularServico() {
        double totalServico = 0.0;
        for (ItemOS item : itens) {
            totalServico += item.getValorServico();
        }
        this.total = totalServico - (totalServico * (desconto / 100));
        return this.total;
    }

    public void addItemOS(ItemOS itemOS) {
        this.itens.add(itemOS);
        calcularServico();
    }

    public void removeItemOS(ItemOS itemOS) {
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

