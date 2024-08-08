package edu.junhaum.lavacode.domain.ordemServicos;

import edu.junhaum.lavacode.domain.veiculos.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

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
     *
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
     * Cria um cliente com as informaçoes obrigatorias e chama, automaticamente o construtor padrao para gerar o ID de cliente unico.
     *
     * @param nome Nome completo do cliente
     * @param celular O numero do celular do cliente
     * @param email email valido do cliente
     * @param pontuacao Realiza uma composiçao com um objeto Pontuacao
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

    public void setTotal(Double total) {
        this.total = total;
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
        this.status = status;
    }

    public List<ItemOS> getItens() {
        return itens;
    }

    public  getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
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
     * 
     * 
     */
    private String gerarNumeroOrdem() {
        String dataHora = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss").format(new Date());
        String numeroUnico;
        numeroUnico = String.format("%05d", random.nextInt(100000));
        return dataHora + "/" + numeroUnico;
    }

    @Override
    public String toString() {
        return  "ORDEM DE SERVICO=" + 
                "\nnumero=" + numero +
                "\n   total=" + total +
                "\n   desconto=" + desconto +
                "\n   agenda=" + agenda +
                "\n   status=" + status +
                "\n   itens=" + itens +
                "\nVeiculo=" + veiculo +
                "\n\n";
    }
}
