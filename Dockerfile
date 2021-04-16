#JAR
FROM openjdk:8
WORKDIR /
ADD target/bootcamp-avengers-activity.jar bootcamp-avengers-activity.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "bootcamp-avengers-activity.jar"]