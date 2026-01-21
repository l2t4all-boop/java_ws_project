package com.l2t.lcj.functional;

import java.util.function.Predicate;



public class LambdaExample {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,11,15,13,25,34,90,101,20,25};
        System.out.println("Even numbers: " + getCounts(arr,num -> num % 2 == 0));
        System.out.println("Odd numbers: " + getCounts(arr,num -> num % 2 != 0));
        System.out.println("Prime numbers: " + getCounts(arr, LambdaExample::isPrime));

    }


    public static int getCounts(int[] arr, Predicate<Integer> predicate){
        int count = 0;
        for(int num:arr){
            if(predicate.test(num)){
                count++;
            }
        }
        return count;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

}
