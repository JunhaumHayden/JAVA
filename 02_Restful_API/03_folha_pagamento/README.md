# Prjeto para Calculo de Folha de Pagamento

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

/model: Contém as classes que representam entidades de domínio ou objetos de dados. Estas classes são a "Model" no padrão MVC, responsáveis por armazenar e manipular os dados do sistema.
Classe: Funcionario.java

/service: Contém classes de lógica de negócios que realizam o processamento de dados. Esta camada é responsável por implementar regras de negócio e cálculos, e serve como uma ponte entre o controlador e a camada de modelo. Em MVC, ela age como parte da lógica do sistema.
Classe: CalculoSalarioService.java

SeuprojetoApplication.java: Ponto de entrada do projeto Spring Boot.

/resources/application.properties: Arquivo de configuração para definir as propriedades do aplicativo. Você pode adicionar configurações específicas como a porta em que o aplicativo será executado.

```bash 
# Definir a porta do servidor
server.port=8080
``` 
### Vantagens dessa Estrutura
Separação de Responsabilidades: Cada camada tem uma responsabilidade clara e bem definida.
Facilidade de Manutenção: Facilita a adição de novas funcionalidades, manutenção de código e entendimento do fluxo de dados.
Reutilização de Código: A camada de serviço pode ser reutilizada em diferentes controladores se necessário.
Escalabilidade: Facilita o crescimento do projeto sem bagunçar o código existente.
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
