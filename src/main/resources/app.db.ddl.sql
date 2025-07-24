create database ivolve_task;

--- Table USERS ---
--- Table USERS ---
--- Table USERS ---
CREATE TABLE users (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(99) NOT NULL,
    email VARCHAR(99) NOT NULL UNIQUE,
    role ENUM('ADMIN', 'USER') NOT NULL
);

--- Table TEAMS ---
--- Table TEAMS ---
--- Table TEAMS ---
CREATE TABLE teams (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(99) NOT NULL UNIQUE,
    description VARCHAR(255) DEFAULT NULL
);


--- Table TASKS ---
--- Table TASKS ---
--- Table TASKS ---
CREATE TABLE tasks (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(99) NOT NULL,
    description TEXT DEFAULT NULL,
    status ENUM('TODO', 'WIP', 'DONE') DEFAULT 'TODO',
    priority ENUM('LOW', 'MEDIUM', 'HIGH') DEFAULT 'LOW',
    due_date DATE NOT NULL,
    team_id BIGINT NOT NULL,
    assigned_to BIGINT NOT NULL,
    FOREIGN KEY (team_id) REFERENCES teams(id),
    FOREIGN KEY (assigned_to) REFERENCES users(id)
);

