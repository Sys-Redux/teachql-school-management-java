package models;

import java.util.ArrayList;

public class Student extends Person {
    private static int idCounter = 1;
    private static final int MAX_COURSES = 5;

    private int studentId;
    private int grade;
    private ArrayList<Course> courses;

    public Student(String name, int age, String email, int grade) {
        super(name, age, email);
        this.studentId = idCounter++;
        setGrade(grade);
        this.courses = new ArrayList<>();
    }

    // Getters/Setters
    public int getStudentId() { return studentId; }
    public int getGrade() { return grade; }

    public void setGrade(int grade) {
        if (grade < 0) {
            throw new IllegalArgumentException("Grade cannot be negative.");
        }
        this.grade = grade;
    }

    public ArrayList<Course> getCourses() { return courses; }

    // Add course w/ limit check
    public boolean addCourse(Course course) {
        if (courses.size() >= MAX_COURSES) {
            System.out.println("Too many courses!");
            return false;
        }
        courses.add(course);
        return true;
    }

    // Remove course by ID
    public boolean removeCourse(int courseId) {
        return courses.removeIf(course -> course.getCourseId() == courseId);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId + "\n" +
                "Name: " + getName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Grade: " + grade + "\n" +
                "Courses Enrolled: " + courses.size();
    }
}
