<div align="center">
<img src="https://hermes.dio.me/tracks/a039b34c-7aa8-4a3d-b765-07c8c837f67a.png" alt="Logo BackEnd" width="150">
</div>
<h1 align="center"> lavaCode </h1>
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## 📱 Projeto Sistema de Controle de Lavação utilizando API REST com Spring Boot 

![Static Badge](https://img.shields.io/badge/Powered_by-SpringBoot-green)


### Descrição do Projeto

Este projeto tem como objetivo desenvolver um sistema que disponibilizará uma API Rest de lavação de carros. Este projeto foi criado com APIs REST, persistência com JPA, e a integração de Spring Boot com MySQL, Lombok, Maven, JUnit e utilizacao de designer pattner com as melhores praticas de programacao.

> Este projeto é apenas para fins educacionais.

CRUD com banco de dados

A partir dos exemplos produzidos em aula e do seguinte diagrama  de classes.
```mermaid
classDiagram
namespace PacketVeiculos {
    class Modelo {
        -int id
        -String descricao
        +Modelo()
        +Modelo(descricao: String, marca: Marca)
    }

    class Marca {
        -int id
        -String nome
        +Marca()
        +Marca(nome: String) void
    }

    class Motor {
    -int id
    -int potencia
    
    }

    class ETipoCombustivel {
    <<Enumeration>>
    - GASOLINA
    - ETANOL
    - FLEX
    - DIESEL
    - GNV
    - OUTRO
    }

    class ECategoria {
    <<Enumeration>>
    - PEQUENO
    - MEDIO
    - GRANDE
    - MOTO
    - PADRAO
    }
}

    Modelo "0..*" o-- "1" Marca: possui
    Modelo o-- "1" ECategoria: possui
    Modelo "1" *--> "1" Motor: referencia

    Motor --> "1" ETipoCombustivel

```



1. Implemente APIs e endpoints para CRUD de:
- Marca
- Modelo
- Motor

2. Forma de entrega da atividade:
- Projeto completo
- Telas capturadas do POSTMAN com todas as requisições e respostas HTTP

3. Requisições necessárias:
- __1. Marca__
   1. Listar todas
   2. Listar por ID
   3. Nova Marca
   4. Atualização
   5. Exclusão
- __2. Modelo__
  1. Listar todos, cada qual com sua Marca
  2. Listar por ID
  3. Novo Modelo
  4. Atualização
  5. Exclusão


## 📌 Funcionalidades

### Endpoints Disponíveis
1. Listar todos as marcas

GET `/marcas`
>Retorna uma lista de todas as marcas cadastradas, incluindo todos os atributos (id, nome).
2. Listar por ID

GET `/marcas/{id}`
> Retorna os detalhes de uma marca específica com base no id.

3. Adicionar uma nova marca
   
POST `/marcas`
> Adiciona uma nova marca à lista.

Exemplo do corpo da requisição (JSON):
```json
{
  "nome": "Toyota"
}
```

4. Atualiza uma marca por id 

PUT `/marcas/atualizar/{id}`
> Atualiza uma marca especifica buscada pelo id.

5. Exclui uma marca por id

DELETE `/marcas/excluir/{id}`
> Atualiza uma marca especifica buscada pelo id.



- __2. Modelo__
  1. Listar todos, cada qual com sua Marca
  2. Listar por ID
  3. Novo Modelo
  4. Atualização
  5. Exclusão

1. Listar todos as modelo e a marca

GET `/modelo`
>Retorna uma lista de todas as marcas cadastradas, incluindo todos os atributos (id, nome).
2. Listar por ID

GET `/modelo/{id}`
> Retorna os detalhes de um modelo e a marca específica com base no id.

3. Adicionar um novo modelo

POST `/modelo`
> Adiciona um novo modelo à lista.

Exemplo do corpo da requisição (JSON):
```json
{
  "descricao": "Corolla",
  "marca": { "id": 1 },
  "motor": {
    "potencia": 140,
    "tipoCombustivel": "GASOLINA"
  },
  "categoria": "MEDIO"
}
```

4. Atualiza uma marca por id

PUT `/marcas/atualizar/{id}`
> Atualiza uma marca especifica buscada pelo id.

5. Exclui uma marca por id

DELETE `/marcas/excluir/{id}`
> Atualiza uma marca especifica buscada pelo id.

Exemplos de Requisições

## 🛠 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Maven
- JPA (Jakarta Persistence API): Para mapeamento objeto-relacional.
- MySQL: Banco de dados relacional para persistência dos dados.


## 🗂 Estrutura do Projeto

```bash
lavacao-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── edu/
│   │   │       └── ifsc/
│   │   │           └── lavacao_api/
│   │   │               ├── controller/
│   │   │               │   ├── Modelocontroller.java
│   │   │               │   └── Marca.java
│   │   │               ├── dto/
│   │   │               │   ├── ModeloDTO.java
│   │   │               │   └── MarcaDTO.java
│   │   │               ├── model/
│   │   │               │    └── veiculos/
│   │   │               │       ├── Modelo.java
│   │   │               │       ├── Motor.java
│   │   │               │       ├── ETipoCombustivel.java
│   │   │               │       └── Marca.java 
│   │   │               ├── repository/
│   │   │               │   ├── ModeloRepository.java
│   │   │               │   └── MarcaRepository.java 
│   │   │               ├── service/
│   │   │               │   ├── ModeloService.java
│   │   │               │   └── MarcaService.java 
│   │   │               └── LavacaoApiApplication.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── script_banco_dados.sql
│   └── test/
│       └── java/
│           └── com/
│               └── exemplo/
│                   └── livroapi/
│                       └── LavacaoApiApplicationTests.java
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
`- Contém as interfaces que extendem o JpaRepository, responsáveis por interagir diretamente com o banco de dados.

__service/__
- Contém as classes de serviço que encapsulam a lógica de negócios e chamam os métodos do repositório.

__resources/__
- Contém arquivos de configuração e SQL inicial para carregar dados no banco.

__application.properties__
Configurações do Spring Boot e detalhes de conexão com o banco de dados MySQL.

__data.sql__
- Arquivo opcional para popular a tabela utilizada no projeto com dados iniciais.

__pom.xml__
- Arquivo de configuração do Maven, contendo as dependências do projeto.


### Diagrama de Classes do projeto completo (implementacao futura)

<table>
  <tr>
    <td>
      <img src="https://freecomputerbooks.com/covers/UML-Process.gif" alt="UML Image" width="50">
    </td>
    <td>
      <img src="https://seeklogo.com/images/M/mermaid-logo-31DD0B8905-seeklogo.com.png" alt="Mermaid Image" width="60">
    </td>
  </tr>
</table>

<!-- [MermaidChart: 3c7d24e8-f066-4729-bf14-ab089cf5979a] -->



<---------------------------------->
``` mermaid
classDiagram

namespace PacketCliente {
    class ICliente {
        <<Interface>>
        +getDados() String
        +getDados(String Observacao) String
    }
    
    class Cliente {
        <<abstract>>
        #int id
        #String nome
        #String telefone
        #String email
        #Date dataCadastro
        +addVeiculos(veiculo: Veiculo) void
        +removeVeiculos(veiculo: Veiculo) void
        
    }

    class PontuacaoFidelidade {
        -int pontos
        +consultarSaldo() int
        +adicionar(qtd: int) int
        +subtrair(qtd: int) int
    }
    
    class PessoaFisica {
        -Date dataNascimento
        -String cpf
        
    }

    class PessoaJuridica {
        -String inscricaoEstadual
        -String cpfCnpj
    }
}
namespace PacketVeiculo {
    class Veiculo {
        -int id
        -String placa
        -String observacoes
        +Veiculo()
        +Veiculo(placa: String)
        +Veiculo(placa: String, modelo: Modelo)
    }

    class Cor {
        -int id
        -String nome
        +Cor()
        +Cor(nome: String)
    }

    class Modelo {
        -int id
        -String descricao
        +Modelo()
        +Modelo(descricao: String, marca: Marca)
    }

    class Motor {
        -int id
        -int potencia
        
    }

    class ETipoCombustivel {
        <<Enumeration>>
        - GASOLINA
        - ETANOL
        - FLEX
        - DIESEL 
        - GNV
        - OUTRO
    }
    
    class Marca {
        -int id
        -String nome
        +Marca()
        +Marca(nome: String)
    }

    class ECategoria {
        <<Enumeration>>
        - PEQUENO
        - MEDIO 
        - GRANDE
        - MOTO 
        - PADRAO
    }
}
namespace PacketOS {
    class Servico {
        -int id
        -String descricao
        -Double valor
        -int pontos
    }

    class ItemOS {
        -String observacao
        -Double valorServico
    }

    class EStatus {
        <<Enumeration>>
        - ABERTA 
        - FECHADA
        - CANCELADA 
    }

    class OrdemDeServico {
        -long numero
        -Double total
        -float desconto
        -Date agenda: não
        +calcularServico() double
        +add(itemOS: ItemOS) void
        +remove(itemOS: ItemOS) void
    }
}

  
        
    Cliente <|-- PessoaFisica
    Cliente <|-- PessoaJuridica
    Cliente ..|> ICliente
    Cliente "0..*" -- "1" Veiculo : possui
    Cliente "0..*" *--> "1" PontuacaoFidelidade : acumula

    Veiculo "0..*" --> "1" Cor: possui
    Veiculo "0..*" o-- "1" Modelo : referencia

    Modelo "0..*" o-- "1" Marca: possui
    Modelo o-- "1" ECategoria: possui
    Modelo "1" *--> "1" Motor: referencia

    Motor --> "1" ETipoCombustivel

    Servico --> "1" ECategoria: referencia

    OrdemDeServico "0..*" o--> "1" Veiculo : referencia
    OrdemDeServico "*" *--> "*" ItemOS : inclui
    OrdemDeServico --> EStatus
    ItemOS "*" *--> "*" Servico : inclui
    
```
**Diagrama 1:** Diagrama de classe para o projeto Lavação.

## 📚 Aprendizados

Este projeto reforçou conhecimentos em:

- Criação de APIs REST com Spring Boot.
- Persistência de dados com JPA e MySQL.
- Integração de repositórios JPA customizados.
- Manipulação e configuração de dependências com Maven.

# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Carlos Hayden</sub>](https://github.com/JunhaumHayden) |
| :---: |