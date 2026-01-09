package com.l2t.lcj.basics;


import java.util.Scanner;

/**
 * EMI Calculator Formula
 * Here's the formula to calculate EMI:
 *
 * E = [P x R x (1+R) ^N] / [(1+R) ^ (N-1)]
 *
 * Where,
 *
 * E = EMI
 * P = Principal Amount
 * R = Rate of interest. This is calculated on a monthly basis. If the interest rate is 4% per annum then R will be 4/12/100 = 0.0033.
 * N = Duration in months
 */
public class EmiCalculator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Principal Amount  :");
        double P = sc.nextDouble();
        System.out.println("Enter the rate of interest  :");
        double ri = sc.nextDouble();
        double R = ri / 12 / 100;
        System.out.println("Enter the duration in months :");
        int N = sc.nextInt();

        double E =  (P * R * Math.pow(1+R,N)) / (Math.pow(1+R,N) -1);

        double totalAmount = E * N;
        double interestPaid = totalAmount - P;
        System.out.println("Principal amount :"+Math.round(P));
        System.out.println("EMI amount       :"+Math.round(E));
        System.out.println("Interest paid    :"+Math.round(interestPaid));
        System.out.println("Total amount paid :"+Math.round(totalAmount));


    }
}
