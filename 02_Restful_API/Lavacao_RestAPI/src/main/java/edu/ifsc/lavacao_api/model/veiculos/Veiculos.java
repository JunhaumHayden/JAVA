package edu.ifsc.lavacao_api.model.veiculos;

import edu.ifsc.lavacao_api.exceptions.ExceptionLavacao;
import edu.ifsc.lavacao_api.model.clientes.Cliente;

/**
* 
* Classe responsavel pelos veiculos no sistema, garante que cada veiculo esteja vinculado a apenas um unico cliente.
*
* 
* @author  Junhaum Hayden
* @version 1.0
* @since   07/08/2024
* 
*/
public class Veiculos {
    private static int ultimoId = 0;
    private int id;
    private String placa;
    private String observacoes;
    private Cliente cliente;
    private Cor cor;
    private Modelo modelo;
    

     //construtor padrao
    /**
     * O construtor padrao gera automaticamente um ID de veiculo unico a cada nova instancia da classe. 
     * @param id Autoincremento do Id.
     */
    private Veiculos() {
        this.id = ++ultimoId; 
    }

    
    /**
     * Este construtor sobrecarregado gera veiculo com as informaçoes minimas para cadastro rápido.
     *
     * @param this() Chama o construtor padrão para gerar o id.
     * @param placa Placa será um identificador.
     * @param observacoes Anotacoes pertinentes.
     * @param cliente Todo veiculo deve ser atribuido a um cliente
     * @throws ExceptionLavacao 
     * 
     */
    public Veiculos(String placa, String observacoes, Cliente cliente) throws ExceptionLavacao {
        this();
        this.placa = placa;
        this.observacoes = observacoes;
        this.cliente = cliente;
        cliente.addVeiculos(this);
    }
    /**
     * Este construtor sobrecarregado gera veiculos com as informaçoes completas.
     *
     * @param this() Chama o construtor padrão para gerar o id.
     * @param placa Placa será um identificador.
     * @param observacoes Anotacoes pertinentes.
     * @param cliente Todo veiculo deve ser atribuido a um cliente
     * @param Cor Selecao de cor
     * @param modelo Selecao de modelo
     * @throws ExceptionLavacao 
     * 
     */
    public Veiculos(String placa, String observacoes, Cliente cliente, Cor cor, Modelo modelo) throws ExceptionLavacao {
        this();
        this.placa = placa;
        this.observacoes = observacoes;
        this.cliente = cliente;
        this.cor = cor;
        this.modelo = modelo;
        cliente.addVeiculos(this);
        
    }

    // Getters e Setters
    public static int getUltimoId() {
        return ultimoId;
    }

    public int getId() {
        return id;
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
        return this.getClass().getSimpleName() +
        "\n   ID..........: " + id +
        "\n   Proprietario: " + cliente.getNome() +
        "\n   Placa.......: " + placa + 
        "\n   Modelo......: " + modelo.getDescricao() +
        "\n   Marca.......: " + modelo.getMarca().getNome() +
        "\n   Cor.........: " + cor.getNome() +
        "\n   Categoria...: " + modelo.getCategoria() +
        "\n   Combustivel.: " + modelo.getMotor().getTipoCombustivel() +
        "\n   Observacoes.: " + observacoes
        ;
    }
    
}
