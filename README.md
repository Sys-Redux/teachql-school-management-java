# TeachQL Pro - School Management System

[![GitHub](https://img.shields.io/badge/GitHub-Sys--Redux-181717?style=for-the-badge&logo=github)](https://github.com/Sys-Redux)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-t--edge-0A66C2?style=for-the-badge&logo=linkedin)](https://www.linkedin.com/in/t-edge/)
[![Website](https://img.shields.io/badge/Website-sysredux.xyz-4285F4?style=for-the-badge&logo=google-chrome)](https://www.sysredux.xyz)
[![X](https://img.shields.io/badge/X-sys__redux-000000?style=for-the-badge&logo=x)](https://x.com/sys_redux)
[![Discord](https://img.shields.io/badge/Discord-Join%20Server-5865F2?style=for-the-badge&logo=discord)](https://discord.gg/KdfApwrBuW)
[![Upwork](https://img.shields.io/badge/Upwork-Hire%20Me-6FDA44?style=for-the-badge&logo=upwork)](https://www.upwork.com/freelancers/~011b4cf7ebf1503859?mp_source=share)
[![Freelancer](https://img.shields.io/badge/Freelancer-Hire%20Me-29B2FE?style=for-the-badge&logo=freelancer)](https://www.freelancer.com/u/trevoredge?frm=trevoredge&sb=t)

---

A console-based Java application for managing students, teachers, and courses in an educational setting. Built as part of my learning journey at Coding Temple, this project demonstrates core object-oriented programming concepts including inheritance, encapsulation, and data validation.

## 📋 Table of Contents

- [Features](#-features)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [Usage](#-usage)
- [Class Overview](#-class-overview)
- [Technologies Used](#-technologies-used)
- [Future Improvements](#-future-improvements)
- [License](#-license)

## ✨ Features

- **Student Management**: Add, view, update, and delete students
- **Teacher Management**: Add and view teachers with subject specialization
- **Course Management**: Create courses and assign them to students and teachers
- **Input Validation**: Robust validation for names, emails, ages, and grades
- **Course Limits**: Students can enroll in up to 5 courses; teachers can teach up to 3
- **Auto-Generated IDs**: Unique IDs automatically assigned to students, teachers, and courses
- **Interactive Menu**: User-friendly console interface for all operations

## 📁 Project Structure

```
java-student-manager-tool/
├── src/
│   ├── Main.java                 # Entry point and menu system
│   ├── managers/
│   │   └── SchoolManager.java    # Central management for all entities
│   └── models/
│       ├── Person.java           # Base class for Student and Teacher
│       ├── Student.java          # Student entity with course enrollment
│       ├── Teacher.java          # Teacher entity with course assignments
│       └── Course.java           # Course entity
├── .gitignore
└── README.md
```

## 🚀 Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or higher
- Any Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/Sys-Redux/java-student-manager-tool.git
   cd java-student-manager-tool
   ```

2. **Compile the project**
   ```bash
   cd src
   javac Main.java models/*.java managers/*.java
   ```

3. **Run the application**
   ```bash
   java Main
   ```

## 💻 Usage

When you run the application, you'll see an interactive menu:

```
==================================================
===== TEACHQL PRO -- SCHOOL MANAGEMENT SYSTEM ====
==================================================
1. Add Student
2. Add Teacher
3. Add Course
4. Assign Course to Student
5. Assign Course to Teacher
6. View Student by ID
7. View All Students and Teachers
8. View All Courses
9. Update Student
10. Delete Student
0. Exit
```

### Example Workflow

1. **Add a Course**: Select option 3 and enter "Mathematics"
2. **Add a Teacher**: Select option 2 and enter teacher details with their subject
3. **Add a Student**: Select option 1 and enter student details including grade level
4. **Assign Course to Student**: Select option 4, enter the student ID and course ID
5. **View All**: Use options 7 and 8 to see all registered students, teachers, and courses

## 📚 Class Overview

### Person (Base Class)
The abstract base class for `Student` and `Teacher` containing common properties:
- `name` - Person's full name (validated: cannot be empty)
- `age` - Person's age (validated: 0-150)
- `email` - Person's email address (validated: must contain @)

### Student (extends Person)
Represents a student in the system:
- `studentId` - Auto-generated unique identifier
- `grade` - Student's grade level (validated: non-negative)
- `courses` - List of enrolled courses (max 5)

### Teacher (extends Person)
Represents a teacher in the system:
- `teacherId` - Auto-generated unique identifier
- `subject` - Teacher's area of expertise
- `courses` - List of courses taught (max 3)

### Course
Represents a course offering:
- `courseId` - Auto-generated unique identifier
- `courseName` - Name of the course (validated: cannot be empty)

### SchoolManager
Central manager class handling all CRUD operations:
- Maintains collections of students, teachers, and courses
- Provides methods for adding, retrieving, and deleting entities
- Acts as the data layer for the application

## 🛠️ Technologies Used

- **Java** - Core programming language
- **Object-Oriented Programming** - Inheritance, encapsulation, polymorphism
- **Collections Framework** - ArrayList for data storage
- **Exception Handling** - Input validation with IllegalArgumentException

## 🔮 Future Improvements

Here are some features I'm considering for future versions:

- [ ] Database integration (MySQL/PostgreSQL) for persistent storage
- [ ] Grade tracking and GPA calculation for students
- [ ] Search functionality by name or email
- [ ] Export data to CSV/JSON formats
- [ ] GUI version using JavaFX or Swing
- [ ] Unit tests with JUnit
- [ ] Remove course from student/teacher functionality
- [ ] Teacher update and delete operations

## 📝 License

This project is open source and available for educational purposes.

---

Made with ☕ and Java | Part of my journey at [Coding Temple](https://www.codingtemple.com/)

