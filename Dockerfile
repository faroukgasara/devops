FROM openjdk:8-jdk-alpine
COPY target/tpAchatProject-1.0-RELEASE.jar tpAchatProject-1.0-RELEASE.jar
ENTRYPOINT ["java","-jar","/tpAchatProject-1.0-RELEASE.jar"]