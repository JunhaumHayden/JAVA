

<div align="center">

<img src="https://avatars.githubusercontent.com/u/874086?s=200&v=4" alt="Logo Java" width="220">
</div>
<h1 align="center"> Testes Unitários com JUnit </h1>

![Static Badge](https://img.shields.io/badge/STATUS-Em_Constru%C3%A7%C3%A3o-green)


![Static Badge](https://img.shields.io/badge/Powered_by-JUnit-red) ![Static Badge](https://img.shields.io/badge/Powered_by-Spring%20Boot-green) ![Static Badge](https://img.shields.io/badge/Powered_by-Maven-blue)



# Testes unitários com JUnit

Respositório com roteiros e exemplos de como utilizar JUnit no dia a dia como dev.
JUnit 4 e JUnit 5 são duas versões do popular framework de testes em Java, mas elas diferem significativamente em arquitetura, funcionalidade e sintaxe.

## Aqui estão as principais diferenças entre as duas:

### 1. Arquitetura

__JUnit 4__:
   - _Monolítica_: Consiste em um único jar que inclui todas as funcionalidades.
   - O design é menos modular, o que dificulta a extensão ou personalização.

__JUnit 5__:
   - _Modular_: Dividida em três componentes principais:
   - _JUnit Platform_: Base para execução de testes (compatível com IDEs e ferramentas de build).
   - _JUnit Jupiter_: Novo modelo de programação e extensão para escrever testes.
   - _JUnit Vintage_: Suporte para executar testes escritos com JUnit 3 e 4.

>Essa modularidade facilita a integração com outras bibliotecas e a evolução do framework.

## 2. Declaração de Dependências
__JUnit 4__: Uma única dependência:
```markdown
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.x</version>
    <scope>test</scope>
</dependency>
```

__JUnit 5__: Dependências separadas para cada módulo:
```markdown
   <dependency>
      <groupId>org.junit.jupiter</groupId>
      <artifactId>junit-jupiter-engine</artifactId>
      <version>${junit.jupiter.version}</version>
      <scope>test</scope>
   </dependency>
```
## 3. Anotações
__JUnit 4__:
    _Anotações principais_:
   * `@Test`: Marca um método como um teste.
   * `@Before` e `@After`: Executados antes e depois de cada teste.
   * `@BeforeClass` e `@AfterClass`: Executados antes e depois de todos os testes em uma classe (devem ser static).
   * `@Ignore`: Ignora um teste.
    
__JUnit 5__:
> Algumas anotações foram renomeadas ou substituídas:
   * `@Test`: Igual ao JUnit 4.
   * `@BeforeEach` e `@AfterEach`: Substituem `@Before` e `@After`.
   * `@BeforeAll` e `@AfterAll`: Substituem `@BeforeClass` e `@AfterClass` (podem ser `static` ou métodos de instância se a classe de teste usar anotação `@TestInstance(Lifecycle.PER_CLASS))`.
   * `@Disabled`: Substitui `@Ignore`.
>Novas anotações, como:
   * `@DisplayName`: Fornece um nome descritivo para o teste.
   * `@Nested`: Permite criar classes de teste aninhadas.
   * `@Tag`: Usado para categorizar testes.

## 4. Suporte a Novas Funcionalidades
__JUnit 4__:
   * Suporte limitado para expressar dependências entre testes ou personalizar a execução.
   
__JUnit 5__:
   * Suporte a `DynamicTest`: Criação de testes dinamicamente em tempo de execução.
   * `Assertions` e `Assumptions` mais robustos e flexíveis.
   * Melhor suporte para programação funcional e **lambda**.
   * Extensões mais poderosas com a API Extension.
  
## 5. Extensibilidade
__JUnit 4__:
   * Extensões limitadas por meio de `Rules` e `Runners`.
   * Menos flexível para criar novas funcionalidades.
    
__JUnit 5__:
   * Extensões são gerenciadas por meio da API `Extension`.
   * Melhor integração com outras bibliotecas e frameworks.
    
## 6. Execução de Testes
__JUnit 4__:
   * Executado com base em ferramentas que suportam JUnit 4 (por exemplo, Gradle ou Maven).
   * Dependência do `Runner`.
    
__JUnit 5__:
   * Executado na **JUnit Platform**, o que permite a execução de múltiplos frameworks de teste.
   * Suporte para testes escritos em JUnit 3, 4 e 5 através do módulo `Vintage`.
## 7. Compatibilidade
__JUnit 4__:
   * Somente suporta o modelo de programação JUnit 4.
  
__JUnit 5__:
   * Compatível com testes antigos (JUnit 3 e 4) por meio do `JUnit Vintage`.

## Resumo
| Característica                     | JUnit 4                        | JUnit 5                                |
|------------------------------------|---------------------------------|----------------------------------------|
| **Arquitetura**                    | Monolítica                     | Modular (Platform, Jupiter, Vintage)  |
| **Anotações**                      | Simples, menos flexíveis       | Mais completas e descritivas          |
| **Extensibilidade**                | Limitada (Rules, Runners)      | API Extension poderosa                |
| **Compatibilidade**                | Apenas JUnit 4                 | JUnit 3, 4 e 5                        |
| **Suporte a programação funcional**| Não                            | Sim                                    |


## 8. Exemplo de Roteiros de Teste

1. [Configurando JUnit](CONFIGURACAO.md)
2. [Classe Assertions](./src/test/java/com/github/hayden/junit/AssertionsTest.md)
3. [Classe Assumptions](./src/test/java/com/github/hayden/junit/AssumptionsTeste.md)
4. [Exceptions](./src/test/java/com/github/hayden/junit/ExceptionsTeste.md)

# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Hayden Junior</sub>](https://github.com/JunhaumHayden) |
| :---: |
