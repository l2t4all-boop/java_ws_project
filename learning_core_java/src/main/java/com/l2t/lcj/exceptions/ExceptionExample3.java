package com.l2t.lcj.exceptions;

public class ExceptionExample3 {

    public static void main(String[] args) {
        System.out.println("Start of main");
        try {
            int num1 = 10;
            int num2 = 0;
            int res = num1 / num2;
            System.out.println(res);

        } catch (Exception e) {
            System.out.println("I am from catch");
            e.printStackTrace();
        } finally {
            System.out.println("I am from finally");
        }
        System.out.println("End of main");
    }
}
