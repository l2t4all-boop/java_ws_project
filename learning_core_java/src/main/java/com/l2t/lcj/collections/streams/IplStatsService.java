package com.l2t.lcj.collections.streams;

import java.util.List;
import java.util.Map;

public interface IplStatsService {
    List<String> getTeamNames();

    IplStatsDto getTeamAmountStats();

    List<Player> getMaxPaidPlayers(String team);

    Map<String, List<Player>> getMaxPaidPlayersOfEachRole(String team);

    List<Player> getAllPlayers(String team);

    TeamStatsDto getTeamStats(String team);
}
