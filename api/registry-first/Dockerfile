FROM openjdk:8-alpine
RUN mkdir /app
WORKDIR /app
COPY build/libs/registry-first-0.1.jar /app
ENTRYPOINT ["java", "-jar", "/app/registry-first-0.1.jar"]
EXPOSE 8761