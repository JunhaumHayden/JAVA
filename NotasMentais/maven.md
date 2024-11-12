Para criar um novo projeto Maven usando a linha de comando, você pode usar o comando mvn archetype:generate. Este comando cria a estrutura básica de um projeto Maven. Aqui está o passo a passo:

Abra o terminal ou prompt de comando.
Navegue até o diretório onde deseja criar o projeto.
Execute o comando abaixo:
shell
Copy code
mvn archetype:generate -DgroupId=com.seuprojeto -DartifactId=meu-projeto -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
-DgroupId: Define o ID do grupo (normalmente reflete o domínio do projeto, como com.seuprojeto).
-DartifactId: Define o nome do projeto (por exemplo, meu-projeto).
-DarchetypeArtifactId: Especifica o modelo ou arquétipo Maven (o arquétipo maven-archetype-quickstart é um modelo básico para projetos Java).
-DinteractiveMode=false: Executa o comando sem perguntar nada adicional durante o processo de geração.
Verifique a estrutura do projeto criada: Maven criará um diretório com o nome do artifactId especificado (por exemplo, meu-projeto). Dentro deste diretório, você terá a seguinte estrutura básica:
plaintext
Copy code
meu-projeto
├── pom.xml
└── src
    ├── main
    │   └── java
    │       └── com
    │           └── seuprojeto
    │               └── App.java
    └── test
        └── java
            └── com
                └── seuprojeto
                    └── AppTest.java
Compilação e execução inicial (opcional): Entre no diretório do projeto e execute o comando Maven para compilar e rodar os testes:
shell
Copy code
cd meu-projeto
mvn compile
mvn test
Pronto! Agora você tem um projeto Maven configurado, com estrutura básica e pronto para começar a desenvolver.