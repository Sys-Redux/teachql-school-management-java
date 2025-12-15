import models.*;
import managers.*;
import java.util.Scanner;

public class Main {
    private static SchoolManager manager = new SchoolManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addTeacher();
                    break;
                case 3:
                    addCourse();
                    break;
                case 4:
                    assignCourseToStudent();
                    break;
                case 5:
                    assignCourseToTeacher();
                    break;
                case 6:
                    viewStudentById();
                    break;
                case 7:
                    viewAllStudentsAndTeachers();
                    break;
                case 8:
                    viewAllCourses();
                    break;
                case 9:
                    updateStudent();
                    break;
                case 10:
                    deleteStudent();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Termination is upon you.");
        scanner.close();
    }

    public static String welcomeMessage() {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (count < 50) {
            sb.append("=");
            count++;
        }
        return sb.toString();
    }

    private static void printMenu() {
        System.out.println(welcomeMessage());
        System.out.println("===== TEACHQL PRO -- SCHOOL MANAGEMENT SYSTEM ====");
        System.out.println(welcomeMessage());
        System.out.println("1. Add Student");
        System.out.println("2. Add Teacher");
        System.out.println("3. Add Course");
        System.out.println("4. Assign Course to Student");
        System.out.println("5. Assign Course to Teacher");
        System.out.println("6. View Student by ID");
        System.out.println("7. View All Students and Teachers");
        System.out.println("8. View All Courses");
        System.out.println("9. Update Student");
        System.out.println("10. Delete Student");
        System.out.println("0. Exit");
    }

    // Helper methods for input
    private static int getIntInput(String prompt) {
        System.out.println(prompt);
        while(!scanner.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            scanner.next();
        }
        int value = scanner.nextInt();
        scanner.nextLine(); // consume newline
        return value;
    }

    private static String getStringInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    // Each menu option has its own method
    private static void addStudent() {
        String name = getStringInput("Enter student name: ");
        int age = getIntInput("Enter student age: ");
        String email = getStringInput("Enter student email: ");
        int grade = getIntInput("Enter student grade: ");

        try {
            Student student = new Student(name, age, email, grade);
            manager.addStudent(student);
            System.out.println("Student added with ID: " + student.getStudentId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding student: " + e.getMessage());
        } finally {
            System.out.println("Welcome to TEACHQL PRO!");
        }
    }

    private static void addTeacher() {
        String name = getStringInput("Enter teacher name: ");
        int age = getIntInput("Enter teacher age: ");
        String email = getStringInput("Enter teacher email: ");
        String subject = getStringInput("Enter teacher subject: ");

        try {
            Teacher teacher = new Teacher(name, age, email, subject);
            manager.addTeacher(teacher);
            System.out.println("Teacher added with ID: " + teacher.getTeacherId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding teacher: " + e.getMessage());
        } finally {
            System.out.println("Welcome to TEACHQL PRO!");
        }
    }

    private static void addCourse() {
        String courseName = getStringInput("Enter course name: ");

        try {
            Course course = new Course(courseName);
            manager.addCourse(course);
            System.out.println("Course added with ID: " + course.getCourseId());
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding course: " + e.getMessage());
        } finally {
            System.out.println("Welcome to TEACHQL PRO!");
        }
    }

    private static void assignCourseToStudent() {
        int studentId = getIntInput("Enter student ID: ");
        int courseId = getIntInput("Enter course ID: ");

        try {
            Student student = manager.getStudentById(studentId);
            Course course = manager.getCourseById(courseId);
            if (student != null && course != null) {
                if (student.addCourse(course)) {
                    System.out.println("Course assigned to student.");
                }
            } else {
                System.out.println("Student or Course not found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error assigning course: " + e.getMessage());
        } finally {
            System.out.println("Welcome to TEACHQL PRO!");
        }
    }

    private static void assignCourseToTeacher() {
        int teacherId = getIntInput("Enter teacher ID: ");
        int courseId = getIntInput("Enter course ID: ");

        try {
            Teacher teacher = manager.getTeacherById(teacherId);
            Course course = manager.getCourseById(courseId);
            if (teacher != null && course != null) {
                if (teacher.addCourse(course)) {
                    System.out.println("Course assigned to teacher.");
                }
            } else {
                System.out.println("Teacher or Course not found.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error assigning course: " + e.getMessage());
        } finally {
            System.out.println("Welcome to TEACHQL PRO!");
        }
    }

    private static void viewStudentById() {
        int studentId = getIntInput("Enter student ID: ");
        Student student = manager.getStudentById(studentId);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void viewAllStudentsAndTeachers() {
        System.out.println("=== Students ===");
        for (Student s : manager.getAllStudents()) {
            System.out.println(s);
            System.out.println("----------------");
        }

        System.out.println("=== Teachers ===");
        for (Teacher t : manager.getAllTeachers()) {
            System.out.println(t);
            System.out.println("----------------");
        }
    }

    private static void viewAllCourses() {
        System.out.println("=== Courses ===");
        for (Course c : manager.getAllCourses()) {
            System.out.println(c);
            System.out.println("----------------");
        }
    }

    private static void updateStudent() {
        int studentId = getIntInput("Enter student ID to update: ");
        Student student = manager.getStudentById(studentId);
        if (student != null) {
            String name = getStringInput("Enter new name (current: " + student.getName() + "): ");
            int age = getIntInput("Enter new age (current: " + student.getAge() + "): ");
            String email = getStringInput("Enter new email (current: " + student.getEmail() + "): ");
            int grade = getIntInput("Enter new grade (current: " + student.getGrade() + "): ");

            try {
                student.setName(name);
                student.setAge(age);
                student.setEmail(email);
                student.setGrade(grade);
                System.out.println("Student updated.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error updating student: " + e.getMessage());
            } finally {
                System.out.println("Welcome to TEACHQL PRO!");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void deleteStudent() {
        int studentId = getIntInput("Enter student ID to delete: ");
        if (manager.deleteStudent(studentId)) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }
}
