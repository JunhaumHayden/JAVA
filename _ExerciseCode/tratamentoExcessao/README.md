<div align="center">
<img src="https://hermes.dio.me/tracks/a039b34c-7aa8-4a3d-b765-07c8c837f67a.png" alt="Logo BackEnd" width="80">
<h1>Java</h1>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCcxkA70BX5H1N1FFSkncQ-InOpqloUVZLcA&usqp=CAU" alt="Logo Bootcamp" width="100">
</div>

# #JavaCodes



<h1 align="center"> Tratamento de Exceções </h1>



<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## Descrição:

# Estruturas excepcionais

## Exceções

Ao executar o código Java, diferentes erros podem acontecer: erros de codificação feitos pelo programador, erros devido a entrada errada ou outros imprevistos.

Quando ocorre um erro, o Java normalmente para e gera uma mensagem de erro. O termo técnico para isso é: Java lançará uma **exceção** (jogará um erro).

De forma interpretativa em Java, um erro é algo irreparável, a aplicação trava ou é encerrada drasticamente. Já exceções é um fluxo inesperado da nossa aplicação, exemplo: Querer dividir um valor por zero, querer abrir um arquivo que não existe, abrir uma conexão de banco com usuário ou senha inválida. Todos estes cenários e os demais não são erros mas sim fluxos não previstos pela aplicação.

É ai que entra mais uma responsabilidade do desenvolvedor, prever situações iguais a estas e realizar o que denominamos de _**Tratamento de Exceções**_.

### Mão na massa

Para um cenário onde via terminal informamos alguns dados pessoais.

```java
import java.util.Locale;
import java.util.Scanner;

public class AboutMe 
{
    private static Scanner scanner =  new Scanner(System.in);
    public static void main(String[] args) 
    {
        String nome = null;
        String sobrenome = null;
        int idade = 0;
        double altura = 0;
        boolean flag = false;
        while (!flag)
        {
            try 
            {
                System.out.println("Informe um nome: ");
                nome = scanner.nextLine();
                System.out.println("Informe um sobrenome: ");
                sobrenome = scanner.nextLine();
                System.out.println("Informe a idade: ");
                idade = scanner.nextInt();
                System.out.println("Informe a altura: ");
                altura = scanner.nextDouble();
                flag = true;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Os campos 'idade' e 'altura' precisam ser numéricos. Por favor, tente novamente.");
                scanner.nextLine(); // Limpa o buffer do scanner
            }
        }
        System.out.println("O nome é: " + nome + " " + sobrenome );
        System.out.println("Idade de: " + idade);
        System.out.println("Altura de: " + altura + "cm ");
    }  
}
```

Aparentemente é um programa simples, mas listando algumas possíveis exceções que podem acontencer.

* Não informar o nome e sobrenome
* O valor da idade ter um caractere NÃO numérico
* O valor da altura ter uma vírgula ao invês de ser um ponto _**(conforme padrão americano)**_

Executando o programa com os valores abaixo, vamos entender qual exceção acontecerá:

| Entrada               | Valor           | Exceção                          | Causa                                                                                        |
| --------------------- | --------------- | -------------------------------- | -------------------------------------------------------------------------------------------- |
| Digite seu nome:      | **Marcelo**     |                                  |                                                                                              |
| Digite seu sobrenome: | **Azevedo**     |                                  |                                                                                              |
| Digite sua idade:     | **quinze (15)** | java.util.InputMismatchException | O programa esperava o valor do tipo numérico  inteiro.                                       |
| Digite sua altura:    | **1,65**        | java.util.InputMismatchException | O programa esperava o valor do tipo numérico decimal no formata americano, exemplo: **1.65** |

>  **&#8505;**
> A melhor forma de prever que pode ocorrer uma exceção, é pensar que ela pode ocorrer.\
> _**Lei de Murphy**_


### Conhecendo algumas exceções já mapeadas

A linguagem Java dispõe de uma vasta lista de classes que representam exceções, abaixo iremos apresentar as mais comuns:

| Nome                           | Causa                                                                |
| ------------------------------ | -------------------------------------------------------------------- |
| java.lang.NullPointerException | Quando tentamos obter alguma informação de uma variável nula.        |
| java.lang.ArithmeticException  | Quando tentamos dividir um valor por zero.                           |
| java.sql.SQLException          | Quando existe algum erro relacionado a interação com banco de dados. |
| java.io.FileNotFoundException  | Quando tentamos ler ou escrever em um arquivo que não existe.        |

### Tratamento de exceções

E quando inevitavelmente ocorrer uma exceção? Como nós desenvolvedores podemos ajustar o nosso algoritmo para amenizar o ocorrido?

A instrução **`try`** permite que você defina um bloco de código para ser testado quanto a erros enquanto está sendo executado.&#x20;

A instrução **`catch`** permite definir um bloco de código a ser executado, caso ocorra um erro no bloco try.&#x20;

A instrução **`finally`** permite definir um bloco de código a ser executado independente de ocorrer um erro ou não. As palavras-chave `try` e `catch` vêm em pares:&#x20;

Estrutura de um bloco com try e catch

```java
try {
  //  bloco de código conforme esperado
}
catch(Exception e) {// precisamos saber qual exceção
  // bloco de código que captura as exceções que podem acontecer
  // em caso de um fluxo não previsto
}
```

> ⚠️ **Aviso:**
> O bloco **`try`** / **`catch`** pode conter um conjunto de **catchs** correspondentes a cada exceção que **prevista** em uma funcionalidade do programa.


### Hierarquia das exceções

A linguagem Java dispõe de uma variedade de classes que representam exceções, e estas classes são organizadas em uma hierarquia denominadas **Checked and Unchecked Exceptions** ou _Exceções Checadas e Não Checadas_.&#x20;

![](<../.gitbook/assets/image (6).png>)

>  **&#8505;**
> O que determina uma exceção ser classificado como **checada** ou **não checada** ?\
> É o risco dela ser disparada logo você precisa tratá-la, exemplo:


Pode-se realizar de duas maneiras a conversão de uma String para um número. Explorando as formas de exceções em cada uma com o texto contendo Alfanuméricos.

```java
public class ExemploExcecao {
    public static void main(String[] args) 
    {
        ExemploRunTimeException();  
        ExemploException();
    }
    private static void ExemploRunTimeException()
    {
        Number valor = Double.valueOf("a1.75");
        System.out.println(valor);
    }
    public static void ExemploException()
    {
        Number valor;
        try {
            valor = NumberFormat.getInstance().parse("a1.75");
            System.out.println(valor);
        } catch (ParseException e) {
            e.printStackTrace();
        } 
    }
}
```

>  **&#8505;**
> 
> Os métodos apresentarão uma exceção ao serem executadas, o método `ExemploRunTimeException` é um exemplo de ***RunTimeException*** que determina que a exceção precisa ocorrer para ser tratada, ou seja, a IDE não apresenta sugestões, ocorrendo erro somente na execução.
> O método `ExemploException` é um exemplo de ***Exception*** que determina que a exceção precisa ser tratada antes de ocorrer, ou seja, a IDE indica um erro e segere tratar, pois o método `parse()` pode disparar uma exceção **checada**, logo deverá ser tratada explicitamente com **`try \ catch`**.


### Exceções customizadas

Pode-se criar exceções customizadas baseadas em regras de negócio e assim melhor direcionar quem for utilizar os recursos desenvolvidos no projeto, exemplo:

* Como regra de negócio, para formatar um cep necessita sempre de ter 8 dígitos, caso contrário lançará uma exceção que denominamos de **CepInvalidoException**.
* Passo01: cria-se a exceção:

```java
public class CepInvalidoException extends Exception {}
```

* Passo02: Cria-se o método de formatação de cep.

```java
static String formatarCep(String cep) throws CepInvalidoException{
        if(cep.length() != 8)
          throw new CepInvalidoException();
        
          //simulando um cep formatado
          return "23.765-064";
    }
```

#### Referências

> <img src="https://www.w3schools.com/images/w3schools_logo_436_2.png" alt="Logo W3Schools" width="40">
> 
> [Exercicios sobre try-catch em Java](https://www.w3schools.com/java/java_try_catch.asp)

> <img src="https://upload.wikimedia.org/wikipedia/commons/c/c3/Oracle_Logo.svg" alt="Logo Oracle" width="40">
> 
> [Visite o artigo sobre try-catch em Java](https://www.oracle.com/br/technical-resources/article/java/erros-java-exceptions.html)


### *Tópicos*:

Revisar sobre:
- <details><summary>Tratamento de Exceções</summary></details>
- <details><summary>try-catch</summary></details>
- <details><summary>RunTimeException</summary></details>
- <details><summary>Exception</summary></details>
- - <details><summary>Javadoc</summary></details>
- - <details><summary>Terminal</summary></details>


## ✅ O que você vai encontrar aqui:

### Uso e comportamento Esperado:

- Abrir o código fornecido em uma IDE.
- Executar o codigo utilização os parametros incorretos para verificar o tratamento da exceção
- Observar a apresentação da informação de parametro invalido e a solicitação para tentar novamente.

### Diagram
<table>
  <tr>
    <td>
      <img src="https://freecomputerbooks.com/covers/UML-Process.gif" alt="UML Image" width="60">
    </td>
    <td>
      <p> - Não Aplicável.</p>
      <p> - para esse exercício</p>
    </td>
  </tr>
</table>



  
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDmxBf388rTztkURwI__dAM73TG_Pe1lqSGdiuulglYMV1c4XnB8qyGgi48bgD4QPtIXI&usqp=CAU" alt="Diagrama de Classe" width="40">


### Estrutura dos Diretórios

O workspace contém três diretórios por padrão, onde:

- `src`: diretório para manter os códigos fontes,
- - Arquivo: `AboutMe.java`
- - Classe **AboutMe** cenário onde via terminal informamos alguns dados pessoais.
- - Arquivo: `ExemploExcecao.java`
- - Classe **ExemploExcecao** cenário explora-se as formas de exceções checadas e não checadas.
- `lib`: diretório para manter dependências
- `doc`: diretório com a documentação javadoc

Enquanto isso, os arquivos compilados serão gerados no diretório `bin` por padrão.

> Se você deseja personalizar a estrutura de diretórios, abra `.vscode/settings.json` a atualize as configurações relacionadas lá.

## Dependency Management

A visualização `JAVA PROJECTS` permite que você gerencie suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).



# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Carlos Hayden</sub>](https://github.com/JunhaumHayden) |
| :---: |

