FROM openjdk:17-alpine

WORKDIR /home/app

COPY ./target/service-discovery-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "service-discovery-0.0.1-SNAPSHOT.jar"]