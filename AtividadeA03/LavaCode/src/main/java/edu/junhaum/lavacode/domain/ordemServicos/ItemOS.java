package edu.junhaum.lavacode.domain.ordemServicos;

public class ItemOS {
    private String observacao;
    private Double valorServico;
    private Servico servico;
    private OrdemDeServico ordemDeServico;

    // Construtores
    public ItemOS() {}

    public ItemOS(String observacao, Servico servico, OrdemDeServico ordemDeServico) {
        this.observacao = observacao;
        this.servico = servico;
        this.ordemDeServico = ordemDeServico;
        this.valorServico = servico.getValor();
    }

    // Getters e Setters
    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getValorServico() {
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

    @Override
    public String toString() {
        return  "\n       Servico.........:" + servico +
                "\n       Valor do Servico: R$" + valorServico +
                "\n       Observacao......:" + observacao + "\n"
                ;
    }

    
}

