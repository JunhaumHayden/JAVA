package domain;

public class Cor {
    private long ultimoId = 0;
    private long id;
    private String nome;

    // Construtor sobrecarregado
    public Cor(){
        this.id = ++ultimoId;
    }

    public Cor(String nome) {
        this();
        this.nome = nome;
    }

    // Getters e Setters
    public long getUltimoId() {
        return ultimoId;
    }

    public void setUltimoId(long ultimoId) {
        this.ultimoId = ultimoId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //O método toString() para fornecer uma representação de string da instância da classe Marca.
    @Override
    public String toString()
    {
        return "Cor [id= " + nome + "]";
    }
    

    
}
