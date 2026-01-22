package com.l2t.lcj.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample4 {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student("1001", "Krish"));
        students.add(new Student("1002", "Manoj"));
        students.add(new Student("1003", "Charan"));
        students.add(new Student("1004", "Krish"));

        for (Student student : students) {
            System.out.println(student.getUsn());
        }
    }
}
