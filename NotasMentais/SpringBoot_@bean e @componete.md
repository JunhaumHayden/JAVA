No Spring Framework, as noções de Beans, Components, e a anotação @Autowired estão relacionadas ao gerenciamento de dependências e à inversão de controle (IoC). Vamos explorar os conceitos em detalhes.

1. Beans

Definição
Um Bean no Spring é um objeto gerenciado pelo contêiner do Spring.
Ele é declarado explicitamente no código ou detectado automaticamente por meio de anotações.
Criação de Beans
a) Configuração com @Bean

Usada em uma classe de configuração marcada com @Configuration.
Permite criar e configurar manualmente instâncias de objetos como Beans.
Exemplo:

@Configuration
public class AppConfig {
@Bean
public MyService myService() {
return new MyService();
}
}
b) Detectado automaticamente com @Component

Objetos marcados como @Component (ou suas variações) são automaticamente registrados como Beans no contexto do Spring.
Exemplo:

@Component
public class MyService {
public String sayHello() {
return "Hello, Spring!";
}
}
Ciclo de vida dos Beans
Gerenciado pelo Spring: criação, inicialização e destruição.
Escopos: singleton (padrão), prototype, ou escopos específicos para aplicações web (request, session, etc.).
2. Components

Definição
Um Component no Spring é um Bean que é detectado automaticamente pelo contêiner de IoC.
Ele é registrado no contexto de aplicação usando a anotação @Component ou anotações derivadas como @Service, @Repository e @Controller.
Diferença entre @Component e Beans com @Bean
Aspecto	@Component	@Bean
Declaração	Usado diretamente na classe	Usado dentro de uma classe @Configuration
Descoberta	Descoberto automaticamente	Declarado explicitamente
Controle	Útil para classes reutilizáveis	Útil para objetos configurados manualmente
Exemplo de Component:

@Component
public class MyRepository {
public List<String> findData() {
return List.of("Data1", "Data2");
}
}
3. A anotação @Autowired

Definição
@Autowired é usada para realizar injeção de dependências em campos, construtores ou métodos.
O Spring automaticamente resolve a dependência e injeta o Bean correspondente.
Tipos de injeção com @Autowired
a) Injeção em Campo

Injeta diretamente na variável.
Exemplo:

@Component
public class MyController {
@Autowired
private MyService myService;

    public void execute() {
        System.out.println(myService.sayHello());
    }
}
b) Injeção via Construtor

Recomendado por facilitar a testabilidade e seguir o princípio de imutabilidade.
Exemplo:

@Component
public class MyController {
private final MyService myService;

    @Autowired
    public MyController(MyService myService) {
        this.myService = myService;
    }

    public void execute() {
        System.out.println(myService.sayHello());
    }
}
c) Injeção em Método (Setter)

Menos comum, mas útil em casos de dependências opcionais.
Exemplo:

@Component
public class MyController {
private MyService myService;

    @Autowired
    public void setMyService(MyService myService) {
        this.myService = myService;
    }

    public void execute() {
        System.out.println(myService.sayHello());
    }
}
Principais diferenças entre Beans e Components

Aspecto	Beans (@Bean)	Components (@Component)
Declaração explícita	Feito em classes de configuração (@Configuration)	Feito diretamente nas classes
Descoberta automática	Não é detectado automaticamente	Detectado automaticamente pelo Spring
Escopo e configuração	Ideal para lógica complexa de configuração	Usado para classes básicas ou simples
Casos de uso	Classes externas ou criadas manualmente	Classes internas, controladores ou serviços
Quando usar @Bean ou @Component?

Use @Component quando sua classe for básica e puder ser detectada automaticamente pelo Spring.
Use @Bean para criar Beans manualmente, especialmente quando precisa:
Configurar bibliotecas de terceiros.
Criar objetos com lógica de inicialização ou dependências dinâmicas.
Conclusão sobre @Autowired

@Autowired trabalha com qualquer tipo de Bean, seja criado manualmente com @Bean ou detectado automaticamente com @Component.
No Spring Boot, o suporte a autoconfiguração e escaneamento de componentes facilita o uso de @Component combinado com @Autowired.
Fluxo de uso típico:
Crie um Bean com @Component ou @Bean.
Injete-o em outra classe usando @Autowired.