package com.l2t.lsj;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionExample {

    public static void main(String[] args) {

        try {
            Class<?> cls = Class.forName("java.lang.String");

            Method[] methods = cls.getMethods();

            for(Method method:methods){
                System.out.println(method);
            }

            Field[] fields = cls.getDeclaredFields();

            for(Field field:fields){
                System.out.println(field);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
