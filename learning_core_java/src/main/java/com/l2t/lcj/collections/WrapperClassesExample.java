package com.l2t.lcj.collections;

public class WrapperClassesExample {
    public static void main(String[] args) {

        // id, name,salary,age
        String data = "1001,Krish,56998.90,28";

        String[] arr = data.split(",");
        int id = Integer.parseInt(arr[0]);
        String name = arr[1];
        double salary = Double.parseDouble(arr[2]);
        int age = Integer.parseInt(arr[3]);
        System.out.println("Id " + id);
        System.out.println("Name " + name);
        System.out.println("Age " + age);
        System.out.println("Salary " + salary);

        int num = 15;
        System.out.println(Integer.toBinaryString(num));

        // Casting, Parsing, Boxing, Unboxing

        float num1 = 12.25f;
        int num2 = (int)num1; // Type casting

        int num3 = 30;
        float num4 = num3; // Type casting

        String strNum = "125";

        int num5 = Integer.parseInt(strNum); // Parsing

        int num6 = 100;
        Integer num7 = num6; // Boxing
        int num8 = num7; // Unboxing
        System.out.println(num8);

    }

    public static int sum(int a, int b){
        return a + b;
    }
}
