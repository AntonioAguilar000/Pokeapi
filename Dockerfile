# Etapa 1: Construcción
FROM maven:3.9.6-eclipse-temurin-17 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17
WORKDIR /app
COPY --from=builder /app/target/pokedex-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
