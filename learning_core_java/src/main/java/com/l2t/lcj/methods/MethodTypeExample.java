package com.l2t.lcj.methods;

public class MethodTypeExample {
    // class method
    // instance methods

    public void greet(String message){
        System.out.println(message);
    }

    public static void greetings(String message){
        System.out.println(message);
    }

    public static void main(String[] args) {
         MethodTypeExample obj = new MethodTypeExample();
         obj.greet("Welcome to java world!");
         greetings("Welcome to java world!");
    }
}
