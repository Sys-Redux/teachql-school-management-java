package models;

import java.util.ArrayList;

public class Teacher extends Person {
    private static int idCounter = 1;
    private static final int MAX_COURSES = 3;

    private int teacherId;
    private String subject;
    private ArrayList<Course> courses;

    public Teacher(String name, int age, String email, String subject) {
        super(name, age, email);
        this.teacherId = idCounter++;
        setSubject(subject);
        this.courses = new ArrayList<>();
    }

    // Getters/Setters
    public int getTeacherId() { return teacherId; }
    public String getSubject() { return subject; }

    public void setSubject(String subject) {
        if (subject == null || subject.trim().isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty.");
        }
        this.subject = subject;
    }

    public ArrayList<Course> getCourses() { return courses; }

    public boolean addCourse(Course course) {
        if (courses.size() >= MAX_COURSES) {
            System.out.println("Too many courses!");
            return false;
        }
        courses.add(course);
        return true;
    }

    public boolean removeCourse(int courseId) {
        return courses.removeIf(course -> course.getCourseId() == courseId);
    }

    @Override
    public String toString() {
        return "Teacher ID: " + teacherId + "\n" +
                "Name: " + getName() + "\n" +
                "Age: " + getAge() + "\n" +
                "Email: " + getEmail() + "\n" +
                "Subject: " + subject + "\n" +
                "Courses Taught: " + courses.size();
    }
}
