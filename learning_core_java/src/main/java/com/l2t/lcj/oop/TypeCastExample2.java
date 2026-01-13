package com.l2t.lcj.oop;


class M1{}
class M2 extends M1{}
class M3 extends  M2{}
class M4{}
public class TypeCastExample2 {

    public static void main(String[] args) {

        int a = 10;
        float b = a;
        System.out.println(b);
        float c = 20.45f;
        int d = (int) c;
        System.out.println(d);

        M1 obj1 = new M2();


    }
}
