FROM openjdk:8-jdk-alpine
WORKDIR /app
COPY build/libs/*.jar Libreria-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Libreria-0.0.1-SNAPSHOT.jar"]