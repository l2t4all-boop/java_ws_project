package com.l2t.lcj.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample3 {
    public static void main(String[] args) {

            List<Integer> list = new ArrayList<>();
            list.add(1001);
            list.add(1010);
            list.add(1020);
            list.add(1030);
            list.remove(Integer.valueOf(1010));
            System.out.println(list);

            List<Integer> evenNumbers = List.of(2,4,6,8,10);
            List<Integer> oddNumbers = List.of(1,3,5,7,9);

            List<Integer> numbers = new ArrayList<>();
            numbers.addAll(evenNumbers);
            numbers.addAll(oddNumbers);
            System.out.println(numbers);

            List<String> dayNames = List.of("Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday");
            List<String> workingDays = List.of("Friday","Thursday");

            if(dayNames.containsAll(workingDays)){
                System.out.println("Yes");
            }
    }
}
