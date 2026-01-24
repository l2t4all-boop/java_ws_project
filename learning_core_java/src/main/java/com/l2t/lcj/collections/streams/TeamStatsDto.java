package com.l2t.lcj.collections.streams;

import lombok.Data;

import java.util.Map;

@Data
public class TeamStatsDto {

        private Map<String,Integer> roleCount;
        private Map<Double,Integer> amountCount;
        private Map<String, Integer> countryCount;
}
