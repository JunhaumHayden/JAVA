/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Veiculo {
    private int id;
    private String placa;
    private String observacoes;
    private Modelo modelo;
    private Cor cor;

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    private Cliente cliente;

    public void setId(int id) {
        this.id = id;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }
    
    private List<Veiculo>veiculos = new ArrayList<>();
   
    

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor() {
        this.cor = new Cor();
    }

    public Veiculo( ) {
    }

    public Veiculo(int id, String placa, String observacoes, Modelo modelo, Cor cor) {
        this.id = id;
        this.placa = placa;
        this.observacoes = observacoes;
        this.modelo = modelo;
        this.cor = cor;
    }

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public Veiculo(String placa, Modelo modelo) {
        this.placa = placa;
        this.modelo = modelo;
    }

    public int getIdModelo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdCor() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdModelo(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdCor(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   }

   


    

