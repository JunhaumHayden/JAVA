package edu.ifsc.cambio.dto;

public class ConversaoResponseDTO {
    private double valorEntrada;
    private String tipoMoeda;
    private String operacao;
    private double valorConvertido;

    public ConversaoResponseDTO(double valorEntrada, String tipoMoeda, String operacao, double valorConvertido) {
        this.valorEntrada = valorEntrada;
        this.tipoMoeda = tipoMoeda;
        this.operacao = operacao;
        this.valorConvertido = valorConvertido;
    }

    public double getValorEntrada() {
        return valorEntrada;
    }

    public String getTipoMoeda() {
        return tipoMoeda;
    }

    public String getOperacao() {
        return operacao;
    }

    public double getValorConvertido() {
        return valorConvertido;
    }
}

