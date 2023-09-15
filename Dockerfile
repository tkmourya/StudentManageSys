# Build Stage
FROM maven:3.8.5-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime Stage
FROM openjdk:17.0.1-jdk-slim
WORKDIR /app
COPY --from=build /app/target/StudManageSys.jar StudManageSys.jar
EXPOSE 8087
ENTRYPOINT ["java", "-jar", "StudManageSys.jar"]
