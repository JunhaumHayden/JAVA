Os padrões de projeto Inversão de Controle (IoC) e Injeção de Dependência (DI) estão relacionados ao princípio de responsabilidade única, modularidade e desacoplamento no design de software. Esses conceitos são fundamentais no desenvolvimento de aplicações modernas, especialmente em frameworks como o Spring.

## 1. Inversão de Controle (IoC)
   Definição

A Inversão de Controle é um princípio onde o controle sobre o fluxo de execução ou criação de objetos é delegado a um contêiner ou framework, em vez de ser gerenciado manualmente pelo código do desenvolvedor.

### Motivação

Evitar dependências rígidas entre as classes.
Tornar o código mais testável e modular.
Como funciona

No paradigma tradicional, o próprio código cria e gerencia as dependências.
Com IoC, o controle é "invertido", e o contêiner (como o Spring) injeta essas dependências automaticamente.
## 2. Injeção de Dependência (DI)
   Definição

A Injeção de Dependência é uma técnica de IoC onde as dependências de uma classe são fornecidas ("injetadas") por um contêiner ou framework, em vez de serem criadas dentro da própria classe.

#### Como funciona

A DI pode ser feita de três formas principais:

### Injeção via Construtor
As dependências são passadas como argumentos para o construtor da classe.
Exemplo:
```java
public class Car {
private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }
}
```

### Injeção via Setter (ou Método)
As dependências são configuradas usando métodos setters.
Exemplo:
```java
public class Car {
private Engine engine;

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
```

### Injeção por Campo (Direta)
As dependências são atribuídas diretamente a campos da classe (frequentemente usadas com anotações como @Autowired no Spring).
Exemplo:
```java
public class Car {
@Autowired
private Engine engine;
}
```
## IoC e DI em ação
### Sem IoC e DI (Paradigma Tradicional)

Aqui, a classe é responsável por criar suas dependências, resultando em forte acoplamento.

Exemplo:
```java
public class Car {
private Engine engine;

    public Car() {
        this.engine = new Engine(); // Forte acoplamento
    }
}
```

### Com IoC e DI

O contêiner (como Spring) é responsável por fornecer a dependência.

Exemplo:
```java
@Component
public class Car {
private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine; // A dependência é injetada
    }
}
```

### Benefícios do IoC e DI
1. Desacoplamento:
As classes não criam nem gerenciam suas dependências diretamente, tornando-as mais independentes.
2. Testabilidade:
Permite a substituição de dependências reais por mock objects, facilitando testes unitários.
3. Reusabilidade:
Classes podem ser reutilizadas com diferentes implementações de dependências.
4. Manutenção:
Alterações em dependências podem ser feitas sem modificar as classes dependentes.
### IoC e DI no Spring
No Spring Framework, o contêiner IoC gerencia os Beans e injeta dependências automaticamente.

Exemplo prático:
```java
@Component
public class Engine {
public String start() {
return "Engine started!";
}
}

@Component
public class Car {
private final Engine engine;

    @Autowired
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void drive() {
        System.out.println(engine.start());
    }
}

@SpringBootApplication
public class Application {
public static void main(String[] args) {
ApplicationContext context = SpringApplication.run(Application.class, args);
Car car = context.getBean(Car.class);
car.drive();
}
}
```
## Diferença entre IoC e DI
### Aspecto	IoC	DI
| Aspecto                | IoC                                      | DI                                     |
|-------------------------|------------------------------------------|----------------------------------------|
| **Definição**          | Princípio que delega o controle ao framework | Técnica de IoC para fornecer dependências |
| **Foco**               | Controle do fluxo e criação de objetos   | Fornecimento de dependências específicas |
| **Como é implementado** | Framework ou contêiner gerencia o ciclo de vida | Dependências são fornecidas via injeção |

## Conclusão
`IoC` fornece um modelo geral para delegar responsabilidades a um contêiner.
`DI` é a implementação prática de IoC para lidar com dependências.

> Juntos, eles promovem modularidade, flexibilidade, e testabilidade, sendo padrões essenciais para desenvolvimento em frameworks como Spring.