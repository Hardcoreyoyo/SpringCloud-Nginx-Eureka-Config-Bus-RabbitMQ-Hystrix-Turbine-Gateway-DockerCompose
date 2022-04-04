FROM openjdk:11.0-jre-slim
WORKDIR /app
RUN apt-get -q update && apt-get -qy install wget && apt-get -qy install netcat
COPY wait-for.sh /app/wait-for.sh
COPY ServiceTurbine-ST1.0.0.jar /app/ServiceTurbine-ST1.0.0.jar
RUN chmod +x /app/wait-for.sh
