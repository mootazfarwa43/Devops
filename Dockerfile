FROM openjdk:11
EXPOSE 8089
ADD home/Devops/agent/workspace/Devops/target/tpachat-1.0.jar tpachat-1.0.jar
ENTRYPOINT ["java", "-jar", "/tpachat-1.0.jar" ]
