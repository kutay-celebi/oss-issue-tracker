FROM openjdk:8-alpine
LABEL maintainer=ekuneri
WORKDIR /app
COPY build/libs libs/
COPY build/resources resources/
COPY build/classes classes/
RUN gradle build
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-Xmx1024m", "-cp", "/app/resources:/app/classes:/app/libs/*", "com.kuartz.api.auth.AuthorizationServer"]
EXPOSE 9090 8080
