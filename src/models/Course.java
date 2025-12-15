package models;

public class Course {
    private static int idCounter = 1; // Auto generate ID via counting

    private String courseName;
    private int courseId;

    // Constructor
    public Course(String courseName) {
        this.courseId = idCounter++;
        setCourseName(courseName);
    }

    // Getters/Setters
    public String getCourseName() { return courseName; }

    public void setCourseName(String courseName) {
        if (courseName == null || courseName.trim().isEmpty()) {
            throw new IllegalArgumentException("Course name cannot be null or empty.");
        }
        this.courseName = courseName;
    }

    public int getCourseId() { return courseId; }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Course Name: " + courseName;
    }
}
