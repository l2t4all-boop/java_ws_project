package com.l2t.lcj.collections.streams.ex;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class MapToIntFloatDoubleExample {

    public static void main(String[] args) {

        List<String> numbers = List.of("10", "20", "30", "40", "50");

        int sum =
                numbers
                        .stream()
                        .mapToInt(Integer::parseInt)
                        .sum();
        System.out.println(sum);
        List<Double> prices = List.of(10.5, 20.5, 30.5, 40.5, 50.5, 20.5, 30.5, 40.5, 50.5, 60.5);

        DoubleSummaryStatistics stats =
                prices.stream()
                        .mapToDouble(Double::doubleValue)
                        .summaryStatistics();

    }
}
