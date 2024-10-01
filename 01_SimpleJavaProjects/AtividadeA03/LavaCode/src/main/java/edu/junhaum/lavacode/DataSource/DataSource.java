package edu.junhaum.lavacode.DataSource;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.junhaum.lavacode.domain.Ecategoria;
import edu.junhaum.lavacode.domain.clientes.Cliente;
import edu.junhaum.lavacode.domain.clientes.PessoaFisica;
import edu.junhaum.lavacode.domain.clientes.PessoaJuridica;
import edu.junhaum.lavacode.domain.ordemServicos.Servico;
import edu.junhaum.lavacode.domain.veiculos.*;
import edu.junhaum.lavacode.exceptions.ExceptionLavacao;

/**
* Classe para instanciar os objetos Mokado necessários a manipulacao das OS. Contem os metodos para que se consiga manipular as listas mais facilmente. 
*
* 
* @author  Junhaum Hayden
* @version 1.0
* @since   07/08/2024
* 
*/

public class DataSource {
    private static List<Veiculos> veiculos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Servico> servicos = new ArrayList<>();

    public static void carregarDados() {

        try {
            clientes.add(new PessoaFisica("Ana", "1111-1111", "ana@example.com", "123.456.789-10", new Date(2001 - 01 - 01)));
            // printing("Dados da Pessoa Física 1:");
            clientes.get(0).getPontuacao().adicionarPontos(0);
            clientes.add(new PessoaFisica("Bia", "2222-2222", "bia@example.com", "123.456.789-10", new Date(2002 - 02 - 02)));
            clientes.get(1).getPontuacao().adicionarPontos(0);
            clientes.add(new PessoaFisica("Dani", "3333-3333", "Dani@example.com", "123.456.789-10", new Date(2003 - 03 - 03)));
            clientes.get(1).getPontuacao().adicionarPontos(0);
            // Exemplo de uso da classe PessoaJuridica
            clientes.add(new PessoaJuridica("Empresa Z", "9999-99999", "empresa@example.com", "12.345.678/0001-90", "99999999"));
            clientes.add(new PessoaJuridica("Empresa Y", "8888-8888", "empresa@example.com", "12.345.678/0001-90", "88888888"));
            clientes.add(new PessoaJuridica("Empresa X", "7777-7777", "empresa@example.com", "12.345.678/0001-90", "7777777"));

        } catch (ExceptionLavacao e) {
            System.out.println(e.getMessage());
        }


        // Criando uma instância de Veiculos
        try{
            veiculos.add(new Veiculos("ABC1111", "Veículo em boas condições", clientes.get(0), new Cor("Branco"),new Modelo("Civic", new Marca("Honda"), Ecategoria.MEDIO, 112, EtipoCombustivel.FLEX )));

            veiculos.add(new Veiculos("BCD1122", "Veículo azul bebe", clientes.get(0), new Cor("Azul"),new Modelo("Azera", new Marca("Hiunday"), Ecategoria.MEDIO, 119, EtipoCombustivel.GASOLINA )));

            veiculos.add(new Veiculos("CDE3333", "Veículo sem espete", clientes.get(4), new Cor("Fantasia"),new Modelo("Vito", new Marca("Mercedes"), Ecategoria.GRANDE, 119, EtipoCombustivel.GASOLINA )));

            veiculos.add(new Veiculos("DEF4411", "Veículo Geral Interno", clientes.get(5), new Cor("Cinza"),new Modelo("Uno", new Marca("FIAT"), Ecategoria.PEQUENO, 45, EtipoCombustivel.GASOLINA )));

            veiculos.add(new Veiculos("DEF4422", "Com Escada", clientes.get(5), new Cor("Cinza"),new Modelo("Uno", new Marca("FIAT"), Ecategoria.PEQUENO, 45, EtipoCombustivel.GASOLINA )));

            // Adicionando veículos à lista 'veiculos'
            veiculos.add(new Veiculos("GHI2234", "Rebaixado, Me rouba, logo!!!", clientes.get(2), new Cor("Branco"), new Modelo("Gol", new Marca("Volks"), Ecategoria.MEDIO, 100, EtipoCombustivel.FLEX)));

            veiculos.add(new Veiculos("JKL5678", "Veículo Executivo", clientes.get(1), new Cor("Preto"), new Modelo("Corolla", new Marca("Toyota"), Ecategoria.MEDIO, 110, EtipoCombustivel.GASOLINA)));

            veiculos.add(new Veiculos("MNO9012", "Veículo de Transporte", clientes.get(3), new Cor("Azul"), new Modelo("Sprinter", new Marca("Mercedes-Benz"), Ecategoria.GRANDE, 150, EtipoCombustivel.DIESEL)));

            veiculos.add(new Veiculos("PQR3456", "Veículo Compacto", clientes.get(4), new Cor("Vermelho"), new Modelo("Ka", new Marca("Ford"), Ecategoria.PEQUENO, 85, EtipoCombustivel.ETANOL)));

            veiculos.add(new Veiculos("STU7890", "Veículo de Entrega", clientes.get(5), new Cor("Amarelo"), new Modelo("Doblò", new Marca("FIAT"), Ecategoria.GRANDE, 120, EtipoCombustivel.GASOLINA)));

            veiculos.add(new Veiculos("VWX2345", "Veículo Esportivo", clientes.get(3), new Cor("Verde"), new Modelo("Mustang", new Marca("Ford"), Ecategoria.MEDIO, 200, EtipoCombustivel.GASOLINA)));
        } catch (ExceptionLavacao e) {
            System.out.println(e.getMessage());
        }


        servicos.add(new Servico("Lavagem Simples ", 75.0, 10, Ecategoria.PADRAO));
        servicos.add(new Servico("Lavagem Simples ", 20.0, 10, Ecategoria.PEQUENO));
        servicos.add(new Servico("Lavagem Simples ", 30.0, 10, Ecategoria.MEDIO));
        servicos.add(new Servico("Lavagem Simples ", 40.0, 10, Ecategoria.GRANDE));
        servicos.add(new Servico("Lavagem Simples ", 15.0, 10, Ecategoria.MOTO));

        servicos.add(new Servico("Lavagem Completa", 75.0, 10, Ecategoria.PADRAO));
        servicos.add(new Servico("Lavagem Completa", 20.0, 10, Ecategoria.PEQUENO));
        servicos.add(new Servico("Lavagem Completa", 30.0, 10, Ecategoria.MEDIO));
        servicos.add(new Servico("Lavagem Completa", 40.0, 10, Ecategoria.GRANDE));
        servicos.add(new Servico("Lavagem Completa", 15.0, 10, Ecategoria.MOTO));

        servicos.add(new Servico("Cera Liquida    ", 50.0, 10, Ecategoria.PADRAO));
        servicos.add(new Servico("Cera Liquida    ", 15.0, 10, Ecategoria.PEQUENO));
        servicos.add(new Servico("Cera Liquida    ", 30.0, 10, Ecategoria.MEDIO));
        servicos.add(new Servico("Cera Liquida    ", 40.0, 10, Ecategoria.GRANDE));
        servicos.add(new Servico("Cera Liquida    ", 5.0, 10, Ecategoria.MOTO));

        servicos.add(new Servico("Polimento       ", 50.0, 10, Ecategoria.PADRAO));
        servicos.add(new Servico("Polimento       ", 15.0, 10, Ecategoria.PEQUENO));
        servicos.add(new Servico("Polimento       ", 30.0, 10, Ecategoria.MEDIO));
        servicos.add(new Servico("Polimento       ", 40.0, 10, Ecategoria.GRANDE));
        servicos.add(new Servico("Polimento       ", 5.0, 10, Ecategoria.MOTO));

        servicos.add(new Servico("Aspiração       ", 75.0, 10, Ecategoria.PADRAO));
        servicos.add(new Servico("Aspiração       ", 20.0, 10, Ecategoria.PEQUENO));
        servicos.add(new Servico("Aspiração       ", 30.0, 10, Ecategoria.MEDIO));
        servicos.add(new Servico("Aspiração       ", 40.0, 10, Ecategoria.GRANDE));
        servicos.add(new Servico("Aspiração       ", 15.0, 10, Ecategoria.MOTO));


                
    }

    public static Cliente getCliente(int id) {
        for (Cliente c : clientes) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }

    public static int getClienteLenth(){
        return clientes.size();
    }

    public static Veiculos getVeiculo(int id) {
        for (Veiculos v : veiculos) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    public static int getVeiculosLenth(){
        return veiculos.size();
    }

    public static Servico getServicos(int id) {
        for (Servico s : servicos) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public static int getServicosLenth(){
        return servicos.size();
    }

    //Funcao auxiliar
    // private static void printing(String string)
    // {
    //     System.out.println("*********************");
    //     System.out.println(string);
    //     System.out.println("\n\n");
    // }
}
