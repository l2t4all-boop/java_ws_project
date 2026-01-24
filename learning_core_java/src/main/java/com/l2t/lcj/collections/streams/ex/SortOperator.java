package com.l2t.lcj.collections.streams.ex;

import java.util.Comparator;
import java.util.List;

record Invoice(String invoiceNumber,int month,String customerName, double amount){
}

public class SortOperator {

    public static void main(String[] args) {

        List<Integer> numbers = List.of(10, 20, 15, 85, 25, 55, 5, 25, 30, 35, 40, 45, 50);

        numbers.stream()
                .sorted()
                .forEach(ele -> System.out.print(ele + " "));
        // descending order
        System.out.println();
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(ele -> System.out.print(ele + " "));

        System.out.println();
        List<Invoice> invoices =
                List.of(
                        new Invoice("J-2026-1",1,"Infy",45000),
                        new Invoice("J-2026-3",1,"Dell",85000),
                        new Invoice("J-2026-2",2,"Infy",95000),
                        new Invoice("J-2026-5",3,"Infy",25000),
                        new Invoice("J-2026-4",2, "Dell",65000),
                        new Invoice("J-2026-6",3, "Dell",75000));
                // Sort by amount, month, customer name

        invoices.stream()
                .sorted(Comparator.comparing(Invoice::amount).reversed()
                        .thenComparing(Invoice::month)
                        .thenComparing(Invoice::customerName))
                .forEach(System.out::println);
    }
}
