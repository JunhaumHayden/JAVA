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
import edu.junhaum.lavacode.report.Relatorio;

public class MainExcepition {
    public static void main(String[] args) {
        DataSource.carregarDados();
        try {
            Pontuacao pontuacao = new Pontuacao();
            pontuacao.adicionarPontos(50);
            //pontuacao.subtrairPontos(100);  // Vai lançar ExceptionLavacao Saldo de pontos insuficiente
            

        
            Cliente cliente = new PessoaFisica("João", "11999999999", "joao@email.com","123.456.789-10", new Date(2001 - 01 - 01));
            //cliente.addVeiculos(null);  // Vai lançar ExceptionLavacao Adicionar veiculo nulo

            //cliente.addVeiculos(DataSource.getVeiculo(3));// Vai lançar ExceptionLavacao Veiculo já associado

            Relatorio relatorio = new Relatorio(cliente);
            System.out.println(relatorio.imprimirCliente());

            Veiculos veiculo = (new Veiculos("XXX9999", "Veículo Avulso", cliente, new Cor("Verde"), new Modelo("Ranger", new Marca("Ford"), Ecategoria.GRANDE, 200, EtipoCombustivel.GASOLINA)));
    

            System.out.println(cliente.getVeiculos()); // Confirmacao de associacao do veiculo ao cliente
        
            OrdemDeServico os = new OrdemDeServico(0,DataSource.getVeiculo(3));
            os.setStatus(EStatus.FECHADA);
            //os.setStatus(EStatus.ABERTA); // Vai lançar ExceptionLavacao
            os.addItemOS(null);  // Vai lançar ExceptionLavacao

            System.out.println(relatorio.imprimirCliente());

        } catch (ExceptionLavacao e) {
            System.out.println(e.getMessage());
        }
    }

}
