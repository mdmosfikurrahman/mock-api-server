FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .

RUN ./gradlew clean build -x test

FROM openjdk:17-jdk-slim

EXPOSE 1234

COPY --from=build /build/libs/mock-api-server-0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]