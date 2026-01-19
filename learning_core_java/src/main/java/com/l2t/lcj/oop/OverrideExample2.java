package com.l2t.lcj.oop;
class CX1{

    int num = 10;
    protected int sum(int a, int b){
       return a + b;
    }
    int prod(int a, int b){
        return a * b;
    }
    int biggest(int a, int b, int c){
        if(a > b && a > c){
            return a;
        }else if(b > c){
            return b;
        }else {
            return c;
        }
    }

}
class CX2 extends  CX1{

    int num = 100;
    @Override
    public int biggest(int a, int b, int c){
        return a > b && a > c ? a : Math.max(b,c);
    }

    public void showResult(int a, int b){
        System.out.println("Sum  :"+sum(a,b));
        System.out.println("Prod :"+prod(a,b));
        System.out.println("Biggest :"+biggest(20,30,50));
        System.out.println("Biggest :"+super.biggest(20,30,50));
        System.out.println("Num :"+num);
        System.out.println("Super num :"+super.num);

    }
}
public class OverrideExample2 {
    public static void main(String[] args) {

            CX2 obj = new CX2();
            obj.showResult(10,20);
    }
}
