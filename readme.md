Tentu, ini adalah versi gabungan yang sudah saya rapikan agar terlihat profesional, terstruktur, dan bersih. Format ini sangat cocok untuk diletakkan langsung di repositori GitHub sebagai dokumentasi utama.

---

```markdown
# Course Management System

This repository contains a Java console-based application for managing courses and users. The project is built as a learning exercise to practice object-oriented programming (OOP), MVC architecture, and file-based persistence in Java.

---

## Project Description

The Course Management System is a console application that allows users to interact with course data based on their roles. It focuses on demonstrating fundamental software design patterns without the complexity of a database or graphical interface.

**Core Capabilities:**
* User authentication and role-based access control.
* Course management (CRUD operations).
* Persistent storage using flat-file systems.

---

## Features

### Role-Based Access
* **Anonymous User:** View course lists, view course details, and login.
* **Admin:** Create new courses, view all system data, and manage records.
* **Student:** Enroll in available courses and view personal enrollment history.

---

## Project Structure

The project follows a modular structure to maintain a clear separation of concerns:

```text
src/
├── controllers/    # Handles application flow and coordination
├── services/       # Contains business logic and file operations
├── models/         # Data structures (Course, User, etc.)
├── views/          # Console-based UI and user input handling
└── Main.java       # Application entry point

```

---

## Architecture

The project follows the **MVC (Model–View–Controller)** pattern:

* **Model:** Defines the data structures and business entities.
* **View:** Manages the CLI (Command Line Interface) for user interaction.
* **Controller:** Acts as an intermediary between the View and Services.
* **Service:** Encapsulates business rules and handles direct data manipulation.

---

## Data Storage

This application uses simple file-based storage located in the `data/` directory.

**Course Data Format (`data/courses.txt`):**
Data is stored using a pipe-separated format:
`id|title|description|credits`

**Example:**
`1|Introduction to Programming|Basic programming concepts|3`

---

## Requirements

* **Java Development Kit (JDK):** Version 11 or higher.
* **Environment:** Any terminal or IDE (IntelliJ IDEA, VS Code, Eclipse).

---

## How to Run

1. **Clone the repository:**
```bash
git clone [https://github.com/your-username/course-management-system.git](https://github.com/your-username/course-management-system.git)

```


2. **Ensure the data directory exists:**
Create a folder named `data` in the root directory if it is not present.
3. **Compile the application:**
```bash
javac Main.java

```


4. **Run the application:**
```bash
java Main

```



---

## Project Limitations & Notes

* **Security:** Passwords are currently stored in plain text (educational purposes only).
* **Persistence:** No SQL/NoSQL database is used; all data is stored in `.txt` files.
* **Scope:** This project is a foundational exercise and is not intended for production use.

---

## Purpose

This project was developed to:

1. Apply **Object-Oriented Programming** principles (Encapsulation, Inheritance, Polymorphism).
2. Implement the **MVC Architecture** in a decoupled manner.
3. Handle **File I/O** operations for data persistence.
4. Understand the flow of a multi-role user system.

```

```