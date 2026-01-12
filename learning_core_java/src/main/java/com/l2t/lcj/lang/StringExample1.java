package com.l2t.lcj.lang;

public class StringExample1 {
    public static void main(String[] args) {

            String str1 = "CoreJava";
            String str2 = "CoreJava";

            System.out.println(str1 == str2);

            String str3 = new String("CoreJava");
            String str4 = new String("CoreJava");

            System.out.println(str3 == str4);
            System.out.println(str3.equals(str4));
            System.out.println(str1.equals(str3));

            String data = "Hello";
            System.out.println(data.concat(" world"));
            System.out.println(data);


            String s1 = "Hello".concat(" World");
            String s2 = "Hello".concat(" World");
            System.out.println(s1.equals(s2));
            System.out.println(s1 == s2);
    }
}
