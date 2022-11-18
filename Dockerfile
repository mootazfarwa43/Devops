FROM openjdk:11
EXPOSE 8089
ADD target/tpachatproject-1.0-s7.jar tpachatproject-1.0-s7.jar
ENTRYPOINT ["java", "-jar", "/tpachatproject-1.0-s7.jar" ]
