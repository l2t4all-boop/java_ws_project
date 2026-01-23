package com.l2t.lcj.collections;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
class Employee{
    int exp;
}

public class SortElements {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(2,3,1,4,5,6,7,9,8,10));
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(5));
        empList.add(new Employee(10));
        empList.add(new Employee(12));
        empList.add(new Employee(2));
        empList.add(new Employee(3));
        empList.add(new Employee(1));
        Collections.sort(empList, (o1, o2) -> Integer.compare(o2.getExp(), o1.getExp()));
        System.out.println(empList);
    }
}
