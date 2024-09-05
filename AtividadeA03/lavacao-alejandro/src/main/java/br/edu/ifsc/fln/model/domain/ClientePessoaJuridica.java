/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author Sentinel
 */
public class ClientePessoaJuridica extends Cliente {
    
    private String cnpj;
    private String inscricaoEstadual;

    public ClientePessoaJuridica(int id, String nome, String celular, String email, LocalDate dataCadastro, int pontuacao, List<Veiculo> veiculos) {
        super(id, nome, celular, email, dataCadastro, pontuacao, veiculos);
    }
    
    

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

    public ClientePessoaJuridica() {
        
    }

    public ClientePessoaJuridica(String inscricaoEstadual, int id, String nome) {
        super(id, nome);
        this.inscricaoEstadual = inscricaoEstadual;
    }

    
    public ClientePessoaJuridica(int id, String nome, String celular, String email, LocalDate dataCadastro, int pontuacao) {
        super(id, nome, celular, email, dataCadastro, pontuacao);
    }

    public ClientePessoaJuridica(String cnpj, String inscricaoEstadual, int id, String nome) {
        super(id, nome);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }
    
    
    


    @Override
    public String toString() {
        return super.toString() +  "PessoaJuridica{" + "cnpj=" + cnpj + ", inscricaoEstadual=" + inscricaoEstadual + '}';
    }

    @Override
    public String getDados() {
       StringBuilder sb = new StringBuilder();
       sb.append(super.getDados());
       sb.append("CNPJ.......: ").append(cnpj).append("\n");
       sb.append("Inscricao Estadual.....: ").append(inscricaoEstadual).append("\n");
       return sb.toString();        
    }
    
    
    
    
    
    
    
    
    
    
   
    
}
