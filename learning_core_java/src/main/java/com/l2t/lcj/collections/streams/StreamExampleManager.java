package com.l2t.lcj.collections.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamExampleManager {

    public static void main(String[] args) {

        List<Player> players = JsonReaderUtil.readPlayersFromJson();
        // Show all team names
        List<String> teamName =
                players
                        .stream()
                        .map(Player::getTeam)
                        .distinct()
                        .toList();
        System.out.println(teamName);


        // Stream map -> convert to different type

        List<String> names = List.of("John", "Jane", "Jack", "Jill","Krish");
        List<Integer> namesLength =
                names.stream()
                        .map(String::length)
                        .toList();


        // Get RCB players basic details

        List<PlayerBasicDetails> playerBasicDetails
                = players
                 .stream()
                .filter(p -> p.getTeam().equalsIgnoreCase("RCB"))
                .map(p -> new PlayerBasicDetails(p.getName(), p.getTeam(), p.getRole()))
                .toList();

        System.out.println(playerBasicDetails);

    }
}
