package edu.ifsc.service;

import edu.ifsc.model.Funcionario;

/**
 * Classe CalculoSalarioService para encapsular a lógica de cálculo.
 * Esta classe encapsula a lógica de cálculo do salário líquido.
 * 
 * @author Hayden
 */

public class CalculoSalarioService {

    public CalculoSalarioService (){
    }

    public double calcularSalarioLiquido(Funcionario funcionario) {
        double salarioBase = funcionario.getSalarioBase();
        int numeroDependentes = funcionario.getNumeroDependentes();

        // Calcular IRPF
        double irpf = calcularIrpf(salarioBase);

        // Calcular Salário Família
        double salarioFamilia = calcularSalarioFamilia(numeroDependentes);

        // Calcular Salário Líquido
        return salarioBase - irpf + salarioFamilia;
    }

    private double calcularIrpf(double salarioBase) {
        if (salarioBase >= 8500.00) {
            return salarioBase * 0.275; // 27.5%
        } else if (salarioBase >= 5000.00) {
            return salarioBase * 0.15; // 15%
        } else {
            return 0; // Isento
        }
    }

    private double calcularSalarioFamilia(int numeroDependentes) {
        return numeroDependentes * 150.00;
    }
}
