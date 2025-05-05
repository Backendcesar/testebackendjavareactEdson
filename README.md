# Sistema de Votação para Cooperativas

Este é um sistema de votação desenvolvido em Java com Spring Boot para gerenciar sessões de votação em cooperativas.

## Requisitos

- Java 17 ou superior
- Maven 3.6 ou superior

## Como executar

1. Clone o repositório
2. Navegue até o diretório do projeto
3. Execute o comando:
```bash
mvn spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080/api/v1`

## Endpoints da API

### Pautas

- `POST /api/v1/pautas` - Criar uma nova pauta
  ```json
  {
    "titulo": "Título da Pauta",
    "descricao": "Descrição da Pauta"
  }
  ```

- `POST /api/v1/pautas/{id}/abrir-sessao?duracaoMinutos=1` - Abrir sessão de votação
  - `duracaoMinutos` é opcional (padrão: 1 minuto)

- `GET /api/v1/pautas/{id}` - Buscar pauta por ID

### Votos

- `POST /api/v1/pautas/{pautaId}/votos` - Registrar voto
  ```json
  {
    "cpfAssociado": "12345678900",
    "voto": "SIM"
  }
  ```

- `GET /api/v1/pautas/{pautaId}/votos/resultado` - Obter resultado da votação

## Banco de Dados

A aplicação utiliza o banco de dados H2 em memória. O console H2 está disponível em:
`http://localhost:8080/api/v1/h2-console`

- JDBC URL: `jdbc:h2:mem:votacaodb`
- Username: `sa`
- Password: (vazio)

## Funcionalidades

- Cadastro de pautas
- Abertura de sessões de votação com tempo configurável
- Registro de votos (SIM/NÃO)
- Validação de CPF (simulada)
- Contagem de votos e resultado da votação
- Validações de regras de negócio
- Tratamento de erros
- API versionada (v1)

## Tecnologias Utilizadas

- Java 17
- Spring Boot 3.2.3
- Spring Data JPA
- H2 Database
- Lombok
- Maven 