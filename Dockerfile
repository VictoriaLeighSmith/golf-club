FROM maven:3.10-eclipse-temurin-27 AS build
WORKDIR /workspace/app
COPY . .
RUN mvn clean package -DskipTests

FROM eclipse-temurin:27-jre-alpine
WORKDIR /app
COPY --from=build /workspace/app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]