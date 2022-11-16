FROM openjdk:11
EXPOSE 8089
ADD target/tpAchatProject.jar tpAchatProject.jar
ENTRYPOINT ["java", "-jar", "/achat-1.0-S7.jar" ]
