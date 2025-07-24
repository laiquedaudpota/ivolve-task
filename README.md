# Team Task Management System

## Overview
The **Team Task Management System** is a Spring Boot-based backend application designed to manage teams, users, and their assigned tasks with priorities, deadlines, and status tracking. The application supports CRUD operations for users, teams, and tasks, along with additional functionality for task status updates and team member assignments.

## Technologies Used
- **Java**: 21
- **Spring Boot**: 3.3.5
- **MySQL**: 9.3.0
- **Lombok**: 1.18.34
- **Thymeleaf**: 3.3.0

## Prerequisites
- **Java 21** installed
- **MySQL 9.3.0** server running
- **Maven** for dependency management
- **Postman** for testing APIs
- A MySQL database named `ivolve_task`

## Database Schema
The application uses the following database schema:

### Users
| Column | Type | Constraints |
|--------|------|-------------|
| id     | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| name   | VARCHAR(99) | NOT NULL |
| email  | VARCHAR(99) | NOT NULL, UNIQUE |
| role   | ENUM('ADMIN', 'USER') | NOT NULL |

### Teams
| Column | Type | Constraints |
|--------|------|-------------|
| id     | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| name   | VARCHAR(99) | NOT NULL, UNIQUE |
| description | VARCHAR(255) | DEFAULT NULL |

### Tasks
| Column | Type | Constraints |
|--------|------|-------------|
| id     | BIGINT | PRIMARY KEY, AUTO_INCREMENT |
| title  | VARCHAR(99) | NOT NULL |
| description | TEXT | DEFAULT NULL |
| status | ENUM('TODO', 'WIP', 'DONE') | DEFAULT 'TODO' |
| priority | ENUM('LOW', 'MEDIUM', 'HIGH') | DEFAULT 'LOW' |
| due_date | DATE | NOT NULL |
| team_id | BIGINT | NOT NULL, FOREIGN KEY (teams.id) |
| assigned_to | BIGINT | NOT NULL, FOREIGN KEY (users.id) |

## Postman Collection
The provided `iVolve Task.postman_collection.json` includes the following API requests:
- **Users Add**: POST /users
- **Users List**: GET /users
- **Teams Add**: POST /teams
- **Teams List**: GET /teams
- **Tasks Add**: POST /tasks
- **Tasks Update**: PUT /tasks/{id}
- **Tasks Update Status**: PUT /tasks/{id}/status
- **Tasks List**: GET /tasks

## Setup
* Create database with name `ivolve_task`
* [iVolve-Task](https://github.com/laiquedaudpota/ivolve-task) Clone the project
* [app.db.ddl.sql](https://github.com/laiquedaudpota/ivolve-task/blob/main/src/main/resources/app.db.ddl.sql) Read, and execute the commands
* [app.db.dml.sql](https://github.com/laiquedaudpota/ivolve-task/blob/main/src/main/resources/app.db.dml.sql) Read, and execute the commands
* [iVolve_Task.postman_collection.json](https://github.com/laiquedaudpota/ivolve-task/blob/main/src/main/resources/iVolve_Task.postman_collection.json) Import this collection into Postman to test the APIs.