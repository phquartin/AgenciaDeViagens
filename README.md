# Projeto da faculdade

## Sobre: [Oque foi pedido](docs/SOBRE.md)

---------------------------

# Sistema de Agência de Viagens

Este sistema permite o gerenciamento de clientes (nacionais e estrangeiros), pacotes de viagem e serviços adicionais para uma agência de turismo.

## Requisitos

- Recomendado usar alguma IDEA como `InteliJ` ou `eclipse`

- **Java JDK 21 ou inferior** (Caso use 21+ pode dar problemas com o LomBok)
- **Docker** e **Docker Compose** (obrigatório) [Como instalar](https://www.youtube.com/watch?v=Lgh8JgcYFwM)
- **Maven**

## Tecnologias Usadas

- Java 21
- Spring Boot
- MySQL
- Docker e Docker Compose
- JPA / Hibernate
- Idea: InteliJ

---

## Como executar

### 1. Clonar o projeto

```bash
git clone https://github.com/seu-usuario/https://github.com/phquartin/AgenciaDeViagens.git
cd https://github.com/phquartin/AgenciaDeViagens.git
```

### 2. Subir o banco de dados com Docker Compose

O projeto já inclui o arquivo `compose.yml`. Para iniciar o banco MySQL

Por causa da dependencia abaixo, ao rodar o Application, caso possua docker instalado na sua maquina o Banco de Dados sera gerado automaticamente
```bash
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-docker-compose</artifactId>
            <scope>runtime</scope>
            <optional>true</optional>
        </dependency>
```

O banco será iniciado em `localhost:3310`, compose.yaml:
````
services:
mysql:
image: 'mysql:8.1'
environment:
- 'MYSQL_DATABASE=mydatabase'
- 'MYSQL_PASSWORD=secret'
- 'MYSQL_ROOT_PASSWORD=verysecret'
- 'MYSQL_USER=myuser'
ports:
- '3310:3306'
````

### 3. Configurar o `application.properties` (se necessário)

```properties
spring.application.name=AgenciaDeViagens

spring.jpa.hibernate.ddl-auto=create # create usado para testes
spring.datasource.url=jdbc:mysql://localhost:3310/mydatabase
spring.datasource.username=myuser
spring.datasource.password=secret
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql= true
spring.jpa.properties.hibernate.format_sql=true
```

### 4. Rodar a aplicação

#### Com Maven:

```bash
./mvnw spring-boot:run
```

#### Ou na IDE:

Execute a classe principal que contém a anotação `@SpringBootApplication` (recomendo).

---

## Funcionalidades

- Cadastro, listagem, busca e exclusão de clientes (com CPF ou passaporte)
- Cadastro, listagem, busca e exclusão de pacotes de viagem
- Associação de pacotes a clientes
- Inclusão de serviços adicionais (translado, passeio, aluguel de carro etc.)
- Visualização de pacotes contratados por cliente e clientes de um pacote

---

## Observações

- Um pacote só pode ser removido se não houver clientes associados.
- Clientes estrangeiros devem informar o passaporte; nacionais, o CPF.
- Um pacote precisa ter **preço** e **destino** obrigatoriamente.
- !!!! Para ver os pedidos de um cliente ou pacote especifico voce deve clicar no botão **visualizar** apos selecionar pacotes, ou clientes no `index.html` que fica em **localhost:8080/**

---

## Scripts de Teste

Scripts para popular o banco de dados sao gerados automaticamente em: `src/main/java/com/agenciadeviagens/global/dataloader/DataLoader.java`

---

## Contribuições

Contribuições são bem-vindas!

Se você quiser sugerir melhorias, corrigir bugs ou adicionar novas funcionalidades, sinta-se à vontade para abrir uma **pull request**.  
Passo a passo:

1. Faça um fork do repositório
2. Crie uma branch (`git checkout -b minha-feature`)
3. Faça suas alterações
4. Faça o commit (`git commit -m 'Minha nova feature'`)
5. Faça o push para a branch (`git push origin minha-feature`)
6. Abra uma pull request

---

## Licença

Projeto acadêmico. Uso livre para fins de estudo e aprendizado.

Caso queira 