FROM openjdk:11

WORKDIR /app

EXPOSE 8080

COPY target/project-consume-api-rest-0.0.1-SNAPSHOT.jar /app/spring-app.jar

ENTRYPOINT ["java", "-jar", "spring-app.jar"]

