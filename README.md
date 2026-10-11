# ⚙️ AutoSphere - Backend: Enterprise Vehicle Rental & Fleet Intelligence API

> **Spring Boot 3 RESTful Microservice powering the AutoSphere Vehicle Rental & Fleet Management Ecosystem**

AutoSphere Backend is a secure, high-performance Java microservice platform built with **Spring Boot 3.2.5**, **Spring Data JPA**, **Spring Security with JWT**, and **MySQL**. It manages fleet inventories, automated reservation lifecycles, user identity & access control, FASTag route calculations, and vehicle health diagnostics.

---

## 🌟 Key Architecture & Capabilities

- **🔐 Robust Authentication & Security**:
  - Stateless JWT (JSON Web Token) authentication with HMAC-SHA256 signature verification.
  - Role-Based Access Control (RBAC) supporting `ROLE_CUSTOMER`, `ROLE_MANAGER`, and `ROLE_ADMIN`.
  - Passwords salted and hashed with BCrypt.
- **🚙 Fleet Lifecycle & Availability Tracking**:
  - Full CRUD operations for passenger cars, SUVs, and premium motorcycles.
  - State tracking: `AVAILABLE`, `RESERVED`, `RENTED`, `MAINTENANCE`.
  - Dynamic pricing engine factoring in daily base rates, security deposits, and weekend multipliers.
- **📅 End-to-End Rental Operations**:
  - Automated booking validation (driver's license verification, overlapping rental conflict detection).
  - Digital rental agreements, instant invoice calculation, and return processing.
- **🛣️ FASTag & Toll Integration**:
  - Automated toll booth fee calculation and highway route expense estimation for intercity journeys.
- **🔧 Fleet Health & Diagnostics**:
  - Odometer tracking, service schedule logging, and proactive maintenance alerts.

---

## 🛠️ Technology Stack

| Component | Technology | Version |
|---|---|---|
| **Core Framework** | Spring Boot | 3.2.5 |
| **Language Runtime**| Java (JDK) | 17+ |
| **Persistence / ORM**| Spring Data JPA / Hibernate | 6.x |
| **Database** | MySQL | 8.0+ |
| **Security** | Spring Security 6 & JJWT | 0.11.5 |
| **Connection Pool** | HikariCP | Default |
| **Build Tool** | Apache Maven | 3.9+ |

---

## 📋 API Endpoints Overview

### 1. Authentication (`/api/auth`)
- `POST /api/auth/register` — Register a new customer account
- `POST /api/auth/login` — Authenticate and receive signed JWT token
- `GET /api/auth/me` — Retrieve current user session and permissions

### 2. Fleet & Vehicles (`/api/vehicles`)
- `GET /api/vehicles` — List all vehicles (supports filtering by type, transmission, price)
- `GET /api/vehicles/{id}` — Fetch detailed vehicle profile and 3D specifications
- `POST /api/vehicles` — Register a new fleet vehicle *(Admin/Manager)*
- `PUT /api/vehicles/{id}` — Update vehicle status, pricing, or details *(Admin/Manager)*
- `DELETE /api/vehicles/{id}` — Decommission vehicle from active fleet *(Admin)*

### 3. Rentals & Bookings (`/api/rentals`)
- `POST /api/rentals/book` — Reserve a vehicle for specified dates
- `GET /api/rentals/my-bookings` — Customer reservation history
- `PUT /api/rentals/{id}/cancel` — Cancel an upcoming booking
- `PUT /api/rentals/{id}/complete` — Complete rental and process vehicle return

### 4. Telematics & Maintenance (`/api/diagnostics`)
- `GET /api/diagnostics/{vehicleId}` — Vehicle health report and odometer log
- `POST /api/diagnostics/{vehicleId}/service` — Log maintenance service record

---

## 🚀 Getting Started

### Prerequisites
- **JDK 17** or higher installed and configured in `JAVA_HOME`.
- **MySQL Server 8.0+** running locally on port `3306`.
- **Maven 3.8+** (or use included `./mvnw`).

### Configuration

1. Create the MySQL Database:
   ```sql
   CREATE DATABASE vehiclerental;
   ```

2. Configure database credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/vehiclerental?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=root
   server.port=8082
   ```

3. Build and run:
   ```bash
   mvn clean package -DskipTests
   mvn spring-boot:run
   ```

The REST API will start on `http://localhost:8082`.

---

## 👨‍💻 Author

- **GitHub**: [@karan77711](https://github.com/karan77711)
- **Institution**: Anurag Group of Institutions
