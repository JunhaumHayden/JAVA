
## @BeforeEach
A anotação `@BeforeEach` no JUnit é usada para marcar um método que deve ser executado antes de cada teste individual em uma classe de teste. É útil para configurar ou inicializar o estado necessário para cada teste, garantindo que cada teste seja executado de forma isolada e independente.
### Quando e por que usar @BeforeEach?
       - Usada para evitar repetição de código nos métodos de teste.
       - Ideal para preparar dados ou configurações comuns a vários testes.
       - Garante um estado limpo e previsível para cada teste, reduzindo dependências entre eles.
      
### Regras do @BeforeEach
       - O método anotado deve ser public e não deve retornar valores (deve ser void).
       - É executado uma vez antes de cada método de teste na classe.
       - Pode ser usado com outras anotações, como @AfterEach (executado após cada teste).
       - Em testes com herança, métodos @BeforeEach de superclasses também são executados.
      
### Vantagens
- _Reduz duplicação de código_: A inicialização de objetos ou configuração comum é feita apenas uma vez no método `@BeforeEach`.
- _Testes independentes_: Cada teste começa com uma configuração limpa, o que ajuda a evitar interferências entre os testes.
- _Isolamento_: Cada teste é executado com um novo estado inicial, garantindo que os testes não interfiram entre si.
- _Manutenção_: Facilita a atualização da lógica de configuração, pois ela está centralizada em um único método.
- _Código Limpo_: Evita duplicação de código de inicialização em cada teste.

## @AfterEach
A anotação @AfterEach faz parte do JUnit 5 e é usada para marcar métodos que devem ser executados após cada método de teste em uma classe de testes. Ele é geralmente utilizado para limpeza ou liberação de recursos, como fechar conexões, limpar dados temporários ou reiniciar estados modificados durante o teste.
 
### Por que usar @AfterEach?
  - Para limpar recursos ou estados que foram criados ou alterados pelo teste.
  - Para garantir que os testes seguintes não sejam impactados por efeitos colaterais de testes anteriores.
  - Para liberar recursos como arquivos, conexões de banco de dados ou threads após o uso.
### Regras e características
  - Método com @AfterEach: Deve ser público (ou com visibilidade padrão) e não pode retornar nada (void).
  - Não aceita argumentos.
 
### Execução: 
  - É executado após cada método de teste.
  - Se houver múltiplos métodos anotados com @AfterEach na hierarquia de classes, eles são executados na ordem inversa à da herança, começando pela subclasse.
 
### Complementaridade:
- Normalmente usado em conjunto com @BeforeEach, que executa a inicialização antes de cada teste.
 
### Benefícios
  - Evita efeitos colaterais: Garante que estados ou recursos sejam reiniciados ou liberados antes do próximo teste.
  - Boas práticas: Segue o princípio de manter os testes isolados e independentes.
  - Código limpo: Centraliza a lógica de limpeza, reduzindo duplicação de código nos métodos de teste.
