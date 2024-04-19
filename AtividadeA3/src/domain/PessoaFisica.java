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

    // Sobrescrita do método toString para incluir os atributos adicionais
    @Override
    public String toString() {
        return super.toString() + "\nPessoaFisica: "+ "\ncpf=" + getCpf() + "\ndataNascimento=" + getDataNascimento();
    }

}

