package com.l2t.lcj.staticex;
import static java.lang.IO.println;
import static java.lang.IO.print;
public class StaticBlockExample {
    static{
        println("IIB-1");
    }
    void main(String... args){
        print("\nMain\n");
    }
    static{
        println("IIB-2");
    }
}
