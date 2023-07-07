Customer Management System
The Customer Management System is a project that provides APIs for managing customer information, addresses, and mobile numbers. It is built using the Spring Boot framework and follows a layered architecture.

Prerequisites:
Before running the application, make sure you have the following installed:

Java Development Kit (JDK) 1.8 or higher
Maven
MariaDB (or any other compatible relational database)
Getting Started
To run the Customer Management System, follow these steps:

Clone the repository to your local machine.

Open the project in your preferred IDE.

Configure the database connection by updating the application.properties file located in the src/main/resources directory. Modify the following properties according to your database setup:

spring.datasource.url=jdbc:mariadb://localhost:3307/customer_system?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=1234
Build the project using Maven. Open a terminal or command prompt, navigate to the project's root directory, and run the following command:

mvn clean install

Once the build is successful, you can run the application using the following command:

mvn spring-boot:run
The Customer Management System will start up and be accessible at http://localhost:8080/customer-management-system.

API Endpoints:
The Customer Management System provides the following API endpoints:

GET /v1/customer: Retrieves a list of all customers.
POST /v1/customer: Creates a new customer.
GET /v1/customer/{id}: Retrieves a specific customer by ID.
PUT /v1/customer/{id}: Updates a specific customer by ID.
GET /v1/customer/{id}/family: Retrieves the family members of a customer.
POST /v1/customer/{id}/family: Adds a new family member to a customer.
GET /v1/customer/{id}/address: Retrieves the addresses of a customer.
POST /v1/customer/{id}/address: Adds a new address to a customer.
GET /v1/customer/{id}/mobileNo: Retrieves the mobile numbers of a customer.
POST /v1/customer/{id}/mobileNo: Adds a new mobile number to a customer.
GET /v1/address: Retrieves a list of all addresses.
PUT /v1/address/{id}: Updates a specific address by ID.
GET /v1/mobileNo: Retrieves a list of all mobile numbers.
PUT /v1/mobileNo/{id}: Updates a specific mobile number by ID.
Note: Replace {id} with the corresponding customer, address, or mobile number ID.

Technologies Used:
Spring Boot
Spring Data JPA
Spring Validation
MariaDB (Relational Database)
Maven
MapStruct (Object Mapping Library)
Lombok (Java Library for Reducing Boilerplate Code)