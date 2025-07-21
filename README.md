
# jooby-api-usuarios

Este é um projeto de exemplo de uma API REST simples construída com o framework **Jooby** em **Java**. Ele gerencia uma lista de usuários em memória.

---

## 🗂️ Estrutura do Projeto

```
jooby-api-usuarios/
├── pom.xml                   # Arquivo de configuração do Maven
├── README.md                 # Explicação do projeto
├── .gitignore                # Arquivos a serem ignorados pelo Git
├── src/
│   └── main/
│       ├── java/
│       │   └── app/
│       │       ├── App.java                    # Classe principal da aplicação
│       │       ├── model/
│       │       │   └── Usuario.java            # Modelo de dados para o usuário
│       │       ├── controller/
│       │       │   └── UsuarioController.java  # Controlador para as rotas de usuário
│       │       └── repository/
│       │           └── UsuarioRepository.java  # Repositório mock para simular o acesso a dados
│       └── resources/
│           └── application.conf                # Configurações do Jooby
└── target/                                     # Gerado após o build do Maven
```

---

## ▶️ Como Executar

Para executar este projeto, você precisará ter o **Maven** e o **JDK 11** (ou superior) instalados.

1. Clone o repositório (se aplicável) ou crie a estrutura de arquivos.
2. Navegue até o diretório raiz do projeto (`jooby-api-usuarios/`) no seu terminal.
3. Execute a aplicação usando Maven:

```bash
mvn jooby:run
```

A aplicação será iniciada e estará disponível em:  
👉 [http://localhost:8080](http://localhost:8080)

---

## 🔗 Endpoints da API

A API fornece os seguintes endpoints para gerenciar usuários:

### `GET /usuarios`
Retorna uma lista de todos os usuários.

### `GET /usuarios/{id}`
Retorna um usuário específico pelo ID.

### `POST /usuarios`
Cria um novo usuário.  
**Corpo da Requisição (JSON):**
```json
{
  "nome": "Nome do Usuário",
  "email": "email@example.com"
}
```

### `PUT /usuarios/{id}`
Atualiza um usuário existente pelo ID.  
**Corpo da Requisição (JSON):**
```json
{
  "nome": "Novo Nome",
  "email": "novo.email@example.com"
}
```

### `DELETE /usuarios/{id}`
Exclui um usuário pelo ID.

---

## 🛠️ Tecnologias Utilizadas

- **Jooby**: Framework web para Java.
- **Maven**: Ferramenta de automação de build.
- **Java 11+**: Linguagem de programação.
- **Jackson**: Biblioteca para serialização/desserialização JSON.
