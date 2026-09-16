# Eventz API

![Java](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk\&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4-6DB33F?logo=springboot\&logoColor=white)
![Spring Security](https://img.shields.io/badge/Spring_Security-6DB33F?logo=springsecurity\&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-Authentication-000000?logo=jsonwebtokens\&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?logo=hibernate\&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-18-4169E1?logo=postgresql\&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-C71A36?logo=apachemaven\&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker\&logoColor=white)
![Render](https://img.shields.io/badge/Deploy-Render-46E3B7?logo=render\&logoColor=white)
![Neon](https://img.shields.io/badge/Database-Neon-00E699?logo=neon\&logoColor=black)

Backend da plataforma **Eventz**, desenvolvido para gerenciamento de eventos, usuários e autenticação.

A API foi construída com **Java + Spring Boot**, utilizando **PostgreSQL** como banco de dados e **JWT** para autenticação.

O projeto faz parte do desenvolvimento full stack da plataforma Eventz.

---

## Tecnologias

* Java 21
* Spring Boot
* Spring Security
* JWT
* Spring Data JPA
* Hibernate
* PostgreSQL
* Maven
* Docker
* Render
* Neon

---

## Funcionalidades

### Autenticação

* Cadastro de usuários
* Login
* Criação de token JWT
* Proteção de endpoints com autenticação
* Consulta dos dados do usuário autenticado

### Eventos

* Criar eventos
* Listar eventos
* Buscar evento por ID
* Atualizar eventos
* Excluir eventos
* Controle de ingressos disponíveis
* Definição de categoria, preço, data e horário


### Segurança

A API utiliza **Spring Security** para proteger os endpoints.

As senhas dos usuários são armazenadas utilizando **BCrypt** e a autenticação é realizada através de **JWT (JSON Web Token)**.

---

## Estrutura do projeto

```text

src/
└── main/
    ├── java/
    │   └── com/eventz/eventz_api/
    │       ├── config/
    │       ├── controller/
    │       ├── dto/
    │       ├── entity/
    │       ├── exception/
    │       ├── repository/
    │       ├── security/
    │       └── service/
    │
    └── resources/
        └── application.properties
```


### Principais responsabilidades

**Controller**
Responsável pelos endpoints da API e recebimento das requisições HTTP.

**Service**
Contém as regras de negócio da aplicação.

**Repository**
Responsável pelo acesso aos dados através do Spring Data JPA.

**Entity**
Representa as tabelas do banco de dados.

**DTO**
Define os dados utilizados nas requisições e respostas da API.

**Security**
Contém as configurações de autenticação e validação do JWT.

**Exception**
Centraliza o tratamento de erros da API.

---

## Principais endpoints

### Autenticação

| Método | Endpoint             | Descrição                     |
| ------ | -------------------- | ----------------------------- |
| POST   | `/api/auth/register` | Cadastrar usuário             |
| POST   | `/api/auth/login`    | Fazer login                   |
| GET    | `/api/users/me`      | Consultar usuário autenticado |

### Eventos

| Método | Endpoint                | Descrição                 |
| ------ | ----------------------- | ------------------------- |
| GET    | `/api/events`           | Listar eventos            |
| GET    | `/api/events/{id}`      | Buscar evento             |
| POST   | `/api/events`           | Criar evento              |
| PUT    | `/api/events/{id}`      | Atualizar evento          |
| DELETE | `/api/events/{id}`      | Excluir evento            |
| GET    | `/api/events/my-events` | Listar eventos do usuário |

Os endpoints protegidos exigem um token JWT no header:

```http
Authorization: Bearer SEU_TOKEN
```

---

## Banco de dados

O projeto utiliza **PostgreSQL**.

Durante o desenvolvimento local, a aplicação pode ser executada com um banco PostgreSQL local.

Para produção, o banco utilizado é o **Neon PostgreSQL**.

O Hibernate é responsável pela integração entre as entidades Java e as tabelas do banco através do **JPA**.

---

## Configuração

As informações sensíveis não são versionadas no GitHub.

O arquivo:


src/main/resources/application.properties


está protegido pelo `.gitignore`.

Exemplo das propriedades utilizadas:

```properties
spring.datasource.url=jdbc:postgresql://HOST/DATABASE
spring.datasource.username=USERNAME
spring.datasource.password=PASSWORD

spring.jpa.hibernate.ddl-auto=update

jwt.secret=JWT_SECRET
jwt.expiration=3600000

server.port=${PORT:8080}
```

As credenciais reais devem ser configuradas através das variáveis de ambiente.

---

## Como executar localmente

### 1. Clone o repositório

```bash
git clone https://github.com/kiaraengineer-dev/eventz-api.git
```

### 2. Entre na pasta

```bash
cd eventz-api
```

### 3. Configure o banco de dados

Crie um banco PostgreSQL e configure as informações de conexão no arquivo `application.properties`.

### 4. Execute o projeto

No Windows:

```bash
mvnw.cmd spring-boot:run
```

A API será executada, por padrão, em:


http://localhost:8080

---

## Docker

O projeto possui um `Dockerfile` para facilitar a execução e o deploy da aplicação.

Para criar o projeto:

```bash
docker build -t eventz-api .
```

Para executar:

```bash
docker run -p 8080:8080 eventz-api
```

---

## Deploy

O backend está preparado para ser executado em ambiente de produção utilizando:

* **Render** para hospedagem da API
* **Neon** para PostgreSQL
* **Docker** para empacotamento da aplicação

As credenciais e configurações sensíveis são fornecidas através das **Environment Variables** do ambiente de produção.

---

## Testando a API

A API pode ser testada utilizando ferramentas como:

* Bruno
* Postman
* Insomnia

Durante o desenvolvimento, os endpoints foram testados utilizando requisições HTTP e autenticação com JWT.

---

## Frontend

O backend fornece a API utilizada pelo frontend React do Eventz.

**Frontend:**
https://github.com/kiaraengineer-dev/Eventz

---

## Próximas melhorias

* Implementar autorização para que somente o criador possa editar ou excluir seu evento
* Melhorar o gerenciamento de permissões
* Implementar sistema de compra de ingressos
* Integrar pagamentos
* Integração com plataformas externas como Ticketmaster e Sympla
* Melhorar tratamento e validação de dados
* Adicionar mais testes automatizados
* Suporte a diferentes provedores de eventos

---

## Autora

**Kiara Toster Santos França**

Projeto pessoal desenvolvido para prática e evolução em desenvolvimento **Full Stack**.

---

## Licença

Este projeto é destinado para fins de estudo e desenvolvimento pessoal.
