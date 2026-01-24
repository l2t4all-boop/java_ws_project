package com.l2t.lcj.collections.streams.ex;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


record Faculty(String dept,List<String> names){
}

public class FlatMapOperator {

    public static void main(String[] args) {

        List<List<Integer>> nestedList = List.of(
                List.of(1,2,3),
                List.of(4,5,6),
                List.of(7,8,9));
        // List should have 1,2, 3, 4, 5, 6, 7, 8, 9

        List<Integer> list = nestedList.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(list);

        List<String> sentences = List.of(
                "Java Collections with stream apis",
                "Java lambda expression",
                "Java exception handling with try catch throw throws finally");

        List<String> words =
                sentences
                        .stream()
                        .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
                        .toList();
        System.out.println(words);

        List<Faculty> faculties = List.of(
                new Faculty("CSE", List.of("John", "Jane", "Jack", "Jill")),
                new Faculty("ECE", List.of("Krish", "Kishore", "John")),
                new Faculty("EEE", List.of("Ravi", "John", "Ravi", "Raj", "Ravi", "Raj")),
                new Faculty("MECH", List.of("Ravi", "John", "Ravi", "Raj", "Ravi", "Raj")));


        // Get unique faculty names from faculties list

        List<String> uniqueNames = faculties.stream()
                .flatMap(faculty -> faculty.names().stream())
                .distinct()
                .toList();
        System.out.println(uniqueNames);
    }
}
