FROM openjdk:8-jdk-alpine
RUN apt-get install curl
RUN curl -u admin:adminadmin -o achat.jar "http://192.168.0.29:8081	tn/esprit/rh/achat/1.0/achat-1.0.jar" -L
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089
