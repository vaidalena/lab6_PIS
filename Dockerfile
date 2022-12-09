#FROM maven:3.6.0-jdk-10-slim
#ADD pom.xml /tmp/build/
#RUN cd /tmp/build && mvn -q dependency:resolve
#ADD src /tmp/build/src
#RUN cd /tmp/build && mvn -q -DskipTests=true package \ && mv target/*.jar /app.jar \ && cd / && rm -rf /tmp/build
#VOLUME /tmp
#EXPOSE 8080
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app"]


FROM openjdk:11
FROM maven:3.6.0-jdk-10
ADD pom.xml /tmp/build/
RUN cd /tmp/build && mvn -q dependency:resolve
ADD src /tmp/build/src
RUN cd /tmp/build && cd / && rm -rf /tmp/build
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app"]
