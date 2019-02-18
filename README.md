# clientes

Clientes Back end.

Web Service para prover serviços para o front end ClientesFront

Teconologias 
- Java 8
- Maven
- Spring Framework
- JPA
- Banco de dados H2

Instruções 
- 1 - Baixar o código fonte deste repositório 
- 2 - Instalar o Maven CLI
- 3 - Acessar a pasta do projeto e executar o comando mvn install
- 4  - Rodar o comando mvn spring-boot:run 
- 6 – Acesso através da url http://localhost:8080

São serviçõs providos:
- GET ~/vendedores - Buscar Todos Vendedores
- GET ~/vendedores/id - Buscar vendedor por Id
- POST ~/vendedores - Cadsatrar Vendedor
- PUT ~/vendedores/id - Editar Vendedor
- DELETE ~/vendedores/id - Apaagr Vendedores

- GET ~/clientes - Buscar Todos clientes
- GET ~/clientes/id - Buscar cliente por Id
- POST ~/clientes - Cadsatrar cliente
- PUT ~/clientes/id - Editar cliente
- DELETE ~/clientes/id - Apaagr cliente
