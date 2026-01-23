package com.l2t.lcj.collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();

        List<String> names = List.of("Krish", "Rajani", "Rajani", "Manohar", "Jayesh", "Siva Shankar", "Tanvi");

        for (String name : names) {
            map.put(name, name.length());
        }
        System.out.println(map);

        Map<Integer, String> map1 = new HashMap<>();
        map1.put(1, "Krish");
        map1.put(2, "Manoj");
        map1.put(1, "Charan");
        System.out.println(map1);

        System.out.println(map1.get(1));
        System.out.println(map1.get(10));

        map1.putIfAbsent(1,"Kalyan");

        if(map1.get(1) != null){
            map1.put(1,"Ram Charan");
        }

        System.out.println(map1.get(1));


        Map<String,Integer> map2 = new HashMap<>();

        map2.put("Ram",1);
        map2.put("Charn",1);

        if(map2.containsKey("Ram")){
            map2.put("Ram", map2.get("Ram")+1);
        }
        System.out.println(map2);
    }
}
