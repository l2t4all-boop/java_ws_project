package com.l2t.lsj;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicObjectCreation {

    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        map.put("name","Krish");
        map.put("salary",5000);
        map.put("email","krish@gmail.com");

        // Simple approach -> convert map to json string and json employee object
        try {

            Employee employee = convertRowObject(map,Employee.class);
            System.out.println(employee);
        }catch (Exception e){
            e.printStackTrace();
        }

        List<Map<String,Object>> rows = new ArrayList<>();
        Map<String,Object> row1 = new HashMap<>();
        row1.put("name","Krish");
        row1.put("salary",5000);
        row1.put("email","krish@gmail.com");

        Map<String,Object> row2 = new HashMap<>();
        row2.put("name","Charan");
        row2.put("salary",8000);
        row2.put("email","charan@gmail.com");

        Map<String,Object> row3 = new HashMap<>();
        row3.put("name","Manoj");
        row3.put("salary",4000);
        row3.put("email","manoj@gmail.com");

        rows.add(row1);
        rows.add(row2);
        rows.add(row3);

        List<Employee> empList =
                rows.stream()
                        .map(ele -> convertRowObject(ele,Employee.class))
                        .toList();

        System.out.println(empList);


        Map<String,Object> proRow = new HashMap<>();
        proRow.put("name","iPhone 16 pro max");
        proRow.put("price",159000);

        Product product = convertRowObject(proRow,Product.class);
        System.out.println(product);

    }

    private static <T> T convertRowObject(Map<String, Object> map, Class<T> t){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = objectMapper.writeValueAsString(map);
            return objectMapper.readValue(jsonString, t);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

}
