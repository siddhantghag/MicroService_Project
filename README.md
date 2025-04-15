# 🧩 Microservices-Based Banking System

This is a Microservices architecture-based Java application built using **Spring Boot**. The project demonstrates modular design, RESTful communication, centralized configuration, and inter-service communication using Eureka, Feign, and API Gateway.

---

## 🏗️ Architecture Overview

- **API Gateway** – Handles all incoming requests and routes to appropriate services.
- **Eureka Server** – Service registry for microservices.
- **Config Server** – Centralized external configuration.
- **Authentication Service** – Handles login, JWT authentication.
- **User Service** – Manages user details.
- **Account Service** – Handles account info and balances.
- **Transaction Service** – Manages deposits, withdrawals, and transfers.

---

## ⚙️ Tech Stack

- Java 8+
- Spring Boot
- Spring Cloud (Eureka, Config, Feign, Gateway)
- Hibernate / JPA
- MySQL 
- JWT (JSON Web Token)
- Maven
- Docker (optional)

