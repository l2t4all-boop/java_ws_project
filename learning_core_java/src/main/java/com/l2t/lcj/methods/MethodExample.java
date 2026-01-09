package com.l2t.lcj.methods;

import java.time.LocalDateTime;

public class MethodExample {

    public static void main(String[] args) {

        MethodExample obj = new MethodExample();
        System.out.println(obj.sumOfNaturalNumbers(10));
        System.out.println(obj.getOsName());
        obj.showMessage("Welcome to java world");
        obj.showDateTime();

    }

    public int sumOfNaturalNumbers(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public String getOsName() {
        return System.getProperty("os.name");
    }

    public void showMessage(String greetings) {
        System.out.println(greetings.toUpperCase());
    }

    public void showDateTime() {
        System.out.println(LocalDateTime.now());
    }
}
