package domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Cliente 
{
    private static int ultimoId = 0;
    protected int id;
    protected String nome;
    protected String celular;
    protected String email;
    protected Date dataCadastro;
    protected Pontuacao pontuacao = new Pontuacao(); //Para configurar uma composicao precisa instanciar no momento da criacao
    protected List<Veiculos> listaVeiculos;
    
    //construtor padrao
    public Cliente() 
    {
        this.id = ++ultimoId; //Autoincemento do ID
        this.listaVeiculos = new ArrayList<>();
    }

    //construtor sobrecarregado
    public Cliente(String nome, String celular, String email, Date dataCadastro, Pontuacao pontuacao) 
    {
        this(); //chama o construtor padrao para gerar id
        this.nome = nome;
        this.celular = celular;
        this.email = email;
        this.dataCadastro = dataCadastro;
        this.pontuacao = pontuacao;
        
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

    //########
    public void setId(int id) {
        this.id = id;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Pontuacao getPontuacao() 
    {
        return pontuacao;
    }

    public String addVeiculos(Veiculos veiculo) {
        if (veiculo.getCliente() == null) {
            listaVeiculos.add(veiculo);
            veiculo.setCliente(this);
            return "Veículo adicionado ao cliente com sucesso!";
        } else {
            return "Este veículo já possui um cliente associado.";
        }
    }
    

    public void removeVeiculos(Veiculos veiculo) {
        listaVeiculos.remove(veiculo);
        veiculo.setCliente(null);
    }
    //Nao é necessario criar um set para pontuacao. Será utilizado os metodos da classe pontuacao
    // public void setPontuacao(Pontuacao pontuacao) {
    //     this.pontuacao = pontuacao;
    // }

    //Declaração do método para listar todos os produtos (opção 5)


    public List<Veiculos> getVeiculos() 
    {
        return listaVeiculos;
            
    }
    
   

    @Override
    public String toString() {
        return "\nid= " + id + "\nnome= " + nome + "\ncelular= " + celular + "\nemail= " + email + "\ndataCadastro= " + dataCadastro + "\npontuacao= " + pontuacao.getSaldo() + "\n" + getVeiculos();
    }
}
