package com.l2t.lcj.oop;

class One1{
    int num1 = 1;
    public void showValues(){
        System.out.println(num1);
    }
}
class Two2 extends  One1{
    int num1 = 10;
    int num2 = 20;
    public void showValues(){
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(super.num1);
    }
}
class Three3 extends  Two2{
    int num1 = 100;
    int num2 = 200;
    int num3 = 300;
    @Override
    public void showValues(){
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        super.showValues();
    }
}
public class OverrideExample3 {

    public static void main(String[] args) {
        One1 obj = new Three3();
        obj.showValues();
    }
}
