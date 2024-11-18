# Assertions
A classe `Assertions` no JUnit é utilizada para verificar o comportamento esperado de um sistema durante os testes unitários. Ela fornece métodos estáticos que ajudam a:
1. comparar valores
2. validar condições
3. garantir que a lógica testada funcione como esperado.

> Esses métodos são a base dos testes unitários, pois permitem verificar se os resultados gerados pelo código correspondem ao esperado.

### Principais métodos da classe Assertions
Os métodos mais comuns incluem:

1. `assertEquals(expected, actual)`
    * Compara o valor esperado com o valor real.
    * Testa se dois objetos ou valores primitivos são iguais.
Exemplo:
```java
@Test
void testSoma() {
    int resultado = Calculadora.soma(2, 3);
    Assertions.assertEquals(5, resultado, "A soma deveria ser 5");
}
```

2. `assertNotEquals(expected, actual)`
    * Testa se dois objetos ou valores não são iguais.
Exemplo:
```java
@Test
void testDiferenca() {
    int resultado = Calculadora.soma(2, 3);
    Assertions.assertNotEquals(4, resultado, "O resultado não deveria ser 4");
}
```

3. `assertTrue(condition)` e `assertFalse(condition)`
    * Verifica se uma condição booleana é verdadeira ou falsa.
Exemplo:
```java
@Test
void testMaiorQueZero() {
    int resultado = Calculadora.soma(2, 3);
    Assertions.assertTrue(resultado > 0, "O resultado deveria ser maior que zero");
}
```

4. `assertNull(object)` e `assertNotNull(object)`
    * Verifica se um objeto é nulo ou não.
Exemplo:
```java
@Test
void testObjetoNaoNulo() {
    String nome = "JUnit";
    Assertions.assertNotNull(nome, "O objeto não deveria ser nulo");
}
```

5. `assertSame(expected, actual)` e `assertNotSame(expected, actual)`
    * Verifica se dois objetos são ou não a mesma instância.
Exemplo:
```java
@Test
void testMesmoObjeto() {
    String nome1 = "JUnit";
    String nome2 = nome1;
    Assertions.assertSame(nome1, nome2, "Os objetos deveriam ser a mesma instância");
}
```

6. `assertThrows(expectedType, executable)`
    * Verifica se uma exceção específica é lançada durante a execução de um código.
Exemplo:
```java
@Test
void testExcecao() {
    Assertions.assertThrows(ArithmeticException.class, () -> {
        int resultado = 10 / 0;
    }, "Deveria lançar ArithmeticException");
}
```

7. `assertAll(executables...)`
    * Permite agrupar várias verificações em um único teste.
Exemplo:
```java
@Test
void testAgrupado() {
    int resultado = Calculadora.soma(2, 3);
    Assertions.assertAll(
        () -> Assertions.assertTrue(resultado > 0, "O resultado deveria ser positivo"),
        () -> Assertions.assertEquals(5, resultado, "A soma deveria ser 5")
    );
}
```

8. `fail(message)`
    * Força a falha de um teste explicitamente.
    * Útil para cenários em que não se espera que o código chegue a certo ponto.
Exemplo:
```java
@Test
void testNaoDeveriaPassar() {
    if (someCondition()) {
        Assertions.fail("Este ponto não deveria ser alcançado");
    }
}
```

## Por que usar Assertions?
   - _Validação de resultados_: Certifica que os valores calculados pelo sistema correspondem ao esperado.
   - _Clareza_: Fornece mensagens claras para entender o que deu errado.
   - _Automatização_: Permite automatizar a verificação de resultados sem necessidade de intervenção manual.
   - _Confiabilidade_: Aumenta a confiança de que o código funciona conforme esperado.
Exemplo completo com vários `Assertions`
```java
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

    @Test
    void testOperacoes() {
        Assertions.assertAll(
            () -> Assertions.assertEquals(5, Calculadora.soma(2, 3), "Soma incorreta"),
            () -> Assertions.assertTrue(Calculadora.soma(2, 3) > 0, "Resultado deveria ser positivo"),
            () -> Assertions.assertThrows(ArithmeticException.class, () -> {
                int resultado = Calculadora.divide(10, 0);
            }, "Deveria lançar exceção ao dividir por zero")
        );
    }
}
```
