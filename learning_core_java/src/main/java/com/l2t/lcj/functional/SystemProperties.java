package com.l2t.lcj.functional;

import java.util.Properties;

public class SystemProperties {
    public static void main(String[] args) {
        Properties props = System.getProperties();
        
        System.out.println("All System Properties:");
        System.out.println("=====================");
        
        props.forEach((key, value) -> {
            System.out.println(key + " = " + value);
        });
        
        System.out.println("\nTotal properties count: " + props.size());
    }
}
