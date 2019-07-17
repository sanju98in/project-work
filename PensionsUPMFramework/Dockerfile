FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
COPY target/UPMWeb-00.jar app.jar
ENTRYPOINT java -Djava.security.egd=file:/dev/./urandom -jar /app.jar