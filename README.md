# SmartRent API

A RESTful API for property rental management, built with Java and Spring Boot.

## Technologies

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Docker
- Lombok
- Maven

## Getting Started

### Prerequisites

- Java 17+
- Docker and Docker Compose

### Running the project

1. Clone the repository
```bash
git clone https://github.com/gilberttobarros/smartrent-api.git
cd smartrent-api
```

2. Start the database
```bash
docker compose up -d
```

3. Run the application
```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Endpoints

### Users

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /users | Create a new user |
| GET | /users | List all users |
| GET | /users/{id} | Get user by ID |

### Properties

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | /properties | Create a new property |
| GET | /properties | List all properties |
| GET | /properties/{id} | Get property by ID |
| GET | /properties/search?city= | Filter properties by city |
| PUT | /properties/{id} | Update a property |
| DELETE | /properties/{id} | Delete a property |

## Request Examples

### Create User
```json
{
    "name": "John Doe",
    "email": "john@email.com",
    "password": "123456"
}
```

### Create Property
```json
{
    "title": "2 bedroom apartment downtown",
    "description": "Well located apartment, close to the subway",
    "address": "Flower Street, 123",
    "city": "São Paulo",
    "pricePerMonth": 2500.00,
    "totalArea": 65.5,
    "rooms": 3,
    "available": true,
    "owner": {
        "id": 1
    }
}
```