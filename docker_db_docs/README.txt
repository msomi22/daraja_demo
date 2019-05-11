

e:

cd E:\docker\volume\postgres

docker-compose up -d


docker build --tag=“Build-Essential:Dockerfile” /path/to/file .

docker build --tag="daraja:latest"  .


docker run postgres --name postgres -e POSTGRES_PASSWORD=movies_user -d moviesdb -e POSTGRES_DB=moviesdb -e POSTGRES_USER=movies_user

echo %username%



md E:\docker\volume\postgres
 /e/docker/volume/postgres


docker container prune


working**
docker run -p 5433:5432 -it -v e:/docker/volume/postgres:/var/lib/postgresql/data postgres:latest -e POSTGRES_USER=root POSTGRES_PASSWORD=root POSTGRES_DB=demodb

psql -h localhost -U root -d demodb


https://forums.docker.com/t/data-directory-var-lib-postgresql-data-pgdata-has-wrong-ownership/17963/25

docker exec -it postgres_postgres_1 bash


docker run -e CONSUMER_KEY=BdxK4NoxTTzibPykKoCjQ1YFhgknwpMM -e CONSUMER_SECRET=OogO6G9bB7Lad933 -p 2020:8082 daraja:latest --link postgres_postgres_1

docker create -v /var/lib/postgresql/data --name spring_app_data postgres:9.4

docker run --name spring_app_container \
--link spring_app_pg:spring_app_pg \
-p 8080:8080 \
-d tdelev/spring_app


A Dockerfile uses the following commands for building the images:

ADD: Copy files from a source on the host to the container’s own filesystem at the set destination.
CMD: Execute a specific command within the container.
ENTRYPOINT: Set a default application to be used every time a container is created with the image.
ENV: Set environment variables.
EXPOSE: Expose a specific port to enable networking between the container and the outside world.
FROM: Define the base image used to start the build process.
MAINTAINER: Define the full name and email address of the image creator.
RUN: Central executing directive for Dockerfiles.
USER: Set the UID (the username) that will run the container.
VOLUME: Enable access from the container to a directory on the host machine.
WORKDIR: Set the path where the command, defined with CMD, is to be executed.
Not every command must be used. You will create a working Dockerfile example in the following section.