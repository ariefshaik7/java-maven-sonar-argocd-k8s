#  springboot-app: A Simple ToDo REST API with UI

This is a basic **Spring Boot ToDo application** that provides a RESTful API with an interactive frontend.  
It is a Java-based rewrite of a previously built Flask app.

---

##  Features

-  Add, list, delete tasks
-  Toggle task completion status
-  Clear all tasks
-  Interactive Bootstrap UI
-  REST API endpoints
-  In-memory task storage
-  JUnit + MockMvc test cases
-  Dockerized

---

## 🛠 Tech Stack

- Java 17
- Spring Boot 3
- Maven
- Lombok
- JUnit 5 (for testing)
- HTML + Bootstrap 5 (for frontend)
- Docker

---

##  How to Run (Locally)

### 1. Clone the repo

```bash
git clone <your-repo-url>
cd springboot-app
```

### 2. Run via IntelliJ or terminal

#### Option 1: IntelliJ
- Open the project.
- Right-click `SpringbootAppApplication.java` → Run

#### Option 2: CLI

```bash
./mvnw spring-boot:run
```

Then open: [http://localhost:8080](http://localhost:8080)

---

##  Run Tests

```bash
./mvnw test
```

---

##  Run with Docker

### 1. Build the Docker image

```bash
docker build -t springboot-app .
```

### 2. Run the container

```bash
docker run -p 8080:8080 springboot-app
```

Then go to: [http://localhost:8080](http://localhost:8080)

---

##  Project Structure

```
springboot-app/
├── src/
│   ├── main/
│   │   ├── java/org/example/springbootapp/
│   │   │   ├── SpringbootAppApplication.java
│   │   │   ├── controller/TodoController.java
│   │   │   └── model/Todo.java
│   │   └── resources/
│   │       ├── static/index.html
│   │       └── application.properties
│   └── test/
│       └── java/org/example/springbootapp/controller/TodoControllerTest.java
├── Dockerfile
├── pom.xml
└── README.md
```

---
