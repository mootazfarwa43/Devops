FROM openjdk:8

#EXPOSE 8091
WORKDIR /app

COPY /target/tpAchatProject-1.0.jar /app/tpAchatProject-1.0.jar

COPY /src/main/resources/application.properties /app

ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar", "-Dspring.config.location=", "/app/application.properties"]
