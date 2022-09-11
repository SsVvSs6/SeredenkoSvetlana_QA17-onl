package lesson8.task1.university;

import java.util.ArrayList;
import java.util.Arrays;

public class Department {

    private String name;
    private String university;
    private ArrayList<Integer> courseIDs = new ArrayList<>();
    private boolean active;

    public Department(String name, String university, boolean active, int ... courseID) {
        this.name = name;
        this.university = university;
        this.active = active;
        for (int i = 0; i < courseID.length; i++) {
            assert false;
            this.courseIDs.add(courseID[i]);
        }
    }

    @Override
    public String toString() {
        return "Name: " + name + "; university: " + university + ", courseIDs: " +
                Arrays.toString(courseIDs.toArray());
    }

    public void addInstructor(Teacher objectTeacher) {
        ArrayList<Teacher> teachers = Teacher.getTeachers();
        teachers.add(objectTeacher);
        objectTeacher.setActive(true);
    }

    public void removeInstructor(int teacherID) {
        ArrayList<Teacher> teachers = Teacher.getTeachers();
        if (teachers.get(teacherID) != null) {
            System.out.println("Teacher " + teachers.get(teacherID).getName() + " is removed");
            teachers.get(teacherID).setActive(false);
        } else {
            System.out.println("No such Teacher exists");
        }
    }

    public static Teacher getInstructor(int teacherId) {
        ArrayList<Teacher> teachers = Teacher.getTeachers();
        if (teachers.get(teacherId) != null) {
            if (teachers.get(teacherId).isActive()) {
                return teachers.get(teacherId);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public static void getAllInstructor() {
        ArrayList<Teacher> teachers = Teacher.getTeachers();
        for (int i = 0; i < teachers.toArray().length; i++) {
            if (teachers.get(i) != null) {
                if (teachers.get(i).isActive()) {
                    System.out.println(teachers.get(i));
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

    public ArrayList<Integer> getCourseIDs() {
        return courseIDs;
    }

    public void setCourseIDs(ArrayList<Integer> courseIDs) {
        this.courseIDs = courseIDs;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
