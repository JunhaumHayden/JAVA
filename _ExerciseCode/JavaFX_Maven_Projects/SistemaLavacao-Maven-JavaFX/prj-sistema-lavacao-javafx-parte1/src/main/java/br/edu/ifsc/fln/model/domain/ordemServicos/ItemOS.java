package br.edu.ifsc.fln.model.domain.ordemServicos;

import java.math.BigDecimal;

/**
* Classe para vincular um item de servico com a ordem de servico.<br>
* 
* @author  Junhaum Hayden
* @version 1.0
* @since   07/08/2024
* 
*/

public class ItemOS {
    private String observacao;
    private BigDecimal valorServico;
    private Servico servico;
    private OrdemDeServico ordemDeServico;

    // Construtores
    //private ItemOS() {}
    //construtor sobrecarregado
    /**
     * Cria um item de OS vinculando um servico a uma ordem de servico e armazena o valor do servico para ser usado na Ordem de Servico.
     *
     * @param observacao String com uma observacao referente a algo pertimente ao serviço.
     * @param servico Um objeto do tipo Servico será vinculado a uma Ordem de Servico.
     * @param ordemDeServico Um objeto do tipo Ordem de Servico será vinculado a um Servico.
     * 
     */
    public ItemOS(String observacao, Servico servico) {
        this.observacao = observacao;
        this.servico = servico;
        this.valorServico = servico.getValor();
    }

    // Getters e Setters
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public BigDecimal getValorServico() {
        return valorServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
        this.valorServico = servico.getValor();
    }

    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }

    void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    @Override
    public String toString() {
        return  "\n       Servico.........:" + servico +
                "\n       Valor do Servico: R$" + valorServico +
                "\n       Observacao......:" + observacao + "\n"
                ;
    }

    
}

