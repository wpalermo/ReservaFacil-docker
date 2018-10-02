FROM maven:3.5.4-alpine
USER root

WORKDIR /app

COPY . /app

RUN mvn -f /app clean install

CMD mvn run



