package com.l2t.lcj.oop;

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        Student student = new Student("Anish");
        System.out.println(student);
    }
}
