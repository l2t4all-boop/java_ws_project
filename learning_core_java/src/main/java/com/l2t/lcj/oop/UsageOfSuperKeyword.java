package com.l2t.lcj.oop;

class One{
    One(int i){
        System.out.println("one");
    }
}
class Two extends  One{
    Two(int i){
        super(i);
        System.out.println("two");
    }

}
class Three extends  Two{
    Three(int i){
        super(i);
        System.out.println("three");
    }
}


public class UsageOfSuperKeyword {

    public static void main(String[] args) {
          One obj = new Three(10);


    }
}
