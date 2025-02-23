# Employee Payroll SpringBoot App

## Overview
The **Employee Payroll SpringBoot App** is a backend service designed to handle employee payroll operations. It provides RESTful APIs for managing employee records, including adding, updating, retrieving, and deleting employee details.

## Features
- **CRUD Operations**: Create, Read, Update, Delete employee records.
- **Spring Boot Framework**: Uses Spring Boot for rapid development and easy deployment.
- **RESTful APIs**: Exposes endpoints for frontend integration.
- **MySQL Database**: Open-source relational database management system (RDBMS) known for its speed, reliability, and ease of use.


## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- MySQL

## Getting Started
### Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven
- Git

### Installation & Setup
1. **Clone the Repository**
   ```sh
   git clone https://github.com/your-username/Employee-Payroll-App.git
   cd Employee-Payroll-App
   ```

2. **Build the Project**
   ```sh
   mvn clean install
   ```

3. **Run the Application**
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
| Method | Endpoint                 | Description                  |
|--------|--------------------------|------------------------------|
| GET    | `/employees/`             | Get all employees            |
| GET    | `/employees/get/{id}`        | Get employee by ID           |
| POST   | `/employees/create`             | Add a new employee           |
| PUT    | `/employees/update/{id}`        | Update employee details      |
| DELETE | `/employees/delete/{id}`        | Delete employee by ID        |



## Author

[Sonu Sharma](https://github.com/thelastcig)

---
