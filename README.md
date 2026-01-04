# JWT Authentication & Role-Based Access Control

This project demonstrates **user authentication and authorization** using **JSON Web Tokens (JWT)** with **role-based access control**.

## Features

- **User Registration & Login** endpoints
- **Password hashing** with bcrypt
- **JWT token generation** on login
- **Protected routes** accessible only by authenticated users
- **Role-based access control** (admin, user, owner)

## API Endpoints

- `POST /auth/register` - Register a new user  
- `POST /auth/login` - Login and receive JWT token  
- `GET /users` - Accessible only to authenticated users with proper role  
- `GET /profile` - View your own profile (authenticated users only)

## Technologies

- Spring Boot  
- Spring Security  
- JWT (io.jsonwebtoken)  
- Bcrypt for password hashing  
-  MySQL for database


