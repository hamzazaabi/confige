FROM openjdk:8
FROM mysql
VOLUME /tmp
ADD  target/project-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]