# Url Shortener

Um encurtador de url usando Base62

## Funcionalidades
 - Encurta uma URL longa em um código curto
 - Redireciona o código curto para URL original

## Tecnologias
 - Java 21
 - Spring Boot
 - Docker
 - PostgreSQL

## Como rodar

```bash
    docker-compose up -d
    ./mvnw spring-boot:run
```

## Endpoints
- POST /v1/shorten
- GET /{id} 

## Decisões Tecnicas
- **Por que Base62?** Porque não utiliza caracteres especiais, evitando quebrar a URL.
- **Como o código curto é gerado:** Pegamos o ID numérico do registro e dividimos repetidamente por 62, usando o resto de cada divisão para indexar um caractere do nosso alfabeto Base62. Juntando os restos de trás pra frente, obtemos o código curto.



