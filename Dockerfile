FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean build -x test

FROM openjdk:17-jdk-slim

EXPOSE 1234

COPY --from=build /app/build/libs/mock-api-server-0.1.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]