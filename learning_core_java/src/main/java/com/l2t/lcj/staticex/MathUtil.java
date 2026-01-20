package com.l2t.lcj.staticex;


public final class MathUtil {

    private MathUtil(){
    }

    public static int reverse(int num){
        int rev = 0;
        while(num != 0){
            rev = rev * 10 + num % 10;
            num /= 10;
        }
        return rev;
    }

    public static boolean isPalindrome(int num){
        return reverse(num) == num;
    }

    public static int sumOfDigits(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int sumOfDigitsUntilSingleDigit(int num){
        int sum = 0;
        while(num >= 10){
            sum += sumOfDigits(num);
            num = sumOfDigits(num);
        }
        return sum + num;
    }

}
