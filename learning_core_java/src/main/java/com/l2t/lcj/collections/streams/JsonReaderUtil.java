package com.l2t.lcj.collections.streams;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public final class JsonReaderUtil {

    private JsonReaderUtil(){
        throw new UnsupportedOperationException("Utility class");
    }
    public static List<Player> readPlayersFromJson(){
       String  fileName = "ipl_players.json";
       try{
           ObjectMapper objectMapper = new ObjectMapper();
           return objectMapper.readValue(JsonReaderUtil
                   .class
                   .getClassLoader()
                   .getResourceAsStream(fileName) ,
                   new TypeReference<List<Player>>(){});
       }catch(Exception e){
           e.printStackTrace();
       }
        throw new RuntimeException("Failed to read players from json");
    }
}
