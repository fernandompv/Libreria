FROM openjdk:8-jdk-alpine as dev
COPY build/libs/*.jar Libreria-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Libreria-0.0.1-SNAPSHOT.jar"]

FROM postgres:13-alpine as base
COPY tables/*.sql docker-entrypoint-initdb.d/01tablas.sql
EXPOSE 5432