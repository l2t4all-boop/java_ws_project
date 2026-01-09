package com.l2t.lcj.enumsandarrays;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class PlayerManager {

    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Player> players =
                    objectMapper.readValue(Player.class.getResourceAsStream("/players.json"),
                            new TypeReference<List<Player>>() {});

            List<String> teams = players
                    .stream()
                    .map(Player::getTeamLabel)
                    .distinct().toList();
            System.out.println(teams);

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
