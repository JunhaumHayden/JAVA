package edu.ifsc.folha_pagamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsc.folha_pagamento.domain.Funcionario;
import edu.ifsc.folha_pagamento.service.CalculoSalarioService;

/**
 * Classe FuncionarioController para gerenciar as requisições HTTP.
 * Esta classe cria um endpoint para receber os dados de entrada e retornar o salário líquido.
 * 
 * @author Hayden
 */


@RestController
public class FuncionarioController {

    /**
     * A notação @Autowired é uma anotação do Spring Framework usada para realizar a injeção de dependência automaticamente. Quando aplicada a um campo, método ou construtor de uma classe, o Spring tenta injetar uma instância apropriada (um bean) para essa dependência automaticamente.
     * Neste caso o Spring injeta automaticamente uma instância de CalculoSalarioService na classe FuncionarioController. Isso significa que não é necessário criar manualmente um objeto CalculoSalarioService dentro do controlador
     */
    @Autowired
    private CalculoSalarioService calculoSalarioService;

    /**
     * Endpoint /salario que recebe os dados do funcionário como parâmetros de URL.
     */
    // @GetMapping("/salario") sem path variable
    @RequestMapping(value = "/salario/{nome}/{salarioBase}/{dependentes}", method = RequestMethod.GET)
    /**
     * O método calcularSalarioLiquido é exposto como um endpoint para processar requisições HTTP.
     * @param nome capturados diretamente da URL, passado como argumento para o método através da anotação @PathVariable.
     * @param salarioBase capturados diretamente da URL, passado como argumento para o método através da anotação @PathVariable.
     * @param numeroDependentes capturado diretamente da URL, passado como argumento para o método através da anotação @PathVariable.
     * @return
     */
    public String calcularSalarioLiquido(
            @PathVariable("nome") String nome,
            @PathVariable("salarioBase") double salarioBase,
            @PathVariable("dependentes") int numeroDependentes) {

          /**
           * Cria um objeto Funcionario, chama o serviço para calcular o salário e retorna o resultado.
           */      

        Funcionario funcionario = new Funcionario(nome, salarioBase, numeroDependentes);
        double salarioLiquido = calculoSalarioService.calcularSalarioLiquido(funcionario);

        return String.format("Nome: %s, Salário Líquido: %.2f", funcionario.getNome(), salarioLiquido);
    }
}
