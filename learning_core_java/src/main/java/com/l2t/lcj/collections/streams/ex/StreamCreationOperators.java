package com.l2t.lcj.collections.streams.ex;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamCreationOperators {

    public static void main(String[] args) {

        // 1. Stream.of() creates a stream from values
        Stream<String> stream = Stream.of("A","B","C","D");
        System.out.println("Stream of(): ");
        stream.forEach(System.out::println);

        // 2. Collection.stream() - from collections

        List<Integer> list = List.of(1,2,3,4,5);
        Stream<Integer> stream2 = list.stream();
        System.out.println(stream2.toList());

        // 3. Arrays.stream() - from arrays

        String[] arr = {"Java","Python","JavaScript","TypeScript"};
        Stream<String> stream3 = Arrays.stream(arr);
        stream3.forEach(System.out::println);

        // 4. Stream.builder() - from builder

        Stream<String> stream4 = Stream.<String>builder()
                .add("Java")
                .add("Python")
                .add(".Net")
                .build();
        stream4.forEach(System.out::println);

        // 5. Stream.iterate() - from iterate

        Stream<Integer> stream5 = Stream.iterate(1, n -> n + 1);
        stream5.limit(10).forEach(System.out::println);

        // 6. Stream.range() - from range

        IntStream stream6 = IntStream.range(10,1000);
        stream6.forEach(System.out::println);

        Stream<Integer> evenStream = Stream.of(2,4,6,8,10,12);
        Stream<Integer> oddStream = Stream.of(1,3,5,7,9,11);

        Stream<Integer> mergedStream = Stream.concat(evenStream, oddStream);

        mergedStream.sorted().forEach(ele-> System.out.print(ele+" "));


    }
}
