package com.l2t.lcj.cs;

import java.util.Scanner;

public class SwitchStatement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter the num1 :");
            int num1 = sc.nextInt();
            System.out.println("Enter the num2 :");
            int num2 = sc.nextInt();
            System.out.println("1.Add 2.Sub 3.Mul 4.Div 5.Mod");
            System.out.println("Enter the choice:");
            int choice = sc.nextInt();
            double res = getResult(num1,num2,choice);
            System.out.println("Result :"+res);
            sc.nextLine();
            System.out.println("Do you want to continue ?");
            String response = sc.nextLine();
            if(!response.equalsIgnoreCase("yes")){
                break;
            }
        }
    }

    private static double getResult(int num1, int num2, int choice) {
         return switch (choice) {
             case 1 -> num1 + num2;
             case 2 -> num1 - num2;
             case 3 -> num1 * num2;
             case 4 -> num1 / (num2 * 1.0);
             case 5 -> num1 % num2;
             default -> 0.0;
         };

    }
}
