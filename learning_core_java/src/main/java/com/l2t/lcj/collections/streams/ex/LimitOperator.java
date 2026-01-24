package com.l2t.lcj.collections.streams.ex;

import java.util.stream.IntStream;

public class LimitOperator {

    public static void main(String[] args) {

        IntStream.rangeClosed(10, 100)
                .skip(81)
                .limit(10)
                .forEach(System.out::println);
    }
}
