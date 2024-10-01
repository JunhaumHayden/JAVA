/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sentinel
 */
public class OrdemDeServico {
    private long numero;
    private double total;
    private Date agenda;
    private double desconto;
    private EStatus status;
    private List<ItemOS> itensOS = new ArrayList<>();
    private Cliente cliente;

    public OrdemDeServico(long numero, double desconto, EStatus status) {
        this.numero = numero;
        this.desconto = desconto;
        this.status = status;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Date getAgenda() {
        return agenda;
    }

    public void setAgenda(Date agenda) {
        this.agenda = agenda;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public EStatus getStatus() {
        return status;
    }

    public void setStatus(EStatus status) {
        this.status = status;
    }

    public List<ItemOS> getItensOS() {
        return itensOS;
    }

    public void setItensOS(List<ItemOS> itensOS) {
        this.itensOS = itensOS;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    public void addItemOS(ItemOS item) {
        itensOS.add(item);
    }

    public void removeItemOS(ItemOS item) {
        itensOS.remove(item);
    }

    private static class ItemOS {

        public ItemOS() {
        }
    }

   
   
}


    
    
   