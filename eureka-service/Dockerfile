FROM maven:3.5.4-alpine
USER root
COPY ./ /app
WORKDIR /app
RUN mvn clean spring-boot:build-info