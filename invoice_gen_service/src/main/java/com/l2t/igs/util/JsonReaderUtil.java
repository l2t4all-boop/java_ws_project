package com.l2t.igs.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.l2t.igs.dto.UserServiceUsageDataDto;

public final class JsonReaderUtil {

    private JsonReaderUtil(){}

    public static UserServiceUsageDataDto loadDataFromJson(){
        try{
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper
                    .readValue(JsonReaderUtil.class.getResourceAsStream("/usage_service_user_data.json"),UserServiceUsageDataDto.class);
        }catch (Exception e){
           throw new RuntimeException(e);
        }
    }
}
