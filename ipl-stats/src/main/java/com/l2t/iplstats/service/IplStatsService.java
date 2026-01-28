package com.l2t.iplstats.service;

import com.l2t.iplstats.domain.Player;
import com.l2t.iplstats.dto.PlayerTeamAmountDto;

import java.util.List;
import java.util.Map;

public interface IplStatsService {

    List<String> teamLabels();
    List<Player> getPlayers(String teamLabel);
    Map<String,List<Player>> getAllPlayersOfEachTeam();
    Map<String,Double> getEachTeamAmountSpent();
    List<PlayerTeamAmountDto> getMaxPaidPlayers();

}
