package com.l2t.lcj.oop;

abstract class AbstractNumberOperations {
    public abstract boolean isPrime(int num);

    public int primeCount(int lb, int ub) {
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i))
                count++;
        }
        return count;
    }
}

class NumberOperations extends AbstractNumberOperations {
    public boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}

public class AbstractClassExample {

    public static void main(String[] args) {

        AbstractNumberOperations obj = new NumberOperations();

        int count = obj.primeCount(101, 10000);
        System.out.println(count);

    }
}
