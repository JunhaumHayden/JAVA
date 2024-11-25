# Escopo no Spring Boot
No contexto do Spring Boot, o conceito de Scopes (escopos) refere-se ao ciclo de vida e ao número de instâncias de um objeto gerenciado pelo contêiner de inversão de controle (IoC) do Spring. Os escopos determinam como e quando um bean é criado e disponibilizado dentro do contexto da aplicação.

Os dois principais escopos usados no Spring são Singleton e Prototype. Vamos explorar cada um em detalhes.

## 1. Singleton Scope

__Definição__
- `Singleton` é o escopo padrão no Spring.
Indica que o contêiner Spring cria apenas _uma única_ instância do bean para toda a aplicação.
Todos os objetos que dependem desse bean compartilham a mesma instância.
### _Características_
  1. Ciclo de vida: 
  * - A instância do bean é criada no momento da inicialização do contêiner ou no primeiro acesso, dependendo do tipo de inicialização.
  2. Compartilhamento: 
  * - A mesma instância é usada em todas as injeções de dependência.
  3. Performance: 
  * - Reduz o overhead de criação de múltiplas instâncias.
###  Uso típico
     Para beans que contêm estado compartilhado ou funcionalidade sem estado, como serviços ou repositórios.
     Exemplo
```java
     @Component
     @Scope("singleton") // Este é o padrão, não é obrigatório declarar explicitamente.
     public class SingletonBean {
     public SingletonBean() {
     System.out.println("SingletonBean Instanciado");
     }
     }
```
### Testando o escopo Singleton:
```java
@Autowired
private SingletonBean bean1;

@Autowired
private SingletonBean bean2;

System.out.println(bean1 == bean2); // true, pois é a mesma instância.
```
## 2. Prototype Scope

__Definição__
- Indica que uma nova instância do bean é criada _toda vez_ que ele é solicitado ao contêiner.
Cada dependência recebe uma nova instância do bean.
### _Características_
1. Ciclo de vida: 
* - A instância é criada sob demanda e descartada após o uso. Não é gerenciada além do momento da criação.
2. Independência:
* - Cada injeção de dependência recebe uma instância independente.
3. Overhead: 
* - Maior uso de memória e processamento, já que múltiplas instâncias são criadas.
### Uso típico
Para beans que têm estado transitório ou precisam ser exclusivos por operação, como objetos que processam dados de forma isolada.
Exemplo
```java
@Component
@Scope("prototype")
public class PrototypeBean {
public PrototypeBean() {
System.out.println("PrototypeBean Instanciado");
}
}
```

### Testando o escopo Prototype:
```java
@Autowired
private PrototypeBean bean1;

@Autowired
private PrototypeBean bean2;

System.out.println(bean1 == bean2); // false, pois são instâncias diferentes.

```
## Principais diferenças entre Singleton e Prototype

| Característica          | Singleton                             | Prototype                            |
|--------------------------|---------------------------------------|--------------------------------------|
| **Número de instâncias** | Apenas uma instância                 | Uma nova instância para cada requisição |
| **Ciclo de vida**        | Gerenciado pelo contêiner Spring     | Criado e descartado pelo cliente     |
| **Uso típico**           | Serviços sem estado ou compartilhados | Objetos com estado transitório      |
| **Performance**          | Mais eficiente                       | Overhead maior devido à criação constante |

## Considerações importantes

1. Beans Prototype em Singletons:

Se um bean com escopo `prototype` for injetado em um bean `singleton`, a _mesma instância será reutilizada_. Isso ocorre porque o `singleton` é criado apenas uma vez.
Para contornar isso, use o `ObjectFactory` ou `@Lookup`.
Exemplo com ObjectFactory:
```java
@Component
public class SingletonWithPrototype {
@Autowired
private ObjectFactory<PrototypeBean> prototypeBeanFactory;

    public PrototypeBean getPrototypeInstance() {
        return prototypeBeanFactory.getObject();
    }
}
```

2. Configuração de escopos personalizados:

Além de `singleton` e `prototype`, o Spring suporta escopos adicionais como `request`, `session` e `application`, geralmente usados em aplicações web.
### Quando usar cada escopo?

`Singleton`:
- Para objetos reutilizáveis e sem estado, como serviços ou componentes de configuração.

`Prototype`:
- Para objetos com dados temporários ou que não devem ser compartilhados, como DTOs ou objetos específicos por operação.
> Escolher o escopo correto é crucial para garantir a eficiência e o funcionamento correto da aplicação no Spring Boot.