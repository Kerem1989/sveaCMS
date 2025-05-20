# 1. Basimage: officiell OpenJDK 17 för att köra Spring Boot
FROM openjdk:17-jdk-slim

# 2. Sätt arbetskatalog i containern
WORKDIR /app

# 3. Kopiera din JAR-fil till containern
COPY target/sveaCMS-0.0.1-SNAPSHOT.jar app.jar

# 4. Kör applikationen
ENTRYPOINT ["java", "-jar", "app.jar"]