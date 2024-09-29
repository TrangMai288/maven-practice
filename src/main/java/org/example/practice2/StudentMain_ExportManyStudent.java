package org.example.practice2;

import java.util.Comparator;
import java.util.List;

public class StudentMain_ExportManyStudent {
    /*
     * Tao 1 danh sach 10 student
     * tim student co diem mon Toan (math) cao nhat
     */
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

        // todo: in ra danh sach cac student
        for (Student student : students) {
            student.printInfo();
            System.out.println("===========");
        }

        // todo: tim student co diem mon Toan (math) cao nhat
        Student studentMaxMath = students
                .stream()
                .max(Comparator.comparing(Student::getMath))
                .get();

        System.out.println("=== Max math ===");
        studentMaxMath.printInfo();

        // todo: get list of math point
        List<Integer> listMathPoint = students
                .stream()
                .map(Student::getMath)
                .toList();
        for (int mathPoint : listMathPoint) {
            System.out.println(mathPoint);
        }
    }
}
