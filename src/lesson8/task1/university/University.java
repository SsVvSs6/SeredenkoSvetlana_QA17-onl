package lesson8.task1.university;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class University {

    private String name;
    private String address;
    private String phone;
    private static Department[] departments = new Department[10];

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public University(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void addStudent(Student objectStudent) {
        boolean isStudent = random.nextBoolean();
        int studentID = 0;
        Student[] students = Student.getStudents();
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                studentID = i;
                objectStudent.setStudentID(studentID);
                break;
           }
        }
        if (isStudent) {
            System.out.println(objectStudent.getName() + " is enrolled");
            students[studentID] = objectStudent;
            objectStudent.setStudent(true);
        } else {
            System.out.println(objectStudent.getName() + " didn't enroll");
        }
    }

    public void removeStudent(int studentID) {
        Student[] students = Student.getStudents();
        if (students[studentID] != null) {
            System.out.println("Student " + students[studentID].getName() + " is expelled");
            students[studentID].setStudent(false);
        } else {
            System.out.println("No such Student exists");
        }
    }

    public static Student getStudent(int studentId) {
        Student[] students = Student.getStudents();
        if (students[studentId].isStudent()) {
            return students[studentId];
        } else {
            return null;
        }
    }

    public void getStudents() {
        Student[] students = Student.getStudents();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].isStudent()) {
                    System.out.println(students[i].getName());
                }
            }
        }
    }

    public void addDepartment(Department name) {
        int departmentID = 0;
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] == null) {
                departmentID = i;
                break;
            }
        }
            departments[departmentID] = name;
            name.setActive(true);
    }

    public void removeDepartment(int departmentID) {
        if (departments[departmentID] != null) {
            System.out.println("Department \"" + departments[departmentID].getName() + "\" is removed");
            departments[departmentID].setActive(false);
        } else {
            System.out.println("No such Department exists");
        }
    }

    public Department getDepartment(int departmentNumber) {
        if (departments[departmentNumber] != null) {
            if (departments[departmentNumber].isActive()) {
                return departments[departmentNumber];
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void getAllDepart() {
        for (int i = 0; i < departments.length; i++) {
            if (departments[i] != null) {
                if (departments[i].isActive()) {
                    System.out.println(departments[i]);
                }
            } else {
                break;
            }
        }
    }

    public static void findStudent() {
        System.out.print("Enter Student name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Student second name: ");
        String studentSecondName = scanner.nextLine();
        String studentFullName = studentName + " " + studentSecondName;
        System.out.print("Enter Teacher name: ");
        String teacherName = scanner.nextLine();

        Student[] students = Student.getStudents();
        Teacher[] teachers = Teacher.getTeachers();
        boolean studentsEqual = isStudentNameEqual(studentFullName, students);
        int studentId = getStudentEqualId(studentFullName, students);
        boolean teacherEqual = isTeacherNameEqual(teacherName, teachers);
        int teacherId = getTeacherEqualId(teacherName, teachers);
        if (studentsEqual & teacherEqual) {
            if (isCourseEqual(studentId, teacherId)) {
                System.out.println(students[studentId]);
            } else {
                System.out.println("Student is not found");
            }
        } else {
            System.out.println("Student is not found");
        }
    }

    private static int getTeacherEqualId(String teacherName, Teacher[] teachers) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                if (teacherName.equalsIgnoreCase(teachers[i].getName())) {
                    if (teachers[i].isActive()) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isCourseEqual(int studentId, int teacherId) {
        for (int i = 0; i < Objects.requireNonNull(getStudent(studentId)).getCourseIDs().length; i++) {
            for (int j = 0; j < Objects.requireNonNull(Department.getInstructor(teacherId)).getCourseID().length; j++) {
               if (Objects.requireNonNull(getStudent(studentId)).getCourseIDs()[i] ==
                       Objects.requireNonNull(Department.getInstructor(teacherId)).getCourseID()[j]) {
                   return  true;
               }
            }
        }
        return false;
    }

    private static boolean isTeacherNameEqual(String teacherName, Teacher[] teachers) {
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] != null) {
                if (teacherName.equalsIgnoreCase(teachers[i].getName())) {
                    if (teachers[i].isActive()) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static int getStudentEqualId(String studentFullName, Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].isStudent()) {
                    if (studentFullName.equalsIgnoreCase(students[i].getName())) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isStudentNameEqual(String studentFullName, Student[] students) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                if (students[i].isStudent()) {
                    if (studentFullName.equalsIgnoreCase(students[i].getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Department[] getDepartments() {
        return departments;
    }
}
