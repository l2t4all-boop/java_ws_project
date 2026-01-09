package com.l2t.lcj.methods.one;

public class ClassOne {

    private int pri_num = 10;
    public int pub_num = 20;
    protected  int pro_num = 30;
    int def_num = 40;

    public void show(){
        System.out.println(pri_num);
        System.out.println(pub_num);
        System.out.println(pro_num);
        System.out.println(def_num);
    }

}
