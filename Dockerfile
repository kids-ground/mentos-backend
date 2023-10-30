FROM openjdk:17-jdk-slim

EXPOSE 80

COPY ./build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar","/app.jar"]