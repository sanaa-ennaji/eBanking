# eBanking API - Basic Authentication with Spring Security

## Project Overview
This project is a secure eBanking REST API built with Spring Boot and Spring Security. It uses **Basic Authentication** for user authentication, with users and their roles stored in a database. The application secures sensitive endpoints while exposing public endpoints for general information.

---

## Features
### Public Endpoints
- **GET** `/api/notices`: Fetch general announcements (e.g., system updates).
- **GET** `/api/contact`: Retrieve customer support contact information.

### Secured Endpoints (Authentication Required)
- **GET** `/api/myLoans`: Retrieve loan details for the authenticated user.
- **GET** `/api/myCards`: View the authenticated user’s bank cards.
- **GET** `/api/myAccount`: Get account details for the authenticated user.
- **GET** `/api/myBalance`: Check the authenticated user’s overall account balance.

### User Management
#### Endpoints for Admins (`ROLE_ADMIN`)
- **POST** `/api/users/register`: Register a new user.
- **GET** `/api/users`: List all registered users.
- **GET** `/api/users/{username}`: Retrieve a specific user by username.
- **DELETE** `/api/users/{username}`: Delete a user by username.
- **PUT** `/api/users/{username}/updateRole`: Update the role of an existing user.

#### Endpoints for Users (`ROLE_USER`)
- **PUT** `/api/users/{username}`: Update the password for the authenticated user. The user must provide their old password and a new one.

---

## Technologies Used
- **Spring Boot**
- **Spring Security**
- **Java Persistence API (JPA)** with Hibernate
- **H2 Database** (for development)
- **BCryptPasswordEncoder** for secure password hashing
- **Maven** for dependency management

---

## Security Configuration
- Basic Authentication implemented via `CustomAuthenticationProvider` and a custom `UserDetailsService`.
- Stateless security: Session creation (`JSESSIONID`) is disabled.
- Passwords are securely hashed using `BCryptPasswordEncoder`.
- Roles are stored in the database with the prefix `ROLE_` (e.g., `ROLE_USER`, `ROLE_ADMIN`).

---

## Exception Handling
- Custom exceptions include:
    - `UsernameAlreadyExistsException`: Thrown when trying to register a user with an existing username.
- Centralized exception handling using `@RestControllerAdvice`.
- Custom error responses with a dedicated Error DTO.
- Access Denied (403) errors are handled with a custom `AccessDeniedHandler`.

---

## Setup and Configuration
### Prerequisites
- **JDK 17+**
- **Maven 3.6+**
- **Postman** or any other API testing tool


