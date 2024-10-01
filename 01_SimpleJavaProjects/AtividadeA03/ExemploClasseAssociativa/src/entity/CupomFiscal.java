/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author mpisching
 */
public class CupomFiscal {
    private int codigo;
    private Date data;
    private Date hora;
    
    private List<ItensCP> itensCP = new ArrayList<>();

    public CupomFiscal(int codigo, Date data, Date hora) {
        this.codigo = codigo;
        this.data = data;
        this.hora = hora;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }
    
    public void add(ItensCP item){
        itensCP.add(item);
        item.setCupomFiscal(this);
    } 
    
    public String imprimir() {
        SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");
        StringBuilder sb = new StringBuilder();
        sb.append("     CUPOM FISCAL     ").append("\n");
        sb.append("----------------------").append("\n");
        sb.append(sdfData.format(data)).append("  ").
                append(sdfHora.format(hora)).
                append("    COD:").append(codigo).append("\n");
        sb.append("----------------------").append("\n");
        for (ItensCP item: itensCP) {
            sb.append(item.getProduto().getDados()).append("\n");
        }
        sb.append("----------------------").append("\n");
        sb.append("Total: ").append(totalizar());
        return sb.toString();
    }
    
    private double totalizar() {
        double total = 0.0;
        for (ItensCP item: itensCP) {
            total += item.getProduto().getPreco();
        }
        return total;
    }
}
