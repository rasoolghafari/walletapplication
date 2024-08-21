We are going to have a micro-service to keep all data of user wallet. We need to have two APIs to expose them to other micro-services.

It's important to say that this project was implemented just in 2 hours to showcase my coding style.
So, of course, this project isn't a good choice for the production environment and doesn't meet requirements, and may cause concurrency issues.

**Technologies Used**

•	Java 17
•	Spring Framework
•	Spring Security
•	Spring Boot
•	Spring Data JPA
•	H2 Database
•	MapStruct
•	Swagger UI
•	JUnit 5

**Getting Started**

**Prerequisites**

•	Java 17 or higher
•	Maven

**Installation**

1.	Clone the repository: git clone [https://github.com/rasoolghafari/walletapplication.git](https://github.com/rasoolghafari/walletapplication.git)
2.	Navigate to the project directory: ```cd walletapplication```
3.	Build the project using Maven: ```mvn clean install```

**Usage**

1. Run the following commands:
   ```docker-compose build```
   ```docker-compose up -d```
3. Access the Swagger UI at [http://localhost:8081/swagger-ui/index.html](http://localhost:8081/swagger-ui/index.html) to view and test the APIs.
4. Use the default username/password for APIs: ```user/user```.
5. To call APIs and check the functionality first create a user, then create a wallet. Then, call other APIs that you want.

**Unit Tests**

Unit tests have been written for the controllers using JUnit 5 and Mockito. These tests ensure the functionality of the API endpoints and verify the expected behavior.
To run the unit tests, navigate to the project directory and run the following command:

```mvn test```

**Database**

The application uses an MySql database for storing information. The database connection properties can be configured in the application.properties file.

**MapStruct**

MapStruct is used to convert DTOs (Data Transfer Objects) to entities and vice versa. It simplifies the mapping process and reduces boilerplate code.

**Exception Handling**

Exception handling is implemented using Spring's @ControllerAdvice and @ExceptionHandler annotations. This allows for centralized exception handling and provides custom error responses for different types of exceptions.

**License**

This project is licensed under the MIT License - see the LICENSE file for details.
