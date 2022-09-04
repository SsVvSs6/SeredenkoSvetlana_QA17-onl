package lesson8.task1.university;

import java.util.Arrays;

public class Student {

    private String name;
    private int studentID;
    private String faculty;
    private int[] courseIDs = new int[5];
    private static Student[] students = new Student[20];
    private boolean student;

    public Student(String name, boolean student, String faculty, int ... courseIDs) {
        this.name = name;
        this.student = student;
        this.faculty = faculty;
        this.courseIDs = courseIDs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int[] getCourseIDs() {
        return courseIDs;
    }

    public void setCourseIDs(int[] courseIDs) {
        this.courseIDs = courseIDs;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        Student.students = students;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; id: " + studentID + ": department: " + getFaculty() + "; courses: " +
                Arrays.toString(courseIDs);
    }
}
