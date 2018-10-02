FROM maven:3.5.4-alpine
USER root

ADD [ "./eureka-service", "/app" ]

WORKDIR /app

EXPOSE 8761
CMD pwd && ls -ltra && mvn spring-boot:run



