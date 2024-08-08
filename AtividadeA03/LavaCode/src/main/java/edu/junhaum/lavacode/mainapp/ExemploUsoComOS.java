package edu.junhaum.lavacode.mainapp;

import edu.junhaum.lavacode.domain.Ecategoria;
import edu.junhaum.lavacode.domain.Pontuacao;
import edu.junhaum.lavacode.domain.clientes.*;
import edu.junhaum.lavacode.domain.ordemServicos.*;
import edu.junhaum.lavacode.domain.veiculos.*;
import java.util.Date;

public class ExemploUsoComOS 
{
    public static void main(String[] args) 
    {

         // Exemplo de uso

         printing("\nIniciando Programa...\n");
         System.out.println("\n----------------\n");


        Pontuacao pontuacaoTeste01 = new Pontuacao();
        

        // Exemplo de uso da classe PessoaFisica
        printing("Instanciando Pessoa Fisicao... \n");

        PessoaFisica pessoaFisica01 = new PessoaFisica("Ana", "987654321", "ana@example.com", new Pontuacao(), "123.456.789-10", new Date(2001 - 01 - 01));
        printing("Dados da Pessoa Física 1:");
        System.out.println(pessoaFisica01);
        

        // Exemplo de uso da classe PessoaJuridica
        printing("Instanciando Pessoa Juridica... \n");

        PessoaJuridica pessoaJuridica01 = new PessoaJuridica("Empresa X", "999999999", "empresa@example.com", new Date(), pontuacaoTeste01, "12.345.678/0001-90", "123456789");
        printing("Dados da Pessoa Jurídica 1:");
        System.out.println(pessoaJuridica01);

       
       
        //************************************* */
        // Exemplo de uso da classe Marca
        printing("\nInstanciando os Marca...\n");
        //Usando Construtor padrão
        Marca marca1 = new Marca();
        marca1.setNome("Marca X");
        //Usando Construtor Sobrecarregado
        Marca marca2 = new Marca("Marca Y");

        System.out.println("\nInstanciando os Modelos...\n");

        //Usando Construtor padrão
        Modelo modelo1 = new Modelo();
        modelo1.setDescricao("Modelo A");
        modelo1.getMotor().setPotencia(100);
        modelo1.getMotor().setTipoCombustivel(EtipoCombustivel.FLEX);
        modelo1.setCategoria(Ecategoria.MEDIO);

        //Usando Construtor Sobrecarregado
        Modelo modelo2 = new Modelo("Modelo B");

       
        // Realizando associação entre as classes (agregação)
        modelo1.setMarca(marca1);
        modelo2.setMarca(marca2);
        System.out.println("\n----------------\n");

       
        // Criando uma instância de Cor
        Cor cor1 = new Cor("Preto");
        Cor cor2 = new Cor("Branca");
        
        // Criando uma instância de Veiculos
        System.out.println("\nInstanciando os Veiculos...\n");

        Veiculos veiculo1 = new Veiculos("ABC1111", "Veículo em boas condições");
        veiculo1.setCor(cor1); // Definindo a cor do veículo
        veiculo1.setModelo(modelo1); // Definindo o modelo do veículo 2
        
        Veiculos veiculo2 = new Veiculos("BCD2222", "Veículo novo");
        veiculo2.setCor(cor2); // Definindo a cor do veículo 2
        veiculo2.setModelo(modelo2); // Definindo o modelo do veículo 2
      

        printing("Associando veiculo ao cliente");
        pessoaFisica01.addVeiculos(veiculo1);
        pessoaFisica01.addVeiculos(veiculo2);
        pessoaJuridica01.addVeiculos(veiculo2);   

        // Criando serviços
        Servico lavagemSimples = new Servico("Lavagem Simples", 30.0, 10, Ecategoria.MEDIO);
        Servico polimento = new Servico("Polimento", 150.0, 50, Ecategoria.MEDIO);
        Servico lavagemCompleta = new Servico("Lavagem Completa", 50.0, 20, Ecategoria.MEDIO);
        

        // Criando uma ordem de serviço
        OrdemDeServico ordemDeServico10 = new OrdemDeServico(10, veiculo1); // 10% de desconto

        // Criando itens de ordem de serviço
        ItemOS item11 = new ItemOS("Retorna as 13", 35.5,lavagemSimples,ordemDeServico10);
        ItemOS item12 = new ItemOS("Cera Liquida", 35.5,polimento,ordemDeServico10);

         // Adicionando itens à ordem de serviço
         ordemDeServico10.addItemOS(item11);
         ordemDeServico10.addItemOS(item12);

        // Calculando o total da ordem de serviço
        double total = ordemDeServico10.calcularServico();

        // Exibindo os detalhes da ordem de serviço
        printing("\n\n\n#############################");
        System.out.println("Número da Ordem de Serviço: " + ordemDeServico10.getNumero());
        System.out.println("Total da Ordem de Serviço: R$" + total);
        System.out.println("Detalhes da Ordem de Serviço: " + ordemDeServico10);

        
        // Criando uma ordem de serviço
        OrdemDeServico ordemDeServico20 = new OrdemDeServico(10, veiculo2); // 10% de desconto

        // Criando itens de ordem de serviço
        ItemOS item21 = new ItemOS("Verificar brinqudo do filho atras do banco", 35.5,lavagemCompleta,ordemDeServico10);

        // Adicionando itens à ordem de serviço
        ordemDeServico20.addItemOS(item21);
        

        // Calculando o total da ordem de serviço
        double total20 = ordemDeServico20.calcularServico();

        // Exibindo os detalhes da ordem de serviço
        printing("\n\n\n#############################");
        System.out.println("Número da Ordem de Serviço: " + ordemDeServico20.getNumero());
        System.out.println("Total da Ordem de Serviço: R$" + total20);
        System.out.println("Detalhes da Ordem de Serviço: " + ordemDeServico20);
    }
     //Aplicando o conceito de polimorfismo
     private static void printing(String string)
     {
         System.out.println("*********************");
         System.out.println(string);
         System.out.println("\n\n");
     }
}
