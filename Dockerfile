# 1. Capa de compilación: Descarga Maven y Java 25 para compilar tu código
FROM maven:3.9.9-eclipse-temurin-25 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# 2. Capa de ejecución: Crea una imagen ultra ligera solo con el JRE de Java 25 para correr el jar
FROM eclipse-temurin:25-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]