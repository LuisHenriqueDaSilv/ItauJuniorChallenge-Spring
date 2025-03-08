<div align="center">

# Desafio Backend   Itau Unibanco

Projeto desenvolvido como solução para o 
<a>**Itaú Unibanco - Desafio de Programação**</a>
</div>

## Sobre:
Este é um desafio bacana tanto de desenvolvimento de software quanto de engenharia de software. O objetivo é testar a capacidade de construir um software com várias partes diferentes funcionando em conjunto!
</br></br>
A missão é criar uma **API REST** que recebe Transações e retorna Estatísticas sob essas transações. Para este desafio, a API deve ser criada utilizando-se de Java e Spring Boot.
</br>

## Endpoints:

#### Receber Transações: `POST /transacao`

Este é o endpoint que irá receber as Transações. Cada transação consiste de um `valor` e uma `dataHora` de quando ela aconteceu:

```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

Os campos no JSON acima significam o seguinte:

| Campo      | Significado                                                   | Obrigatório? |
|------------|---------------------------------------------------------------|--------------|
| `valor`    | **Valor em decimal com ponto flutuante** da transação         | Sim          |
| `dataHora` | **Data/Hora no padrão ISO 8601** em que a transação aconteceu | Sim          |

A API só aceitará transações que:

1. Tenham os campos `valor` e `dataHora` preenchidos
2. A transação **NÃO DEVE** acontecer no futuro
3. A transação **DEVE** ter acontecido a qualquer momento no passado
4. A transação **NÃO DEVE** ter valor negativo
5. A transação **DEVE** ter valor igual ou maior que `0` (zero)

Como resposta, este endpoint responde com:

- `201 Created` sem nenhum corpo
  - A transação foi aceita (ou seja foi validada, está válida e foi registrada)
- `422 Unprocessable Entity` sem nenhum corpo
  - A transação **não** foi aceita por qualquer motivo (1 ou mais dos critérios de aceite não foram atendidos - por exemplo: uma transação com valor menor que `0`)
- `400 Bad Request` sem nenhum corpo
  - A API não compreendeu a requisição do cliente (por exemplo: um JSON inválido)

#### Limpar Transações: `DELETE /transacao`

Este endpoint simplesmente **apaga todos os dados de transações** que estejam armazenados.

Como resposta, este endpoint responde com:

- `200 OK` sem nenhum corpo
  - Todas as informações foram apagadas com sucesso

#### Calcular Estatísticas: `GET /estatistica`

Este endpoint deve retornar estatísticas das transações que **aconteceram nos últimos 60 segundos (1 minuto)**. As estatísticas que devem ser calculadas são:

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

Os campos no JSON acima significam o seguinte:

|  Campo  | Significado                                                   |
|---------|---------------------------------------------------------------|
| `count` | **Quantidade de transações** nos últimos 60 segundos          |
| `sum`   | **Soma total do valor** transacionado nos últimos 60 segundos |
| `avg`   | **Média do valor** transacionado nos últimos 60 segundos      |
| `min`   | **Menor valor** transacionado nos últimos 60 segundos         |
| `max`   | **Maior valor** transacionado nos últimos 60 segundos         |

Como resposta, este endpoint responde com:

- `200 OK` com os dados das estatísticas
  - Um JSON com os campos `count`, `sum`, `avg`, `min` e `max` todos preenchidos com seus respectivos valores

</br>

## Como executar:
- Em breve 