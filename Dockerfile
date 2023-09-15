FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/*.jar StudManageSys.jar

ENTRYPOINT [ "java","-jar","StudManageSys.jar" ]