package edu.junhaum.lavacode.domain.clientes;

import edu.junhaum.lavacode.domain.veiculos.*;
import edu.junhaum.lavacode.domain.*;

import java.util.Date;

/**
* <h1>Pessoa Fisica</h1>
* Classe para tratar de clientes pessoa fisica.<br>
* E uma das especializações da classe Cliente e deve implementar os Métodos abstratos das superclasses. 
* 
*
* 
* @author  Junhaum Hayden
* @version 1.0
* @since   07/08/2024
* 
*/
public class PessoaFisica extends Cliente {
    private String cpf;
    private Date dataNascimento;

    //construtor sobrecarregado
    /**
     * Cria um cliente com as informaçoes obrigatorias e garante que nao seja criado cliente sem informacoes.
     *
     * @param super trata dos atributos da superclasse.
     * @param cpf O numero do cpf valido do cliente
     * @param dataNascimento A data de nascimento do cliente.
     * 
     * 
     */
    public PessoaFisica(String nome, String celular, String email, Pontuacao pontuacao, String cpf, Date dataNascimento) {
        super(nome, celular, email, pontuacao);
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

    /**
     * A classe PessoaFisica herda de Cliente e deve fornecer a implementação do método getDados(String observacao).
     *
     * @param Observacao A Observacao que se dejesa inserir no retorno dos dados
     * @return As informaçoes referentes ao cliente.
     */
    @Override
    public String getDados(String observacao) {
        return  "CLIENTE:\n"+ this.getClass() + 
        "\n cpf=" + getCpf() + 
        "\n dataNascimento=" + getDataNascimento() + "\n" +
        super.getDados() + "\n\nObservação: " + observacao;
    }

    // Sobrescrita do método toString para incluir os atributos adicionais
    @Override
    public String toString() {
        return  "CLIENTE:\n"+ this.getClass() + 
        "\ncpf=" + getCpf() + 
        "\ndataNascimento=" + getDataNascimento() + 
        super.toString();
    }
    

}

