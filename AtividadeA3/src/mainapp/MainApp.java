package mainapp;

import domain.Cliente;
import domain.PessoaFisica;
import domain.PessoaJuridica;
import domain.Pontuacao;
import java.util.Date;

public class MainApp {
    public static void main(String[] args) {

         // Exemplo de uso

         // Exemplo de uso da classe Pontuacao
        System.out.println("Exemplo generico de uso da classe Pontuação: \n");

        Pontuacao pontuacaoTeste01 = new Pontuacao();
        System.out.println("Saldo de pontos de TESTE após criado: " + pontuacaoTeste01.getSaldo());
        pontuacaoTeste01.adicionarPontos(50); // Adicionando pontos
        System.out.println("Saldo de pontos de TESTE apos adicionados 50 pontos: " + pontuacaoTeste01.getSaldo());
        pontuacaoTeste01.subtrairPontos(10); // Subtraindo pontos
        System.out.println("Saldo de pontos de TESTE apos subtraido 10 pontos: " + pontuacaoTeste01.getSaldo());

        // Exemplo de uso da classe PessoaFisica
        System.out.println("Instanciando Pessoa Fisicao... \n");

        PessoaFisica pessoaFisica01 = new PessoaFisica("Ana", "987654321", "ana@example.com", new Date(), new Pontuacao(), "123.456.789-10", new Date(2001 - 01 - 01));
        System.out.println("\nDados da Pessoa Física 1:");
        System.out.println(pessoaFisica01);

        PessoaFisica pessoaFisica02 = new PessoaFisica("Bia", "123456789", "bia@example.com", new Date(), new Pontuacao(), "123.456.789-10", new Date(2002 - 02 - 02));
        System.out.println("\nDados da Pessoa Física 2:");
        System.out.println(pessoaFisica02);

        // Exemplo de uso da classe PessoaJuridica
        System.out.println("Instanciando Pessoa Juridica... \n");

        PessoaJuridica pessoaJuridica01 = new PessoaJuridica("Empresa X", "999999999", "empresa@example.com", new Date(), pontuacaoTeste01, "12.345.678/0001-90", "123456789");
        System.out.println("\nDados da Pessoa Jurídica 1:");
        System.out.println(pessoaJuridica01);

        PessoaJuridica pessoaJuridica02 = new PessoaJuridica("Empresa Z", "1234567890", "z@example.com", new Date(), new Pontuacao(), "12.345.678/0001-90", "123456");
        System.out.println("\nDados da Pessoa Jurídica 2:");
        System.out.println(pessoaJuridica02);

        // Adição de 15 pontos para pessoa física 1 e pessoa jurídica 1
        System.out.println("\nAdicionando 15 pontos para a Pessoa Fisica 1 e Pessoa juridica 1... \n");
        //System.out.println(pessoaFisica01.getPontuacao().getSaldo());
        pessoaFisica01.getPontuacao().adicionarPontos(15);
        //System.out.println(pessoaFisica01.getPontuacao().getSaldo());
        pessoaJuridica01.getPontuacao().adicionarPontos(15);

        // Apresentar o novo saldo de pontos
        System.out.println("\nApresentando saldo de pontos Pessoa Fisica 1 e Pessoa juridica 1: \n");
        System.out.println("--Pessoa Fisica 1-- ");
        System.out.println("Novo saldo de pontos de "+ pessoaFisica01.getNome() + " é de "+ pessoaFisica01.getPontuacao().getSaldo());

        System.out.println("\n--Pessoa Juridica 1-- ");
        System.out.println("Novo saldo de pontos da empresa "+ pessoaJuridica01.getNome() + " é de " + pessoaJuridica01.getPontuacao().getSaldo());

        // Subtrair 5 pontos
        System.out.println("\n\nSubtraindo 5 pontos para a Pessoa Fisica 1 e Pessoa juridica 1... ");
        pessoaFisica01.getPontuacao().subtrairPontos(5);
        pessoaJuridica01.getPontuacao().subtrairPontos(5);

        // Apresentar o novo saldo de pontos após a subtração
        System.out.println("\nApresentando saldo de pontos Pessoa Fisica 1 e Pessoa juridica 1: \n");
        System.out.println("Novo saldo de pontos de "+pessoaFisica01.getNome() + " é de "+ pessoaFisica01.getPontuacao().getSaldo());
        System.out.println("Novo saldo de pontos da empresa "+pessoaJuridica01.getNome()+ " é de " + pessoaJuridica01.getPontuacao().getSaldo());

        print(pessoaFisica01);
        print(pessoaJuridica01);
        System.out.println("\nUsando Polimorfismo");
        printResumido(pessoaFisica02);
        printResumido(pessoaJuridica02);

    }

    //Aplicando o conceito de polimorfismo
    private static void print(Cliente cliente)
    {
        System.out.println("Cliente " + cliente.toString());
    }

    private static void printResumido(Cliente cliente)
        {
            System.out.println("Nome " + cliente.getNome());
            if (cliente instanceof PessoaFisica)
            {
                System.out.println("CPF: "+ ((PessoaFisica)cliente).getCpf());
            }
            else
            {
                System.out.println("CNPJ: "+ ((PessoaJuridica)cliente).getCnpj());
            }
        }
}

