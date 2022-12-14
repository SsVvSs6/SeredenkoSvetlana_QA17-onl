package lesson8.task1.university;

import java.util.ArrayList;

public class Teacher {

    private String name;
    private String faculty;
    private ArrayList<Integer> courseID = new ArrayList<>();
    static ArrayList<Teacher> teachers = new ArrayList<>();
    private boolean active;

    public Teacher (String name, boolean active,  String faculty, int ... courseID) {
        this.name = name;
        this.active = active;
        this.faculty = faculty;
        for (int i = 0; i < courseID.length; i++) {
            this.courseID.add(courseID[i]);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "; department: " + faculty + "; courses: " + Course.getCourseName(courseID);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getCourseID() {
        return courseID;
    }

    public void setCourseID(ArrayList<Integer> courseID) {
        this.courseID = courseID;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        Teacher.teachers = teachers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
