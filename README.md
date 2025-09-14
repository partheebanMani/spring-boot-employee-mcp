# 🌟 Spring Boot Employee MCP

[![GitHub Repo](https://img.shields.io/badge/GitHub-Repository-blue?logo=github)](https://github.com/partheeban/springboot-employee-mcp)

---

## 📖 Overview
A Spring Boot application for managing employee and student records using MCP tools. Supports CRUD operations and uses a relational database for persistence.

> **Note:** This repo is migrated from another project which implemented REST API and gRPC endpoints. All API and gRPC logic has been removed in favor of MCP tool integration. The original project can be found at: [https://github.com/partheebanMani/springboot-restapi-grpc](https://github.com/partheebanMani/springboot-restapi-grpc)

---

## 🛠️ MCP Tools

### 👔 Employee Tools
- ➕ Add employee
- 📋 Get all employees
- 🔍 Get employee by ID

### 🎓 Student Tools
- 📋 Get all students
- 🔍 Get student by ID

> **Note:** All operations are performed using MCP tools. There are no API or gRPC endpoints in this project.

---

## ✨ Features
- Add, update, delete, and retrieve employee details via MCP tools
- Retrieve student details via MCP tools
- Department-based queries
- Data initialization via SQL scripts

---

## ⚙️ Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- H2 Database (default, can be configured)
- Maven

---

## 🚀 Getting Started
1. **Clone the repository:**
   ```bash
   git clone <repo-url>
   ```
2. **Navigate to the project directory:**
   ```bash
   cd springboot-employee-mcp/spring-boot-employee-mcp
   ```
3. **Build the project:**
   ```bash
   mvn clean install
   ```
4. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```

---

## 🗄️ Database
- Uses H2 in-memory database by default.
- Data is initialized from `src/main/resources/data.sql`.
- Schema is defined in `src/main/resources/schema.sql`.

---

## ⚡ MCP Tool Connection

Add the following configuration to your `mcp.json` file to connect MCP to your Spring Boot application:

```json
"employee-mcp": {
  "type": "stdio",
  "command": "java",
  "args": [
    "-jar",
    "<project-root>/target/springboot-employee-mcp-0.0.1-SNAPSHOT.jar"
  ]
}
```

> **Tip:** Make sure the JAR path matches your build location.

---

## 📄 License
This project is licensed under the MIT License.
