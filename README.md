# 🏗️ Construction Management API - Gestão de Obras e Fornecedores

> Sistema de backend robusto desenvolvido para o gerenciamento centralizado de construtoras, com foco em segurança transacional, escalabilidade e portabilidade.

## 🚀 Diferenciais da Arquitetura
Este projeto foi desenvolvido aplicando padrões de **Engenharia de Software** para resolver desafios reais de segurança e ambiente:

- **Segurança com JWT & Auth0:** Implementação de autenticação stateless utilizando **Spring Security**, garantindo proteção total das rotas da API e controle de acesso granular.
- **Isolamento com Docker:** Arquitetura baseada em containers para garantir que a aplicação e o banco de dados (MySQL) funcionem de forma idêntica em qualquer ambiente (Desenvolvimento, Homologação e Produção).
- **Padrões de Projeto (Design Patterns):** Uso rigoroso de **SOLID**, **Clean Code** e **DTOs** para garantir um código desacoplado, modular e de fácil manutenção.
- **Qualidade de Software:** Cobertura de lógica de negócio com **Testes Unitários (JUnit 5 e Mockito)**, assegurando a estabilidade das regras de gestão e evitando regressões.
- **Persistência Evolutiva:** Migrations gerenciadas via **Flyway**, permitindo o versionamento seguro e automatizado do esquema do banco de dados MySQL.

## 🐳 Como Executar (Docker)
Este projeto está pronto para rodar em containers, eliminando a necessidade de configurações manuais de banco de dados local:

1. **Clone o repositório:**
   ```bash
   git clone https://github.com
docker-compose up -d
A API estará disponível em: http://localhost:8080
(Dica: A documentação técnica via Swagger/OpenAPI pode ser acessada em http://localhost:8080/swagger-ui.html)

