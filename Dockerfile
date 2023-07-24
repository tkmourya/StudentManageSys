FROM openjdk
EXPOSE 8087
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT [ "java","-jar","/opt/render/project/src/spring-boot-docker.jar" ]