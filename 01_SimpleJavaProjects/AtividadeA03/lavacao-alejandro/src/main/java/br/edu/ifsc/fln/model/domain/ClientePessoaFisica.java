/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Sentinel
 */
public class ClientePessoaFisica extends Cliente {
    private String cpf;
    private Date dataNascimento;

   
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
    public String toString() {
        return "ClientePessoaFisica{" + "cpf=" + cpf + ", dataNascimento=" + dataNascimento + '}';
    }
    
    @Override
    public String getDados() {
        StringBuilder sb = new StringBuilder();
       sb.append(super.getDados());
        sb.append("CPF.......: ").append(cpf).append("\n");
        sb.append("Data de nascimento.....: ").append(dataNascimento).append("\n");
        return sb.toString();        
    }
    
    
    
}
