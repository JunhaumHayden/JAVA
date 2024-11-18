# Assumptions 
No JUnit são um conjunto de métodos utilizados para definir pré-condições que precisam ser atendidas para que um teste seja executado. Se a condição especificada pela Assumption não for atendida, o teste será ignorado em vez de ser marcado como falho.

Essa abordagem é útil para situações em que o teste depende de um ambiente ou condição específica, como variáveis de ambiente, configurações do sistema ou dados dinâmicos.

## Por que usar Assumptions?
- Evitar falhas desnecessárias: Se um teste só é válido em determinadas condições, é melhor ignorá-lo quando essas condições não forem atendidas.
- Testes dependentes do ambiente: Útil para testes que dependem de configurações específicas, como sistemas operacionais, versões de bibliotecas ou presença de variáveis de ambiente.
- Testes condicionais: Permite definir claramente quando um teste deve ou não ser executado.

### Métodos principais
As Assumptions são fornecidas pela classe estática org.junit.jupiter.api.Assumptions no JUnit 5. Os métodos principais incluem:

1. `assumeTrue(condition)`
* Executa o teste apenas se a condição for verdadeira.
    Exemplo:
```java
    Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Windows"));
```
2. `assumeFalse(condition)`
* Executa o teste apenas se a condição for falsa.
    Exemplo:
```java
    Assumptions.assumeFalse(System.getenv("CI") != null);
```
3. `assumeTrue(condition, message)`
* Similar a assumeTrue, mas permite incluir uma mensagem para o caso de o teste ser ignorado.
    Exemplo:
```java
    Assumptions.assumeTrue(System.getProperty("user.name").equals("admin"), "Usuário não autorizado.");
```
4. `assumeThat(actual, matcher)`
* Realiza uma comparação com base em um matcher (usado com bibliotecas como Hamcrest).
    Exemplo:
```java
    Assumptions.assumeThat(42, Matchers.greaterThan(40));
```
### Exemplo prático 1: Dependência de sistema operacional
```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

class SistemaOperacionalTest {

    @Test
    void deveExecutarApenasNoWindows() {
        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Windows"), 
            "Teste ignorado: não está rodando no Windows.");

        // Código específico para Windows
        System.out.println("Executando no Windows!");
    }

    @Test
    void deveExecutarApenasNoLinux() {
        Assumptions.assumeTrue(System.getProperty("os.name").startsWith("Linux"), 
            "Teste ignorado: não está rodando no Linux.");

        // Código específico para Linux
        System.out.println("Executando no Linux!");
    }
}
```

Exemplo prático 2: Dependência de variável de ambiente
```java
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;

class VariaveisAmbienteTest {

    @Test
    void deveExecutarApenasEmAmbienteDeProducao() {
        Assumptions.assumeTrue("production".equals(System.getenv("APP_ENV")),
            "Teste ignorado: não está em ambiente de produção.");

        // Código para ambiente de produção
        System.out.println("Rodando em produção.");
    }
}
```
## Comportamento de Assumptions
- _Condição verdadeira_: O teste será executado normalmente.
- _Condição falsa_: O teste será ignorado, e o relatório indicará que ele não foi executado.
- No JUnit 5, testes ignorados por Assumptions não são tratados como falhas, mas como skipped.

## Benefícios de Assumptions
1. __Reduz ruídos no relatório__: Ignorar testes desnecessários ajuda a focar nos que realmente falharam.
2. __Isola dependências de ambiente__: Ajuda a evitar falhas em testes devido a condições externas que não estão sob controle.
3. __Melhora a flexibilidade dos testes__: Permite executar testes apenas quando as condições são apropriadas.