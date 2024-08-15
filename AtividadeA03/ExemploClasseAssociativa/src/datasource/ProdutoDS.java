/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import entity.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mpisching
 */
public class ProdutoDS {
    private static List<Produto> lista = new ArrayList<>();
    
    public static void iniciliazar() {
        lista.add(new Produto(1, "Ração a", 50.0));
        lista.add(new Produto(2, "Ração b", 65.00));
        lista.add(new Produto(3, "Vacina a", 90.0));
    }
    
    public static Produto get(int id) {
        for (Produto p : lista) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    
    public static String listagem() {
        StringBuilder sb = new StringBuilder();
        sb.append("Listagem dos produtos").append("\n");
        for(Produto p: lista) {
            sb.append(p.getDados());
        }
        return sb.toString();
    }
}
