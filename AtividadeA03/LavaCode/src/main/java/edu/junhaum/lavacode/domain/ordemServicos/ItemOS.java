package edu.junhaum.lavacode.domain.ordemServicos;

public class ItemOS {
    private String observacao;
    private Double valorServico;
    
    private Servico servico;
    private OrdemDeServico ordemDeServico;

    // Construtores
    public ItemOS() {}

    public ItemOS(String observacao, Double valorServico, Servico servico, OrdemDeServico ordemDeServico) {
        this.observacao = observacao;
        this.valorServico = valorServico;
        this.servico = servico;
        this.ordemDeServico = ordemDeServico;
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

    public void setValorServico(Double valorServico) {
        this.valorServico = valorServico;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public OrdemDeServico getOrdemDeServico() {
        return ordemDeServico;
    }

    public void setOrdemDeServico(OrdemDeServico ordemDeServico) {
        this.ordemDeServico = ordemDeServico;
    }

    @Override
    public String toString() {
        return "ItemOS{" +
                "observacao='" + observacao + '\'' +
                ", valorServico=" + valorServico +
                ", servico=" + servico +
                '}';
    }

    
}

