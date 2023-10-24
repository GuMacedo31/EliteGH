# Guia de Configuração e Execução da Aplicação Kotlin Spring com MySQL

Este guia fornece instruções detalhadas para configurar e executar uma aplicação Kotlin com Spring Boot, que utiliza um banco de dados MySQL hospedado, em seu computador pessoal.

## Pré-Requisitos

Antes de começar, certifique-se de que você tenha as seguintes versões instaladas em seu sistema:

- **Java 17**: Certifique-se de ter o Java Development Kit (JDK) 17 instalado em sua máquina.
- **Kotlin 1.8.22**: Verifique se o ambiente Kotlin está configurado corretamente.
- **Spring Boot 3.1.3**: Tenha o Spring Boot configurado na versão correta.

## Configuração do Ambiente

1. **Clone o Repositório**

   Clone o repositório da aplicação em seu computador:

   ```shell
   git clone https://github.com/GuMacedo31/EliteGH.git
   ```

2. **Configuração do Banco de Dados**

    - Certifique-se de ter acesso às credenciais e informações de conexão do MySQL.
    - Abra o arquivo `src/main/resources/application.yml` e configure as informações do banco de dados. Você pode usar o seguinte exemplo como modelo, ajustando as variáveis conforme necessário e substituindo as variáveis de ambiente PASSWORD_ELITEGH_DB e HOST_ELITEGH_DB pelos seus respectivos valores:

   ```yaml
    spring:
        datasource:
            username: admin 
            password: ${PASSWORD_ELITEGH_DB}
            url: jdbc:mysql://${HOST_ELITEGH_DB}:3306/eliteghdb
            driver-class-name: com.mysql.cj.jdbc.Driver
        jpa:
            hibernate:
                ddl-auto: create-only
        show-sql: true
   ```

3. **Configuração do API Security Token Secret**
    
    - Abra o arquivo `src/main/resources/application.yml` e configure a informação do segredo que será utilizado no token JWT substituindo a variável de ambiente JWT_SECRET
    ```yaml
    api:
        security:
            token:
                secret: ${JWT_SECRET}
   ```

4. **Inicie a aplicação**
   
   Inicie a aplicação com as configurações prévias realizadas e após uma inicialização bem-sucedida, você pode acessar em seu navegador a seguinte rota:

   ```
   http://localhost:8080/swagger-ui/index.html#/
   ```
   
   **Ela irá indicar todas as rotas disponíveis na aplicação, juntamente com o payload de entrada e o payload de saída**


5. **Chamada nas Rotas Existentes**

   As rotas existentes que não solicitam o token JWT e correspondem ao método GET podem ser feitas através do próprio navegador, enquanto as demais rotas que exigem o token ou são pertencem a outros métodos podem ser chamadas através do Postman ou do Insomnia

## Conclusão

Agora, a aplicação Kotlin Spring com MySQL está em execução em seu computador pessoal. Certifique-se de manter as dependências e configurações atualizadas à medida que a aplicação evolui. Se você tiver alguma dúvida ou encontrar algum problema, sinta-se à vontade para entrar em contato para obter suporte adicional.