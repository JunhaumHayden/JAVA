<div align="center">
<img src="https://hermes.dio.me/tracks/a039b34c-7aa8-4a3d-b765-07c8c837f67a.png" alt="Logo BackEnd" width="80">

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCcxkA70BX5H1N1FFSkncQ-InOpqloUVZLcA&usqp=CAU" alt="Logo Bootcamp" width="100">
</div>

###### #JavaCodes



<h1 align="center"> Control Flow Statement </h1>



<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## Descrição

### Programa

O programa Contador é um simples sistema de contagem que recebe dois números inteiros via terminal e imprime uma série de números incrementados, desde 1 até a diferença entre os dois números fornecidos. Caso o primeiro número seja maior que o segundo, o programa lança uma exceção customizada chamada ParametrosInvalidosException. O código está dentro de um bloco `while (true)` para permitir repetidas tentativas de entrada de dados.
O usuário pode digitar '0' em qualquer ponto para sair do loop e terminar o programa.

### Como usar

- Compilação: Compile os arquivos .java utilizando o javac.

``` bash
javac ParametrosInvalidosException.java
javac Contador.java
```

- Execução: Execute o programa utilizando o java.

``` bash
java Contador
```

- Interação: O programa solicitará dois números inteiros.

``` markdown

**Programa**: "Digite o primeiro parâmetro (ou 0 para sair):"  
**Usuário**: 12 (depois ENTER para o próximo campo)
**Programa**: "Digite o segundo parâmetro (ou 0 para sair):"  
**Usuário**: 30 (depois ENTER para o próximo campo)
``` 

- Saída: O programa imprimirá uma série de números incrementados.

``` markdown
Imprimindo o número 1
Imprimindo o número 2
Imprimindo o número 3
...
Imprimindo o número 18
Digite o primeiro parâmetro (ou 0 para sair):
0
Programa encerrado.
```
- Erro: Se o primeiro parâmetro for maior que o segundo, o programa exibirá a mensagem de erro:

``` markdown
"O segundo parâmetro deve ser maior que o primeiro"
"Digite o primeiro parâmetro (ou 0 para sair):"
```

Se uma entrada inválida for fornecida:

``` mardown
Digite o primeiro parâmetro (ou 0 para sair):
abc
Os parâmetros devem ser números inteiros.

Digite o primeiro parâmetro (ou 0 para sair):
```

### Conceitos Utilizados

>- Exceções Customizadas: Implementação da classe `ParametrosInvalidosException` para tratar um cenário específico de erro.
>- Manipulação de Entrada de Usuário: Utilização da classe `Scanner` para capturar a entrada de dados via terminal.
>- Estruturas de Repetição: Utilização do laço `for` para realizar a contagem e impressão dos números.
>- Estruturas de Controle de Fluxo: Uso de `try-catch` para tratamento de exceções e garantir que o `Scanner` seja fechado corretamente.
  
>❗️ Esse projeto exemplifica a utilização de conceitos básicos de Java, como tratamento de exceções, loops, entrada de dados, e mensagens customizadas para o usuário.

### Gerenciamento de Dependências

Para este projeto, não foram utilizadas dependências externas. Todo o código foi escrito utilizando apenas as bibliotecas padrão do Java.


# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Carlos Hayden</sub>](https://github.com/JunhaumHayden) |
| :---: |