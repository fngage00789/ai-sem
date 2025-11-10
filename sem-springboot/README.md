# SEM Spring Boot API

This module provides a standalone Spring Boot 2.7 service that exposes a RESTful controller wired directly to PostgreSQL using Spring Data JPA. It lifts the SEMMM001 workflow out of the legacy JBoss/RichFaces stack and into a modern Spring Boot application with clear controller → service → DAO layering.

## Features

- Runs independently of JBoss / WildFly.
- Uses standard `application.properties` to configure the JDBC datasource.
- Implements a `Semmm001Controller` backed by a `VendorMasterService` and DAO so the SEMMM001 vendor screens can talk directly to PostgreSQL.
- Bundles the PostgreSQL driver for production use and an embedded PostgreSQL test harness (no H2 fallback).

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

   - `GET http://localhost:8080/api/semmm001/vendors` — search vendors by optional `code`, `name`, or `status` query parameters (mirrors SEMMMM001Action search behaviour).
   - `GET http://localhost:8080/api/semmm001/vendors/{vendorCode}` — fetch a single vendor.
   - `POST http://localhost:8080/api/semmm001/vendors` — create a vendor (send JSON body with code, name, and optional profile details).
   - `PUT http://localhost:8080/api/semmm001/vendors/{vendorCode}` — update vendor attributes.

## Testing with PostgreSQL

Automated tests boot an embedded PostgreSQL instance using Zonky's test harness so that controller flows exercise the same dialect you use in production. Running `mvn test` will download the embedded binary, start it on a random local port, and tear it down automatically when the suite finishes.

## Database Schema

The example expects a table similar to:

```sql
CREATE TABLE sem_vendor_master (
    id BIGSERIAL PRIMARY KEY,
    vendor_code VARCHAR(20) NOT NULL UNIQUE,
    vendor_name VARCHAR(200) NOT NULL,
    vendor_type VARCHAR(20),
    tax_id VARCHAR(20),
    status VARCHAR(10),
    contact_name VARCHAR(120),
    email VARCHAR(120),
    telephone VARCHAR(30),
    mobile VARCHAR(30),
    address VARCHAR(400),
    created_at TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT NOW(),
    updated_at TIMESTAMP WITH TIME ZONE
);
```

Adapt the entity to match the exact columns you already manage in SEMMM001 if they differ.

## Extending the Service Layer

`Semmm001Controller` intentionally mirrors the structure of the legacy `SEMMMM001Action` bean: the controller delegates to a `VendorMasterService`, which coordinates validation, timestamps, and persistence, while the service in turn relies on a DAO that owns all JPA queries. Additional SEMMM001 flows (book bank, payee, contract history, etc.) can be ported by following the same layering—add a DAO that captures the database access, wrap it with a Spring service, and surface the REST endpoints you need.

Spring Boot will manage the connection pool and transaction lifecycle without any JBoss configuration.
