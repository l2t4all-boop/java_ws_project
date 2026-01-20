package com.l2t.lcj.staticex;

interface MathOperation{
    int perform(int a, int b);
}

interface CalculateResult{
    int result(int a, int b, MathOperation ref);
}

class MyCalResult implements CalculateResult{
    @Override
    public int result(int a, int b, MathOperation ref) {
        return ref.perform(a,b);
    }
}

public class InnerClassDemo {
    public static void main(String[] args) {
        CalculateResult calResult = new MyCalResult();
        int res = calResult.result(10,20, new MathOperation(){
            @Override
            public int perform(int a, int b) {
                return a * b;
            }
        });
        System.out.println("Result :"+res);
    }
}
