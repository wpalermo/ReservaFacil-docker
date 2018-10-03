FROM maven:3.5.4-alpine
USER root

ADD [ "./", "/app" ]

WORKDIR /app

EXPOSE 8081
CMD pwd && ls -ltra && mvn spring-boot:run
