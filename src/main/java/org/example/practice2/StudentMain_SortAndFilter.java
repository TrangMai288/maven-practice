package org.example.practice2;

import java.util.Comparator;
import java.util.List;

public class StudentMain_SortAndFilter {
    public static void main(String[] args) {
        List<Student> students = List.of(
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

        // todo: sort theo name
       List<Student> studentSortByName = students
               .stream()
               .sorted(Comparator.comparing(Student::getName))
               .toList();

       // cach 1:
        for (Student student : studentSortByName) {
            System.out.println(student.getName());
        }

        // cach 2:
        studentSortByName.forEach(student -> System.out.println(student.getName()));

        // cach 3:
        studentSortByName.forEach(Student::printInfo);

        // todo: filter student physics > 5
        List<Student> studentFilterByPhysicsPoint = students
                .stream()
                .filter(student -> student.getPhysics() > 5)
                .toList();
        studentFilterByPhysicsPoint.forEach(student -> System.out.println(student.getPhysics()));

    }
}
