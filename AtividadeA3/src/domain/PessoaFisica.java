package domain;

import java.util.Date;

public class PessoaFisica extends Cliente {
    private String cpf;
    private Date dataNascimento;

    // Construtor
    public PessoaFisica(String nome, String celular, String email, Date dataCadastro, Pontuacao pontuacao, String cpf, Date dataNascimento) {
        super(nome, celular, email,dataCadastro, pontuacao);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    // Métodos getters e setters para os atributos específicos de Pessoa Física
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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
        return  "CLIENTE:\nPessoaFisica: "+ 
        "\ncpf=" + getCpf() + 
        "\ndataNascimento=" + getDataNascimento() + 
        super.toString();
    }

}

