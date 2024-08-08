package edu.junhaum.lavacode.mainapp;

import java.util.Date;
import edu.junhaum.lavacode.domain.clientes.*;
import edu.junhaum.lavacode.domain.veiculos.*;
import edu.junhaum.lavacode.domain.Ecategoria;
import edu.junhaum.lavacode.domain.Pontuacao;

public class appExemploUso 
{
     public static void main(String[] args) 
     {

         // Exemplo de uso

         printing("\nIniciando Programa...\n");
         System.out.println("\n----------------\n");

         // Exemplo de uso da classe Pontuacao
        printing("Exemplo generico de uso da classe Pontuação: \n");

        Pontuacao pontuacaoTeste01 = new Pontuacao();
        System.out.println("Saldo de pontos de TESTE após criado: " + pontuacaoTeste01.getSaldo());
        pontuacaoTeste01.adicionarPontos(50); // Adicionando pontos
        System.out.println("Saldo de pontos de TESTE apos adicionados 50 pontos: " + pontuacaoTeste01.getSaldo());
        pontuacaoTeste01.subtrairPontos(10); // Subtraindo pontos
        System.out.println("Saldo de pontos de TESTE apos subtraido 10 pontos: " + pontuacaoTeste01.getSaldo());

        // Exemplo de uso da classe PessoaFisica
        printing("Instanciando Pessoa Fisicao... \n");

        PessoaFisica pessoaFisica01 = new PessoaFisica("Ana", "987654321", "ana@example.com", new Pontuacao(), "123.456.789-10", new Date(2001 - 01 - 01));
        printing("Dados da Pessoa Física 1:");
        System.out.println(pessoaFisica01);
        
        PessoaFisica pessoaFisica02 = new PessoaFisica("Bia", "123456789", "bia@example.com", new Pontuacao(), "123.456.789-10", new Date(2002 - 02 - 02));
        printing("Dados da Pessoa Física 2:");
        System.out.println(pessoaFisica02);

        // Exemplo de uso da classe PessoaJuridica
        printing("Instanciando Pessoa Juridica... \n");

        PessoaJuridica pessoaJuridica01 = new PessoaJuridica("Empresa X", "999999999", "empresa@example.com", new Date(), pontuacaoTeste01, "12.345.678/0001-90", "123456789");
        printing("Dados da Pessoa Jurídica 1:");
        System.out.println(pessoaJuridica01);

        PessoaJuridica pessoaJuridica02 = new PessoaJuridica("Empresa Z", "1234567890", "z@example.com", new Date(), new Pontuacao(), "12.345.678/0001-90", "123456");
        printing("Dados da Pessoa Jurídica 2:");
        System.out.println(pessoaJuridica02);

        // Adição de 15 pontos para pessoa física 1 e pessoa jurídica 1
        printing("Adicionando 15 pontos para a Pessoa Fisica 1 e Pessoa juridica 1... ");
        //System.out.println(pessoaFisica01.getPontuacao().getSaldo());
        pessoaFisica01.getPontuacao().adicionarPontos(15);
        //System.out.println(pessoaFisica01.getPontuacao().getSaldo());
        pessoaJuridica01.getPontuacao().adicionarPontos(15);

        // Apresentar o novo saldo de pontos
        printing("Apresentando saldo de pontos Pessoa Fisica 1 e Pessoa juridica 1: ");
        printing("--Pessoa Fisica 1-- ");
        System.out.println("Novo saldo de pontos de "+ pessoaFisica01.getNome() + " é de "+ pessoaFisica01.getPontuacao().getSaldo());

        printing("--Pessoa Juridica 1-- ");
        System.out.println("Novo saldo de pontos da empresa "+ pessoaJuridica01.getNome() + " é de " + pessoaJuridica01.getPontuacao().getSaldo());

        // Subtrair 5 pontos
        printing("\n\nSubtraindo 5 pontos para a Pessoa Fisica 1 e Pessoa juridica 1... ");
        pessoaFisica01.getPontuacao().subtrairPontos(5);
        pessoaJuridica01.getPontuacao().subtrairPontos(5);

        // Apresentar o novo saldo de pontos após a subtração
        printing("\nApresentando saldo de pontos Pessoa Fisica 1 e Pessoa juridica 1: \n");
        System.out.println("Novo saldo de pontos de "+pessoaFisica01.getNome() + " é de "+ pessoaFisica01.getPontuacao().getSaldo());
        System.out.println("Novo saldo de pontos da empresa "+pessoaJuridica01.getNome()+ " é de " + pessoaJuridica01.getPontuacao().getSaldo());
        //************************************* */
        // Exemplo de uso da classe Marca
        printing("\nInstanciando os Marca...\n");
        //Usando Construtor padrão
        Marca marca1 = new Marca();
        marca1.setNome("Marca X");
        //Usando Construtor Sobrecarregado
        Marca marca2 = new Marca("Marca Y");

        // Criando uma instância de Motor
        Motor motor01 = new Motor(150, EtipoCombustivel.GASOLINA);
        Motor motor02 = new Motor(150, EtipoCombustivel.FLEX);

        System.out.println("\nInstanciando os Modelos...\n");

        //Usando Construtor padrão
        Modelo modelo1 = new Modelo();
        modelo1.setDescricao("Modelo A");
        modelo1.getMotor().setPotencia(100);
        modelo1.getMotor().setTipoCombustivel(EtipoCombustivel.FLEX);
        modelo1.setCategoria(Ecategoria.MEDIO);

        //Usando Construtor Sobrecarregado
        Modelo modelo2 = new Modelo("Modelo B");

        // Exibindo objetos criados
        System.out.println("\nObjetos criados:\n");
        System.out.println(modelo1);
        System.out.println(modelo2);
        System.out.println(marca1);
        System.out.println(marca2);
        System.out.println(motor01);
        System.out.println(motor02);
        System.out.println("\n----------------\n");

        // Realizando associação entre as classes (agregação)
        modelo1.setMarca(marca1);
        modelo2.setMarca(marca2);
        System.out.println("\n----------------\n");

        // Exibindo associação entre as classes
        System.out.println("\nAssociação entre classes:\nPelo Metodo ToString\n\n");
        System.out.println(modelo1);
        System.out.println(modelo2);
        System.out.println("\n----------------\n");

        System.out.println("\n\nAssociação entre classes:");
        System.out.println("Modelo 1 pertence à Marca: " + modelo1.getMarca());
        //System.out.println("Modelo 1 com o Tipo de Combustivel: " + modelo1.getMotor().getTipoCombustivel());
        System.out.println("Modelo 2 pertence à Marca: " + modelo2.getMarca());
        
        //System.out.println("Modelo 2 com o Tipo de Combustivel: " + modelo2.getMotor().getTipoCombustivel()); 
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
        
        // // Exibindo os detalhes do veículo 1
        // System.out.println("\n----------------\n");
        // System.out.println("Detalhes do Veículo 1:");
        // System.out.println("ID: " + veiculo1.getId());
        // System.out.println("Placa: " + veiculo1.getPlaca());
        // System.out.println("Observações: " + veiculo1.getObservacoes());
        // System.out.println("Marca: " + veiculo1.getModelo().getMarca().getNome());
        // System.out.println("Modelo: " + veiculo1.getModelo().getDescricao());
        // System.out.println("Categoria: " + veiculo1.getModelo().getCategoria());
        // System.out.println("Motor: " + veiculo1.getModelo().getMotor().getPotencia());
        // System.out.println("Tipo de Combustível: " + veiculo1.getModelo().getMotor().getTipoCombustivel());
        // System.out.println("Cor: " + veiculo1.getCor().getNome());
        
        // // Exibindo os detalhes do veículo 2
        // System.out.println("\n----------------\n");
        // System.out.println("\nDetalhes do Veículo 2:");
        // System.out.println("ID: " + veiculo2.getId());
        // System.out.println("Placa: " + veiculo2.getPlaca());
        // System.out.println("Observações: " + veiculo2.getObservacoes());
        // System.out.println("Marca: " + veiculo2.getModelo().getMarca().getNome());
        // System.out.println("Modelo: " + veiculo2.getModelo().getDescricao());
        // System.out.println("Categoria: " + veiculo2.getModelo().getCategoria());
        // System.out.println("Motor: " + veiculo2.getModelo().getMotor().getPotencia());
        // System.out.println("Tipo de Combustível: " + veiculo2.getModelo().getMotor().getTipoCombustivel());
        // System.out.println("Cor: " + veiculo2.getCor().getNome());

        printing("Associando veiculo ao cliente");
        pessoaFisica01.addVeiculos(veiculo1);
        pessoaFisica01.addVeiculos(veiculo2);
        pessoaJuridica01.addVeiculos(veiculo2);

        printing("Imprimindo Clientes");
        printing("Imprimindo Cliente 01");
        printC(pessoaFisica01);
        printing("Imprimindo Cliente 02");
        printC(pessoaJuridica01);
        printing("Imprimindo Veiculos");
        printing("Veiculo 01");
        printV(veiculo1);
        printing("Veiculo 02");
        printV(veiculo2);
        printing("Usando Polimorfism");
        printCResumido(pessoaFisica01);
        printCResumido(pessoaJuridica01);
        printCResumido(pessoaFisica02);
        printCResumido(pessoaJuridica02);

    }

    //Aplicando o conceito de polimorfismo
    private static void printing(String string)
    {
        System.out.println("*********************");
        System.out.println(string);
        System.out.println("\n\n");
    }

    private static void printC(Cliente cliente)
    {
        System.out.println("Cliente " + cliente.toString());
    }
    private static void printCResumido(Cliente cliente)
    {
        System.out.println("Nome " + cliente.getNome());
        if (cliente instanceof PessoaFisica)
        {
            System.out.println("    CPF: "+ ((PessoaFisica)cliente).getCpf());
            if (((PessoaFisica)cliente).getVeiculos().size() == 0) 
            {
                System.out.println("    Veiculos: Sem Veiculos Cadastrados");
            } 
            else 
            {
                System.out.println(((PessoaFisica)cliente).getVeiculos()); 
            }
        }
        else
        {
            System.out.println("    CNPJ: "+ ((PessoaJuridica)cliente).getCnpj());
            if (((PessoaJuridica)cliente).getVeiculos().size() == 0) 
            {
                System.out.println("    Veiculos: Sem Veiculos Cadastrados");
            } 
            else 
            {
                System.out.println(((PessoaJuridica)cliente).getVeiculos()); 
            }
        }
    }

    private static void printV(Veiculos veiculo)
    {
        System.out.println("Veiculo " + veiculo.toString());
    }

}
