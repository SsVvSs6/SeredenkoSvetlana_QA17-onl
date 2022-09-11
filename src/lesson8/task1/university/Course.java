package lesson8.task1.university;

import java.util.ArrayList;

public class Course {

    private String name;
    private String faculty;
    private int courseID;
    private static ArrayList<Course> courses = new ArrayList<>();

    public Course (String name, String faculty, int courseID) {
        this.name = name;
        this.faculty = faculty;
        this.courseID = courseID;
    }

    public static void addCourses(Course course) {
        courses.add(course);
    }

    public static StringBuilder getCourseName(ArrayList<Integer> courseID) {
        StringBuilder courseNames = new StringBuilder();
        for (int i = 1; i < courses.toArray().length; i++) {
            if (courses.get(i) != null) {
                for (int j = 0; j < courseID.toArray().length; j++) {
                    if (courseID.get(j) == courses.get(i).getCourseID()) {
                        courseNames.append(courses.get(i).getName()).append(" ");
                    }
                }
            } else {
                break;
            }
        }
        return courseNames;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
}
