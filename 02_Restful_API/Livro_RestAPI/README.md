# API REST de Consulta de Livros 📚

![Static Badge](https://img.shields.io/badge/Powered_by-SpringBoot-green)


Este projeto é uma API REST desenvolvida comLombok, Spring Boot e Maven, usando JPA para persistência de dados e MySQL como banco de dados. A aplicação fornece uma interface de consulta de livros, oferecendo endpoints para listar, buscar e pesquisar. Este projeto foi criado como parte dos meus estudos de APIs REST, persistência com JPA, e a integração de Spring Boot com MySQL.

> Este projeto é apenas para fins educacionais.

1) Considere classe Livro conforme o diagrama de classes da UML a seguir:

``` mermaid
classDiagram

namespace PacketLivros {
    class Livro {
        -int id
        -int isbn
        -String titulo
        -String autor
        -String editora
        -Double preco
        +reajustarPreco(taxa: int) : void
    }

    class LivroDataSource {
        -List<Livro> livros
        +CriarLista() : void
        +adicionar(livro: Livro) : Livro
        +getAll() : List<Livro>
        +getPorIsbn(isbn: int) : Livro
        +getPorAutor(autor: String) : List<Livro>
        +getPorTitulo(titulo: String) : Livro
        +getTodosContendo(titulo: String) : List<Livro>
        +getPorIsbnDTO(isbn: int) : ListDTO
        +getAllDTO() : List<ListDTO>
        +reajustarPrecoPorId(id: int, taxa: int) : void
        +reajustarPreco(taxa: int) : void
    }

    
}
  
   
```
**Diagrama 1:** Diagrama de classe para Livro e LivroDataSource.


* a) Implemente a classe Livro
* b) Implemente uma classe DataSource com uma lista de livros (dados MOCK) estática. Esta classe
deverá oferecer as seguintes operações (métodos):
* 1. `criarLista()` → para iniciar a lista com alguns livros
* 2. `adicionar(Livro livro)` → para adicionar um novo livro na lista
* 3. `getAll()` → para retornar todos os livros da lista, cada qual com todo os seus dados
(atributos)
* 4. `getPorIsbn(int isbn)` → para retornar todos os dados de um livro conforme o seu código
ISBN.
* 5. `getPorAutor(String autor)` → para retornar uma lista de livros dado o nome do autor
> Exemplo para pesquisa de String:
> ```java
> if (livro.getAutor().equalsIgnoreCase(autor)) {
> //implementação...
> }
> ```
* 6. `getPorTitulo(String titulo)` → para retornar um livro conforme o seu título
* 7. `getPorIsbnDTO(int isbn)` → retorna um objeto __DTO__ contendo título, autor, editora e preço.
* 8. `getAllDTO()` → retorna os atributos título, autor, editora e preço de todos os livros.
* 9. `reajustarPrecoPorId(int id, int taxa)` → método para reajustar o preço de um livro da lista
conforme o seu id. O reajuste será feito de acordo com a taxa recebida no parâmetro.
* 10. `reajustarPreco(int taxa)` → reajusta o preço de todos os livros conforme a taxa informada
por parâmetro.
> __Observação__: Note que os itens “vii” e “viii” requerem a implementação de uma classe DTO
contendo os seguintes atributos: título, autor, editora e preço.


* c) Implemente uma classe Controller com as devidas operações para requisitar os métodos
(funções) desenvolvidos na letra “b” do exercício exceto o item “i”.
> Observação: declare o tipo de método (method – GET ou POST) de acordo com o tipo de requisição HTTP.

* d) Use a ferramenta POSTMAN para fazer os testes das operações disponíveis na API. Para cada requisição capture a tela e coloque em um documento (Word por exemplo). No final gere um PDF do arquivo para submeter via SIGAA, juntamente com o código fonte do projeto.

## 📌 Funcionalidades

### Endpoints Disponíveis
1. Listar todos os livros

GET `/livros`
>Retorna uma lista de todos os livros cadastrados, incluindo todos os atributos (id, ISBN, título, autor, editora, preço).
2. Buscar um livro por ISBN

GET `/livros/isbn/{isbn}`
> Retorna os detalhes de um livro específico com base no código ISBN.
3. Buscar livros por autor

GET `/livros/autor/{autor}`
> Retorna uma lista de livros cujo autor corresponda (sem case sensitive) ao nome informado.
4. Buscar um livro por título

GET `/livros/titulo/{titulo}`
> Retorna os detalhes de um livro específico com base no título informado.
5. Listar todos os livros como DTO

GET `/livros/dto`
> Retorna uma lista de livros contendo apenas os atributos: título, autor, editora e preço.
6. Buscar um livro por ISBN como DTO

GET `/livros/isbn/{isbn}/dto`
> Retorna os atributos título, autor, editora e preço de um livro com base no código ISBN informado.
7. Adicionar um novo livro

POST `/livros`
> Adiciona um novo livro à lista.

Exemplo do corpo da requisição (JSON):
```json
{
"id": 5,
"isbn": 5555,
"titulo": "Estrelas",
"autor": "Ema Esteves",
"editora": "Editora E",
"preco": 55.90
}
```
8. Inicializar a lista com dados mock

POST `/livros/iniciar`
> Inicializa a lista com alguns livros pré-definidos para testes.

9. Reajustar o preço de todos os livros

PUT `/livros/reajustar/{taxa}`
> Reajusta o preço de todos os livros cadastrados na lista com base em uma taxa percentual informada.
10. Reajustar o preço de um livro pelo ID

PUT `/livros/{id}/reajustar/{taxa}`
> Reajusta o preço de um livro específico com base no ID e na taxa percentual informada.


Exemplos de Requisições
- Listar todos os livros
> GET `http://localhost:8080/livros`

- Buscar um livro por ISBN (exemplo ISBN: 1234)
> GET `http://localhost:8080/livros/isbn/1234`

- Adicionar um novo livro
> POST `http://localhost:8080/livros`
```json
Content-Type: application/json
Body:
{
"id": 4,
"isbn": 3344,
"titulo": "Livro E",
"autor": "Autor D",
"editora": "Editora E",
"preco": 69.90
}
```

- Reajustar o preço de todos os livros em 10%
> PUT `http://localhost:8080/livros/reajustar/10`

- Buscar livros de um autor específico (exemplo Autor: "Autor A")
> GET `http://localhost:8080/livros/autor/Autor%20A`

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- JPA (Jakarta Persistence API): Para mapeamento objeto-relacional.
- MySQL: Banco de dados relacional para persistência dos dados.


## 🗂 Estrutura do Projeto

```bash
livro-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── edu/
│   │   │       └── ifsc/
│   │   │           └── livro_api/
│   │   │               ├── controller/
│   │   │               │   └── LivroController.java
│   │   │               ├── dto/
│   │   │               │   └── LivroDTO.java
│   │   │               ├── model/
│   │   │               │   └── Livro.java
│   │   │               ├── repository/
│   │   │               │   └── LivroRepository.java
│   │   │               ├── service/
│   │   │               │   └── LivroService.java
│   │   │               └── LivroApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql
│   └── test/
│       └── java/
│           └── com/
│               └── exemplo/
│                   └── livroapi/
│                       └── LivroApiApplicationTests.java
├── pom.xml
└── README.md
```



### Descrição dos Arquivos e Diretórios:
__controller/__

- Contém as classes responsáveis por expor os endpoints da API e lidar com as requisições HTTP.

__dto/__
- Contém as classes de transferência de dados (DTO), que definem quais atributos são retornados ou enviados em determinadas requisições.

__model/__
- Contém as classes de modelo, que representam as entidades do banco de dados.

__repository/__
- Contém as interfaces que extendem o JpaRepository, responsáveis por interagir diretamente com o banco de dados.

__service/__
- Contém as classes de serviço que encapsulam a lógica de negócios e chamam os métodos do repositório.

__resources/__
- Contém arquivos de configuração e SQL inicial para carregar dados no banco.

__application.properties__
Configurações do Spring Boot e detalhes de conexão com o banco de dados MySQL.

__data.sql__
- Arquivo opcional para popular a tabela de livros com dados iniciais.

__pom.xml__
- Arquivo de configuração do Maven, contendo as dependências do projeto.

## 📚 Aprendizados

Este projeto reforçou conhecimentos em:

- Criação de APIs REST com Spring Boot.
- Persistência de dados com JPA e MySQL.
- Integração de repositórios JPA customizados.
- Manipulação e configuração de dependências com Maven.


