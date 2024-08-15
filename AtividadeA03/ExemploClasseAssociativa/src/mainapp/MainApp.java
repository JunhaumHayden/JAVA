/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapp;

import datasource.ProdutoDS;
import entity.CupomFiscal;
import entity.ItensCP;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author mpisching
 */
public class MainApp {
    private static SimpleDateFormat sdfData = new SimpleDateFormat("dd/MM/yyyy");
    private static SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm");

    public static void main(String[] args) {
        
        ProdutoDS.iniciliazar();
        
        System.out.println("Produto: " + (ProdutoDS.get(1)).getDados());
        
        System.out.println(ProdutoDS.listagem());
        
        //criando o cupom fiscal
        Date dia = new Date();
        CupomFiscal cf = new CupomFiscal(1, dia, dia);
        //definindo os itens do cp
        ItensCP item1 = new ItensCP();
        item1.setProduto(ProdutoDS.get(3));
        cf.add(item1);
        ItensCP item2 = new ItensCP();
        item2.setProduto(ProdutoDS.get(2));
        cf.add(item2);
        
        //imprimindo o cupom fiscal
        imprimir(cf);
    }
    
    private static void imprimir(CupomFiscal cf) {
        System.out.println(cf.imprimir());
    }
}
