# Steg 1: Bygg JAR-filen
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Steg 2: Kör applikationen
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/sveaCMS-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
