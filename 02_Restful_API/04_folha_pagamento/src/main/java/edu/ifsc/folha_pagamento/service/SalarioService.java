
package edu.ifsc.folha_pagamento.service;

import edu.ifsc.folha_pagamento.domain.Funcionario;
import org.springframework.stereotype.Service;

@Service
public class SalarioService {

    public double calcularIrpf(double salarioBruto) {
        if (salarioBruto <= 1903.98) return 0;
        else if (salarioBruto <= 2826.65) return (salarioBruto * 0.075) - 142.80;
        else if (salarioBruto <= 3751.05) return (salarioBruto * 0.15) - 354.80;
        else if (salarioBruto <= 4664.68) return (salarioBruto * 0.225) - 636.13;
        else return (salarioBruto * 0.275) - 869.36;
    }

    public double calcularInss(double salarioBruto) {
        if (salarioBruto <= 1045.00) return salarioBruto * 0.075;
        else if (salarioBruto <= 2089.60) return salarioBruto * 0.09;
        else if (salarioBruto <= 3134.40) return salarioBruto * 0.12;
        else if (salarioBruto <= 6101.06) return salarioBruto * 0.14;
        else return 6101.06 * 0.14; // Teto do INSS
    }

    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBruto = funcionario.getSalarioBase();
        double irpf = calcularIrpf(salarioBruto);
        double inss = calcularInss(salarioBruto);
        return salarioBruto - irpf - inss;
    }
}

