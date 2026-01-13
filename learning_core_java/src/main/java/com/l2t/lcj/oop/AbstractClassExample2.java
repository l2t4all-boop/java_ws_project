package com.l2t.lcj.oop;

abstract class AbsOne{
    abstract  void m1();
    abstract public void m2();
    void m3(){
       m1();
       m2();
    }
}
class CTwo extends AbsOne{
     public void m1(){}
     public void m2(){}
}
public class AbstractClassExample2 {

    public static void main(String[] args) {
        AbsOne obj = new CTwo();
        obj.m1();
        obj.m2();
    }
}
