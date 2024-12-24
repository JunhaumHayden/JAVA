# Configurando H2 Database

O H2 é um banco de dados em memória que permite todas as operações do CRUD, permitindo assim que possamos testar nossa aplicação mesmo sem um banco de dados já definido.
Neste artigo vou implementar o H2 em uma API e realizar a operação de consulta no nosso H2 em memória.
Estou utilizando:
IntelliJ
Spring boot 2.3.12
Maven
Java 11
O primeiro passo é incluir as dependências do H2 e do JPA no POM do seu projeto:

```json
<dependency>
<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<scope>runtime</scope>
</dependency>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```


Com as dependências devidamente incluídas, precisamos incluir as configurações de acesso ao H2 no arquivo de `properties da aplicação`:
```json
spring.application.name=teste-jpa-h2
server.port=8081
#Opcional
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.format_sql=true


#Obrigátorio de acordo com o seu banco de dados
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
Em `spring.h2.console.enabled=true`
`spring.h2.console.path=/h2-console` 
a primeira linha indica ao spring que vamos utilizar o H2, já na segunda e terceira linha estamos definindo o usuário e senha de acesso ao banco respectivamente. As duas ultimas linhas dizem ao spring para habilitar o console e o caminho do mesmo para acesso.
### API
Agora, falando da nossa API, faremos todo o código de forma como se já tivéssemos nosso banco definido, não há nada em especial que precise ser declarado para o spring entender que o banco é o H2. Abaixo temos a implementação da `entity` `Usuario` (os getters e setters foram omitidos):
```java 
@Entity
@Table(name = "tb_usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(unique = true, name = "email")
    private String email;
```
    
### Implementação do repository:
```java
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
```



### Implementação do controller para acesso ao repository com um método de consulta a um usuário:
```java
@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Usuario> consultaPorId(@PathVariable Long id){
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
```

## ACESSANDO O CONSOLE DO H2
Agora, vamos acessar o console do H2 para ver se a tabela `tb_usuarios` será criada, para isso será necessário subirmos a aplicação e acessarmos a rota: http://localhost:8081/h2-console

Na tela de login, basta apresentar os dados que foram configurados no arquivo properties:
> username: sa 
>
> password:
>
> JDBC URL: jdbc:h2:mem:testdb

Em seguida, o console é apresentado e no lado esquerdo podemos ver todo o esquema do H2 criado em memória com a nossa tabela `tb_usuarios`:

Para fazermos um teste rápido inclui dois usuários na nossa base, para isso na pasta `resources` usar um arquivo `schema.sql` para criar a tabela. O Spring Boot executa o arquivo `schema.sql` antes de `data.sql`

Certifique-se de que o Spring Boot está executando os scripts na ordem correta (`schema.sql` antes de `data.sql`). O Spring Boot segue essa ordem por padrão, mas se você estiver usando configurações personalizadas, verifique-as., quando usamos o H2 esse arquivo é identificado como um script a ser executado ao subir a aplicação, o arquivo ficou da seguinte forma:
### schema.sql
```sql
CREATE TABLE tb_usuarios (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL
);
```
### data.sql
```sql
INSERT INTO tb_usuarios (nome, email) VALUES ('maria', 'maria@gmail.com');
INSERT INTO tb_usuarios (nome, email) VALUES ('joao', 'joao@gmail.com');
```

Com uma requisição get no postman conseguimos trazer os nossos usuários:

> ### GET request to example server
> GET http://localhost:8081/usuarios/1
> ###
> GET http://localhost:8081/usuarios/2

RESUMO
O H2 é uma forma rápida e eficiente para se testar CRUDs sem a necessidade de apontar para um servidor de banco de dados ou um banco de dados local, além disso o código criado para as operações não exige manutenção quando for utilizar o banco de dados definitivo. O H2 é muito difundido no mercado e vale muito a pena domina-lo.