/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.tds.tso.teste.ml.mavenproject1;

/**
 *
 * @author Professor
 */
public class Compra {
    
    private Double valor;
    
    public boolean freteGratis() {
        return this.valor>150;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
   
}
