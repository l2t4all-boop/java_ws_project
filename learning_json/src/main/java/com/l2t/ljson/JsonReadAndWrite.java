package com.l2t.ljson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonReadAndWrite {

    public static void main(String[] args) {
            String jsonStr = """
                    {
                       "name": "Krish",
                       "age":  "36",
                       "email": "krish.t@gmail.com"
                    }
                    """;
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            try {
                User user = objectMapper.readValue(jsonStr, User.class);
                System.out.println(user);
                String userJsonData = objectMapper.writeValueAsString(user);
                System.out.println(userJsonData);
            }catch (Exception e){
                e.printStackTrace();
            }
    }
}
