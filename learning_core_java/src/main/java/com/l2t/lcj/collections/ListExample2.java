package com.l2t.lcj.collections;

import java.util.ArrayList;
import java.util.List;

public class ListExample2 {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(4);
        list.add(6);
        list.add(8);
        list.add(10);
        for(Integer num: list){
            System.out.println(num);
        }
        System.out.println(list);
        list.remove(3);
        System.out.println(list);

    }
}
