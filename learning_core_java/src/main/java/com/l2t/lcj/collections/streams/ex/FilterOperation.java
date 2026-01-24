package com.l2t.lcj.collections.streams.ex;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


record Employee(int id, String name, int salary){}

public class FilterOperation {

    public static void main(String[] args) {

        IntStream list = IntStream.rangeClosed(10, 100);

        // Get numbers which are divisible by 2 and 3 and collect into another list

        List<Integer> filteredList = list
                .filter(i -> i % 2 == 0 && i % 3 == 0)
                .boxed()
                .toList();
        System.out.println(filteredList);


        List<Employee> employees =
                List.of(
                        new Employee(1001,"Krish",50000),
                        new Employee(1002,"John",60000),
                        new Employee(1003,"Jane",70000),
                        new Employee(1004,"Jack",80000),
                        new Employee(1005,"Jill",90000));
        // Get employees who are earning more than 60000 show only their names

        List<String> names = employees.stream()
                .filter(e -> e.salary() > 60000) // Stream<Employee>
                .map(Employee::name) // Stream<String>
                .toList();
        System.out.println(names);

    }
}
