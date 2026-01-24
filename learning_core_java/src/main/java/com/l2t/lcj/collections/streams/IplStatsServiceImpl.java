package com.l2t.lcj.collections.streams;

import java.util.List;
import java.util.Map;

public class IplStatsServiceImpl implements IplStatsService {

    private static final List<Player> players;

    static {
        players = JsonReaderUtil.readPlayersFromJson();
    }

    @Override
    public List<String> getTeamNames() {
        return List.of();
    }

    @Override
    public IplStatsDto getTeamAmountStats() {
        return null;
    }

    @Override
    public List<Player> getMaxPaidPlayers(String team) {
        return List.of();
    }

    @Override
    public Map<String, List<Player>> getMaxPaidPlayersOfEachRole(String team) {
        return Map.of();
    }

    @Override
    public List<Player> getAllPlayers(String team) {
        return List.of();
    }

    @Override
    public TeamStatsDto getTeamStats(String team) {
        return null;
    }
}
