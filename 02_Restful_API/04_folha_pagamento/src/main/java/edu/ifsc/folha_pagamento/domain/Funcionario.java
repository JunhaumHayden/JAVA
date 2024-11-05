package edu.ifsc.folha_pagamento.domain;

/**
 * Classe Funcionario para representar os dados de entrada.
 * Esta classe conterá as informações do funcionário, como nome, salário base e número de dependentes.
 * 
 * @author Hayden
 */

public class Funcionario {
    private String nome;
    private double salarioBase;
    private int numeroDependentes;

    //Contructor
    public Funcionario(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Funcionario(String nome, double salarioBase, int numeroDependentes) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.numeroDependentes = numeroDependentes;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getNumeroDependentes() {
        return numeroDependentes;
    }

    public void setNumeroDependentes(int numeroDependentes) {
        this.numeroDependentes = numeroDependentes;
    }
}

