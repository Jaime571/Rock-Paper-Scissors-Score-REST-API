![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Maven](https://img.shields.io/badge/Maven-Build-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

# Rock Paper Scissors Score REST API

A simple REST API built with Spring Boot that manages the score of a Rock Paper Scissors game. The API allows clients to retrieve, update, increment, and reset the game statistics, including wins, losses, and ties.

## Overview

This project was developed as a learning exercise to practice RESTful API development using Java and Spring Boot. It exposes multiple HTTP endpoints that demonstrate the use of different HTTP methods such as GET, POST, PUT, PATCH, and DELETE.

The application maintains a score object containing:

- Wins
- Losses
- Ties

## Technologies Used

- Java
- Spring Boot
- Maven
- Spring Tools for Eclipse (STS)
- RESTful API Architecture

## Architecture

The project follows a simple REST API architecture and currently consists of:

- **Model Layer**
  - `Score.java`: Represents the game score containing wins, losses, and ties.

- **Controller Layer**
  - `ScoreController.java`: Exposes REST endpoints for managing and updating the score.

- **Application Entry Point**
  - `SpringRestApiApplication.java`: Bootstraps and runs the Spring Boot application.

### Current Architecture Diagram

```text
Client
   │
   ▼
ScoreController
   │
   ▼
Score Model
```

> This project was intentionally kept simple for educational purposes. Future versions may include Service and Repository layers following Spring Boot best practices.

## Project Structure

```text
src/main/java/com/mayorga/rest
│
├── SpringRestApiApplication.java
├── Score.java
└── ScoreController.java
```

## Features

- Health check endpoint
- Retrieve current score
- Increment wins, losses, or ties
- Update individual score values
- Replace the entire score object
- Delete the current score
- Retrieve a specific score category

## API Endpoints

### Health Check

```http
GET /health
```

Response:

```text
Up!
```

---

### Get Complete Score

```http
GET /score
```

Response:

```json
{
  "wins": 30,
  "ties": 20,
  "losses": 10
}
```

---

### Get Specific Score Value

```http
GET /score/{status}
```

Examples:

```http
GET /score/wins
GET /score/ties
GET /score/losses
```

Response:

```json
30
```

---

### Increment Wins

```http
POST /score/wins
```

---

### Increment Losses

```http
POST /score/losses
```

---

### Increment Ties

```http
POST /score/ties
```

---

### Update Wins

```http
PATCH /score/wins?new-value=50
```

---

### Update Losses

```http
PATCH /score/losses?new-value=15
```

---

### Update Ties

```http
PATCH /score/ties?new-value=25
```

---

### Replace Entire Score

```http
PUT /score
```

Request Body:

```json
{
  "wins": 100,
  "ties": 50,
  "losses": 20
}
```

---

### Delete Score

```http
DELETE /score
```

> This endpoint is included primarily for testing the DELETE HTTP method.

## Getting Started

### Prerequisites

Before running the application, make sure you have installed:

- Java 17+ (or the version used by the project)
- Maven 3.8+
- Spring Tools Suite (optional)

### Clone the Repository

```bash
git clone https://github.com/your-username/your-repository.git
cd your-repository
```

### Build the Project

```bash
mvn clean install
```

### Run the Application

```bash
mvn spring-boot:run
```

The API will be available at:

```text
http://localhost:8080
```

## Testing the API

You can test the endpoints using:

- Postman
- Insomnia
- cURL
- Any frontend application that consumes REST APIs

Example:

```bash
curl http://localhost:8080/score
```

## Learning Objectives

This project was created to practice:

- Spring Boot fundamentals
- REST API development
- Maven dependency management
- HTTP methods (GET, POST, PUT, PATCH, DELETE)
- Request parameters
- Path variables
- JSON serialization and deserialization
- API design principles

## Future Improvements

- Add Service and Repository layers
- Persist data using a relational database
- Add exception handling
- Implement validation
- Add unit and integration tests
- Generate API documentation with Swagger/OpenAPI
- Implement actual Rock Paper Scissors gameplay logic
- Containerize the application using Docker


Software Developer focused on Full Stack Development, Java, Python, and REST API development.
