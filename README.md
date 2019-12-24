# comlic-monger-server
Server for Comic Monger

## Working with mysql
docker exec -it mysql8 mysql -p

==>
CREATE USER 'sa'@'%' IDENTIFIED BY 'root';
GRANT ALL PRIVILEGES ON *.* TO 'sa'@'%';
FLUSH PRIVILEGES;


# Docker

 * https://dzone.com/articles/build-package-and-run-spring-boot-apps-with-docker
 * https://spring.io/guides/gs/spring-boot-docker/

    docker build -f Dockerfile-prod -t comic-monger-server:prod .
    docker run -it -p 8080:8080 --rm comic-monger-server:prod


# Todos
[] add in memory db and external db profile
