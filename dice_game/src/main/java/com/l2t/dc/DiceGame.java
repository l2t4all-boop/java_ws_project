package com.l2t.dc;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class DiceGame {
    public static void main(String[] args) {

        int genNumber = ThreadLocalRandom.current().nextInt(1, 7);
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 3; i++) {
            System.out.println("Guess the number :");
            int num = sc.nextInt();
            if (num == genNumber) {
                System.out.println("You guessed number in " + i + " attempts");
                break;
            } else {
                if (i == 3) {
                    System.out.println("Sorry! you reached max number of attempts, the number is " + genNumber);
                }
            }
        }

    }
}
