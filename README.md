# Daraja API Demo

A **Spring Boot demo application** created in **2019** to explore integration with Safaricom's **M-Pesa Daraja API**, with a focus on OAuth access-token generation, REST client integration, persistence, containerization, and basic CI/CD.

This repository is intentionally preserved as a small integration demo rather than a production payment service.

> **Historical demo:** the project uses Spring Boot 2.1, Java 8, Jersey 1.x, Springfox Swagger 2, and other dependencies from its original period. It should be modernized before being used as the basis of a current production integration.

## What the project demonstrates

The application demonstrates several pieces of a typical external API integration:

- Calling the Safaricom Daraja sandbox OAuth endpoint
- Reading consumer credentials from environment variables
- Generating HTTP Basic authentication credentials
- Requesting an OAuth access token
- Mapping the API response into Java objects
- Persisting returned token information with Spring Data JPA
- Exposing REST endpoints through Spring MVC
- Using PostgreSQL as the persistence store
- Packaging the application with Maven
- Running the application in Docker
- Running PostgreSQL with Docker Compose
- Exposing Spring Boot Actuator endpoints
- Providing Swagger/OpenAPI-style API documentation through Springfox
- Experimenting with a Jenkins-based build/deployment pipeline

## Technology stack

| Area | Technology |
| --- | --- |
| Language | Java 8 |
| Framework | Spring Boot 2.1.4 |
| Web | Spring MVC / REST |
| Persistence | Spring Data JPA |
| Database | PostgreSQL |
| HTTP client | Jersey Client / Apache HttpClient |
| JSON | Gson |
| API documentation | Springfox Swagger 2 |
| Monitoring | Spring Boot Actuator |
| Build | Maven / Maven Wrapper |
| Containerization | Docker |
| Local orchestration | Docker Compose |
| CI/CD experiment | Jenkins |
| License | GNU GPL v3 |

## Architecture

```text
Client
  |
  v
Spring REST Controller
  |
  v
Daraja Integration Client
  |
  +------------------------+
  |                        |
  v                        v
Safaricom Daraja      Spring Data JPA
Sandbox API                 |
                            v
                       PostgreSQL
```

The main integration path is implemented by `RestClient`, which reads the Daraja consumer key and consumer secret from environment variables, creates a Basic Authorization header, calls the Daraja sandbox OAuth endpoint, and maps the response into the application's token model.

## Main endpoints

### Generate a Daraja access token

```http
GET /auth/{id}
```

Example:

```text
GET http://localhost:2020/auth/10
```

The current implementation uses the path parameter as a demo/client identifier and requests an OAuth token from the Safaricom sandbox.

A successful Daraja response is mapped into an object containing values similar to:

```json
{
  "access_token": "<token>",
  "expires_in": "3599"
}
```

### View persisted token records

```http
GET /tokens
```

This returns token records persisted through Spring Data JPA.

> Persisting raw access tokens is useful for demonstrating persistence, but it is **not a pattern I would recommend for a modern production payment integration** without appropriate encryption, retention controls, access restrictions, and a clear operational need.

## Monitoring

Spring Boot Actuator is configured under:

```text
/monitor
```

The project enables actuator endpoints for development/demo purposes.

For a modern production deployment, actuator exposure should be restricted and secured.

## Project structure

```text
daraja-demo/
├── src/
│   ├── main/
│   │   ├── java/com/peter/demo/
│   │   │   ├── bean/            # Daraja response models
│   │   │   ├── controller/      # REST controllers and services
│   │   │   ├── entity/          # JPA entities
│   │   │   ├── persistence/     # Spring Data repositories
│   │   │   └── swagger/         # Swagger configuration
│   │   └── resources/
│   │       └── application.properties
│   └── test/
├── Dockerfile
├── docker-compose.yml
├── Jenkinsfile
├── pom.xml
├── mvnw
├── mvnw.cmd
└── LICENSE
```

## Configuration

The Daraja integration expects the following environment variables:

```text
CONSUMER_KEY
CONSUMER_SECRET
```

Use credentials issued for your own Safaricom Daraja sandbox application.

Do **not** commit real production credentials to source control.

The application also requires PostgreSQL configuration. The original project contains development defaults in `application.properties` and Docker Compose.

## Running locally

### Prerequisites

You will need:

- Java 8 for the original project
- Docker / Docker Compose if using the containerized setup
- PostgreSQL if running the database outside Docker

### Build

Using the Maven Wrapper:

```bash
./mvnw clean package
```

or with a local Maven installation:

```bash
mvn clean package
```

The original Maven configuration skips tests during the Surefire phase.

### Build the Docker image

```bash
docker build -t daraja:latest .
```

### Start the application and PostgreSQL

```bash
docker-compose up -d
```

The Compose configuration maps the application to:

```text
http://localhost:2020
```

### Stop the environment

```bash
docker-compose down
```

## Useful Docker commands

```bash
docker-compose build
docker-compose up -d
docker-compose down
docker ps
docker logs <container-id>
docker container prune
```

## CI/CD experiment

The repository includes a `Jenkinsfile` from the original project.

It represents an early experiment with automating:

1. repository checkout
2. Maven/container build
3. container execution
4. Spring Boot application deployment

The pipeline should be considered historical and would need correction and modernization before being used today.

## Security note

This repository is a **demo project**, and several choices reflect that context.

Before adapting it to a real payment service, review at least:

- secrets management
- Daraja credential rotation
- access-token storage
- database credentials
- TLS and outbound HTTP configuration
- endpoint authentication and authorization
- actuator exposure
- logging of sensitive data
- dependency vulnerabilities
- request/response validation
- retries and timeouts
- idempotency for payment operations
- audit logging
- webhook/callback verification

The repository's historical Docker configuration also contains example credentials. They should be treated as exposed and must not be reused for real systems.

## Modernization ideas

A current implementation could use:

- Java 21+ / current LTS Java
- Spring Boot 3.x+
- Spring Security
- Spring Data JPA
- modern PostgreSQL
- WebClient or the Java HTTP client
- OpenAPI 3
- Docker multi-stage builds
- Testcontainers
- GitHub Actions
- Flyway or Liquibase
- externalized secret management
- structured logging
- OpenTelemetry
- resilient retry / timeout / circuit-breaker policies
- proper payment idempotency
- callback signature or authenticity validation

The core integration idea remains useful, but the implementation should be brought up to current platform and security standards.

## Repository status

**Status:** Historical integration demo

This project is preserved for:

- demonstrating an early M-Pesa Daraja integration
- portfolio context
- showing Spring Boot REST integration patterns
- Docker/PostgreSQL experimentation
- comparing older Spring Boot practices with modern implementations

It is **not a production-ready payment service**.

## License

This repository is licensed under the **GNU General Public License v3.0**.

## Author

**Peter Mwenda — [msomi22](https://github.com/msomi22)**

Software Engineer focused on Java, backend systems, APIs, integrations, messaging, and distributed systems.

---

_Originally created in 2019 as a demo for integrating a Spring Boot application with Safaricom's M-Pesa Daraja sandbox API._
