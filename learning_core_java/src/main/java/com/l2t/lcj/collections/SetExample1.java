package com.l2t.lcj.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetExample1 {

    public static void main(String[] args) {

        Set<String> names = new HashSet<>();
        names.add("Krish");
        names.add("Charan");
        names.add("Balu");
        names.add("Rakesh");
        names.add("Krish");
        System.out.println(names);

        for(String name:names){
            System.out.println(name);
        }

        Iterator<String> iterator = names.iterator();
        while(iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }

        names.forEach(System.out::println);
    }
}
