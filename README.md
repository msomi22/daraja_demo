# Java REST Service and Client
### A simple REST, or rather RESTful application for consuming Safaricom's MPESA daraja interface.
* This application was build using the followng technologies
1. Spring boot 2
2. Java 8
3. PostgreSQL database
4. Jersey Client
5. Docker 

# pull postgresql from docker hub

#Important note
* get the host from db container [ docker exec 6b2ca68b196e env] - you might have run this container first. [docker-compose up -d ] - refer to docker_db_docs directory. 
*once done prune the container
* replace it in the line below  
* spring.datasource.url=jdbc:postgresql://6b2ca68b196e:5433/demodb
### API keys
* replace as show in the compose script 

## build the code
* mvn install - to get the updated jar
* build the image by running the command below
* docker build --tag="daraja:latest"  .



## deploy the images  by executing the below 
##Deploy in docker 
* cd to the root of the application (see the compose script)
* run the below 
* docker-compose up -d 

# API OPERATIONS
## Get token services: 
* Set key and secret (username and password) in environment variables if not done so.
* invoke the services below.
* [Authentication service URL] (http://localhost:2020/auth/10) 
* 10 is an ID, or client indetifier
* sample response
```{
    "access_token": "tSmDp3RKd6yUxLhT7EuGtGjFsHh2",
    "expires_in": "3599"
```



### othe important docker commands
```
1. docker-compose build
2. docker-compose up -d 
3. docker-compose down
4. docker logs --details container_id
5. docker logs --details container_id
6. docker container prune
7. docker build --tag="daraja:latest"  .
8. docker exec 6b2ca68b196e env
```
