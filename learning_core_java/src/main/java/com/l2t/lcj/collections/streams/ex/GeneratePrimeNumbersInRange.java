package com.l2t.lcj.collections.streams.ex;

import java.util.stream.IntStream;

public class GeneratePrimeNumbersInRange {

    public static void main(String[] args) {
            int lb = 100;
            int ub = 1000;
            IntStream.rangeClosed(lb, ub)
                    .filter(GeneratePrimeNumbersInRange::isPrime)
                    .forEach(System.out::println);
    }

    private static boolean isPrime(int i) {
        // TODO need to implement logic
        return false;
    }
}
