FROM postgres:13-alpine as postgres
COPY tables/*.sql docker-entrypoint-initdb.d/01tablas.sql

FROM openjdk:8-jdk-alpine as api
RUN mkdir -p /app
COPY build/libs/*.jar Libreria-0.0.1-SNAPSHOT.jar
RUN cp Libreria-0.0.1-SNAPSHOT.jar app -p
ENTRYPOINT ["java","-jar","Libreria-0.0.1-SNAPSHOT.jar"]