# CDACProject_
# Blogging API

This is a Spring Boot-based REST API for a blogging application. It provides endpoints to manage posts, categories, comments, user authentication, and more.

## Features

- **Category API:**
  - Create, update, delete, and fetch categories.
  
- **Post API:**
  - Create, update, delete, and fetch posts.
  - Get all posts in a category.
  - Pagination and sorting support.
  - Image uploads for posts.

- **Comment API:**
  - Add, update, delete, and fetch comments.

- **Authentication:**
  - Basic Authentication.
  - JWT-based Authentication.

- **Additional Features:**
  - Validation annotations for entities.
  - Used Model Mapper for entity to DTO conversions.
  - Centralized constants for hardcoded values.
  - Searching and sorting support.

---

## Prerequisites

- Java 17 or above
- Maven 3.8+
- Spring Boot 3.1+
- Lombok (Ensure Lombok plugin is enabled in your IDE)

---

## Setup Instructions

1. Clone the repository:
   ```bash
   git clone <repository-URL>

2. Navigate to the project directory:
    cd Blogging-API
   
3. Build the project:
   mvn clean install
   
4. Run the application:
   mvn spring-boot:run

5. Access APIs at:

**API Testing with Postman**
**Postman used to test and verify all API endpoints.

The Postman collection for this project is included in the repository under docs/PostmanCollection.json.
You can import this collection into Postman for direct access to all API requests.
Steps to Use Postman:
Open Postman and click "Import".
Select the PostmanCollection.json file included in the /docs folder.
Update the base URL to http://localhost:8080 in the collection variables.
Explore and test the available endpoints.
Postman Screenshots:
Screenshots showcasing successful API testing are included in the screenshots/ directory:

Category API Testing
Post API Testing
JWT Authentication
Comment API Testing


Dependencies Used
Spring Boot Starter Web
Spring Boot Starter Data JPA
Lombok
Model Mapper
Spring Security
JWT Authentication
MySQL Database


### API Endpoints

#### Category Endpoints

| Method | Endpoint                   | Description                    |
|--------|----------------------------|--------------------------------|
| GET    | `/api/categories`          | Fetch all categories           |
| POST   | `/api/categories`          | Create a new category          |
| PUT    | `/api/categories/{id}`     | Update a category by ID        |
| DELETE | `/api/categories/{id}`     | Delete a category by ID        |

#### Post Endpoints

| Method | Endpoint                   | Description                               |
|--------|----------------------------|-------------------------------------------|
| GET    | `/api/posts`               | Fetch all posts with pagination & sorting |
| GET    | `/api/posts/{id}`          | Fetch a single post by ID                 |
| POST   | `/api/posts`               | Create a new post                         |
| PUT    | `/api/posts/{id}`          | Update a post by ID                       |
| DELETE | `/api/posts/{id}`          | Delete a post by ID                       |
| GET    | `/api/posts/category/{id}` | Fetch all posts in a specific category    |


Authentication
Basic Authentication: Secure endpoints with username and password.
JWT Authentication: Generate and validate JSON Web Tokens for secure API access.

Pagination and Sorting
The /api/posts endpoint supports:

Pagination: Use query parameters page and size (e.g., /api/posts?page=0&size=10).
Sorting: Use the sort parameter (e.g., /api/posts?sort=title,asc).







