package lesson8.task1.university;

public class Teacher {

    private String name;
    private String faculty;
    private int[] courseID;
    static Teacher[] teachers = new Teacher[20];
    private boolean active;

    public Teacher (String name, boolean active,  String faculty, int ... courseID) {
        this.name = name;
        this.active = active;
        this.faculty = faculty;
        this.courseID = courseID;
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

    public int[] getCourseID() {
        return courseID;
    }

    public void setCourseID(int[] courseID) {
        this.courseID = courseID;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public static Teacher[] getTeachers() {
        return teachers;
    }

    public void setTeachers(Teacher[] teachers) {
        Teacher.teachers = teachers;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
