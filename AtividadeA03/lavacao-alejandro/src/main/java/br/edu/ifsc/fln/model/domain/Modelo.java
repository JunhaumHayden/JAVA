/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

/**
 *
 * @author Aluno
 */
public class Modelo {
   
    private String descricao;
    private int id;
    private Marca marca;
    private ECategoria categoria;
    private Motor motor;

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public void setCategoria(ECategoria categoria) {
        this.categoria = categoria;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public Modelo(String descricao, Marca marca, ECategoria categoria, Motor motor) {
        this.descricao = descricao;
        this.marca = marca;
        this.categoria = categoria;
        this.motor = motor;
    }

   
    
    

    public Marca getMarca() {
        return marca;
    }

    public ECategoria getCategoria() {
        return categoria;
    }

    public Motor getMotor() {
        return motor;
    }
    
    
   

    public Modelo(String descricao, int id, ECategoria categoria) {
        this.descricao = descricao;
        this.id = id;
        this.categoria = categoria;
    }
    
    

    public Modelo() {
    }

    public Modelo(String descricao, int id, Motor motor) {
        this.descricao = descricao;
        this.id = id;
        this.motor = motor;
    }
    
    

    public Modelo(String descricao, int id) {
        this.descricao = descricao;
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Modelo{" + "descricao=" + descricao + ", id=" + id + ", categoria=" + categoria + '}';
    }

    public int getIdMarca() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void setIdMarca(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
    
}
   
