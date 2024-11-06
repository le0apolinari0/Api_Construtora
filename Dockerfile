FROM openjdk:17

# Define a variável de ambiente para o projeto
ENV PROJECT_NAME ApiConstrutor

# Copia o arquivo jar para o container
COPY target/ApiConstrutora-0.0.1-SNAPSHOT.jar /app.jar

# Define a porta que o container irá expor
EXPOSE 8081

# Executa o comando para iniciar o aplicativo
CMD ["java", "-jar", "/app.jar"]