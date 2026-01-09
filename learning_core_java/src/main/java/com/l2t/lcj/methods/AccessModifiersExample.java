package com.l2t.lcj.methods;

class One{
     int num1 = 10;
}
class Two extends One{
    int num2 = 20;
}
public class AccessModifiersExample {

    public static void main(String[] args) {
        Two obj = new Two();
        System.out.println(obj.num1);
        System.out.println(obj.num2);
    }
}
