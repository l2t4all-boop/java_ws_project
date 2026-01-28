package com.l2t.iplstats.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.l2t.iplstats.domain.Player;

import java.util.List;

public final class JsonReaderUtil {

    private JsonReaderUtil() {

    }

    public static List<Player> getPlayersFromJsonFile() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(JsonReaderUtil.class.getResourceAsStream("/players.json"),
                    new TypeReference<List<Player>>() {
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
        throw new RuntimeException("While reading file there is an exception");
    }
}
