FROM openjdk:17


ENV PROJECT_NAME ApiConstrutor


COPY target/ApiConstrutora-0.0.1-SNAPSHOT.jar /app.jar


EXPOSE 8081


CMD ["java", "-jar", "/app.jar"]
