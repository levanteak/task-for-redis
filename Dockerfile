FROM openjdk:17-jdk-slim
WORKDIR /app

COPY target/*.war app.war

ENTRYPOINT ["java","-jar","app.war"]
