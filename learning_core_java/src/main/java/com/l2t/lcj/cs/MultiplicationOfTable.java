package com.l2t.lcj.cs;

public class MultiplicationOfTable {

    public static void main(String[] args) {

        for (int l = 1; l <= 20; l++) {
            int num = l;
            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " * " + i + " = " + num * i);
            }
            System.out.println("*".repeat(30));
        }
    }
}
