package edu.junhaum.lavacode.mainapp;

import java.util.Date;

import edu.junhaum.lavacode.DataSource.DataSource;
import edu.junhaum.lavacode.domain.Pontuacao;
import edu.junhaum.lavacode.domain.clientes.Cliente;
import edu.junhaum.lavacode.domain.clientes.PessoaFisica;
import edu.junhaum.lavacode.domain.ordemServicos.EStatus;
import edu.junhaum.lavacode.domain.ordemServicos.OrdemDeServico;
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
            cliente.addVeiculos(DataSource.getVeiculo(3));

            Cliente cliente02 = new PessoaFisica("Maria", "11999999999", "Maria@email.com","123.456.789-10", new Date(2001 - 01 - 01));
            //cliente02.addVeiculos(DataSource.getVeiculo(3));// Vai lançar ExceptionLavacao

        
            OrdemDeServico os = new OrdemDeServico(0,DataSource.getVeiculo(3));
            os.setStatus(EStatus.FECHADA);
            // os.addItemOS(null);  // Vai lançar ExceptionLavacao

        } catch (ExceptionLavacao e) {
            System.out.println(e.getMessage());
        }
    }

}
