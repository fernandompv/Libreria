FROM postgres:13-alpine as postgres
COPY tables/*.sql docker-entrypoint-initdb.d/01tablas.sql

FROM openjdk:8-jdk-alpine as api
COPY var/jenkins_home/workspace/Compilacion/build/libs/Libreria-0.0.1-SNAPSHOT.jar. project/Libreria-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","project/Libreria-0.0.1-SNAPSHOT.jar"]