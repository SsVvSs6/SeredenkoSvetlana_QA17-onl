package lesson8.task1.university;

import java.util.ArrayList;

public class Student {

    private String name;
    private int studentID;
    private String faculty;
    private ArrayList<Integer> courseIDs = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Teacher> studentTeachers = new ArrayList<>();
    private boolean student;

    public Student(String name, boolean student, String faculty, int ... courseIDs) {
        this.name = name;
        this.student = student;
        this.faculty = faculty;
        for (int i = 0; i < courseIDs.length; i++) {
            this.courseIDs.add(courseIDs[i]);
        }

        new Student(this.name, this.student, this.faculty, this.courseIDs, null);
    }

    public Student(String name, boolean student, String faculty, ArrayList<Integer> courseIDs,
                   ArrayList<Teacher> studentTeachers) {
        this.name = name;
        this.faculty = faculty;
        this.courseIDs = courseIDs;
        this.student = student;
        this.studentTeachers = studentTeachers;
    }

    public ArrayList<Teacher> getStudentTeachers() {
        return studentTeachers;
    }

    public StringBuilder getStudentTeachersList() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < studentTeachers.toArray().length - 1; i++) {
            sb.append(" ").append(studentTeachers.get(i).getName()).append(",");
        }
        sb.append(" ").append(studentTeachers.get(studentTeachers.toArray().length - 1).getName()).append(".");
        return sb;
    }

    public void setStudentTeachers(ArrayList<Teacher> studentTeachers) {
        this.studentTeachers = studentTeachers;
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

    public ArrayList<Integer> getCourseIDs() {
        return courseIDs;
    }

    public void setCourseIDs(ArrayList<Integer> courseIDs) {
        this.courseIDs = courseIDs;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
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
                Course.getCourseName(courseIDs);
    }
}
