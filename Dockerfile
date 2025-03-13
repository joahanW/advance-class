FROM openjdk:17-jdk

LABEL author="Joahan"

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} advanve-class.jar

ENTRYPOINT ["jav", "-jar", "/advance-class.jar"]

EXPOSE 8080