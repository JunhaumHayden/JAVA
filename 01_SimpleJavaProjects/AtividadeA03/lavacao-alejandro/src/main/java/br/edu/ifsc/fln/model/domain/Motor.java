/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

/**
 *
 * @author Aluno
 */
class Motor {
    private int potencia;
   private ETipoCombustivel combustivel;
   
  

    public Motor(int potencia) {
        this.potencia = potencia;
    }

    public void setCombustivel(ETipoCombustivel combustivel) {
        this.combustivel = combustivel;
    }
   

    public ETipoCombustivel getCombustivel() {
        return combustivel;
    }

    public Motor(int potencia, ETipoCombustivel combustivel) {
        this.potencia = potencia;
        this.combustivel = combustivel;
    }
   
   

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Motor() {
    }

    @Override
    public String toString() {
        return "Motor{" + "potencia=" + potencia + ", combustivel=" + combustivel + '}';
    }

    
    
}


