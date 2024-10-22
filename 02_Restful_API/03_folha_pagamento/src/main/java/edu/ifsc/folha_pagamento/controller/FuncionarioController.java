package edu.ifsc.folha_pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsc.folha_pagamento.domain.Funcionario;
import edu.ifsc.folha_pagamento.service.CalculoSalarioService;

/**
 * Classe FuncionarioController para gerenciar as requisições HTTP.
 * Esta classe cria um endpoint para receber os dados de entrada e retornar o salário líquido.
 * Endpoint /salario que recebe os dados do funcionário como parâmetros de URL.
 * Cria um objeto Funcionario, chama o serviço para calcular o salário e retorna o resultado.
 * 
 * @author Hayden
 */


@RestController
public class FuncionarioController {

    @Autowired
    private CalculoSalarioService calculoSalarioService;

    @GetMapping("/salario")
    public String calcularSalarioLiquido(
            @RequestParam("nome") String nome,
            @RequestParam("salarioBase") double salarioBase,
            @RequestParam("dependentes") int numeroDependentes) {

        Funcionario funcionario = new Funcionario(nome, salarioBase, numeroDependentes);
        double salarioLiquido = calculoSalarioService.calcularSalarioLiquido(funcionario);

        return String.format("Nome: %s, Salário Líquido: %.2f", funcionario.getNome(), salarioLiquido);
    }
}
