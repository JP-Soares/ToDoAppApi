# 🚀 ToDoApp API

A robust and scalable **RESTful API** for task management, designed to handle tasks, subtasks, and their lifecycle statuses efficiently.

This project follows clean architecture principles and industry best practices, providing a solid foundation for building task-oriented applications.

---

## ✨ Features

- **Task Status Management**  
  Create, update, and manage task statuses dynamically.

- **Task Management**  
  Perform full CRUD operations on tasks.

- **Subtask Management**  
  Handle subtasks associated with parent tasks.

- **Entity Relationships**  
  Structured relationships between tasks, subtasks, and statuses.

- **RESTful API Design**  
  Consistent and well-defined endpoints following REST standards.

- **Containerized Environment**  
  Simplified setup and execution using Docker.

---

## 🧱 Tech Stack

- **Java 17+**
- **Spring Boot**
  - Spring Web
  - Spring Data JPA
- **PostgreSQL**
- **Docker**
- **Maven**

---

## 🏗️ Architecture

The application is structured using a layered architecture:

- **Controller Layer**  
  Responsible for handling HTTP requests and responses.

- **Service Layer**  
  Contains business logic and application rules.

- **Repository Layer**  
  Manages data persistence using JPA.

- **Database Layer**  
  PostgreSQL for reliable data storage.

---

## ⚙️ Getting Started

### Prerequisites

- Java 17 or higher  
- Maven  
- Docker (optional)  
- PostgreSQL (if running locally)

---

## 🐳 Running with Docker

```bash
git clone https://github.com/your-username/todoapp-api.git
cd todoapp-api
docker-compose up --build
