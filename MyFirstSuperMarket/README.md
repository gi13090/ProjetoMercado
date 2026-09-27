# MyFirstSuperMarket — Backend Mercado

## Sobre o Projeto

## Projeto em constante mudança para fins educacionais!!


O MyFirstSuperMarket é uma API REST desenvolvida em Java utilizando Spring Boot e JPA/Hibernate. 

A aplicação simula o backend de gestão de um mercado de bairro, permitindo o gerenciamento de produtos, colaboradores e fornecedores, com regras de negócio aplicadas diretamente no modelo de dados.

O projeto foi desenvolvido de forma independente para consolidar, na prática, conceitos de persistência de dados, modelagem de entidades e boas práticas com Spring/JPA.

---

## Tecnologias Utilizadas

* Java 25 
* Spring Boot 
* Spring Data JPA / Hibernate
* Lombok
* Maven

---

## Arquitetura do Projeto

```text
src/main/java
│
├── entities
│   └── Products, Colaboladores, Fornecedores
│
├── repository
│   └── Camada de acesso ao banco de dados
│
├── controller
│   └── Endpoints REST
│
└── config
    └── Configuração de conexão com banco
```

<!-- ajuste conforme a organização real de pastas do seu projeto -->

---

## Banco de Dados

<!-- descreva aqui o banco utilizado (MySQL, PostgreSQL, H2, etc.) e onde está hospedado -->

Tabelas principais:

* PRODUCTS
* COLABOLADORES
* FORNECEDORES

---

## Configuração de Ambiente

<!-- se o projeto usa variáveis de ambiente para conexão com banco, documente aqui seguindo o padrão: -->

```text
DB_URL=
DB_USER=
DB_PASSWORD=
```

---

## Executando Localmente

### Clonar o repositório

```bash
git clone https://github.com/gi13090/MyFirstSuperMarket.git
```

### Acessar a pasta do projeto

```bash
cd MyFirstSuperMarket
```

### Executar a aplicação

```bash
mvn spring-boot:run
```

A API ficará disponível em:

```text
http://localhost:8080
```

---

## Documentação

<!-- se implementar Swagger/OpenAPI, documente aqui o caminho, ex: http://localhost:8080/swagger-ui.html -->

---

## Deploy

<!-- se o projeto estiver publicado em algum ambiente (Render, Railway, etc.), documente a URL aqui -->

---

## Entidades da Aplicação

### Products

Representa os produtos disponíveis no mercado.

| Campo | Descrição |
|---|---|
| `id` | Identificador único |
| `name` | Nome do produto |
| `marca` | Marca do produto |
| `valor` | Preço do produto |
| `quantidadeEstoque` | Quantidade disponível em estoque |
| `ativo` | Flag de ativação do produto |
| `disponivel` *(derivado)* | Calculado como `ativo && quantidadeEstoque > 0` |

Cada produto está vinculado a um único fornecedor (`@ManyToOne`), garantindo que preço e condições de entrega não se misturem entre fornecedores diferentes.

### Colaboladores

Representa os colaboradores do mercado.

| Campo | Descrição |
|---|---|
| `id_colaborador` | Identificador único |
| `name` | Nome do colaborador |
| `email` | E-mail de contato |
| `endereço` | Endereço do colaborador |
| `turno` | Turno de trabalho |

### Fornecedores

Representa os fornecedores dos produtos.

| Campo | Descrição |
|---|---|
| `nome` | Nome do fornecedor |
| `cnpj` | CNPJ, validado por regex de formato |
| `prazoEntrega` | Prazo de entrega em dias |
| `localização` | Localização do fornecedor |

> Decisão de design: `Fornecedores` não implementa `equals`/`hashCode` customizado — apenas `Products` e `Colaboladores` possuem essa implementação, baseada no identificador de cada entidade.

---

## Endpoints

### Produtos

| Método | Endpoint |
| ------ | -------- |
| GET | /products |
| GET | /products/{id} |
| POST | /products |
| PUT | /products/{id} |
| DELETE | /products/{id} |

### Colaboradores

| Método | Endpoint |
| ------ | -------- |
| GET | /colaboradores |
| GET | /colaboradores/{id} |
| POST | /colaboradores |
| PUT | /colaboradores/{id} |
| DELETE | /colaboradores/{id} |

### Fornecedores

| Método | Endpoint |
| ------ | -------- |
| GET | /fornecedores |
| GET | /fornecedores/{id} |
| POST | /fornecedores |
| PUT | /fornecedores/{id} |
| DELETE | /fornecedores/{id} |

<!-- confirme os caminhos reais definidos nos seus @RestController -->

---

## Exemplos de JSON

### Product

```json
{
  "id": 1,
  "name": "Arroz Tipo 1",
  "marca": "Marca X",
  "valor": 24.90,
  "quantidadeEstoque": 50,
  "ativo": true,
  "fornecedorId": 1
}
```

### Colaborador

```json
{
  "id_colaborador": 1,
  "name": "Giovanni",
  "email": "giovanni@email.com",
  "endereço": "Rua Exemplo, 123",
  "turno": "Manhã"
}
```

### Fornecedor

```json
{
  "id": 1,
  "nome": "Distribuidora Alimentos LTDA",
  "cnpj": "00.000.000/0001-00",
  "prazoEntrega": 5,
  "localização": "São Paulo, SP"
}
```

---

## Autor

Projeto desenvolvido individualmente por **Giovanni Sacristan**.

---

## Links

GitHub: https://github.com/gi13090/MyFirstSuperMarket

LinkedIn: https://www.linkedin.com/in/giovannisacristan-884383388