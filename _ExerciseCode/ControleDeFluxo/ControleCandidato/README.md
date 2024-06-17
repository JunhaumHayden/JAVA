<div align="center">
<img src="https://hermes.dio.me/tracks/a039b34c-7aa8-4a3d-b765-07c8c837f67a.png" alt="Logo BackEnd" width="80">

<img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCcxkA70BX5H1N1FFSkncQ-InOpqloUVZLcA&usqp=CAU" alt="Logo Bootcamp" width="100">
</div>

###### #JavaCodes



<h1 align="center"> Control Flow Statement </h1>



<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=EM%20DESENVOLVIMENTO&color=GREEN&style=for-the-badge"/>
</p>

## Descrição:

### Processo Seletivo

Este repositório contém um programa simples de simulação de um processo seletivo, onde candidatos são selecionados com base em suas pretensões salariais e disponibilidade para atendimento de ligações.

Descrição

O programa simula um processo seletivo onde candidatos são avaliados com base em suas pretensões salariais e disponibilidade para atender chamadas telefônicas. O processo continua até que 5 candidatos sejam selecionados ou que todos os candidatos tenham sido avaliados.

Funcionalidades

- Simulação de valor pretendido: Escolhe um valor aleatório de salário pretendido entre 1800 e 2200.
- Impressão de lista de candidatos: Imprime uma lista de candidatos selecionados.
- Simulação de atendimento de chamada: Simula se um candidato atende a uma chamada com uma chance aleatória.
- Seleção de candidatos: Avalia candidatos com base no salário pretendido e atendimento de chamadas.
- Análise de candidatos: Determina se um candidato deve ser contatado ou não com base no salário pretendido.
- Contato com candidatos: Tenta entrar em contato com candidatos até um máximo de 3 tentativas.

### Como Usar

Clone este repositório para o seu ambiente local.
Compile e execute o programa.
Compilação e Execução
``` bash
javac candidatura/ProcessoSeletivo.java
java candidatura.ProcessoSeletivo
```

### Conceitos Utilizados

- Laços de Repetição: Utilização de `while` para continuar o processo seletivo até que 5 candidatos sejam selecionados ou que todos os candidatos tenham sido avaliados.
- Listas Dinâmicas: Uso da classe `ArrayList` para armazenar os candidatos selecionados.
- Geração de Números Aleatórios: Uso da classe `ThreadLocalRandom` para gerar valores de salário pretendido e `Random` para simular o atendimento de chamadas.
- Métodos Auxiliares: Métodos auxiliares para diversas funcionalidades como impressão de listas, simulação de atendimento e análise de candidatos.
- Tratamento de Exceções: Utilização básica do tratamento de exceções para lidar com possíveis erros de entrada do usuário.

### Estrutura do Código

O código está estruturado em métodos para facilitar a compreensão e manutenção:

- `valorpretendido()`: Gera um valor de salário pretendido.
- `imprimirSelecionados(List<String> selecionados)`: Imprime a lista de candidatos selecionados.
- `atender()`: Simula se um candidato atende a uma chamada.
- `selecaoCandidatos()`: Método principal que realiza a seleção dos candidatos.
- `analisarCandidato(double salarioPretendido, String candidato)`: Analisa se um candidato deve ser contatado.
- `entrandoEmContato(String candidato)`: Tenta entrar em contato com o candidato até 3 vezes.

### Exemplo de Uso

Ao executar o programa, o usuário verá a simulação do processo seletivo. Cada candidato será avaliado e, se selecionado, será adicionado a uma lista. A lista final de candidatos selecionados será impressa ao final do processo.

> ❗️
> Este programa não possui interação com o usuário.
> A lista de candidatos é estatíca.

``` bash
Processo Seletivo
O candidato Ana solicitou o salario de 1900.00
Ligar para o candidato
Contato Realizado com sucesso!!!
O candidato Ana Foi Selecionado!

...
A lista de candidatos selecionados é: 
O candidato nº 1 é Ana
O candidato nº 2 é Bia
...
```

### Gerenciamento de Dependências

Para este projeto, não foram utilizadas dependências externas. Todo o código foi escrito utilizando apenas as bibliotecas padrão do Java.

#### Requisitos
- Java Development Kit (JDK): Certifique-se de ter o JDK instalado em seu sistema. Este projeto foi desenvolvido e testado utilizando o JDK 8, mas versões mais recentes também devem funcionar corretamente.
Você pode verificar a versão do JDK instalada usando o seguinte comando:

``` bash
java -version
```

Compilação e Execução
Para compilar e executar o projeto, siga os passos abaixo:

- Compilação: Compile os arquivos .java utilizando o javac.
```bash
javac candidatura/ProcessoSeletivo.java
```
- Execução: Execute o programa utilizando o java.
``` bash
java candidatura.ProcessoSeletivo
```


# Author

| [<img src="https://avatars.githubusercontent.com/u/79289647?v=4" width=115><br><sub>Carlos Hayden</sub>](https://github.com/JunhaumHayden) |
| :---: |