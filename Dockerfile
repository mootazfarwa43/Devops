FROM openjdk:11
EXPOSE 8089
ADD target/tpachat-1.0.jar tpachat.jar
ENTRYPOINT ["java", "-jar", "/tpachat.jar" ]
