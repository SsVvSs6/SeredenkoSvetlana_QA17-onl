package lesson8.task1.university;

import java.util.Arrays;

public class Department {

    private String name;
    private String university;
    private int[] courseIDs;
    private boolean active;

    public Department(String name, String university, boolean active, int ... courseIDs) {
        this.name = name;
        this.university = university;
        this.active = active;
        this.courseIDs = courseIDs;
    }

    @Override
    public String toString() {
        return "Name: " + name + "; university: " + university + ", courseIDs: " +
                Arrays.toString(courseIDs);
    }

    public void addInstructor(Teacher objectTeacher) {
        int teacherID = 0;
        Teacher[] teachers = Teacher.getTeachers();
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                teacherID = i;
                break;
            }
        }
        teachers[teacherID] = objectTeacher;
        objectTeacher.setActive(true);
    }

    public void removeInstructor(int teacherID) {
        Teacher[] teachers = Teacher.getTeachers();
        if (teachers[teacherID] != null) {
            System.out.println("Teacher " + teachers[teacherID].getName() + " is removed");
            teachers[teacherID].setActive(false);
        } else {
            System.out.println("No such Teacher exists");
        }
    }

    public static Teacher getInstructor(int teacherId) {
        Teacher[] teachers = Teacher.getTeachers();
        if (teachers[teacherId] != null) {
            if (teachers[teacherId].isActive()) {
                return teachers[teacherId];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static void getAllInstructor() {
        Teacher[] teachers = Teacher.getTeachers();
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                if (teachers[i].isActive()) {
                    System.out.println(teachers[i]);
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int[] getCourseIDs() {
        return courseIDs;
    }

    public void setCourseIDs(int[] courseIDs) {
        this.courseIDs = courseIDs;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
