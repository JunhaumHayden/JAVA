package br.edu.ifsc.fln.model.domain.clientes;
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

    /**
     * Adiciona um veículo à lista de veículos do cliente.
     *
     * @param veiculo Veículo a ser adicionado.
     * @throws IllegalArgumentException Se o veículo já está associado ao cliente.
     */
    public void addVeiculos(Veiculo veiculo) {
        if (listaVeiculos.contains(veiculo)) {
            throw new IllegalArgumentException("Não é permitido associar o veiculo. O veículo já está associado a esse cliente.");
        }
        listaVeiculos.add(veiculo);
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

