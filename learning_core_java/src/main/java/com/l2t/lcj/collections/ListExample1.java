package com.l2t.lcj.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListExample1 {

    void main(String... args) {

        List<String> names = new ArrayList<>();
        names.add("Krish");
        names.add("Manoj");
        names.add("Charan");
        names.add("Krish");

        // Process element from the list using index based
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }

        // Using for each loop
        System.out.println("-".repeat(30));
        for (String name : names) {
            System.out.println(name);
        }

        // Java 8
        System.out.println("-".repeat(30));
        names.forEach(System.out::println);

        // Iterator and list iterator interface
        System.out.println("-".repeat(30));

        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
            if(name.startsWith("Z")){
                iterator.remove();
            }
        }
        System.out.println(names);

        ListIterator<String> listIterator = names.listIterator();

        while(listIterator.hasNext()){
            String name = listIterator.next();
            if(name.equalsIgnoreCase("Manoj")){
                listIterator.add("John Doe");
            }
            System.out.println(name);
        }
        System.out.println("....................");
        while(listIterator.hasPrevious()){
            String name = listIterator.previous();
            System.out.println(name);
        }
    }
}
