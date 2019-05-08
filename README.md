# Java REST Service and Client
## A simple REST, or rather RESTful application for consuming Safaricom's MPESA daraja interface.
* This application was build using the followng technologies
1. Spring boot
2. Java 8
3. PostgreSQL database
4. Jersey Client

* Set key and secret (username and password) in environment variables b4 proceeding.
* Clone, clean, build, isntall, execute the jar

# API OPERATIONS
## Get token services: 
* Set key and secret (username and password) in environment variables if not done so.
* invoke the services below.
**- [http://localhost:8080/auth/10] -**
* 10 is an ID, or client indetifier
* sample response
```{
    "access_token": "tSmDp3RKd6yUxLhT7EuGtGjFsHh2",
    "expires_in": "3599"
```
