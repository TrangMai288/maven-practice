package org.example.practice2;

import java.util.Random;

public class Student {
    /*
     * Tao 1 class Student voi cac thuoc tinh
     * Name
     * Id => random 1 chuoi prefix TVN-<number>
     * Math: 0-10
     * Physic: 0-10
     * Chemistry: 0-10
     * Constructor: new Student(String name)
     */
    private String name;
    private String id;
    private int math;
    private int physics;
    private int chemistry;

    public Student(String name) {
        this.name = name;
        Random generator = new Random();
        this.id = "TVN-" + generator.nextInt(1000);
        this.math = generator.nextInt(10);
        this.physics = generator.nextInt(10);
        this.chemistry = generator.nextInt(10);
    }

    public void printInfo() {
        System.out.printf("Student name is %s\n", this.name);
        System.out.printf("Student id is %s\n", this.id);
        System.out.printf("Math: %d\n", this.math);
        System.out.printf("Physics: %d\n", this.physics);
        System.out.printf("Chemistry: %d\n", this.chemistry);
    }

    public int getTotalPoint() {
        return this.math + this.physics + this.chemistry;
    }

    public void printTotalPoint() {
        System.out.printf("Student name is %s\n", this.name);
        System.out.printf("Student id is %s\n", this.id);
        System.out.printf("Total Point: %d\n", getTotalPoint());
    }

    public String getName() {
        return name;
    }

    public int getMath() {
        return math;
    }

    public int getPhysics() {
        return physics;
    }

    public int getChemistry() {
        return chemistry;
    }
}
