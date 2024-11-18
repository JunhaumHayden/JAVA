# Testes de exceções

## 1. assertThrows
Este método é usado para verificar se um bloco de código lança uma exceção específica. Ele garante que o comportamento esperado ocorre em situações de erro.

### Assinatura
```java
<T extends Throwable> T assertThrows(Class<T> expectedType, Executable executable, String message);
```

- `expectedType`: Classe da exceção esperada.
- `executable`: Bloco de código ou expressão lambda a ser executado.
- `message` _(opcional)_: Mensagem de erro exibida caso o teste falhe.

## 2. assertDoesNotThrow
Este método é usado para garantir que um bloco de código não lança nenhuma exceção. Ele é útil para testar cenários onde a execução deve **ser bem-sucedida**.

### Assinatura

```java
<T> T assertDoesNotThrow(Executable executable, String message);
```
- `executable`: Bloco de código ou expressão lambda a ser executado.
- `message` _(opcional)_: Mensagem de erro exibida caso o teste falhe.


## Diferenças entre `assertThrows` e `assertDoesNotThrow`
| Característica                      | `assertThrows`                                  | `assertDoesNotThrow`                   |
|-------------------------------------|------------------------------------------------|----------------------------------------|
| **Objetivo**                        | Verificar se uma exceção específica é lançada  | Verificar que nenhuma exceção é lançada |
| **Uso comum**                       | Testar falhas esperadas, como validações de parâmetros | Testar fluxos normais ou de sucesso     |
| **Retorno**                         | A exceção lançada                              | O valor de retorno do bloco de código  |


## Principais vantagens
- _Legibilidade_: Testes tornam-se mais descritivos e fáceis de entender.
- _Isolamento_: Foco em validar o comportamento de exceções.
- _Flexibilidade_: Suporte a expressões lambda e blocos de código complexos.

Esses métodos são essenciais para garantir que o código funcione corretamente tanto em cenários esperados quanto em situações de erro.