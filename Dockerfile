FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar StudManageSys.jar
EXPOSE 8087
ENTRYPOINT [ "java","-jar","StudManageSys.jar" ]