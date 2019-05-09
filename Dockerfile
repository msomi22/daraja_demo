FROM openjdk:8-jdk-alpine
VOLUME /temp
EXPOSE 8082
ARG JAR_FILE
ADD ${JAR_FILE} target/daraja_demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/.urandom","-jar","target/daraja_demo-0.0.1-SNAPSHOT.jar"]