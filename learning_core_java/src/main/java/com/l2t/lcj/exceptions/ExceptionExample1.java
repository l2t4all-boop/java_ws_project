package com.l2t.lcj.exceptions;

public class ExceptionExample1 {

    public static void main(String[] args) {
        System.out.println("Start of main method");
        String[] names = getUserNames();
        // Print first 3 characters in upper case

        for (String name : names) {
            try {
                System.out.println(name.substring(0, 3).toUpperCase());
            }catch (StringIndexOutOfBoundsException e){
                System.out.println("Invalid name :"+name);
                System.out.println(e.getMessage());
            }
        }
        System.out.println("End of main method");

    }


    private static String[] getUserNames() {
        return new String[]{"John", "Jane", "Jack", "Jill", "cv", "Chetan"};
    }
}
