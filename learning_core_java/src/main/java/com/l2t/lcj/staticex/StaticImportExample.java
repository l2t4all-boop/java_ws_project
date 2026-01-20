package com.l2t.lcj.staticex;
import static java.lang.Math.*;
import static java.lang.System.*;
import static com.l2t.lcj.staticex.M.*;
import static java.lang.IO.*;
public class StaticImportExample {
    public static void main(String[] args) {
        M.println(PI);
        IO.println(E);
        M.println(sqrt(9));
        M.println(max(3,5));
    }
}
