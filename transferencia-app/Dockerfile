FROM maven:3.5.4-alpine
USER root
WORKDIR /app
COPY ./target/transferencia-app-0.0.1-SNAPSHOT.jar /app
CMD ["java","-jar","/app/transferencia-app-0.0.1-SNAPSHOT.jar"]