package com.l2t.lcj.lang;

public class StringExample3 {

    public static void main(String[] args) {

        String data = "12321";
        StringBuilder sb = new StringBuilder(data);
        System.out.println(data.contentEquals(sb.reverse()));
    }
}
