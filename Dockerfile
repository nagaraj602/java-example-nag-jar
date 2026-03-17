FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/java-example-demo-1.0.0.jar app.jar

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "app.jar"]
