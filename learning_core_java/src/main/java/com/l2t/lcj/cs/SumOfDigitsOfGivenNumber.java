package com.l2t.lcj.cs;

public class SumOfDigitsOfGivenNumber {

    // 1982 => 1 +  9 + 8 + 2

    public static void main(String[] args) {
        int num = 1982;
        int temp = num;
        int sum = 0;
        while (temp != 0) {
            int r = temp % 10;
            sum += r;
            temp /= 10;
        }
        System.out.println("The sum of digits of given number " + num + " is  :" + sum);
    }

}
