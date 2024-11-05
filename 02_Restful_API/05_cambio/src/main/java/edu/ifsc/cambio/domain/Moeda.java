package edu.ifsc.cambio.domain;

public class Moeda {
    private String tipo;
    private double compra;
    private double venda;

    public Moeda(String tipo, double compra, double venda) {
        this.tipo = tipo;
        this.compra = compra;
        this.venda = venda;
    }

    public String getTipo() {
        return tipo;
    }

    public double getCompra() {
        return compra;
    }

    public double getVenda() {
        return venda;
    }
}

