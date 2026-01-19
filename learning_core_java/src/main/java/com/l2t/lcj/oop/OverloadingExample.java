package com.l2t.lcj.oop;

class MyMathCls {

    public double sum(double... arr) {
        double res = 0;
        for(double i:arr) {
            res += i;
        }
        return res;
    }

    public int sum(int... arr){
        int res = 0;
        for(int i:arr) {
            res += i;
        }
        return res;
    }

}

public class OverloadingExample {

    public static void main(String... args) {
        MyMathCls obj = new MyMathCls();
        int res = obj.sum(1,2,3,4,5,6);
        System.out.println(res);
        for(String arg: args){
            System.out.println(arg);
        }
    }
}
