# 🧠 Task Manager API (Spring Boot)

A backend REST API for managing users and their tasks, built using Spring Boot.

## 🚀 Features

- 👤 User Management (CRUD)
- ✅ Task Management (CRUD)
- 🔗 User ↔ Task Relationship (One-to-Many)
- 🛡️ Error Handling with Global Exception Handler
- 📡 RESTful API Design
- 💾 MySQL Database Integration

---

## 🏗️ Tech Stack

- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

---

## 📂 Project Structure

- controller → Handles API requests
- service → Business logic
- repository → Database access
- model → Entity classes


---

## 📡 API Endpoints

### 👤 User APIs

| Method | Endpoint | Description |
|--------|--------|-------------|
| POST | /users/register | Create user |
| GET | /users | Get all users |
| GET | /users/{id} | Get user by ID |
| PUT | /users/{id} | Update user |
| DELETE | /users/{id} | Delete user |

---

### 📋 Task APIs

| Method | Endpoint | Description |
|--------|--------|-------------|
| POST | /users/{userId}/tasks | Create task for user |
| GET | /users/{userId}/tasks | Get all tasks of a user |
| GET | /users/{userId}/tasks/{id} | Get task by ID |
| PUT | /users/{userId}/tasks/{id} | Update task |
| DELETE | /users/{userId}/tasks/{id} | Delete task |


## 🧪 Sample Request (Create Task)

```json
{
  "title": "Learn Spring Boot",
  "description": "Complete Task Manager project",
  "completed": false
}
```
⚙️ Setup Instructions

Clone the repo

git clone https://github.com/<your-username>/task-manager.git

Configure MySQL in application.properties

Run the app

mvn spring-boot:run


📌 Future Improvements

🔐 Authentication (JWT)

📊 Task filtering & pagination

🧾 DTO layer

🧪 Unit & Integration Testing

🌐 Deployment (Render / AWS)



👨‍💻 Author
Mathesh S
