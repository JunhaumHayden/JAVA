package br.edu.ifsc.fln.model.domain.veiculos;
import br.edu.ifsc.fln.model.domain.cliente.Cliente;

import br.edu.ifsc.fln.exceptions.ExceptionLavacao;

/**
 * Classe responsável pelos veículos no sistema.
 * Garante que cada veículo esteja vinculado a apenas um único cliente.
 *
 * @author  Junhaum
 * @version 1.1
 * @since   20/11/2024
 */
public class Veiculo {

    private int id; // Será gerado pelo banco de dados
    private String placa;
    private String observacoes;
    private Cliente cliente;
    private Cor cor;
    private Modelo modelo;

    /**
     * Construtor sobrecarregado para cadastro rápido.
     *
     * @param placa       Identificador único do veículo.
     * @param observacoes Notas adicionais.
     * @param cliente     Cliente proprietário do veículo.
     * @throws ExceptionLavacao Se o cliente for inválido.
     */
    public Veiculo(String placa, String observacoes, Cliente cliente) throws ExceptionLavacao {
        validarCliente(cliente);
        this.placa = placa;
        this.observacoes = observacoes;
        this.cliente = cliente;
        cliente.addVeiculos(this); // Atualiza a relação no cliente
    }

    /**
     * Construtor sobrecarregado com informações completas.
     *
     * @param placa       Identificador único do veículo.
     * @param observacoes Notas adicionais.
     * @param cliente     Cliente proprietário do veículo.
     * @param cor         Cor do veículo.
     * @param modelo      Modelo do veículo.
     * @throws ExceptionLavacao Se o cliente for inválido.
     */
    public Veiculo(String placa, String observacoes, Cliente cliente, Cor cor, Modelo modelo) throws ExceptionLavacao {
        validarCliente(cliente);
        this.placa = placa;
        this.observacoes = observacoes;
        this.cliente = cliente;
        this.cor = cor;
        this.modelo = modelo;
        cliente.addVeiculos(this); // Atualiza a relação no cliente
    }

    public Veiculo() {

    }

    /**
     * Valida se o cliente é nulo.
     *
     * @param cliente Cliente a ser validado.
     * @throws ExceptionLavacao Se o cliente for nulo.
     */
    private void validarCliente(Cliente cliente) throws ExceptionLavacao {
        if (cliente == null) {
            throw new ExceptionLavacao("O veículo deve estar vinculado a um cliente Valido.");
        }
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) throws ExceptionLavacao {
        validarCliente(cliente);
        this.cliente = cliente;
        cliente.addVeiculos(this); // Atualiza a relação no cliente
    }

    public String getNomeMarca() {
        return modelo.getMarca() != null ? modelo.getNomeMarca() : "";
    }

    @Override
    public String toString() {
        return placa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return id == veiculo.id; // Comparando apenas pelo ID
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }


}



