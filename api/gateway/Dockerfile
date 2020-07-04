FROM openjdk:8-alpine
LABEL maintainer=kutay-celebi
WORKDIR /app
COPY build/docker/libs libs/
COPY build/docker/resources resources/
COPY build/docker/classes classes/
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-Xmx1024m", "-cp", "/app/resources:/app/classes:/app/libs/*", "com.kuartz.gateway.KuartzGatewayApplication"]
EXPOSE 8765
