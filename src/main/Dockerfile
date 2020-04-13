FROM java
MAINTAINER Jhonatan S. Souza
COPY ./code/eletromilgames-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
VOLUME ["~/home/Documents/docker_volume", "/var/home"]
ENTRYPOINT ["java","-Dspring.data.mongodb.host=api-database","-jar","/app/eletromilgames-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080