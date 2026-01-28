package com.l2t.iplstats.service;

import com.l2t.iplstats.domain.Player;
import com.l2t.iplstats.dto.PlayerTeamAmountDto;
import com.l2t.iplstats.util.JsonReaderUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IplStatsServiceImpl implements IplStatsService {
    private static final List<Player> players;
    static {
        players = JsonReaderUtil.getPlayersFromJsonFile();
    }

    @Override
    public List<String> teamLabels() {
        return players
                .stream()
                .map(Player::getTeamLabel)
                .distinct()
                .toList();
    }

    @Override
    public List<Player> getPlayers(String teamLabel) {
        return List.of();
    }

    @Override
    public Map<String, List<Player>> getAllPlayersOfEachTeam() {
        return players
                .stream()
                .collect(Collectors.groupingBy(Player::getTeamLabel));
    }

    @Override
    public Map<String, Double> getEachTeamAmountSpent() {
        return
                players
                        .stream()
                        .collect(Collectors.groupingBy(
                                Player::getTeamLabel,
                                Collectors.summingDouble(Player::getAmount)
                        ));

    }

    @Override
    public List<PlayerTeamAmountDto> getMaxPaidPlayers() {
        return List.of();
    }

    private double maxAmount(){
        return 0;
    }
}
