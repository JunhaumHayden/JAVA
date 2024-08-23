package edu.junhaum.lavacode.mainapp;

import java.util.Date;

import edu.junhaum.lavacode.DataSource.DataSource;
import edu.junhaum.lavacode.domain.Ecategoria;
import edu.junhaum.lavacode.domain.Pontuacao;
import edu.junhaum.lavacode.domain.clientes.Cliente;
import edu.junhaum.lavacode.domain.clientes.PessoaFisica;
import edu.junhaum.lavacode.domain.ordemServicos.EStatus;
import edu.junhaum.lavacode.domain.ordemServicos.OrdemDeServico;
import edu.junhaum.lavacode.domain.veiculos.Cor;
import edu.junhaum.lavacode.domain.veiculos.EtipoCombustivel;
import edu.junhaum.lavacode.domain.veiculos.Marca;
import edu.junhaum.lavacode.domain.veiculos.Modelo;
import edu.junhaum.lavacode.domain.veiculos.Veiculos;
import edu.junhaum.lavacode.exceptions.ExceptionLavacao;

public class MainExcepition {
    public static void main(String[] args) {
        DataSource.carregarDados();
        try {
            Pontuacao pontuacao = new Pontuacao();
            pontuacao.adicionarPontos(50);
            // pontuacao.subtrairPontos(100);  // Vai lançar ExceptionLavacao

        
            Cliente cliente = new PessoaFisica("João", "11999999999", "joao@email.com","123.456.789-10", new Date(2001 - 01 - 01));
            // cliente.addVeiculos(null);  // Vai lançar ExceptionLavacao

        
            OrdemDeServico os = new OrdemDeServico(0,new Veiculos("ABC1111", "Veículo em boas condições", cliente, new Cor("Branco"),new Modelo("Civic", new Marca("Honda"), Ecategoria.MEDIO, 112, EtipoCombustivel.FLEX )));
            os.setStatus(EStatus.FECHADA);
            // os.addItemOS(null);  // Vai lançar ExceptionLavacao

        } catch (ExceptionLavacao e) {
            System.out.println(e.getMessage());
        }
    }

}
