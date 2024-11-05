# Projeto para Calculo de Folha de Pagamento
### versao 02
Faça uma API para calcular o salário líquido de um funcionário de uma empresa. O programa receberá
o salário bruto e deverá devolver o salário líquido que é dado pela seguinte expressão:
salarioLiquido = salarioBruto – irpf – inss
Regra para calcular o IRPF com base nas seguintes faixas:
• isento até R$ 1.903,98
• 7.5% com dedução de R$ 142,80: R$ 1.903,99 a R$ 2.826,65
• 15% com dedução de R$ 354,80: R$ 2.826,66 a R$ 3.751,05
• 22,5% com dedução de R$ 636,13: R$ 3.751,06 a R$ 4.664,68
• 27,5% com dedução de R$ 869,36: Acima de R$ 4.664,68
Por exemplo: imagine que o salário bruto informado seja de R$ 4.000,00, logo, o IRPF será:
irpf = (4000.0 * 0.225) – 636.13
irpf = 263.87

Regra para calcular a contribuição de INSS (para trabalhador assalariado):
• Até R$ 1.045,00: descontar 7,5 do salário bruto
• de R$ 1.045,01 até R$ 2.089,60: descontar 9% do salário bruto
• de R$ 2.089,61 até R$ 3.134,40: descontar 12% do salário bruto
• de R$ 3.134,41 até R$ 6.101,06: descontar 14% do salário bruto
Por exemplo: suponha que o salário bruto seja também de R$ 4.000,00, logo, o INSS será:
inss = 4000.0 * 0.14
inss = 560.0

Tendo o INSS e IRPF calculado é possível calcular o salário líquido:

salarioLiquido = 4000.0 – 263.87 – 560.0 = 3176,13

A API deverá apresentar as funcionalidades:
A. Recebe o salário bruto e devolve o líquido
Exemplo:
Request: localhost:8080/salario_liquido/4000.0
Response: 3176.13
B. Recebe o salário bruto e devolve o salário bruto, o IRPF, o INSS e o salário líquido:
Exemplo:
Request: localhost:8080/salario_liquido/4000.0
Response:
{
salarioBruto: 4000.0
irpf: 263.87
inss: 560.0
salarioLiquido: 3176.13
}

Baseado nos seguintes dados de entrada de um funcionário:
- nome
- salário base
- número de dependentes
Criou-se uma API Rest para retornar o salário líquido do funcionário, cuja regra de cálculo será a seguinte:
``` bash 
salarioLiquido = salárioBase – irpf + salarioFamilia
``` 
- para Calcular o irpf (Imposto de Renda de Pessoa Física)
Será descontado 27.5% do salário base quando este for igual ou acima de 8500.00, e
15% de para salário base igual ou acima de 5000.00. Abaixo deste valor o funcionário será isento.
- o salarioFamilia terá a seguinte regra de cálculo:
R$ 150,00 por dependente

#### Por Exemplo:
`Request`: localhost:8080/calcular_salario/Marcos/6000/4
`Response`: 5700
`Observação`: O parâmetro “calcular_salario“ se trata do recurso a ser acessado por meio de RequestMapping e os parâmetros “/Marcos/6000/4” correspondem respectivamente a nome, salárioBase e numeroDeDependentes do funcionário.

### Estrutura de Pastas do Projeto
Para um projeto bem estruturado em Spring Boot, seguindo o padrão MVC, organizou-se da seguinte forma:

```bash
Versao 2

src/main/java
└── edu
    └── ifsc
        └── folha_pagamento
            ├── controller
            │   └── FuncionarioController.java
            ├── dto
            │   └── SalarioResponseDTO.java
            ├── model
            │   └── Funcionario.java
            ├── service
            │   └── SalarioService.java
            └── FolhaPagamentoApplication.java


veraso1
/src
 └── /main
     ├── /java
     │    └── /edu
     │         └── /edu
     |                └── /FolhaPagamento
     |                    ├── /controller
     |                    │    └── FuncionarioController.java
     |                    ├── /model
     |                    │    └── Funcionario.java
     |                    ├── /service
     |                    │    └── CalculoSalarioService.java
     |                    └── /SeuprojetoApplication.java
     └── /resources
          ├── application.properties
          └── /static
          └── /templates
``` 

### Organização Detalhada
`/controller`: Contém classes responsáveis por processar as requisições HTTP e interagir com a camada de serviço. Esta é a "View" no padrão MVC, pois ela fornece pontos de entrada para que o usuário possa interagir com o sistema.
Classe: `FuncionarioController.java`

`/model`: Contém as classes que representam entidades de domínio ou objetos de dados. Estas classes são a "Model" no padrão MVC, responsáveis por armazenar e manipular os dados do sistema.
Classe: `Funcionario.java`

`/service`: Contém classes de lógica de negócios que realizam o processamento de dados. Esta camada é responsável por implementar regras de negócio e cálculos, e serve como uma ponte entre o controlador e a camada de modelo. Em MVC, ela age como parte da lógica do sistema.
Classe: `CalculoSalarioService.java`

`FolhaPagamentooApplication.java`: Ponto de entrada do projeto Spring Boot.

`/resources/application.properties`: Arquivo de configuração para definir as propriedades do aplicativo. Você pode adicionar configurações específicas como a porta em que o aplicativo será executado.

```bash 
# Definir a porta do servidor
server.port=8080
``` 
### Vantagens dessa Estrutura
_Separação de Responsabilidades_: Cada camada tem uma responsabilidade clara e bem definida.
_Facilidade de Manutenção_: Facilita a adição de novas funcionalidades, manutenção de código e entendimento do fluxo de dados.
_Reutilização de Código_: A camada de serviço pode ser reutilizada em diferentes controladores se necessário.
_Escalabilidade_: Facilita o crescimento do projeto sem bagunçar o código existente.
Com essa estrutura, seu projeto segue o padrão MVC e adere às boas práticas de desenvolvimento no Spring Framework. Isso torna seu código mais organizado, legível e fácil de manter.


### Exemplos de Requisições:
Requisição:
```bash 
http://localhost:8080/salario?nome=Joao&salarioBase=9000.00&dependentes=2
``` 
Resposta:

```bash 
Nome: Joao, Salário Líquido: 6887.50
```
Requisição:
```bash 
http://localhost:8080/salario?nome=Maria&salarioBase=4500.00&dependentes=3

``` 
Resposta:

```bash 
Nome: Maria, Salário Líquido: 4950.00

```
