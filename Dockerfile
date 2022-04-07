FROM openjdk:19-jdk-alpine3.15

ARG JAR_FILE=*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java","-jar","/app.jar" ]
