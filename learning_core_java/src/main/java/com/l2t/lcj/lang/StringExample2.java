package com.l2t.lcj.lang;

public class StringExample2 {

    public static void main(String[] args) {

        String usn = "OX3060";
        String name = "Krish";
        String sem = "4";
        String email = "krish@gmail.com";

        // String Buffer, String Builder

        StringBuilder sb = new StringBuilder();
        sb.append(usn)
                .append(",")
                .append(name)
                .append(",")
                .append(sem)
                .append(",")
                .append(email);
        System.out.println(sb);
    }
}
