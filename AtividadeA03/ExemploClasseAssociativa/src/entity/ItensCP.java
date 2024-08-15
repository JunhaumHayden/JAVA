/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author mpisching
 */
public class ItensCP {
    private float txDesconto;
    private double precoCalculado;
    
    private Produto produto;
    private CupomFiscal cupomFiscal;
    
    public double calcularPreco() {
        this.precoCalculado = produto.getPreco() - (produto.getPreco() * txDesconto / 100);
        return this.precoCalculado;
    }

    public float getTxDesconto() {
        return txDesconto;
    }

    public void setTxDesconto(float txDesconto) {
        this.txDesconto = txDesconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public CupomFiscal getCupomFiscal() {
        return cupomFiscal;
    }

    public void setCupomFiscal(CupomFiscal cupomFiscal) {
        this.cupomFiscal = cupomFiscal;
    }
    
    
}
