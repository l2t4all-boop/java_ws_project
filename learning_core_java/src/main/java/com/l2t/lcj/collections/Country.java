package com.l2t.lcj.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Country {
    private String commonName;
    private String officialName;
    private List<String> capital;
    private String region;
    private int area;
    private int population;
}
