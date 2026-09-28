# URL Shortener

Um encurtador de URLs desenvolvido com Java e Spring Boot. O projeto utiliza Base62 para gerar códigos curtos a partir do ID numérico das URLs armazenadas no PostgreSQL.

## Funcionalidades

* Encurtar uma URL longa em um código curto
* Redirecionar um código curto para a URL original

## Tecnologias

* Java 21
* Spring Boot
* PostgreSQL
* Docker
* Docker Compose

## Como rodar

### Pré-requisitos

* Docker
* Docker Compose

Clone o repositório:

```bash
git clone https://github.com/josefernandosilva2007/url-shortener.git
cd url-shortener
```

Configure as variáveis de ambiente conforme o arquivo `.env.example` e execute:

```bash
docker compose up --build
```

A aplicação estará disponível em:

```text
http://localhost:8080
```

## Endpoints

### Encurtar URL

```http
POST /v1/shorten
```

Exemplo de requisição:

```json
{
  "url": "https://www.example.com"
}
```

### Redirecionar

```http
GET /{id}
```

O endpoint redireciona para a URL original associada ao código informado.

## Decisões Técnicas

### Por que Base62?

O Base62 utiliza 62 caracteres:

* `A-Z`
* `a-z`
* `0-9`

Isso permite gerar códigos curtos utilizando apenas caracteres alfanuméricos, tornando-os adequados para utilização em URLs.

### Como o código curto é gerado?

O ID numérico do registro é convertido para Base62 por meio de divisões sucessivas por 62.

A cada divisão, o resto é utilizado como índice para obter um caractere do alfabeto Base62. Os caracteres são então reunidos na ordem inversa para formar o código curto.

### Docker

O projeto utiliza Docker para executar a aplicação e o PostgreSQL em containers separados.

O Docker Compose é utilizado para:

* Criar e conectar os containers da aplicação e do banco de dados
* Configurar as variáveis de ambiente
* Disponibilizar a aplicação na porta `8080`
* Gerenciar o ambiente de desenvolvimento

## Estrutura da API

| Método | Endpoint      | Descrição                       |
| ------ | ------------- | ------------------------------- |
| POST   | `/v1/shorten` | Cria uma URL encurtada          |
| GET    | `/{id}`       | Redireciona para a URL original |


