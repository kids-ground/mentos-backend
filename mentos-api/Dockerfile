FROM openjdk:17-jdk-slim
ARG JAR_FILE=./build/libs/mentos-api-0.0.1-SNAPSHOT.jar
EXPOSE 80

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","/app.jar"]