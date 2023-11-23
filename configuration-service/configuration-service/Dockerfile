FROM openjdk:17-alpine

WORKDIR /home/app

COPY ./target/configuration-service-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

CMD ["java", "-jar", "configuration-service-0.0.1-SNAPSHOT.jar"]