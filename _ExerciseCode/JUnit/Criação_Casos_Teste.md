# Documento de Requisitos - ComfortAid
## 1. Introdução

O sistema ComfortAid visa facilitar a conexão entre clientes que buscam serviços de massagem terapêutica e estética domiciliar e profissionais que oferecem esses serviços. O sistema também será acessível a profissionais com conhecimentos tradicionais populares, como parteiras e curandeiras, para divulgar seus trabalhos e alcançar novos clientes.

## 2. Requisitos Funcionais

_Cadastro de usuários_:
 - RF01: O sistema deve permitir que clientes e profissionais se cadastrem na plataforma.
 - RF02: O sistema deve distinguir entre contas de clientes e profissionais.
_Pesquisa e seleção de profissionais_:
 - RF03: O sistema deve permitir que clientes pesquisem profissionais por região e serviço.
 - RF04: O sistema deve exibir uma lista de profissionais com base nos critérios de pesquisa definidos pelos clientes.
_Agendamento de serviços_:
 - RF05: O sistema deve permitir que clientes agendem serviços diretamente com profissionais.
 - RF06: O sistema deve enviar notificações de confirmação e lembretes para clientes e profissionais.
_Avaliação e feedback_:
 - RF07: O sistema deve permitir que clientes avaliem os serviços recebidos e deixem feedbacks visíveis para outros usuários.
_Geolocalização_:
 - RF08: O sistema deve permitir a localização de profissionais próximos com base na geolocalização do cliente.
_Comunicação interna_:
 - RF09: O sistema deve incluir um chat para facilitar a comunicação entre clientes e profissionais.

## 3. Requisitos Não-Funcionais

 - RNF01 - Segurança: O sistema deve utilizar criptografia para proteger dados pessoais e de comunicação dos usuários.
 - RNF02 - Desempenho: O sistema deve ser capaz de processar pesquisas e reservas em até 2 segundos.
 - RNF03 - Usabilidade: O sistema deve possuir uma interface amigável e intuitiva, acessível em dispositivos móveis e desktop.
 - RNF04 - Disponibilidade: O sistema deve estar disponível 99,8% do tempo, com exceção de períodos programados para manutenção.
 - Caso de Uso - Pesquisa e Seleção de Profissionais
 - Nome do Caso de Uso: Pesquisar e Selecionar Profissionais
 - Descrição: Permite que um cliente busque por profissionais cadastrados com base na localização e no tipo de serviço desejado.
 - Ator Principal: Cliente
 - Pré-Condições: O cliente deve estar cadastrado e logado no sistema.

### Fluxo Principal:

1. O cliente acessa a página de pesquisa de profissionais.
2. O cliente insere critérios de busca (ex: localização, tipo de serviço, preço).
3. O sistema exibe uma lista de profissionais que correspondem aos critérios.
4. O cliente seleciona um profissional para ver o perfil detalhado.
5. O cliente pode optar por agendar um serviço ou entrar em contato diretamente com o profissional.
6. O sistema confirma a operação escolhida pelo cliente.

### Fluxos Alternativos:

 - FA01: Se nenhum profissional correspondente for encontrado, o sistema exibirá uma mensagem informando a ausência de resultados e sugerirá ajustes nos critérios de busca.
 - FA02: Se o cliente desejar alterar os critérios de busca, ele poderá retornar ao passo 2 e inserir novas informações.
 - Pós-Condições: O cliente pode visualizar o perfil do profissional selecionado ou agendar um serviço.

_Caso de Teste_ - Pesquisar e Selecionar Profissionais

_ID do Caso de Teste_: __CT001__
 - Nome do Caso de Teste: Testar Pesquisa e Seleção de Profissionais
 - Caso de Uso Associado: Pesquisar e Selecionar Profissionais
 - Descrição: Verificar se o cliente consegue realizar a busca de profissionais com base nos critérios de localização e tipo de serviço, e se o sistema exibe os resultados corretos.
 - Pré-Condições: O sistema deve ter profissionais cadastrados e o cliente deve estar logado.

### Passos de Teste:

1. Acesse a página de pesquisa de profissionais.
2. Insira um critério de pesquisa (ex: "Massagem Relaxante" e localização "Florianopolis").
3. Clique no botão de busca.
4. Verifique se o sistema exibe uma lista de profissionais que atendem aos critérios.
5. Selecione um profissional da lista.
6. Verifique se a página de perfil do profissional é exibida corretamente.
7. Tente agendar um serviço diretamente pela página do profissional.
8. Verifique se o agendamento é confirmado e aparece no histórico do cliente.

### Resultados Esperados:

 - O sistema deve listar profissionais correspondentes aos critérios de pesquisa.
 - O perfil do profissional deve ser exibido corretamente quando selecionado.
 - O agendamento deve ser confirmado e refletido no histórico do cliente.

### Critérios de Aceitação:

 - O sistema retorna resultados corretos com base nos critérios inseridos.
 - O sistema lida adequadamente com situações onde não há resultados correspondentes.
 - O cliente pode visualizar perfis e agendar serviços diretamente.