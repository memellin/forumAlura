# ForumHub

ForumHub é uma aplicação para gerenciar tópicos de discussão em um fórum, desenvolvida utilizando Java e o framework Spring.

## Visão Geral

O ForumHub permite aos usuários criar tópicos de discussão sobre diversos assuntos, interagir através de respostas e gerenciar conteúdos relacionados a cursos.

## Funcionalidades

- **Criação de Tópicos:** Permite criar novos tópicos com título, mensagem e associá-los a cursos específicos.
- **Listagem de Tópicos:** Exibe uma lista paginada dos tópicos disponíveis no fórum.
- **Atualização de Tópicos:** Permite atualizar o título e a mensagem de um tópico existente.
- **Respostas:** Os usuários podem responder aos tópicos existentes.
- **Gestão de Cursos:** Administração dos cursos associados aos tópicos.

## Estrutura do Projeto

O projeto está estruturado da seguinte forma:

- **`src/main/java`:** Contém o código-fonte Java.
    - **`br.com.alura.forumhub.forumHub.controller`:** Controladores da aplicação.
    - **`br.com.alura.forumhub.forumHub.domain`:** Entidades de domínio, como `Topico`, `Curso`, `Autor`, entre outras.
    - **`br.com.alura.forumhub.forumHub.domain.autor`:** Classes relacionadas aos autores dos tópicos.
    - **`br.com.alura.forumhub.forumHub.domain.curso`:** Classes relacionadas aos cursos associados aos tópicos.
    - **`br.com.alura.forumhub.forumHub.domain.topicos`:** Classes relacionadas aos tópicos do fórum.
    - **`br.com.alura.forumhub.forumHub.repository`:** Repositórios para acesso aos dados.
- **`src/main/resources`:** Recursos da aplicação.
    - **`application.properties`:** Configurações da aplicação, como configurações do banco de dados.
    - **`data.sql`:** Script SQL para inicialização dos dados iniciais.

## Tecnologias Utilizadas

- **Java 17:** Linguagem de programação principal.
- **Spring Boot:** Framework para desenvolvimento de aplicações Java.
- **Spring Data JPA:** Facilita o acesso e manipulação de dados relacionais em aplicações Java.
- **Hibernate:** Framework ORM para mapeamento objeto-relacional.
- **MySQL:** Banco de dados relacional utilizado para armazenamento dos dados.

## Como Executar o Projeto

1. **Pré-requisitos:**
    - Java JDK 11 instalado.
    - MySQL Server instalado e configurado.

2. **Configuração do Banco de Dados:**
    - Crie um banco de dados no MySQL chamado `forumhub`.
    - Configure as credenciais de acesso no arquivo `application.properties`.

3. **Execução:**
    - Clone o repositório do projeto.
    - Importe o projeto em sua IDE preferida (IntelliJ IDEA, Eclipse, etc.).
    - Execute a classe principal `ForumHubApplication.java`.

4. **Testando a Aplicação:**
    - Acesse `http://localhost:8080` em seu navegador.
    - Utilize ferramentas como Postman ou curl para testar as APIs REST disponíveis.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para enviar pull requests com melhorias, correções de bugs, novas funcionalidades, entre outros.

## Autor

Juan Cunha - Desenvolvedor Full Stack

## Licença

Este projeto está licenciado sob a [Licença MIT](https://opensource.org/licenses/MIT).
