Para verificar a versão do Java instalada no seu computador, você pode usar o comando java -version no terminal (Windows, macOS ou Linux). Aqui estão os passos para fazer isso:

#### macOS
1. Abrir o Terminal:

 - Você pode encontrar o Terminal em Aplicativos > Utilitários > Terminal.
2. Verificar a Versão do Java:

 -No Terminal, digite java -version e pressione Enter.


#### Exemplo de Saída
O comando java -version deve produzir uma saída semelhante a esta, mostrando a versão do Java instalada:

``` bash
java version "17.0.2" 2022-01-18 LTS
Java(TM) SE Runtime Environment (build 17.0.2+8-LTS-86)
Java HotSpot(TM) 64-Bit Server VM (build 17.0.2+8-LTS-86, mixed mode, sharing)
```
- java version "17.0.2": Esta linha mostra a versão do Java instalada (neste caso, Java 17.0.2).
- Java(TM) SE Runtime Environment: Esta linha mostra o ambiente de execução do Java.
- Java HotSpot(TM) 64-Bit Server VM: Esta linha mostra a versão da JVM (Java Virtual Machine) utilizada.

#### A versão do Java instalada no MacBook (06/07/2024)
 - OpenJDK 11.0.19, fornecida pelo projeto Temurin.

```bash
openjdk version "11.0.19" 2023-04-18
OpenJDK Runtime Environment Temurin-11.0.19+7 (build 11.0.19+7)
OpenJDK 64-Bit Server VM Temurin-11.0.19+7 (build 11.0.19+7, mixed mode)
```
#### Detalhes da Saída:
1. openjdk version "11.0.19" 2023-04-18:

- OpenJDK version: A versão do JDK instalada é 11.0.19.
Release Date: A data de lançamento dessa versão é 18 de abril de 2023.
2. OpenJDK Runtime Environment Temurin-11.0.19+7 (build 11.0.19+7):

 - Runtime Environment: Indica que você está usando o ambiente de execução OpenJDK.
 - Temurin: É o nome do projeto que fornece essa distribuição do OpenJDK.
 - Build version: O número da build é 11.0.19+7.
3. OpenJDK 64-Bit Server VM Temurin-11.0.19+7 (build 11.0.19+7, mixed mode):

 - 64-Bit Server VM: Indica que você está usando a versão 64 bits da JVM.
 - VM Provider: Temurin, que é um projeto da Adoptium.
 - Build version: O número da build da VM é 11.0.19+7.
#### Sobre o OpenJDK e Temurin
 - OpenJDK: O OpenJDK (Open Java Development Kit) é uma implementação livre e open-source da linguagem de programação Java.
 - Temurin: É uma distribuição binária do OpenJDK mantida pelo projeto Adoptium (anteriormente conhecido como AdoptOpenJDK). Eles fornecem builds de alta qualidade e gratuitas do OpenJDK.
#### Considerações
Versão Suportada: A versão 11 do Java é uma versão LTS (Long Term Support), o que significa que receberá atualizações e suporte estendido.
Atualizações: Certifique-se de manter o seu JDK atualizado para receber as últimas correções de bugs e patches de segurança.

Encontre o diretório de instalação do Java:

``` sh
/usr/libexec/java_home -V
```
Isso mostrará as versões do Java e seus diretórios.

#### Observações
> Se o comando java -version não funcionar, pode ser que o Java não esteja instalado corretamente ou a variável de ambiente PATH não esteja configurada para incluir o diretório do Java.
> Para verificar se o javac (compilador Java) também está instalado, você pode usar o comando javac -version.


#### Windows
1. Abrir o Prompt de Comando:

-  Pressione Win + R para abrir a caixa de diálogo "Executar". 
 - Digite cmd e pressione Enter.
1. Verificar a Versão do Java:

- No Prompt de Comando, digite java -version e pressione Enter.

#### Configurando o PATH no Windows
Se o comando java -version não funcionar, você pode precisar adicionar o caminho do Java ao seu PATH:

1. Encontrar o Diretório de Instalação do Java:

- Geralmente, está localizado em C:\Program Files\Java\jdk<versão>.
2. Adicionar ao PATH:

- Vá para Configurações > Sistema > Sobre > Configurações avançadas do sistema.
- Clique em Variáveis de Ambiente.
- Encontre a variável Path na seção Variáveis do sistema e clique em Editar.
- Adicione o caminho do diretório bin do JDK (por exemplo, C:\Program Files\Java\jdk-17\bin) à lista e clique em OK.
3. Reiniciar o Prompt de Comando:

- Feche e reabra o Prompt de Comando para aplicar as mudanças e tente novamente o comando java -version.
Agora você deve ser capaz de verificar a versão do Java instalada no seu computador com sucesso.

#### Linux
1. Abrir o Terminal:

> As etapas para abrir o Terminal podem variar dependendo da distribuição, mas geralmente você pode encontrar o Terminal no menu de aplicativos.
2 .Verificar a Versão do Java:

 - No Terminal, digite java -version e pressione Enter.

### Próximos Passos
Se você estiver desenvolvendo aplicações em Java e precisa de uma versão específica ou deseja gerenciar múltiplas versões do Java, considere usar um gerenciador de versões de Java, como o SDKMAN!:

#### 1. Baixar SDKMAN!:
[Documentação na página oficial](https://sdkman.io/install)


   - Abra o Terminal e execute:
        ``` sh
        curl -s "https://get.sdkman.io" | bash
        ``` 

   - Resposta:
     ``` sh
     All done!


     You are subscribed to the STABLE channel.

     Please open a new terminal, or run the following in the existing one:

     source "/Users/hayden/.sdkman/bin/sdkman-init.sh"
     Then issue the following command:

     sdk help

     Enjoy!!!
     ```

#### 2. Instalar o SDKMAN!:
   - Após a instalação, recarregue o terminal ou execute:
        ``` sh
        source "$HOME/.sdkman/bin/sdkman-init.sh"
        ```
   - Por último, execute o seguinte snippet para confirmar o sucesso da instalação:
        ```sh
        $ sdk version
        ```
   - Você deverá ver a saída contendo o script mais recente e as versões nativas:

        ``` sh
        SDKMAN!
        script:  5.18.2
        native: 0.4.6
        ```

#### 3. Instalar e Gerenciar Versões do Java:

 - Para instalar uma versão específica do Java, execute:
    ``` sh
    sdk install java 17.0.2-tem
    ```
    
 - Para listar todas as versões disponíveis, execute:
    ``` sh
    sdk list java
    ```
 - Para mudar para uma versão específica do Java, execute:
    ``` sh
    sdk use java 17.0.2-tem
    ``` 
    Esses passos podem ajudar você a gerenciar diferentes versões do Java no seu sistema de maneira eficiente.