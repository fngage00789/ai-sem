# SEM Spring Boot API

This module provides a standalone Spring Boot 2.7 service that exposes a RESTful controller wired directly to a SQL database using Spring Data JPA. It is intended as a modern replacement for the legacy JBoss-hosted SEM web tier.

## Features

- Runs independently of JBoss / WildFly.
- Uses standard `application.properties` to configure the JDBC datasource.
- Includes a sample `UserAccount` entity, repository, and controller with CRUD-style endpoints.
- Ships with both PostgreSQL (production) and H2 (in-memory) drivers on the classpath.

## Running Locally

1. Adjust the datasource properties in `src/main/resources/application.properties` or export environment variables:

   ```bash
   export SPRING_DATASOURCE_URL="jdbc:postgresql://db-host:5432/semmm001"
   export SPRING_DATASOURCE_USERNAME="sem_app"
   export SPRING_DATASOURCE_PASSWORD="super-secret"
   ```

2. Build and start the service:

   ```bash
   mvn spring-boot:run
   ```

3. Access the API:

   - `GET http://localhost:8080/api/users` — list all user accounts.
   - `GET http://localhost:8080/api/users/{username}` — fetch a single user by username.
   - `POST http://localhost:8080/api/users` — create a new user (send JSON body with `username`, `displayName`, and `email`).

## Database Schema

The example expects a table similar to:

```sql
CREATE TABLE sem_user_account (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    display_name VARCHAR(120) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE
);
```

You can modify the `UserAccount` entity to match your existing schema.

## Switching Databases

To use a different database vendor, swap the JDBC driver dependency and update the connection URL and Hibernate dialect. For example, to use Oracle:

1. Add the Oracle JDBC driver to `pom.xml`.
2. Update `spring.datasource.url`, `spring.datasource.driver-class-name`, and `spring.jpa.database-platform`.

Spring Boot will manage the connection pool and transaction lifecycle without any JBoss configuration.
