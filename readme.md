# Mock API Server

This is a simple mock API server built using Spring Boot and Gradle. It provides various endpoints for user, product, and order management.

## Getting Started

### Prerequisites
Ensure you have the following installed:
- Java 17 or later
- Gradle

### Clone the Repository
```sh
git clone <repository-url>
cd mockapi-server
```

### Build the Project
Run the following command to build the project:
```sh
gradle build
```

### Running the JAR File
Once the build is complete, navigate to the `build/libs` directory and run the JAR file:
```sh
cd build/libs
java -jar mockapi-server-0.1.jar
```

The server will start on port `1234`.

## API Endpoints

### User Endpoints
#### Get User Details
**Request:**
```http
GET /mockapi/user
```
**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "email": "johndoe@example.com"
}
```

#### Get User by ID
**Request:**
```http
GET /mockapi/user/{id}
```
**Response:**
```json
{
  "id": 2,
  "name": "User 2",
  "email": "user2@example.com"
}
```

#### Update User by ID
**Request:**
```http
PUT /mockapi/user/{id}
Content-Type: application/json
```
**Request Body:**
```json
{
  "name": "Updated Name",
  "email": "updated@example.com"
}
```
**Response:**
```json
{
  "id": 1,
  "name": "Updated Name",
  "email": "updated@example.com"
}
```

### Product Endpoints
#### Get Product Details
**Request:**
```http
GET /mockapi/product/details?name={productName}&price={price}
```
**Response:**
```json
{
  "name": "Laptop",
  "price": 799.99,
  "available": true
}
```

#### Get All Products
**Request:**
```http
GET /mockapi/products
```
**Response:**
```json
[
  {
    "id": 101,
    "name": "Laptop",
    "price": 799.99
  },
  {
    "id": 102,
    "name": "Smartphone",
    "price": 499.99
  }
]
```

### Order Endpoints
#### Place an Order
**Request:**
```http
POST /mockapi/order
Content-Type: application/json
```
**Request Body:**
```json
{
  "items": ["item1", "item2"]
}
```
**Response:**
```json
{
  "orderId": "123e4567-e89b-12d3-a456-426614174000",
  "status": "Order Placed Successfully",
  "items": ["item1", "item2"]
}
```

#### Delete an Order
**Request:**
```http
DELETE /mockapi/order/{orderId}
```
**Response:**
```json
{
  "orderId": "123e4567-e89b-12d3-a456-426614174000",
  "status": "Order Deleted Successfully"
}
```

#### Update Order Status
**Request:**
```http
PATCH /mockapi/order/{orderId}/status?status={newStatus}
```
**Response:**
```json
{
  "orderId": "123e4567-e89b-12d3-a456-426614174000",
  "newStatus": "Shipped"
}
```

### API Status
#### Check API Health
**Request:**
```http
GET /mockapi/status
```
**Response:**
```json
{
  "status": "API is running smoothly"
}
```

## Logging
Logs will be printed in the following format:
```
YYYY-MM-DD HH:MM:SS AM/PM | LEVEL | [File:Line] - Message
```

## License
This project is for mock API purposes only.

---
For further information, contact the project maintainer.
