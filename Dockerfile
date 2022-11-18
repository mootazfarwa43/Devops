FROM openjdk:11
EXPOSE 8089
ADD ./home/Devops/target/tpachat-1.0.jar tpachat.jar
ENTRYPOINT ["java", "-jar", "/tpachat-1.0.jar" ]
