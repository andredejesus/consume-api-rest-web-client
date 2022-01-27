Projeto Construído com Java, Spring Boot, Web Client, Lombok, Imagem Docker, Swagger para documentar as APIs

Essa aplicação é para demonstrar o consumo das APIs do site https://jsonplaceholder.typicode.com/ utilizando o WEB CLIENT que foi introduzido no SPRING versão 5 para realização
de requisições web, com isso substituindo o REST TEMPLAT que era utilizado até então.

# Funcionalidades

1. Consulta de usuários
2. Crud de POSTS
3. Criação e consulta de comentários de um post

## Pré-requisitos para executar a aplicação:

1. Nessário ter o docker instalado na máquina
2. Fazer o clone do projeto
3. Criar a imagem com o comando: ( docker build -t java-spring . ) 
4. Criar o container com o comando: ( docker run --name java-container -d -p 8080:8080 java-spring )

Acessar o Swagger que possui as APIs documentadas: http://localhost:8080/swagger-ui/#/
