package lesson8.task1.university;

public class Course {

    private String name;
    private String faculty;
    private int courseID;
    private static Course[] courses = new Course[20];

    public Course (String name, String faculty, int courseID) {
        this.name = name;
        this.faculty = faculty;
        this.courseID = courseID;
    }

    public static void addCourses(Course course) {
        for (int i = 1; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                break;
            }
        }
    }

    public static StringBuilder getCourseName(int... courseID) {
        StringBuilder courseNames = new StringBuilder();
        for (int i = 1; i < courses.length; i++) {
            if (courses[i] != null) {
                for (int j = 0; j < courseID.length; j++) {
                    if (courseID[j] == courses[i].getCourseID()) {
                        courseNames.append(courses[i].getName()).append(" ");
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
