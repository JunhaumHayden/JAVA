                                                                                            /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sentinel
 */
public abstract class Cliente
        extends Object
        implements ICliente{

    private int id;
    private String nome;
    private String celular;
    private String email;
    private LocalDate dataCadastro;
    private int pontuacao;
  
    private static int totalClientes = 0;
    
    private List<Veiculo> veiculos = new ArrayList<>();

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    
    

    public Cliente(int id, String nome, String celular, String email, LocalDate dataCadastro, int pontuacao, List<Veiculo> veiculos) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.pontuacao = pontuacao;
        this.veiculos = veiculos;
        
    }

    public static int getTotalClientes() {
        return totalClientes;
    }
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void add(Veiculo veiculo) {
        this.veiculos.add(veiculo);
        
    }

    public void remove(Veiculo veiculo) {
        veiculos.remove(veiculo);
        veiculo.setCliente(null);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Cliente(String nome, int pontuacao) {
        this.nome = nome;
        this.pontuacao = pontuacao;
    }
    
    

    public Cliente() {

        createPontuacao(pontuacao);
    }

    public Cliente(int id, String nome, String celular, String email, LocalDate dataCadastro, int pontuacao) {
        this.id = id;
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.pontuacao = pontuacao;
    }

    private void createPontuacao(int pontuacao) {

    }
    
     @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nome=" + nome + ", celular=" + celular + ", email=" + email + ", dataCadastro=" + dataCadastro + ", pontuacao=" + pontuacao + '}';
    }

    @Override
    public String getDados() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dados do cliente:.......").append("\n");
        sb.append("Nome.......: ").append(nome).append("\n");
        sb.append("Celular.......: ").append(celular).append("\n");
        sb.append("Email......: ").append(email).append("\n");
        sb.append("Data de cadastro.......: ").append(dataCadastro).append("\n");
        return sb.toString();
    }


    @Override
    public String getDados(String observacao) {
        return observacao;
    }
   

}
