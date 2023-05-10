FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ./target/Ltnc-0.0.1-SNAPSHOT.jar spring_api.jar


ENTRYPOINT ["java", "-jar","/spring_api.jar"]