package br.edu.ifsc.fln.model.domain.cliente;
import br.edu.ifsc.fln.model.domain.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Classe para representar um cliente criada apenas para teste.
 *
 * @author
 * @version 0.2
 * @since 27/11/2024
 */
public class Cliente {
    private int id;
    private String nome;
    private final List<Veiculo> listaVeiculos; // Lista encapsulada

    // Construtores
    public Cliente() {
        this.listaVeiculos = new ArrayList<>();
    }

    public Cliente(int id) {
        this.id = id;
        this.listaVeiculos = new ArrayList<>();
    }

    public Cliente(String nome) {
        this.nome = nome;
        this.listaVeiculos = new ArrayList<>();
    }

    public Cliente(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.listaVeiculos = new ArrayList<>();
    }


    // Getters e Setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    /**
//     * Adiciona um veículo à lista de veículos do cliente.
//     *
//     * @param veiculo Veículo a ser adicionado.
//     * @throws IllegalArgumentException Se o veículo pertence a outro cliente.
//     */
//    public void addVeiculos(Veiculo veiculo) {
//        // Verifica se o veículo já está associado ao cliente
//        if (listaVeiculos.contains(veiculo)) {
//            throw new IllegalArgumentException("O veículo já está associado a este cliente.");
//        }
//
//        // Verifica se o nome do cliente associado ao veículo é o mesmo
//        if (!this.nome.equals(veiculo.getCliente().getNome())) {
//            throw new IllegalArgumentException("O veículo pertence a outro cliente.");
//        }
//
//        // Adiciona o veículo à lista
//        listaVeiculos.add(veiculo);
//    }
//
//    /**
//     * Atualiza as informações de um veículo associado ao cliente.
//     *
//     * @param veiculo Veículo com as informações atualizadas.
//     * @throws IllegalArgumentException Se o veículo não está associado ao cliente
//     *                                  ou se o nome do cliente associado é diferente.
//     */
//    public void alterarVeiculos(Veiculo veiculo) {
//        // Verifica se o veículo está na lista de veículos do cliente
//        int index = listaVeiculos.indexOf(veiculo);
//        if (index == -1) {
//            throw new IllegalArgumentException("O veículo não está associado a este cliente.");
//        }
//
//        // Verifica se o nome do cliente associado ao veículo é o mesmo
//        Veiculo veiculoExistente = listaVeiculos.get(index);
//        if (!this.nome.equals(veiculoExistente.getCliente().getNome())) {
//            throw new IllegalArgumentException("O veículo pertence a outro cliente.");
//        }
//
//        // Atualiza o veículo na lista
//        listaVeiculos.set(index, veiculo);
//    }


    /**
     * Medoto somente para teste esta implementando as funcoes de atualizar e adicionar para facilitar os testes.
     *
     * @param veiculo Veículo com as informações atualizadas.
     * @throws IllegalArgumentException Se o veículo não está associado ao cliente
     *                                  ou se o nome do cliente associado é diferente.
     */
    public void addVeiculos(Veiculo veiculo) {
        // Verifica se o veículo está na lista de veículos do cliente
        int index = listaVeiculos.indexOf(veiculo);
        if (index == -1) {
            if (this.nome.equals(veiculo.getCliente().getNome())) {
                listaVeiculos.add(veiculo);
                return; // Finaliza a execução do método, pois o veículo foi adicionado
            }
            // Lança exceção se o veículo não estiver associado e o nome do cliente for diferente
            throw new IllegalArgumentException("O veículo não está associado ao cliente.");
        }

        // Verifica se o nome do cliente associado ao veículo é o mesmo
        Veiculo veiculoExistente = listaVeiculos.get(index);
        if (!this.nome.equals(veiculoExistente.getCliente().getNome())) {
            throw new IllegalArgumentException("O veículo pertence a outro cliente.");
        }

        // Atualiza o veículo na lista
        listaVeiculos.set(index, veiculo);
    }

    /**
     * Remove um veículo da lista de veículos do cliente.
     *
     * @param veiculo Veículo a ser removido.
     * @throws IllegalArgumentException Se o veículo não está associado ao cliente.
     */
    public void removeVeiculos(Veiculo veiculo) {
        if (!listaVeiculos.contains(veiculo)) {
            throw new IllegalArgumentException("O veículo não está associado ao cliente.");
        }
        listaVeiculos.remove(veiculo);
    }

    /**
     * Retorna uma cópia não modificável da lista de veículos.
     *
     * @return Lista de veículos do cliente.
     */
    public List<Veiculo> getListaVeiculos() {
        return Collections.unmodifiableList(listaVeiculos);
    }

    @Override
    public String toString() {
        return nome;
    }
}

