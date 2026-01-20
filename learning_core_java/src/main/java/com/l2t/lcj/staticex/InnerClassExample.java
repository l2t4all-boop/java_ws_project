package com.l2t.lcj.staticex;

class Outer{
    private static final int NUM = 10;
    static class Inner{
        public void show(){
            System.out.println(NUM);
        }
    }
}
public class InnerClassExample {

    public static void main(String[] args) {
        Outer.Inner ref = new Outer.Inner();
        ref.show();
    }
}
