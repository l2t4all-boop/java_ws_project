package com.l2t.lcj.staticex;

import static java.lang.IO.println;

public class StaticMethodExamples {

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

    void main(String... args){
        int num = 123321;
        StringBuilder sb = new StringBuilder();
        sb.append("Reverse of ")
                .append(num)
                .append(" is ")
                .append(reverse(num))
                .append(" and is palindrome ? ")
                .append(isPalindrome(num));
        println(sb);
    }
}
