package org.example.practice2;

import java.util.Comparator;
import java.util.List;

public class StudentMain_Practice {
    /*
     * cong diem 3 mon lai
     * sort theo ten
     * sort theo diem tung mon
     * sort theo tong diem 3 mon
     */

    public static void main(String[] args) {
        // todo: lay ra tong diem 3 mon cua cac hoc sinh
        List<Integer> totalPointOfStudents = StudentMain_ExportManyStudent
                .students
                .stream()
                .map(Student::getTotalPoint)
                .toList();
        System.out.println("====== Total Point Of Students ======");
        for (Integer totalPointOfStudent : totalPointOfStudents) {
            System.out.println(totalPointOfStudent);
        }

        // todo: sort theo ten
        List<Student> studentsSortByName = StudentMain_ExportManyStudent
                .students
                .stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        System.out.println("====== Sort By Name ======");
        studentsSortByName.forEach(Student::printInfo);

        // todo: sort theo diem tung mon
        List<Student> sortByMathPoint = StudentMain_ExportManyStudent
                .students
                .stream()
                .sorted(Comparator.comparing(Student::getMath))
                .toList();
        System.out.println("====== Sort By Math Point ======");
        sortByMathPoint.forEach(Student::printInfo);

        // todo: sort theo tong diem 3 mon
        List<Student> studentsGetTotalPoint = StudentMain_ExportManyStudent
                .students
                .stream()
                .sorted(Comparator.comparing(Student::getTotalPoint))
                .toList();
        System.out.println("====== Sort By Total Point ======");
        studentsGetTotalPoint.forEach(Student::printTotalPoint);
    }
}
