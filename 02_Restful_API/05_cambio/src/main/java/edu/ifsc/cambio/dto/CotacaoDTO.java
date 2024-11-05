package edu.ifsc.cambio.dto;

public class CotacaoDTO {
    private String moeda;
    private double compra;
    private double venda;

    public CotacaoDTO(String moeda, double compra, double venda) {
        this.moeda = moeda;
        this.compra = compra;
        this.venda = venda;
    }

    public String getMoeda() {
        return moeda;
    }

    public double getCompra() {
        return compra;
    }

    public double getVenda() {
        return venda;
    }
}

