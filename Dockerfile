FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/studentmanagesys-0.0.1-SNAPSHOT.jar studentmanagesys.jar
EXPOSE 8087
ENTRYPOINT [ "java","-jar","studentmanagesys.jar" ]