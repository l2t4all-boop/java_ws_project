package com.l2t.lcj.lang;

public class Greetings extends Object {

    public static void main(String[] args) {
        Greetings obj = new Greetings();
        System.out.println(obj.getClass().getName());
        System.out.println(Integer.toHexString(obj.hashCode()));
        System.out.println(obj.toString());
    }
}
