package com.l2t.iplstats;

import com.l2t.iplstats.service.IplStatsService;
import com.l2t.iplstats.service.IplStatsServiceImpl;

import java.util.List;
import java.util.Map;

public class IplStatsManager {
    public static void main(String[] args) {

        IplStatsService iplStatsService = new IplStatsServiceImpl();

        List<String> teamLabels = iplStatsService.teamLabels();

        System.out.println("-".repeat(15) + " Team Labels " + "-".repeat(15));
        teamLabels
                .forEach(System.out::println);
        System.out.println("-".repeat(40));
        System.out.println("-".repeat(15) + " Team Amount(s) " + "-".repeat(15));

        Map<String,Double> teamAmounts = iplStatsService.getEachTeamAmountSpent();
        teamAmounts
                .forEach((key, value) -> System.out.println("Team " + key + " has spent " + value.longValue()));
        System.out.println("-".repeat(40));
    }
}
