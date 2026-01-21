package com.l2t.lcj.functional;


import java.util.function.BiFunction;

class Calculator{
    int cal(int a, int b, BiFunction<Integer, Integer, Integer> operation){
        return operation.apply(a,b);
    }
}

public class FunctionInterfaceWithLambdaExample {

    public static void main(String[] args) {
        int num1 = 100;
        int num2 = 10;
        Calculator calculator = new Calculator();
        int res = calculator.cal(num1, num2, (a, b) -> a + b);
        System.out.println("Result :"+res);
    }
}
