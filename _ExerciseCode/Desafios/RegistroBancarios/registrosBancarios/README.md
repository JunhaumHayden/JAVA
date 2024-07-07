<div align="center">
<img src="https://hermes.dio.me/tracks/a039b34c-7aa8-4a3d-b765-07c8c837f67a.png" alt="Logo BackEnd" width="80">
<h1>Java</h1>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCcxkA70BX5H1N1FFSkncQ-InOpqloUVZLcA&usqp=CAU" alt="Logo Bootcamp" width="220">
</div>

# #JavaCodes



<h1 align="center"> Registros Bancarios </h1>



<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

# Sintaxe

## Descrição:

### Exercício sobre Orientação a Objetos codificando o seguinte cenário.

#### Cenario 01
`RegistroTransacoesBancarias`
Desenvolver um programa simples em Java para manter um registro de transações bancárias. Cada transação é armazenada em uma lista.

#### Entrada
O programa solicitará ao usuário que informe o saldo inicial da conta.
Em seguida, o programa solicitará a quantidade total de transações que o cliente deseja realizar.

##### Entrada de Transações:
Para cada transação, o programa solicitará ao usuário:
- O tipo de transação: Digite 'D' para depósito ou 'S' para saque.
- O valor da transação.

#### Saída
Utilizando listas (`ArrayList` ou `LinkedList`), o programa armazenará cada transação, que incluirá um tipo (Depósito ou Saque) e um valor.
Ao final das transações, o programa exibirá o saldo final da conta e a lista de transações.
 

#### Exemplos de uso:
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada |	Saída                |
| ------- | -------------------- |
| 2500    | Saldo: 2100.0        |  
| 2       |Transacoes:           |
| d       | 1. Deposito de 100.0 | 
| 100     | 2. Saque de 500.0    |
| s       |                      |
| 500	  |                      |
| ------- | -------------------- |
| 900     | Saldo: 800.0         |
| 1       | Transacoes:          |
| s       | 1. Saque de 100.0    |
| 100	  |                      |
| ------- | -------------------- |
| 0       | Saldo: 0.0           |
| 0       | Transacoes:          | 	

#### Cenario 02
`RegistroTransacoesComStream`
Aprimorando o programa anterior utilizando a Stream API do Java para processar as transações bancárias de forma mais eficiente.

#### Entrada
O programa solicitará ao usuário que informe o saldo inicial da conta.
Em seguida, o programa solicitará a quantidade total de transações que o cliente deseja realizar.

##### Entrada de Transações:
Para cada transação, o programa solicitará ao usuário:
O tipo de transação: Digite 'D' para depósito ou 'S' para saque.
O valor da transação.

#### Saída
Utilizando a Stream API, o programa armazenará cada transação, que incluirá um tipo (Depósito ou Saque) e um valor.
Ao final das transações, o programa exibirá o saldo final da conta e a lista de transações.
 

#### Exemplos de uso:
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada  |	Saída     |
| -------- | ------------ |
| 100      | Saldo : 90.0 |
| 2        | Transacoes:  |
| d        | d de 10.0    |
| 10       | s de 20.0    |
| s        |              |
| 20	   |              |
| -------- | ------------ |
| 5000     | Saldo : 5500.0 |
| 1        | Transacoes:  |
| d        | d | de 500.0 |
| 500	   |              |

#### Cenario 03
`MainContaBancaria`
Desenvolver um programa simples em Java para representar uma conta bancária. Utilizando programação orientada a objetos (POO), criará uma classe `ContaBancaria` com um construtor que permitirá a inicialização da conta com um saldo inicial.

#### Entrada
O programa solicitará ao usuário que informe o saldo inicial da conta.
Em seguida, o programa solicitará ao usuário que realize transações de depósito e saque.

#### Saída
A classe ContaBancaria conterá métodos para realizar depósitos e saques, atualizando o saldo da conta.
O saldo atual será exibido após cada transação.
Se o valor do saque for maior que o saldo disponível na conta, imprima uma mensagem informando: Saldo insuficiente. Saque não realizado.
 
#### Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

| Entrada  |	Saída            |
| -------- | ------------------- |
| 50       | Deposito feito.     |
| 50       | Saldo atual: 100.0  |
| 100      | Saque feito.        |
|          | Saldo atual: 0.0    |
|          |                     |
| -------- | ------------------- |
| 90       | Deposito feito.     |
| 90       | Saldo atual: 180.0  |
| 12       | Saque feito.        | 
| 500	   |  Saldo atual: 168.0 |

#### Cenario 04
`Desafio`
Herança Bancária: Entendendo a Herança e Polimorfismo
O banco decidiu expandir seus serviços para oferecer diferentes tipos de contas. Agora, além das contas bancárias comuns, eles também oferecem contas poupança. Sua tarefa é implementar a herança e o polimorfismo no sistema, criando uma classe "ContaPoupanca" que herde da classe "ContaBancaria" anteriormente criada. A classe "ContaPoupanca" deve adicionar um novo atributo, taxa de juros, além dos atributos herdados.

> Dica: Utilize a herança para criar a classe "ContaPoupanca" que herde da classe "ContaBancaria" e adicione o atributo "taxaJuros". Implemente o método "exibirInformacoes()" na classe "ContaPoupanca" para exibir as informações adicionais.

#### Entrada
O programa deve solicitar ao usuário as informações necessárias para abrir uma conta poupança. A entrada deve ser feita via console (linha de comando) e deve incluir o número da conta (um valor inteiro), o nome do titular (uma sequência de caracteres), o saldo inicial da conta (um valor decimal) e a taxa de juros da conta poupança (um valor decimal).

####  Saída
Após receber as informações da conta poupança, o programa deve criar um objeto do tipo "ContaPoupanca" e exibir na tela as informações dessa conta, incluindo o número da conta, o nome do titular, o saldo atual e a taxa de juros. A saída deve ser formatada de forma clara e legível para o usuário.

####  Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
Joao
123456
1000.0
1.5	Conta Poupanca:
Joao
123456
Saldo: R$ 1000.0
Taxa de juros: 1.5%
Ana
789012
2500.0
3.0	Conta Poupanca:
Ana
789012
Saldo: R$ 2500.0
Taxa de juros: 3.0%
Maria
987654
500.0
2.5	Conta Poupanca:
Maria
987654
Saldo: R$ 500.0
Taxa de juros: 2.5%

#### Cenario 05
`Cofre`
Cofres Seguros: Dominando o Encapsulamento e Abstração
Desenvolver um sistema de cofres seguros. O objetivo é criar dois tipos de cofres: um Cofre Digital, que é aberto por senha, e um Cofre Físico, que é aberto por chave.

#### Entrada
O programa irá solicitar ao usuário que digite o tipo de cofre a ser criado: "digital" ou "físico". Se for escolhido o tipo "digital", o programa irá solicitar a senha e a confirmação de senha do cofre digital (ambas com apenas números). Caso seja escolhido o tipo "físico", não é necessário nenhuma outra entrada.

#### Saída
O programa irá exibir as informações do cofre criado. Para o Cofre Digital, será exibido o tipo e o método de abertura (senha). Para o Cofre Físico, será exibido apenas o tipo e o método de abertura (chave).

#### Exemplos
A tabela abaixo apresenta exemplos com alguns dados de entrada e suas respectivas saídas esperadas. Certifique-se de testar seu programa com esses exemplos e com outros casos possíveis.

Entrada	Saída
digital
12345
1234

Tipo: Cofre Digital
Metodo de abertura: Senha
Senha incorreta!

fisico

Tipo: Cofre Fisico
Metodo de abertura: Chave

digital
2525
2525

Tipo: Cofre Digital
Metodo de abertura: Senha
Cofre aberto!







- Nome: Projeto ContaBanco 
- Função: Receber dados via terminal contendo as características de conta em banco conforme atributos abaixo:

| Atributo    |   Tipo	|  Exemplo       |
| ----------- | ------- | -------------- | 
|Numero	      | Inteiro	|  1021          |
|Agencia	  | Texto	|  067-8         |
|Nome Cliente | Texto	|  MARIO ANDRADE | 
|Saldo	      | Decimal	|  237.48        |

### *Tópicos*:

Revisar sobre:
- <details><summary>Regras de declaração de variáveis</summary></details>
- <details><summary>Terminal</summary></details>
- <details><summary>Main args</summary></details>
- <details><summary>Classe Scanner</summary></details>
- <details><summary>Classe String com método concat</summary></details>
- <details><summary>Concatenação</summary></details>

## ✅ O que você vai encontrar aqui:

### Uso e comportamento Esperado:

- Solicitar inserção de dados via terminal
- O usuário receberá a mensagem de qual informação será solicitada, exemplo:

```markdown
**Programa**: "Por favor, digite o número da Agência!"  
**Usuário**: 1021 (depois ENTER para o próximo campo)
```

Depois de todas as informações terem sido inseridas, o sistema deverá exibir a seguinte mensagem:

```markdown
"Olá [Nome Cliente], obrigado por criar uma conta em nosso banco, sua agência é [Agencia], conta [Numero] e seu saldo [Saldo] já está disponível para saque".
```
*Os campos em [ ] devem ser alterados pelas informações que forem inseridas pelos usuários.*


### Estrutura dos Diretórios

#### Diagram
- Diagrama de classe
- Com os arquivos em formato PNG e ASTA
  
<img src="https://github.com/JunhaumHayden/JAVA/blob/main/conta_banco/Diagram/ClassDiagram01.png" alt="Diagrama de Classe" width="220">

#### src/domain
- Arquivo: `ContaTerminal.java`
- Classe **ContaTerminal** para instanciar uma conta

#### src/main
- Arquivo: `Main.java`
- Classe **Main** que realizará toda a interação do programa


# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Carlos Hayden</sub>](https://github.com/JunhaumHayden) |
| :---: |

