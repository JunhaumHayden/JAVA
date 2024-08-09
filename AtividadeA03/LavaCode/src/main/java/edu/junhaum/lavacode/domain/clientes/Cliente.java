package edu.junhaum.lavacode.domain.clientes;

import edu.junhaum.lavacode.domain.*;
import edu.junhaum.lavacode.domain.veiculos.*;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

/**
* <h1>Cliente</h1>
* Classe para garantir que todos os clientes tenham informaçoes minimmas no sistema.<br>
* A classe Cliente é uma classe abstrata que implementa a interface ICliente. Isso significa que ela pode fornecer implementações parciais ou completas dos métodos da interface, mas como é abstrata, não precisa fornecer todas as implementações. As subclasses concretas (não abstratas) terão que completar a implementação. 
*
* 
* @author  Junhaum Hayden
* @version 1.0
* @since   07/08/2024
* 
*/
public abstract class Cliente implements ICliente
{
    private static int ultimoId = 0;
    protected int id;
    protected String nome;
    protected String celular;
    protected String email;
    protected LocalDate dataCadastro;
    protected Pontuacao pontuacao = new Pontuacao(); //Para configurar uma composicao precisa instanciar no momento da criacao
    protected List<Veiculos> listaVeiculos;
    
    //construtor padrao
    /**
     * Gera automaticamente um ID de cliente unico a cada nova instancia da classe e atribui a data e inicializa a lista de veiculos. 
     *
     * 
     * 
     */
    private Cliente() 
    {
        this.id = ++ultimoId; //Autoincemento do ID
        this.listaVeiculos = new ArrayList<>();
        this.dataCadastro = LocalDate.now(); // Atribui a data e hora atuais
    }

    //construtor sobrecarregado
    /**
     * Cria um cliente com as informaçoes obrigatorias e chama, automaticamente o construtor padrao para gerar o ID de cliente unico.
     *
     * @param nome Nome completo do cliente
     * @param celular O numero do celular do cliente
     * @param email email valido do cliente
     * @param pontuacao Realiza uma composiçao com um objeto Pontuacao
     * 
     */
    public Cliente(String nome, String celular, String email) 
    {
        this(); //chama o construtor padrao para gerar id
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        //this.pontuacao = pontuacao;
        
    }

    // Getters e Setters
    public static int getUltimoId() {
        return ultimoId;
    }

    public static void setUltimoId(int ultimoId) {
        Cliente.ultimoId = ultimoId;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public Pontuacao getPontuacao() 
    {
        return pontuacao;
    }
    /**
     * Vincula um veiculo ao cliente adicionando-o a uma lista.
     * Garantindo que não será adicionado um veiculo que já esteja vinculado a outro cliente e vinculando o veiculo ao cliente.
     * @param veiculo Recebe o veiculo a ser adicionado, é um objeto do tipo Veiculo 
     * @return Uma String com uma mensagem se houve sucesso ou não 
     */
    public String addVeiculos(Veiculos veiculo) {
        if (veiculo.getCliente() == this) {
            listaVeiculos.add(veiculo);
            veiculo.setCliente(this);
            return "Veículo adicionado ao cliente com sucesso!";
        } else {
            return "Este veículo já possui um cliente associado.";
        }
    }
    /**
     * Desvincula um veiculo de um cliente, retirando-o da lista.
     * Desvincula o cliente do veiculo também.
     * @param veiculo Recebe o veiculo a ser removido, é um objeto do tipo Veiculo 
     * 
     */
    public void removeVeiculos(Veiculos veiculo) {
        listaVeiculos.remove(veiculo);
        veiculo.setCliente(null);
    }
    //Nao é necessario criar um set para pontuacao. Será utilizado os metodos da classe pontuacao
    // public void setPontuacao(Pontuacao pontuacao) {
    //     this.pontuacao = pontuacao;
    // }

    //Declaração do método para listar todos os produtos (opção 5)

    /**
     * Retorna a lista de veiculos do cliente.
     *  
     * @return A lista com os veiculos. É uma lista de Objetos 
     */
    public List<Veiculos> getVeiculos() 
    {
        return listaVeiculos;
            
    }

    // Sobrescrever metodos obrigatórios
    /**
     * Implementação parcial do método getDados
     *
     * @return As informaçoes referentes ao cliente.
     * 
     */
    @Override
    public String getDados() {
        return  " Nome= " + nome + "\n  celular= " + celular + "\n  emial= " + email + "\n  dataCadastro= "+ dataCadastro + "\n  pontuacao=" + pontuacao.getSaldo() + "\n Veiculos: " + getVeiculos() ;
    }
    /**
     * Método abstrato que deve ser implementado pelas subclasses
     *
     * @param Observacao A Observacao que se dejesa inserir no retorno dos dados
     * 
     */
    @Override
    public abstract String getDados(String Observacao);

    @Override
    public String toString() {
        return  "\n  ID...........: " + id + 
                "\n  Nome.........: " + nome + 
                "\n  Celular......: " + celular + 
                "\n  Email........: " + email + 
                "\n  Data Cadastro: " + dataCadastro + 
                "\n  Pontuacao....: " + pontuacao.getSaldo() + 
                "\n  VEICULOS.....: " + getVeiculos();
    }
}
