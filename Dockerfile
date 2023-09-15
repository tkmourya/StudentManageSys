FROM eclipse-temurin:17-jdk-alpine AS build


FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/StudManageSys.jar StudManageSys.jar
EXPOSE 8087
ENTRYPOINT [ "java","-jar","StudManageSys.jar" ]