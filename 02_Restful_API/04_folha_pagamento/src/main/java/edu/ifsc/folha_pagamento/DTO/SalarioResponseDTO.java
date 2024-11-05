package edu.ifsc.folha_pagamento.DTO;

public class SalarioResponseDTO {
    private double salarioBruto;
    private double irpf;
    private double inss;
    private double salarioLiquido;

    public SalarioResponseDTO(double salarioBruto, double irpf, double inss, double salarioLiquido) {
        this.salarioBruto = salarioBruto;
        this.irpf = irpf;
        this.inss = inss;
        this.salarioLiquido = salarioLiquido;
    }

    public double getSalarioBruto() {
        return salarioBruto;
    }

    public double getIrpf() {
        return irpf;
    }

    public double getInss() {
        return inss;
    }

    public double getSalarioLiquido() {
        return salarioLiquido;
    }

}
