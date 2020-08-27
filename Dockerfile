FROM openjdk:8-jdk-alpine
COPY . /app
ENTRYPOINT ["java","-jar","build/libs/Libreria-0.0.1-SNAPSHOT.jar"]