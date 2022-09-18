FROM openjdk:8-jdk-alpine
MAINTAINER badrkacimi
COPY target/account-cqrs-es-2.0.0-SNAPSHOT.jar backend-test-server.jar
ENTRYPOINT ["java","-jar","/backend-test-server.jar"]