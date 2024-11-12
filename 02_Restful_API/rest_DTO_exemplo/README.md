# API REST de Consulta de Produtos 📦

Este projeto é uma API REST desenvolvida com Spring Boot e Maven, usando JPA para persistência de dados e MySQL como banco de dados. A aplicação fornece uma interface de consulta para categorias de produtos, oferecendo endpoints para listar, buscar e pesquisar produtos por descrição. Este projeto foi criado como parte dos meus estudos de APIs REST, persistência com JPA, e a integração de Spring Boot com MySQL.

## 📌 Funcionalidades

A API oferece os seguintes endpoints para gerenciar as categorias de produtos:

>GET /categorias: Retorna uma lista de todas as categorias.
>GET /descricao/{id}: Busca uma categoria específica com base no ID.
>GET /categorias/descricao/{descricao}: Pesquisa categorias que contenham a descrição informada.

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- JPA (Jakarta Persistence API): Para mapeamento objeto-relacional.
- MySQL: Banco de dados relacional para persistência dos dados.

## 🚀 Como Executar o Projeto

Clone este repositório:
```bash
git clone https://github.com/seu-usuario/nome-do-repositorio.git
```
Navegue até o diretório do projeto:
```bash
cd nome-do-repositorio
```
## Configure o banco de dados MySQL:
Crie um banco de dados para a aplicação.
Atualize o arquivo `application.properties` com as credenciais do seu banco de dados.

### Execute o projeto:
```bash
mvn spring-boot:run
```
Acesse a API em http://localhost:8081.

## 🗂 Estrutura do Projeto

```bash
src/main/java
└── edu
    └── ifsc
        └── rest_DTO_exemplo
            ├── controller
            │   └── CategoriaController.java
            ├── dto
            │   └── SalarioResponseDTO.java
            ├── model
            │   └── Categoria.java
            ├── repository
            │   └── CategoriaRepository.java
            └── RestDtoExemploApplication.java
```



### O projeto possui as seguintes classes principais:

#### __Categoria__
Uma entidade representando a tabela de categorias no banco de dados. Contém os atributos `id` e `descricao` e está anotada com `@Entity` para mapeamento pelo `JPA`.

#### __CategoriaRepository__
Interface `JPA` para interação com o banco de dados. Fornece métodos para operações CRUD, além de uma consulta personalizada para buscar categorias pela descrição.

#### __CategoriaController__
Controlador REST responsável pelos endpoints da API. Através de @GetMapping, disponibiliza os métodos de listagem e pesquisa de categorias.

## 📚 Aprendizados

Este projeto reforçou conhecimentos em:

- Criação de APIs REST com Spring Boot.
- Persistência de dados com JPA e MySQL.
- Integração de repositórios JPA customizados.
- Manipulação e configuração de dependências com Maven.

## 📝 Licença

Este projeto é apenas para fins educacionais.