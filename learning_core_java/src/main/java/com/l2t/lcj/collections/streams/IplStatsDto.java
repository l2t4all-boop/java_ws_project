package com.l2t.lcj.collections.streams;

import lombok.Data;

import java.util.Map;

@Data
public class IplStatsDto {
    private  Map<String,Double> teamAmount;
    private  Map<String,Integer> teamPlayerCount;
    private Map<String,Integer> rolePlayerCount;
}
