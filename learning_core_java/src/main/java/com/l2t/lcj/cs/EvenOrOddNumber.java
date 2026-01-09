package com.l2t.lcj.cs;

import java.util.Scanner;

public class EvenOrOddNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the num: ");
        int num = sc.nextInt();

        if(num % 2 == 0){
            System.out.println("Number "+num+" is even");
        }else{
            System.out.println("Number "+num+" is odd");
        }
    }
}
