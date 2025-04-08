package edu.ufsc.fln.datastructures;

import edu.ufsc.fln.datastructures.domain.queue.Queue;

// Suponha que você tenha essas classes já criadas:
class Cliente {
    private String nome;
    public Cliente(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
    @Override
    public String toString() {
        return "Cliente: " + nome;
    }
}

class PessoaFisica extends Cliente {
    private String cpf;
    public PessoaFisica(String nome, String cpf) {
        super(nome);
        this.cpf = cpf;
    }
    public String getCpf() { return cpf; }
    @Override
    public String toString() {
        return "Pessoa Física: " + getNome() + " - CPF: " + cpf;
    }
}

class PessoaJuridica extends Cliente {
    private String cnpj;
    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }
    public String getCnpj() { return cnpj; }
    @Override
    public String toString() {
        return "Pessoa Jurídica: " + getNome() + " - CNPJ: " + cnpj;
    }
}

public class QueueTest {
    public static void main(String[] args) {
        Queue fila = new Queue(5);  // Fila de tamanho 5

        // Enfileirando diferentes tipos de cliente
        fila.enqueue(new PessoaFisica("Joana", "123.456.789-00"));
        fila.enqueue(new PessoaJuridica("Empresa X", "00.000.000/0001-00"));
        fila.enqueue(new PessoaFisica("Carlos", "987.654.321-00"));

        System.out.println("Tamanho da fila: " + fila.size());
        System.out.println("Elemento na frente: " + fila.peekFront());

        // Desenfileirando os elementos
        while (!fila.isEmpty()) {
            Object obj = fila.dequeue();
            System.out.println("Desenfileirado: " + obj);

            // Podemos verificar o tipo se quisermos:
            if (obj instanceof PessoaFisica pf) {
                System.out.println("  → CPF: " + pf.getCpf());
            } else if (obj instanceof PessoaJuridica pj) {
                System.out.println("  → CNPJ: " + pj.getCnpj());
            }
        }

        System.out.println("Fila está vazia? " + fila.isEmpty());
    }
}

