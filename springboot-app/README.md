
#  Simple Spring Boot Web App

This is a minimal Spring Boot web application demonstrating how to serve a styled HTML page using Thymeleaf, Bootstrap, and a simple Java controller.

---

##  Features

- Spring Boot 3 Web App
- Thymeleaf templating engine
- Bootstrap 5 for UI styling
- Docker support

---

##  Requirements

Before you begin, ensure you have the following installed:

- [Java 17+](https://adoptopenjdk.net/)
- [Maven 3.6+](https://maven.apache.org/)
- [Docker](https://www.docker.com/) 

---

##  Getting Started

###  Clone the Repository

```bash
git clone https://github.com/your-username/simple-springboot-webapp.git
cd simple-springboot-webapp
```

###  Run the App Locally

You can run the application using Maven:

```bash
./mvnw spring-boot:run
```

Or build and run the JAR:

```bash
./mvnw clean package
java -jar target/*.jar
```

Then open your browser and navigate to [http://localhost:8080](http://localhost:8080)

---

##  Docker Usage

### Build Docker Image

```bash
docker build -t dockerusername/ci-cd-proj:tag .
```

### Run the Container

```bash
docker run -p 8080:8080 dockerusername/ci-cd-proj:tag
```


