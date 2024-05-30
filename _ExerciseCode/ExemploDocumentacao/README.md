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

# Documentação

Uma das maiores características da linguagem Java é que desde suas primeiras versões tínhamos em nossas mãos uma documentação rica e detalhada dos recursos da linguagem.

Conforme site oficial, podemos compreender e explorar todos os recursos organizados por pacotes e classes bem específicas sem nem mesmo escrever uma linha de código.

Link da documentação de uma das principais classes da linguagem Java.

{% embed url="https://docs.oracle.com/javase/7/docs/api/java/lang/String.html" %}
Documentação da classe String na versão 7 da linguagem
{% endembed %}

## Tags

**Quais as informações que obtemos através de classes documentadas na linguagem ?**
 *** Java Documentation *** é composto por tags que representam dados relevantes para a compreensão da proposta de uma classe e os conjunto de seus métodos e atributos conforme tabela abaixo:

| Tag      | Descrição                                              |
| -------- | ------------------------------------------------------ |
| @autor   | Autor / Criador                                        |
| @version | Versão do recurso disponibilizado                      |
| @since   | Versão / Data de início da disponibilização do recurso |
| @param   | Descrição dos parâmetros dos métodos criados           |
| @return  | Definição do tipo de retorno de um método              |
| @throws  | Se o método lança alguma exceção                       |

A classe Calculadora é um exemplo de documentação destacando as **tags** mais utilizadas.

*Código*

```java
/**
* <h1>Calculadora</h1>
* A Calculadora realiza operações matemáticas entre números inteiros
* <p>
* <b>Note:</b> Leia atentamente a documentação desta classes
* para desfrutar dos recursos oferecidos pelo autor
*
* @author  Junhaum Hayden
* @version 1.0
* @since   30/05/2024
*/
public class Calculadora {
    /**
   * Este método é utilizado para somar dois números inteiros
   * @param numeroUm este é o primeiro parâmetro do método
   * @param numeroDois este é o segundo parâmetro do método
   * @return int o resultado deste método é a soma dos dois números.
   */
    public int somar(int numeroUm, int numeroDois) {
        return  numeroUm + numeroDois;
    }
}

```

*Guia*
![](<../.gitbook/assets/image (15) (1).png>)


### Tipos de comentários


*One Line*
```
// Olá, eu sou um comentário em uma única linha
```


*Mult Line*
```
/* Olá,
 * Eu sou um comentario
 * que posso ser mais detalhadod
 * quando necessário
 */
```

*Documentation*
```
/** 
 * Estas duas estrelinhas acima
 * é para identificar que você
 * pretende elaborar um comentário
 * a nível de documentação.
 * Que incrível !!!
 */
```


{% hint style="danger" %}
Um comentário não possui a finalidade de **amenizar** um algoritmo não estruturado conforme as convenções da linguagem.&#x20;
{% endhint %}

```java
/*
 * Este método foi elaborado as pressas
 * por isso eu abrevei o nome das variáveis
 * mas olha, ele tem a finalidade somar ou  multiplicar
 * dois números
 * /
public int somaMultiplica (int n, int x, String m){
    int r = 0; // r é igual ao resultado
    if (m == "M"){ // M= multiplicação
        r= n * x;
    }else{
        // se não soma mesmo
        r = n + x
    }
    return r;
}
```

## Javadoc

**Javadoc** é um gerador de documentação criado pela [Sun Microsystems](https://pt.wikipedia.org/wiki/Sun\_Microsystems) para documentar a [API](https://pt.wikipedia.org/wiki/API) dos programas em [Java](https://pt.wikipedia.org/wiki/Linguagem\_de\_programa%C3%A7%C3%A3o\_Java), a partir do [código-fonte](https://pt.wikipedia.org/wiki/C%C3%B3digo-fonte). O resultado é expresso em [HTML](https://pt.wikipedia.org/wiki/HTML). É constituído, basicamente, por algumas marcações muitos simples inseridas nos comentários do programa.

Este sistema é o padrão de documentação de classes em Java, e muitas dos [IDEs](https://pt.wikipedia.org/wiki/Ambiente\_de\_desenvolvimento\_integrado) desta linguagem irão automaticamente gerar um Javadoc em [HTML](https://pt.wikipedia.org/wiki/HTML).

{% embed url="https://pt.wikipedia.org/wiki/Javadoc" %}

### Criando nossa documentação no formato html para disponibilizar via web.

```
// No terminal execute o comando abaixo

javadoc -encoding UTF-8 -docencoding ISO-8859-1  -d ../docs  src/*.java
```
*OBS:* Executar dentro do diretório raiz do projeto 
Após executar o comando será criado um diretório `DOCS` onde pode-se abrir o arquivo `index.html`


### Exercício sobre Sintaxe e utilização.

- Nome: Documentação 
- Função: Verificar o uso de comentarios de documentação inserido no código

### *Tópicos*:

Revisar sobre:
- <details><summary>Javadoc</summary></details>
- <details><summary>Terminal</summary></details>
- <details><summary>Main args</summary></details>
- <details><summary>Classe Scanner</summary></details>
- <details><summary>Classe String com método concat</summary></details>
- <details><summary>Concatenação</summary></details>

## ✅ O que você vai encontrar aqui:

### Uso e comportamento Esperado:

- Abrir o código fornecido em uma IDE.
- Construir os comentários com  utilização dos parametros corretos
- Observar a apresentação automatica dos comentário ao posicionar o cursor do mouse sobre os elementos.
- Gerar a documentação através da linha de comando


### Estrutura dos Diretórios

#### Diagram
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


## Folder Structure

O workspace contém dois diretórios por padrão, onde:

- `src`: diretório para manter os códigos fontes,
-  Arquivo: `Calculadora.java`
-  Classe **Calculadora** com os exemplos de comentários
- `lib`: pasta para manter dependências

Enquanto isso, os arquivos compilados serão gerados no diretório `bin` por padrão.

> Se você deseja personalizar a estrutura de diretórios, abra `.vscode/settings.json` a atualize as configurações relacionadas lá.

## Dependency Management

A visualização `JAVA PROJECTS` permite que você gerencie suas dependências. Mais detalhes podem ser encontrados [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).



# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Carlos Hayden</sub>](https://github.com/JunhaumHayden) |
| :---: |

