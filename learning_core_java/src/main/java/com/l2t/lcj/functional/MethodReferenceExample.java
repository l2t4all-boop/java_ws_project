package com.l2t.lcj.functional;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

class C1{

        String showValue(){
           return "Welcome to java world";
        }
}

public class MethodReferenceExample {

    public static void main(String[] args) {

        Function<String,Integer> fun = Integer::parseInt;
        Consumer<String> consumer = System.out::println;
        System.out.println(fun.apply("1234") + 3);
        consumer.accept("Hello world");

        String message = "welcome to java world";
        C1 obj = new C1();
        Supplier<String> supplier = obj::showValue;
        System.out.println(supplier.get());
        Supplier<String> supplier1 =  String::new;
    }
}
