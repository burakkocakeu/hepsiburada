FROM adoptopenjdk/openjdk16:ubi

VOLUME /springboot-microservice

ARG JAR_FILE=target/springboot-microservice.jar

ADD ${JAR_FILE} springboot-microservice.jar

EXPOSE 8090

ENTRYPOINT ["java","-jar","springboot-microservice.jar"]

# Dockerfile’nin bulunduğu klasörde terminali açıp şunu yazacağız;
# docker build -t logger .
# Projemiz dockerize oldu şimdi terminalde “docker images” yazınca şunu görebilmeniz gerekmekte

# Another way of creating a docker image is the command below:
# docker build -f Dockerfile -t springboot-microservice.jar .