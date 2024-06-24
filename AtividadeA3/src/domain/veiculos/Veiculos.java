package java.AtividadeA3.src.domain.veiculos;

import java.AtividadeA3.src.domain.clientes.Cliente;

public class Veiculos {
    private static int ultimoId = 0;
    private int id;
    private String placa;
    private String observacoes;
    private Cor cor;
    private Modelo modelo;
    private Cliente cliente;

    // Construtor padrão
    public Veiculos() {
        this.id = ++ultimoId; //Autoincremento do Id
    }

    // Construtor sobrecarregado
    public Veiculos(String placa, String observacoes) {
        this(); //Chama o construtor padrão para gerar o id
        this.placa = placa;
        this.observacoes = observacoes;
    }
    

    public Veiculos(int id, String placa, String observacoes, Cor cor, Modelo modelo, Cliente cliente) {
        this.id = id;
        this.placa = placa;
        this.observacoes = observacoes;
        this.cor = cor;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    // Getters e Setters
    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Veiculos.ultimoId = ultimoId;
    }

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

    public Cor getCor(){
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

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    @Override
    public String toString() {
        return "\nVeiculo\n    id= " + id + "\n    Placa= " + placa + "\n    Observacoes= " + observacoes + "\n    Cor= " + cor + modelo;
    }
    
}
