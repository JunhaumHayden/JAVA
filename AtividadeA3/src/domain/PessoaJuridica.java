package domain;

import java.util.Date;

public class PessoaJuridica extends Cliente {
    private String cnpj;
    private String inscricaoEstadual;

    // Construtor
    public PessoaJuridica(String nome, String celular, String email, Date dataCadastro, Pontuacao pontuacao, String cnpj, String inscricaoEstadual) {
        super(nome, celular, email, dataCadastro, pontuacao);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    // Métodos getters e setters para os atributos específicos de Pessoa Jurídica
    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    @Override
    public String addVeiculos(Veiculos veiculo) {
        return super.addVeiculos(veiculo);
    }

    @Override
    public void removeVeiculos(Veiculos veiculo) {
        super.removeVeiculos(veiculo);
    }
    // Sobrescrita do método toString para incluir os atributos adicionais
    @Override
    public String toString() {
        return "CLIENTE:\nPessoaJuridica: " + 
        "\ncnpj=" + cnpj + 
        "\ninscricaoEstadual=" + inscricaoEstadual + 
        super.toString();
    }
}

