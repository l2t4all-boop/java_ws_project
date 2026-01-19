package com.l2t.lcj.oop;

final class CF3{

    private CF3(){
    }
    public static int reverse(int num){
        //LOGIC
        return 0;
    }
    public static int sumOfDigits(int num){
        // LOGIC
        return 0;
    }

}
class CF1{

    final public boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i=2;i<=num/2;i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
    public int[] getPrimes(int lb,int ub){
        return null;
    }

    public boolean isPalindrome(int num){
        int rev = CF3.reverse(num);
        return rev == num;
    }

}
class CF2 extends CF1{


    public int[] getPrimes(int lb,int ub){
        int count = getPrimeCount(lb,ub);
        int[] arr = new int[count];

        // Logic
        return arr;
    }

    private int getPrimeCount(int lb, int ub) {
       int count = 0;
       for(int i=lb;i<=ub;i++){
           if(isPrime(i)){
               count++;
           }
       }
       return count;
    }
}

public class FinalExample {

    final int DAYS_IN_WEEK = 7;
    public FinalExample(){}

    public final static void main(String[] args) {
        FinalExample obj = new FinalExample();
        System.out.println(obj.DAYS_IN_WEEK);
    }
}
