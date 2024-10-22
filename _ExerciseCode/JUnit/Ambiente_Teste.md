
# Plano de Testes para ComfortAid

Data: 18/10/2024
Entidade: IFSC
Responsável: Carlos Benedito Hayde de Albuquerque Junior

## 1. Introdução

O objetivo deste plano de testes é garantir que a aplicação ComfortAid funcione corretamente e de acordo com os requisitos definidos. Os testes serão realizados em um ambiente controlado para identificar possíveis falhas e garantir que o sistema esteja pronto para produção.

## 2. Local para Realização dos Testes

* Local: Escritório do Desenvolvedor / Home Office
* Descrição: Os testes serão realizados em um ambiente interno controlado, com acesso seguro aos servidores de desenvolvimento e testes.

## 3. Hardware Utilizado

* Equipamento: MacBook Pro
* Especificações:
* Modelo: MacBook Pro (M1, 2023)
* Processador: Apple M1 Chip
* Memória RAM: 16 GB
* Armazenamento: 512 GB SSD
* Sistema Operacional: macOS Ventura 13.0

## 4. Software/Ferramentas de Testes

Para garantir uma cobertura de testes completa, as seguintes ferramentas e softwares serão utilizados:

* Navegadores:
  - Safari
  - Google Chrome
  - Mozilla Firefox
* Ferramentas de Testes:
  - Postman: Para testes de API e endpoints
  - Selenium: Para testes automatizados de interface
  - JMeter: Para testes de performance e carga
  - JIRA / Trello: Para gestão de tarefas e bugs encontrados durante os testes
  - MySQL Workbench: Para verificação e manipulação de dados no banco de dados
* Ambiente de Desenvolvimento e Teste:
  - Xcode: Para emulação e testes no ambiente iOS
  - Android Studio: Para emulação e testes no ambiente Android
  - VS Code: Para análise de código e correção de problemas diretamente
  - Docker: Para simulação de ambientes e containers
  - Git: Para versionamento e controle do código-fonte

## 5. Documentação Utilizada

A documentação é essencial para a preparação e execução dos testes. Inclui:

 * Documentos de Requisitos de Software (DRS): Detalhamento dos requisitos funcionais e não-funcionais do ComfortAid.
Especificação de Casos de Uso: Descrição detalhada dos casos de uso da aplicação para garantir a cobertura completa dos cenários de teste.
 * Plano de Testes: Documento que contém todas as etapas do processo de testes, escopo, estratégia e objetivos.
 * Manual de Usuário: Documento de referência para a interface e funcionalidades disponíveis para os usuários finais.
 * Relatório de Bugs: Documento gerado a partir dos resultados de testes que lista todos os bugs encontrados durante a execução.

## 6. Preparação do Ambiente de Testes

### 6.1. Configurações Gerais
1 _Configuração do Hardware_:
 - Certificar que o MacBook Pro esteja atualizado com a última versão do macOS Ventura 13.0.
 - Realizar a limpeza do cache e atualização do sistema operacional para garantir desempenho ideal durante os testes.

2 _Configuração do Software_:
 - Instalar e configurar as versões mais recentes dos navegadores (Safari, Chrome, Firefox).
 - Garantir que as ferramentas de testes (Postman, Selenium, JMeter, JIRA, etc.) estejam instaladas e operacionais.
 - Configurar emuladores Android e iOS para testes de compatibilidade e responsividade.

3 _Configuração do Ambiente de Desenvolvimento_:
 - Utilizar Docker para criar um ambiente de desenvolvimento semelhante ao de produção para testes.
 - Conectar-se ao banco de dados MySQL, garantindo acesso e permissões corretas para testes de persistência de dados.
 - Configurar variáveis de ambiente para permitir comunicação segura com APIs e servidores back-end.

### 6.2. Acesso e Conectividade

 
 * Verificar conectividade com os servidores de desenvolvimento e testes para garantir a disponibilidade e estabilidade durante o processo de testes.
 * Configurar VPN, se necessário, para acesso seguro aos ambientes de teste remoto.

### 6.3. Preparação de Dados de Teste

 * Criar dados fictícios para clientes, profissionais e serviços para simular cenários realistas.
 * Garantir que os dados utilizados durante os testes não interfiram no ambiente de produção e que sejam reinicializados após cada ciclo de teste para garantir consistência.