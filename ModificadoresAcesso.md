## Modificadores de Acesso em Java
Os modificadores de acesso em Java são usados para definir a visibilidade e o escopo de classes, métodos, construtores e variáveis. Eles controlam onde esses elementos podem ser acessados e ajudam a implementar o encapsulamento, um dos principais conceitos da programação orientada a objetos. Existem quatro modificadores de acesso em Java:

- public
- protected
- default (nenhum modificador explícito)
- private

### _public_

- Visibilidade: Em qualquer lugar.
- Descrição: Define que a classe, método ou variável é acessível de qualquer outro código. Membros declarados como public são acessíveis de qualquer outra classe. Não há restrições sobre sua visibilidade.
- Uso: É comumente usado para métodos e variáveis que precisam ser acessados de outras classes.
```java
public class MinhaClasse {
    public int numero;
    
    public void meuMetodo() {
        // Código do método
    }
}
```

### _protected_

- Visibilidade: No mesmo pacote e em subclasses (mesmo que estejam em pacotes diferentes).
- Descrição: Define que o método ou variável é acessível dentro do mesmo pacote e por subclasses. Membros declarados como protected são acessíveis dentro de seu próprio pacote e também por subclasses.
- Uso: Utilizado quando você deseja permitir o acesso em subclasses, mas esconder dos usuários não relacionados (outras classes não pertencentes ao mesmo pacote ou à hierarquia de herança).

```java
public class MinhaClasse {
    protected int numero;
    
    protected void meuMetodo() {
        // Código do método
    }
}
```

### _default_ (pacote-privado)

- Visibilidade: Apenas no mesmo pacote.
- Descrição: Se nenhum modificador for especificado, a visibilidade padrão (package-private) é aplicada, onde a classe, método ou variável é acessível apenas dentro do mesmo pacote. Membros que não têm um modificador de acesso explícito são acessíveis apenas por outras classes no mesmo pacote.
- Uso: Útil para encapsular membros e classes dentro de um pacote específico.

```java
class MinhaClasse {
    int numero;
    
    void meuMetodo() {
        // Código do método
    }
}
```

### _private_

- Visibilidade: Dentro da própria classe.
- Descrição: Define que o método ou variável é acessível apenas dentro da própria classe. Membros declarados como private são acessíveis apenas dentro da classe em que são declarados.
- Uso: Utilizado para ocultar detalhes de implementação e proteger os dados de acesso externo.
```java
public class MinhaClasse {
    private int numero;
    
    private void meuMetodo() {
        // Código do método
    }
}
```

## Resumo dos Modificadores de Acesso
| Modificador |	Classe Própria	| Subclasse (Mesmo Pacote)	| Subclasse (Diferente Pacote)	| Outro Pacote  |
| ----------- | --------------- | ------------------------- | ----------------------------- | ------------- |
|public	      | Sim	            | Sim	                    | Sim	                        |  Sim          |
|protected    | Sim	            | Sim	                    | Sim	                        |  Não          |
|default      | Sim	            | Sim	                    | Não	                        |  Não          |
|private      | Sim	            | Não	                    | Não	                        |  Não          |

## Modificadores de Classe
Em Java, os modificadores de classe determinam o comportamento e a visibilidade de classes, métodos e variáveis. Os principais modificadores de classe são:
- 1. _abstract_
- 2. _final_
- 3. _static_
- 4. _strictfp_  

### _abstract_
Descrição: Define uma classe abstrata que não pode ser instanciada diretamente. Deve ser subclassificada por outras classes.
Exemplo:
```java
public abstract class Animal {
    // Métodos abstratos e concretos
}
```

### _final_
Descrição: Define uma classe que não pode ser subclassificada. Também pode ser usado para métodos e variáveis para impedir a modificação.
Exemplo:
```java
public final class Utility {
    // Métodos utilitários estáticos
}
```

### _static_
Descrição: Usado para definir membros de classe (variáveis e métodos) que pertencem à classe em si, e não a instâncias da classe. Não é usado para definir classes em nível superior (exceto para classes internas).
Exemplo:
```java
public class MyClass {
    public static int staticVariable;
    public static void staticMethod() {
        // Implementação
    }
}
```

### _strictfp_
Descrição: Usado para garantir que os cálculos em ponto flutuante dentro da classe ou método sigam as especificações IEEE 754 para maior portabilidade.
Exemplo:
```java
public strictfp class PreciseCalculations {
    // Implementação de cálculos em ponto flutuante
}
```
> Esses modificadores de classe em Java permitem controlar a visibilidade e o comportamento das classes e seus membros, ajudando a garantir a encapsulação, a herança apropriada e o controle de acesso.

## Conceitos Relacionados
- Encapsulamento: O uso de modificadores de acesso é fundamental para implementar o encapsulamento, que protege os dados e restringe o acesso a eles.
- Herança: protected facilita a herança ao permitir que subclasses acessem membros de sua superclasse.
- Pacotes: default restringe o acesso a membros dentro do mesmo pacote, promovendo uma organização modular do código.

### Exemplos Práticos
#### Encapsulamento

```java
public class ContaBancaria {
    private double saldo;
    
    public double getSaldo() {
        return saldo;
    }
    
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }
    
    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
        }
    }
}
```

#### Herança

```java
public class Animal {
    protected void fazerSom() {
        System.out.println("Som do animal");
    }
}

public class Cachorro extends Animal {
    @Override
    protected void fazerSom() {
        System.out.println("Latido");
    }
}
```

> Compreender e usar corretamente os modificadores de acesso é essencial para escrever código Java seguro, robusto e bem estruturado.