<div align="center">
<img src="https://hermes.dio.me/tracks/a039b34c-7aa8-4a3d-b765-07c8c837f67a.png" alt="Logo BackEnd" width="80">
<h1>Java</h1>
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCcxkA70BX5H1N1FFSkncQ-InOpqloUVZLcA&usqp=CAU" alt="Logo Bootcamp" width="100">
</div>

# #JavaCodes



<h1 align="center"> JavaDoc </h1>



<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>


## Descrição:

# Terminal e Argumentos

Nem sempre executamos nosso programa Java pela IDE, já pensou nossos clientes tendo que instalar o Eclipse ou VsCode para rodar o sistema em sua empresa ?

Com a JVM devidamente configurada, nós podemos criar um executável do nosso programa e disponibilizar o instalador para qualquer sistema operacional.

No nosso caso iremos aprender como executar um programa Java via terminal como MS - DOS ou terminal do VsCode.

Vamos criar uma classe chamada `AboutMe.java` com o código abaixo:

```java
public class AboutMe {
    public static void main(String[] args) {
        System.out.println("Oi, fui executado pelo Terminal");
    }
}
```

{% hint style="info" %}
Observe que nosso projeto Java criado por um IDE, ele terá uma pasta chamada **bin**. É nesta pasta que ficarão os arquivos **.class**, o nosso `bytecode`.
{% endhint %}

![](<../.gitbook/assets/image (15).png>)

Mesmo usando uma IDE, nós sempre precisaremos identificar aonde se encontram as classes do nosso projeto, no meu caso está em: **/java/_ExerciseCode/aboutMe.**

![](<../.gitbook/assets/image (6) (1).png>)

## Terminal

Vamos ilustrar como executar uma classe, depois de compilada, sem precisar usar a IDE.

1. Abra o MS-DOS ou Power Shell
2. Localize o diretório do seu projeto: **`cd /java/_ExerciseCode/aboutMe`**
3. Acesse a pasta **** _bin_: ** `cd bin`**
4. Agora digite o comando:**`java AboutMe` ** _(nome da sua classe sem a extensão .**class**)_&#x20;

![](<../.gitbook/assets/image (14).png>)

## Argumentos

Quando executamos uma classe que contenha o método main, o mesmo permite que passemos um array `[]` de argumentos do tipo String. Logo podemos após a definição da classe a ser executada informar estes parâmetros, exemplo:

```
java MinhaClasse agumentoUm argumentoDois
```

Exemplo

```java
public class AboutMe {
    public static void main(String[] args) {
        //os argumentos começam com indice 0
        String nome = args [0];
        String sobrenome = args [1];
        int idade = Integer.valueOf(args[2]); //vamos falar sobre Wrappers
        double altura = Double.valueOf(args[3]);

        System.out.println("Ola, me chamo " + nome + " " + sobrenome);
        System.out.println("Tenho " + idade + " anos ");
        System.out.println("Minha altura é " + altura + "cm ");
    }
}

```

**Passando valores aos argumentos pelo VsCode.**

![](<../.gitbook/assets/image (12).png>)

![](<../.gitbook/assets/image (8).png>)

```json
{
    "version": "0.2.0",
    "configurations": [
        {
            "type": "java",
            "request": "launch",
            "mainClass": "AboutMe",
            "args": ["Carlos", "hayden", "28", "1.88"]
        }
    ]
}
```

Executando o programa agora no terminal

```
cd /java/_ExerciseCode/aboutMe
cd bin

java AboutMe Carlos Hayden 28 1.88

```

## Scanner

Nos exemplos anteriores percebemos que podemos receber dados digitados pelo usuário do nosso sistema, porém tudo precisa estar em uma linha e também é necessário informar os valores nas posições correspondentes. Esta abordagem pode deixar margens de execução com erro do nosso programa. Para isso, com a finalidade de deixar as nossas entradas de dados mais seguras agora vamos receber estes dados via **Scanner**.

A classe **Scanner** permite que o usuário tenha uma interação mais assertiva com o nosso programa, veja como vamos mudar o nosso programa **`AboutMe`** para deixar mais intuitivo aos usuários.

```java
import java.util.Locale;
import java.util.Scanner;

public class AboutMe {
    public static void main(String[] args) {
        //criando o objeto scanner
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        
        System.out.println("Digite seu nome");
        String nome = scanner.next();
        
        System.out.println("Digite seu sobrenome");
        String sobrenome = scanner.next();

        System.out.println("Digite sua idade");
        int idade = scanner.nextInt();
        
        System.out.println("Digite sua altura");
        double altura = scanner.nextDouble();

        
        //imprimindo os dados obtidos pelo usuario
        System.out.println("Ola, me chamo " + nome + " " + sobrenome);
        System.out.println("Tenho " + idade + " anos ");
        System.out.println("Minha altura é " + altura + "cm ");
        
        
    }
}

```



{% embed url="https://code.visualstudio.com/docs/java/java-debugging" %}

{% embed url="https://linuxtut.com/pass-parameters-when-debugging-vscode-java.-note-462e0" %}



### Exercício sobre Sintaxe e utilização.

- Nome: Documentação 
- Função: Verificar o uso de comentarios de documentação inserido no código

### *Tópicos*:

Revisar sobre:

- <details><summary>Terminal</summary></details>
- <details><summary>Main args</summary></details>
- <details><summary>Classe Scanner</summary></details>


## ✅ O que você vai encontrar aqui:

### Uso e comportamento Esperado:

- Abrir o código fornecido em uma IDE.
- executar o programa através da linha de comando


### Estrutura dos Diretórios

#### Diagram
<table>
  <tr>
    <td>
      <img src="https://freecomputerbooks.com/covers/UML-Process.gif" alt="UML Image" width="60">
    </td>
    <td>
      <p> - Não Aplicável</p>
      <p> - para esse exercício</p>
    </td>
  </tr>
</table>



  
<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDmxBf388rTztkURwI__dAM73TG_Pe1lqSGdiuulglYMV1c4XnB8qyGgi48bgD4QPtIXI&usqp=CAU" alt="Diagrama de Classe" width="40">


## Folder Structure

O workspace contém dois diretórios por padrão, onde:

- `src`: diretório para manter os códigos fontes,
-  Arquivo: `AboutMe.java`
-  Classe **AboutMe** com os exemplos do exercício
- `lib`: pasta para manter dependências

Enquanto isso, os arquivos compilados serão gerados no diretório `bin` por padrão.

> Se você deseja personalizar a estrutura de diretórios, abra `.vscode/settings.json` a atualize as configurações relacionadas lá.

## Dependency Management

A visualização `JAVA PROJECTS` permite que você gerencie suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).



# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Carlos Hayden</sub>](https://github.com/JunhaumHayden) |
| :---: |

