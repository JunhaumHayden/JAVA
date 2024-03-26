package domain;

public class Veiculos {
    private static int ultimoId = 0;
    private int id;
    private String placa;
    private String observacoes;
    private Cor cor;
    private Modelo modelo;

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

    @Override
    public String toString() {
        return "Veiculos [id=" + id + ", placa=" + placa + ", observacoes=" + observacoes + ", Modelo=" + modelo + ", Cor=" + cor + "]";
    }
    
}
