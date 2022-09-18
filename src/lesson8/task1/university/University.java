package lesson8.task1.university;

/**
 * Вывести используя карту список всех студентов и их преподов (ни одного студента не потерять)
 */

import lesson9.task1.exceptions.*;

import java.util.*;

public class University {

    private String name;
    private String address;
    private String phone;
    private static ArrayList<Department> departments = new ArrayList<>();

    static Random random = new Random();
    static Scanner scanner = new Scanner(System.in);

    public University(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public void addStudent(Student objectStudent) {
        boolean isStudent = random.nextBoolean();
        ArrayList<Student> students = Student.getStudents();
        if (isStudent) {
            System.out.println(objectStudent.getName() + " is enrolled");
            students.add(objectStudent);
            objectStudent.setStudent(true);
            try {
                if (Objects.equals(Arrays.toString(new ArrayList[]{objectStudent.getCourseIDs()}), "[5]")) {
                    throw new CourseIsOnlyMathException();
                }
            } catch (CourseIsOnlyMathException ciome) {
                System.out.println("\n" + ciome.courseIsOnlyMathMessage);
                System.out.println();
            }
        } else {
            System.out.println(objectStudent.getName() + " didn't enroll");
        }
    }

    public void removeStudent(int studentID) {
        ArrayList<Student> students = Student.getStudents();
        if (students.get(studentID) != null) {
            System.out.println("Student " + students.get(studentID).getName() + " is expelled");
            students.get(studentID).setStudent(false);
        } else {
            System.out.println("No such Student exists");
        }
    }

    public static Student getStudent(int studentId) {
        ArrayList<Student> students = Student.getStudents();
        try {
            if (students != null) {
                if (students.get(studentId).isStudent()) {
                    return students.get(studentId);
                } else {
                    return null;
                }
            } else {
                throw new NoStudentFoundExceptions();
            }
        } catch (NoStudentFoundExceptions nsfe) {
            System.out.println(nsfe.noStudentFoundMessage);
        }
        return null;
    }

    public void getStudents() {
        ArrayList<Student> students = Student.getStudents();
        for (int i = 0; i < students.toArray().length; i++) {
            if (students.get(i) != null) {
                if (students.get(i).isStudent()) {
                    System.out.println(students.get(i).getName());
                }
            }
        }
    }

    public void addDepartment(Department name) {
        departments.add(name);
        name.setActive(true);
    }

    public void removeDepartment(int departmentID) {
        if (departments.get(departmentID) != null) {
            System.out.println("Department \"" + departments.get(departmentID).getName() + "\" is removed");
            departments.get(departmentID).setActive(false);
        } else {
            System.out.println("No such Department exists");
        }
    }

    public Department getDepartment(int departmentNumber) {
        if (departments.get(departmentNumber) != null) {
            if (departments.get(departmentNumber).isActive()) {
                return departments.get(departmentNumber);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    public void getAllDepart() {
        for (int i = 0; i < departments.toArray().length; i++) {
            if (departments.get(i) != null) {
                if (departments.get(i).isActive()) {
                    System.out.println(departments.get(i));
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
        try {
            if (!Objects.equals(teacherName, "Viktor") & !Objects.equals(teacherName, "viktor")) {
                throw new TeacherIsNotViktorException();
            }
        } catch (TeacherIsNotViktorException tinve) {
            System.out.println("\n" + tinve.teacherIsNotViktorMessage);
            System.out.println();
        }

        ArrayList<Student> students = Student.getStudents();
        ArrayList<Teacher> teachers = Teacher.getTeachers();
        boolean studentsEqual = isStudentNameEqual(studentFullName, students);
        int studentId = getStudentEqualId(studentFullName, students);
        boolean teacherEqual = isTeacherNameEqual(teacherName, teachers);
        int teacherId = getTeacherEqualId(teacherName, teachers);

        try {
            if (studentsEqual & teacherEqual & isCourseEqual(studentId, teacherId)) {
                if (isCourseEqual(studentId, teacherId)) {
                    System.out.println(students.get(studentId));
                } else {
                    System.out.println("Student is not found");
                }
            } else {
                System.out.println("Student is not found");
                throw new NoDataForCourseComparisonException();
            }
        } catch (NoDataForCourseComparisonException ndfcce) {
            System.out.println(ndfcce.noDataForCourseComparisonMessage);
        } catch (NullPointerException npe) {
            System.out.println("Courses could not be compared with null");
        }

    }

    public static void getAllStudentsAndTheirTeachersNames() {
        ArrayList<Student> students = Student.getStudents();

        for (int i = 0; i < students.toArray().length; i++) {
            ArrayList<Teacher> teachersList = new ArrayList<>();
            for (int j = 0; j < students.get(i).getCourseIDs().toArray().length; j++) {
                teachersList.add(Teacher.getTeacherByCourseID(students.get(i).getCourseIDs().get(j),
                        students.get(i).getFaculty()));
            }
            students.get(i).setStudentTeachers(teachersList);
        }

        HashMap<Student, ArrayList<Teacher>> studentAndTheirTeachersMap = new HashMap<>();
        ArrayList<Student> activeStudents = new ArrayList<>();
        for (int i = 0; i < students.toArray().length; i++) {
            if (students.get(i).isStudent()) {
                studentAndTheirTeachersMap.put(students.get(i), students.get(i).getStudentTeachers());
                activeStudents.add(students.get(i));
            }
        }

        for (int i = 0; i < studentAndTheirTeachersMap.size(); i++) {
            System.out.println(activeStudents.get(i).getName() + " - " +
                    activeStudents.get(i).getStudentTeachersList());
        }


    }

    private static int getTeacherEqualId(String teacherName, ArrayList<Teacher> teachers) {
        for (int i = 0; i < teachers.toArray().length; i++) {
            if (teachers.get(i) != null) {
                if (teacherName.equalsIgnoreCase(teachers.get(i).getName())) {
                    if (teachers.get(i).isActive()) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isCourseEqual(int studentId, int teacherId) {
        for (int i = 0; i < Objects.requireNonNull(getStudent(studentId)).getCourseIDs().toArray().length; i++) {
            for (int j = 0; j < Objects.requireNonNull(Department.getInstructor(teacherId)).
                    getCourseID().toArray().length; j++) {
               if (Objects.equals(Objects.requireNonNull(getStudent(studentId)).getCourseIDs().get(i),
                       Objects.requireNonNull(Department.getInstructor(teacherId)).getCourseID().get(j))) {
                   return  true;
               }
            }
        }
        return false;
    }

    private static boolean isTeacherNameEqual(String teacherName, ArrayList<Teacher> teachers) {
        try {
            for (int i = 0; i < teachers.toArray().length; i++) {
                if (teachers.get(i) != null) {
                    if (teacherName.equalsIgnoreCase(teachers.get(i).getName())) {
                        if (teachers.get(i).isActive()) {
                            return true;
                        }
                    }
                }
            }
            throw new NoTeacherFoundException();
        } catch (NoTeacherFoundException ntfe) {
            System.out.println(ntfe.noTeacherFoundMessage);
            return false;
        }
    }

    private static int getStudentEqualId(String studentFullName, ArrayList<Student> students) {
        for (int i = 0; i < students.toArray().length; i++) {
            if (students.get(i) != null) {
                if (students.get(i).isStudent()) {
                    if (studentFullName.equalsIgnoreCase(students.get(i).getName())) {
                        return i;
                    }
                }
            }
        }
        return 0;
    }

    private static boolean isStudentNameEqual(String studentFullName, ArrayList<Student> students) {
        try {
            for (int i = 0; i < students.toArray().length; i++) {
                if (students.get(i) != null) {
                    if (students.get(i).isStudent()) {
                        if (studentFullName.equalsIgnoreCase(students.get(i).getName())) {
                            return true;
                        }
                    }
                }
            }
            throw new NoStudentFoundExceptions();
        } catch (NoStudentFoundExceptions nsfe) {
            System.out.println(nsfe.noStudentFoundMessage);
            return false;
        }
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

    public ArrayList<Department> getDepartments() {
        return departments;
    }
}
