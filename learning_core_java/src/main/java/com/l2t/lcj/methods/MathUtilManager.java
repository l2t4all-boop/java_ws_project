package com.l2t.lcj.methods;

import java.util.Arrays;

public class MathUtilManager {

    public static void main(String[] args) {

        int[] primes = MathUtils.getPrimes(10, 200);
        System.out.println(Arrays.toString(primes));
    }
}
