package com.l2t.lcj.oop;

interface EI1{
    int num =10;
}

interface I1 {
    void m1();

    void m2();

    void m3();
}

interface I2 {
    void m1();

    void m4();
}

class CI1 implements I1, I2 {

    @Override
    public void m1() {
        System.out.println("M1");
    }

    @Override
    public void m4() {
        System.out.println("M4");
    }

    @Override
    public void m2() {
        System.out.println("M2");
    }

    @Override
    public void m3() {
        System.out.println("M3");
    }
}

public class InterfaceExample2 {

    public static void main(String[] args) {
        I1 obj = new CI1();
        obj.m1();
        obj.m2();
        obj.m3();

        I2 obj1 = new CI1();
        obj1.m1();

    }
}
