package managers;

import models.*;
import java.util.ArrayList;

public class SchoolManager {
    private ArrayList<Student> students;
    private ArrayList<Teacher> teachers;
    private ArrayList<Course> courses;

    public SchoolManager() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        courses = new ArrayList<>();
    }

    // Student Ops
    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudentById(int id) {
        for (Student s : students) {
            if (s.getStudentId() == id) return s;
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        return students.removeIf(s -> s.getStudentId() == id);
    }

    public ArrayList<Student> getAllStudents() { return students; }

    // Teacher Ops
    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public Teacher getTeacherById(int id) {
        for (Teacher t : teachers) {
            if (t.getTeacherId() == id) return t;
        }
        return null;
    }

    public ArrayList<Teacher> getAllTeachers() { return teachers; }

    // Course Ops
    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course getCourseById(int id) {
        for (Course c : courses) {
            if (c.getCourseId() == id) return c;
        }
        return null;
    }

    public ArrayList<Course> getAllCourses() { return courses; }
}
