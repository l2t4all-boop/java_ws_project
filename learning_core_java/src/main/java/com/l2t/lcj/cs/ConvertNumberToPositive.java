package com.l2t.lcj.cs;

import java.util.Scanner;

public class ConvertNumberToPositive {

    public static void main(String[] args) {
        System.out.println("Enter your age :");
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        if (age < 0) {
            age = -age;
        }
        System.out.println("Entered age is :" + age);

    }
}
