package edu.junhaum.lavacode.domain.veiculos;

public class Motor {
    private int potencia;
    private EtipoCombustivel tipoCombustivel;

    // Construtor padrão
    public Motor() {
    }

    // Construtor
    public Motor(int potencia, EtipoCombustivel tipoCombustivel) {
        this.potencia = potencia;
        this.tipoCombustivel = tipoCombustivel;
    }

    // Getters e Setters
    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public EtipoCombustivel getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(EtipoCombustivel tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public String toString() {
        return "Motor:\n    potencia=" + potencia + "\n    tipoCombustivel=" + tipoCombustivel;
    }
    

   
}
