# 📚 LibraryAPI

API REST para gerenciamento de biblioteca, desenvolvida com Spring Boot.

> **Nota:** O back-end foi desenvolvido acompanhando um curso de Spring Boot. O front-end, a configuração de segurança OAuth2, e o deploy em produção foram feitos por mim de forma independente.

---

## 🚀 Deploy

- **API:** [Railway](https://railway.app) — `https://libraryapi-production-d42e.up.railway.app`
- **Front-end:** [GitHub Pages](https://pages.github.com)
- **Banco de dados:** [Neon](https://neon.tech) (PostgreSQL serverless)

---

## 🛠️ Tecnologias

| Camada | Tecnologia |
|---|---|
| Linguagem | Java 21 |
| Framework | Spring Boot 3.3.4 |
| Segurança | Spring Security + OAuth2 Authorization Server |
| Banco de dados | PostgreSQL (Neon) |
| ORM | Spring Data JPA + Hibernate |
| Mapeamento | MapStruct |
| Documentação | SpringDoc OpenAPI (Swagger UI) |
| Build | Maven |
| Deploy | Railway |

---

## 📋 Funcionalidades

- Cadastro, edição, busca e exclusão de **autores**
- Cadastro, edição, busca e exclusão de **livros**
- Filtros de busca por título, ISBN, autor, gênero e ano
- Paginação nos resultados
- Autenticação via **OAuth2 / JWT** (client credentials + authorization code)
- Controle de acesso por roles
- Documentação interativa via Swagger UI

---

## 🔐 Segurança

A API utiliza **Spring Authorization Server** com dois fluxos OAuth2:

- `client_credentials` — para integrações máquina-a-máquina
- `authorization_code` — para login de usuários
- `refresh_token` — renovação de tokens

Senhas armazenadas com **BCrypt**.

---

## 📦 Endpoints principais

### Autores
| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/autores` | Cadastrar autor |
| `GET` | `/autores/{id}` | Buscar por ID |
| `GET` | `/autores?nome=&nacionalidade=` | Pesquisar autores |
| `PUT` | `/autores/{id}` | Atualizar autor |
| `DELETE` | `/autores/{id}` | Excluir autor |

### Livros
| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/livros` | Cadastrar livro |
| `GET` | `/livros/{id}` | Buscar por ID |
| `GET` | `/livros?titulo=&isbn=&nome-autor=&genero=&ano-publicacao=` | Pesquisar livros |
| `PUT` | `/livros/{id}` | Atualizar livro |
| `DELETE` | `/livros/{id}` | Excluir livro |

### Autenticação
| Método | Rota | Descrição |
|---|---|---|
| `POST` | `/oauth2/token` | Obter token JWT |

---

## ⚙️ Como rodar localmente

### Pré-requisitos
- Java 21
- Maven
- PostgreSQL (ou conta no Neon)

### Configuração

Crie um arquivo `.env` ou configure as variáveis de ambiente:

```env
DB_URL=jdbc:postgresql://<host>/<database>
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
```

### Rodando

```bash
# Clonar o repositório
git clone https://github.com/seu-usuario/libraryapi.git
cd libraryapi

# Rodar a aplicação
./mvnw spring-boot:run
```

A API estará disponível em `http://localhost:8080`.

A documentação Swagger estará em `http://localhost:8080/swagger-ui/index.html`.

---

## 🗄️ Modelo de dados

```
Autor
├── id (UUID)
├── nome
├── dataNascimento
└── nacionalidade

Livro
├── id (UUID)
├── isbn
├── titulo
├── dataPublicacao
├── genero (FICCAO, FANTASIA, MISTERIO, ROMANCE, BIOGRAFIA, CIENCIA)
├── preco
└── autor (FK → Autor)
```

---

## 📄 Licença

Projeto de estudo. Livre para uso e referência.
