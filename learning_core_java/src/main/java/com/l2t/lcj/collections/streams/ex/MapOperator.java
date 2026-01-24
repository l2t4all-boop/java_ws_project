package com.l2t.lcj.collections.streams.ex;

import java.util.List;
import java.util.stream.Stream;

public class MapOperator {
    public static void main(String[] args) {

        String names = "John, Jane, Jack, Jill , Krishna, Kishore, Mohan";

        String[] arr = names.split(",");


        List<String> list = Stream.of(arr)
                .map(String::trim)
                .map(String::toUpperCase)
                .filter(name -> name.startsWith("J"))
                .map(name -> name.substring(0, 3))
                .toList();
        System.out.println(list);

    }
}
