package lesson8.task1;

import lesson8.task1.university.*;

/**
 * Создать вуз с факультетами их курсами, студентами и преподами. Я хочу по имени препода и имени+фамилии студента
 * найти всю инфу по студенту, которую знает универ. Мне не важно, как именно вы реализуете работу самого вуза,
 * главное, чтобы он действительно работал и делал это со здравым смыслом.
 */

public class Main {

    public static void main(String[] args) {
        University bsu = new University("BSU", "Nezavisimosty", "1234567");

        Department mechMath = new Department("MechMath", bsu.getName(), false,  1, 3, 4);
        Department chemistry = new Department("Chemistry", bsu.getName(), false, 1, 2);
        Department philosophy = new Department("Philosophy", bsu.getName(), false, 3, 4);
        Department forDelete = new Department("Delete", bsu.getName(), false, 1);
        bsu.addDepartment(mechMath);
        bsu.addDepartment(chemistry);
        bsu.addDepartment(philosophy);
        bsu.addDepartment(forDelete);
        System.out.println("Department List:");
        bsu.getAllDepart();
        System.out.println("Department #2 - " + bsu.getDepartment(1));
        System.out.println();
        bsu.removeDepartment(3);
        System.out.println("Department List:");
        bsu.getAllDepart();
        System.out.println();

        Course courseMathOne = new Course("Mathematics", mechMath.getName(), 1);
        Course courseChemistry = new Course("Chemistry", chemistry.getName(), 2);
        Course coursePhilosophy = new Course("Philosophy", philosophy.getName(), 3);
        Course courseRights = new Course("Rights", philosophy.getName(), 4);
        Course courseMathTwo = new Course("Mathematics", chemistry.getName(), 5);
        Course.addCourses(courseMathOne);
        Course.addCourses(courseChemistry);
        Course.addCourses(coursePhilosophy);
        Course.addCourses(courseRights);
        Course.addCourses(courseMathTwo);

        Teacher firstTeacher = new Teacher("Valentina", false, mechMath.getName(),
                courseMathOne.getCourseID(), courseMathTwo.getCourseID());
        Teacher secondTeacher = new Teacher("Viktor", false, chemistry.getName(),
                courseMathTwo.getCourseID());
        Teacher thirdTeacher = new Teacher("Tanja", false, philosophy.getName(),
                coursePhilosophy.getCourseID());
        Teacher fourthTeacher = new Teacher("Gena", false, philosophy.getName(),
                courseRights.getCourseID());
        Teacher fifthTeacher = new Teacher("Masha", false, chemistry.getName(),
                courseChemistry.getCourseID());
        Teacher sixthTeacher = new Teacher("Delete", false, chemistry.getName(),
                courseChemistry.getCourseID());
        mechMath.addInstructor(firstTeacher);
        chemistry.addInstructor(secondTeacher);
        chemistry.addInstructor(fifthTeacher);
        philosophy.addInstructor(thirdTeacher);
        philosophy.addInstructor(fourthTeacher);
        chemistry.addInstructor(sixthTeacher);
        System.out.println("Instructors: ");
        Department.getAllInstructor();
        System.out.println();
        chemistry.removeInstructor(5);
        Department.getAllInstructor();
        System.out.println();

        Student firstStudent = new Student("Pasha M", false, mechMath.getName(),
                courseMathOne.getCourseID(),
                coursePhilosophy.getCourseID());
        Student secondStudent = new Student("Misha D", false, chemistry.getName(),
                courseMathTwo.getCourseID());
        Student thirdStudent = new Student("Liza V", false, chemistry.getName(),
                courseChemistry.getCourseID());
        Student fourthStudent = new Student("Nina P", false, philosophy.getName(),
                coursePhilosophy.getCourseID(),
                courseRights.getCourseID());
        Student fifthStudent = new Student("Dima K", false, mechMath.getName(),
                coursePhilosophy.getCourseID(),
                courseRights.getCourseID());
        System.out.println("Admission results:");
        bsu.addStudent(firstStudent);
        bsu.addStudent(secondStudent);
        bsu.addStudent(thirdStudent);
        bsu.addStudent(fourthStudent);
        bsu.addStudent(fifthStudent);
        System.out.println("\nStudents List:");
        bsu.getStudents();
        System.out.println();

        bsu.removeStudent(0);
        System.out.println("\nStudents List:");
        bsu.getStudents();
        System.out.println();

        University.findStudent();
    }
}
