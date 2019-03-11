FROM openjdk:8-jdk-alpine

VOLUME /tmp

ARG JAR_FILE=target/course-service-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} course-service.jar

CMD ["java","-jar","/course-service.jar"]