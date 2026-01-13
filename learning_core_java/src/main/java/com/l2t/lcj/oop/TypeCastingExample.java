package com.l2t.lcj.oop;

import java.util.concurrent.ThreadLocalRandom;

class C1 {
    int num = 10;

    void m1() {
        System.out.println("C1 of M1");
    }
}

class C2 extends C1 {
    int num = 20;

    void m1() {
        System.out.println("C2 of M1");
    }

    void m2() {
        System.out.println("C2 of M2");
    }

}

class C3 extends C1 {
    int num = 20;

    void m1() {
        System.out.println("C3 of M1");
    }

    void m2() {
        System.out.println("C3 of M2");
    }

    void m3() {
        System.out.println("C3 of M3");
    }

}

public class TypeCastingExample {

    public static void main(String[] args) {
        C1 obj = getInstanceType();

        if (obj instanceof C3 ref) {
            ref.m1();
            ref.m2();
            ref.m3();
        } else if (obj instanceof C2 ref) {
            ref.m1();
            ref.m2();
        }


    }

    private static C1 getInstanceType() {
        int num = ThreadLocalRandom.current().nextInt();
        if (num % 2 == 0) {
            return new C2();
        } else {
            return new C3();
        }
    }
}
