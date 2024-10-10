 Intermediate Princípios Básicos
## Descrição

Neste desafio, você desenvolverá uma solução que analise transações financeiras de um cliente ao longo de um mês. O programa deve receber uma lista de transações e calcular o saldo final, a maior transação de depósito e a maior transação de retirada. Além disso, o programa deve verificar se o saldo final é positivo ou negativo.

Para resolver este desafio, você aplicará os conceitos de Clean Architecture. Seu objetivo é completar a classe AnaliseTransacoesUseCase, utilizando os conceitos de Clean Architecture. Dessa forma, implemente a condição necessária para a análise das transações e construa a saída de acordo com a análise.

Saiba mais sobre: [Clean Architecture](https://engsoftmoderna.info/artigos/arquitetura-limpa.html)
### Entrada

O programa deve receber:

1. O número de transações.

2. Uma lista de números representando as transações (valores positivos para depósitos e valores negativos ( - ) para retiradas).
Saída

    Saldo: X, onde X é o saldo final após todas as transações.

    Deposito: Y, onde Y é o valor da maior transação de depósito.

    Retirada: Z, onde Z é o valor da maior transação de retirada.

    Saldo positivo ou Saldo negativo, dependendo do valor do saldo final.

#### Exemplos

A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.
Entrada 	Saída
2
1500.00
-300.00 	Saldo: 1200.00
Deposito: 1500.00
Retirada: -300.00
Saldo positivo
3
600.00
200.00
-900.00 	Saldo: -100.00
Deposito: 600.00
Retirada: -900.00
Saldo negativo
5
2500.00
400.00
50.00
-150.00
-10.00

### Explicação:
Transação:
A classe `Transacao` armazena uma lista de transações, que pode conter tanto valores positivos (depósitos) quanto negativos (retiradas).
`AnaliseTransacoesUseCase`:
Implementa o cálculo do saldo final e verifica a maior transação de depósito e retirada. Também verifica se o saldo final é positivo ou negativo.
Fluxo da lógica:
O saldo final é calculado somando todas as transações.
O maior depósito e a maior retirada são calculados verificando os valores positivos e negativos, respectivamente.
A mensagem final é formatada com base nos resultados dos cálculos, e o saldo é verificado para determinar se é positivo ou negativo.

No código apresentado, os conceitos da Clean Architecture que foram aplicados incluem a separação de responsabilidades entre as diferentes camadas, o isolamento da lógica de negócios e a criação de uma estrutura modular e independente de frameworks. Aqui estão os principais conceitos da Clean Architecture aplicados:

1. Separação de camadas (camadas independentes):
A Clean Architecture sugere a divisão do sistema em camadas bem definidas, sendo que cada camada possui sua responsabilidade. O código implementa isso ao separar a lógica de entrada/saída e o caso de uso principal:
_Camada de Entrada_: A classe AnaliseTransacoes é responsável por lidar com a entrada de dados (interação com o usuário via Scanner) e por invocar o caso de uso. Ela representa o "controller" da aplicação.
_Camada de Caso de Uso_ (Application Layer): A classe AnaliseTransacoesUseCase contém toda a lógica de análise das transações, como o cálculo do saldo, o maior depósito, a maior retirada e a verificação se o saldo é positivo ou negativo. Essa é a lógica central do sistema e está isolada, sem depender de frameworks ou tecnologias específicas.
_Entidade do Domínio_: A classe Transacao serve como um modelo para representar os dados que estão sendo manipulados (a lista de transações financeiras). Ela contém os dados essenciais e representa a entidade central do domínio.

2. Independência de frameworks e tecnologias:
A Clean Architecture preza por uma arquitetura independente de frameworks e bibliotecas externas. O código implementado segue esse princípio ao não depender de frameworks externos para implementar a lógica de negócios. O uso de classes nativas do Java (Scanner, List, ArrayList) permite que o código seja facilmente testado e mantido, independentemente de bibliotecas específicas.

3. Lógica de negócios isolada:
A lógica de negócios deve ser completamente isolada da interface do usuário ou de detalhes de infraestrutura. A classe AnaliseTransacoesUseCase contém toda a lógica de verificação de saldo, depósitos e retiradas, mantendo-a isolada das outras partes do código. Isso facilita a testabilidade e a evolução do sistema, já que mudanças na interface ou na infraestrutura não afetam a lógica de negócios.

4. Facilidade de teste (testabilidade):
A lógica de negócios foi encapsulada em uma classe (AnaliseTransacoesUseCase), o que facilita os testes unitários. Pode-se testar a lógica sem a necessidade de interagir com o sistema de entrada/saída (como o Scanner), tornando o código mais modular e testável. Você poderia, por exemplo, testar a classe AnaliseTransacoesUseCase isoladamente, apenas passando uma entidade Transacao e verificando a saída.

5. Regra de dependência (Dependency Rule):
Na Clean Architecture, as camadas mais externas (como interface do usuário ou frameworks) dependem das camadas internas (como a lógica de negócios), e nunca o contrário. No código, a classe AnaliseTransacoes (camada de entrada) depende de AnaliseTransacoesUseCase (caso de uso), mas o caso de uso não depende de como a entrada foi fornecida. A classe Transacao está no núcleo e também é independente de qualquer detalhe externo.

6. Uso de Entidades (Entities):
A Clean Architecture usa o conceito de "Entidades" para representar objetos de negócio importantes. No código, a classe Transacao representa uma entidade do domínio, com as propriedades necessárias para o caso de uso. Essa entidade é fundamental para a lógica do negócio, mas está desacoplada de outras camadas.

7. Regra de Inversão de Dependência (Dependency Inversion Principle):
Embora o código não inclua inversão de dependências explícita com interfaces, o uso da classe AnaliseTransacoesUseCase já segue parcialmente esse princípio ao permitir que outras camadas dependam de abstrações (caso de uso), e não de detalhes específicos. Essa prática poderia ser expandida em uma implementação mais complexa usando interfaces e inversão de dependência.

#### Resumo
Os principais conceitos de Clean Architecture aplicados no código são:

- Separação de responsabilidades entre a entrada, o caso de uso e a entidade de domínio.
- Independência de frameworks e tecnologias externas.
- Lógica de negócios isolada e independente da interface de entrada/saída.
- Facilidade de teste, ao manter a lógica central desacoplada de detalhes de entrada.
- Uso de entidades que representam o domínio do negócio (no caso, Transacao).
  
Esses conceitos juntos tornam o código mais modular, fácil de manter e expandir, além de promover a testabilidade e independência de detalhes de implementação.

``` mermaid
classDiagram
    class Transacao {
        - List~Double~ transacoes
        + Transacao(List~Double~ transacoes)
        + List~Double~ getTransacoes()
    }

    class AnaliseTransacoesUseCase {
        + String analisar(Transacao transacao)
        - double saldoFinal
        - double maiorDeposito
        - double maiorRetirada
    }

    class AnaliseTransacoes {
        + main(String[] args)
    }

    Transacao --> AnaliseTransacoesUseCase : "Usa"
    AnaliseTransacoes --> AnaliseTransacoesUseCase : "Executa caso de uso"
    AnaliseTransacoesUseCase --> Transacao : "Recebe"
```
### Explicação:
O diagrama mostra a classe `Transacao` como uma entidade de domínio que possui uma lista de transações.
A classe `AnaliseTransacoesUseCase` contém a lógica do caso de uso e opera sobre a entidade Transacao.
A classe `AnaliseTransacoes` atua como a camada de entrada, que interage com o usuário e invoca o caso de uso.
As setas indicam a relação entre as classes, onde `AnaliseTransacoes` e `AnaliseTransacoesUseCase` usam a entidade `Transacao` para executar suas funções.
Isso reflete a estrutura modular do código, aplicando os princípios da Clean Architecture.