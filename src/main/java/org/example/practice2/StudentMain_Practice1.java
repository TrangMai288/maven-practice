package org.example.practice2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentMain_Practice1 {
    public static List<Student> students = List.of(
            new Student("Trang1"),
            new Student("Trang2"),
            new Student("Trang3"),
            new Student("Trang4"),
            new Student("Trang5"),
            new Student("Trang6"),
            new Student("Trang7"),
            new Student("Trang8"),
            new Student("Trang9"),
            new Student("Trang10")
    );

    public static void main(String[] args) {
        // todo: lay ra tong diem 3 mon cua cac hoc sinh
        List<Integer> totalPointOfStudents = students
                .stream()
                .map(Student::getTotalPoint)
                .toList();
        System.out.println("====== Total Point Of Students ======");
        for (Integer totalPointOfStudent : totalPointOfStudents) {
            System.out.println(totalPointOfStudent);
        }

        // todo: sort theo ten
        List<Student> nameOfStudents = students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        System.out.println("====== Sort Student By Name ======");
        nameOfStudents.forEach(student -> System.out.println(student.getName()));

        // todo: sort theo diem tung mon
        List<Student> sortByMathPoints = students
                .stream()
                .sorted(Comparator.comparing(Student::getMath))
                .toList();
        System.out.println("====== Sort Student By Math Points ======");
        sortByMathPoints.forEach(Student::printInfo);

        // todo: sort theo tong diem 3 mon
        List<Student> sortByTotalPoints = students
                .stream()
                .sorted(Comparator.comparing(Student::getTotalPoint))
                .toList();
        System.out.println("====== Sort By Total Points ======");
        sortByTotalPoints.forEach(Student::printTotalPoint);

        // todo: in ra danh sach cac student
        System.out.println("====== Print List Student ======");
        students.forEach(Student::printInfo);

        // todo: tim student co diem mon Toan (math) cao nhat
        Student studentHasMaxMathPoint = students
                .stream()
                .max(Comparator.comparing(Student::getMath))
                .get();
        System.out.println("====== Student Has Max Math Point ======");
        studentHasMaxMathPoint.printInfo();

        // todo: get list of math point
        List<Integer> listMathPoint1 = students
                .stream()
                .map(Student::getMath)
                .toList();
        System.out.println("====== List Of Math Point ======");
        for (Integer mathPoint : listMathPoint1) {
            System.out.println(mathPoint);
        }

        // todo: sort theo name
        List<Student> studentSortByName = students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        System.out.println("====== Sort Student By Name ======");
        studentSortByName.forEach(Student::printInfo);

        // todo: filter student physics > 5
        List<Student> studentFilterByPhysicsPoint = students
                .stream()
                .filter(student -> student.getPhysics() > 5)
                .toList();
        System.out.println("====== Filter By Physics Point ======");
        studentFilterByPhysicsPoint.forEach(student -> System.out.println(student.getPhysics()));
        studentFilterByPhysicsPoint.forEach(Student::printInfo);

        // todo: get list student
        List<Student> studentList = students
                .stream()
                .toList();
        System.out.println("====== List Student ======");
        studentList.forEach(Student::printInfo);
    }
}
