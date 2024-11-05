# Projeto para Calculo de Folha de Pagamento

### Estrutura de Pastas do Projeto
Para um projeto bem estruturado em Spring Boot, seguindo o padrão MVC, organizou-se da seguinte forma:

```bash

src/main/java
└── edu
    └── ifsc
        └── cambio
            ├── controller
            │   └── MoedaController.java
            ├── dto
            │   └── ConversaoResponseDTO.java
            │   └── CotacaoDTO.java
            ├── model
            │   └── Moeda.java
            ├── service
            │   └── MoedaService.java
            └── CambioApplication.java
``` 




### Exemplos de Requisições:
API de Conversão de Moeda (a):
bash
Copy code
GET http://localhost:8080/converter_moeda/10000.0/DT/venda
Resposta esperada:

json
Copy code
{
  "valorEntrada": 10000.0,
  "tipoMoeda": "DT",
  "operacao": "venda",
  "valorConvertido": 1739.13
}
API de Conversão para Todas as Moedas (b):
bash
Copy code
GET http://localhost:8080/converter_moeda/10000.0/venda
Resposta esperada:

json
Copy code
{
  "DC": 1783.61,
  "DP": 1727.12,
  "DX": 1783.68,
  "DT": 1738.22,
  "EU": 1469.08,
  "OU": 28.31
}
API de Cotações de Moedas (c):
bash
Copy code
GET http://localhost:8080/converter_moeda/cotacao_moeda
Resposta esperada:

json
Copy code
[
  {
    "moeda": "DC",
    "compra": 5.6061,
    "venda": 5.6066
  },
  {
    "moeda": "DP",
    "compra": 5.69,
    "venda": 5.79
  },
  {
    "moeda": "DX",
    "compra": 5.6058,
    "venda": 5.6064
  },
  {
    "moeda": "DT",
    "compra": 5.543,
    "venda": 5.753
  },
  {
    "moeda": "EU",
    "compra": 6.563,
    "venda": 6.807
  },
  {
    "moeda": "OU",
    "compra": 346.7,
    "venda": 346.7
  }
]
