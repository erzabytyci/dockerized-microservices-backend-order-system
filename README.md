Microservices-based Customer and Order Management System (Backend-focused)

This project is a backend-focused microservices-based application for managing customers and their orders. It demonstrates the implementation of Spring Boot, Feign Clients, Docker, API Gateway (Spring Cloud Gateway), and service discovery with Eureka.
 
Features:
-Customer Service: Manages customer information such as name, email, and address.
-Order Service: Handles order creation, associating products with customers.
-Product Service: Provides product details, including stock levels.
-API Gateway: Provides a single entry point for all services.
-Service Discovery: Eureka is used for registering services.
-Feign Clients: Simplifies communication between services.
-H2 Database: Used for in-memory data storage and quick prototyping.
-Docker Compose: Containerizes and orchestrates services.

Tech Stack:
-Java 21 and Spring Boot
-Spring Cloud (Feign, Eureka, Gateway)
-H2 Database
-Docker & Docker Compose

Running the Application:
1.Clone the repository.
2.Start the application using Docker Compose:  docker-compose up --build
3.Access the services through the API Gateway: 
   -Customer Service: http://localhost:8765/customer-service/customers
   -Order Service: http://localhost:8765/order-service/orders
   -Product Service: http://localhost:8765/product-service/products

How it Works:
-Customer Service: Allows the creation, update, and deletion of customers. It also fetches customer order history 
 through Feign Clients.
-Order Service: Handles order creation and assigns products to customers.
-Product Service: Provides product information and availability.
-H2 Database: Used for persistence and can be accessed via the H2 Console at http://localhost:8080/h2-console

Note: This project is primarily focused on backend development, showcasing how to design and implement microservices with communication between services, containerization, and data handling.

Feel free to check out the GitHub repository for more details!

---API Endpoints (Testing with Postman)---

You can test the endpoints using Postman or any HTTP client. Below are the key endpoints for testing:

1.Customer Endpoints:

-Get All Customers-
GET http://localhost:8765/customer-service/customers

-Get Customer by ID-
GET http://localhost:8765/customer-service/customers/{customerId}

-Create a New Customer-
POST http://localhost:8765/customer-service/customers
Body (JSON):
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "address": "123 Main St"
}

-Update Customer-
PUT http://localhost:8765/customer-service/customers/{customerId}

-Delete Customer-
DELETE http://localhost:8765/customer-service/customers/{customerId}

-Get Customer Orders-
GET http://localhost:8765/customer-service/customers/{customerId}/orders

2.Product Endpoints:

-Create a New Product-
POST http://localhost:8765/product-service/products
Body (JSON):
{
  "name": "Laptop",
  "description": "High-performance laptop",
  "price": 1200.99,
  "stock": 50
}

-Get All Products-
GET http://localhost:8765/product-service/products

-Get Product By Id-
GET http://localhost:8765/product-service/products/{productId}

-Delete Product By Id-
DELETE http://localhost:8765/product-service/products/{productId}

3.Order Endpoints:

-Create a New Order-
POST http://localhost:8765/order-service/orders
Body (JSON):
{
  "customerId": 1,
  "productIds": [1, 1],
  "totalPrice": 2000.98,
  "status": "Pending"
}

-Get All Orders-
GET http://localhost:8765/order-service/orders

-Get Order By Customer Id-
GET http://localhost:8765/order-service/orders/customer/{customerId}




