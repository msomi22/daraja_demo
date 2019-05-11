FROM openjdk:8-jdk-alpine
LABEL maintainer="mwendapeter72@gmail.com"
VOLUME /tmp
ADD target/daraja_demo-0.0.1-SNAPSHOT.jar daraja.jar  
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom","-jar","daraja.jar"]
EXPOSE 8082