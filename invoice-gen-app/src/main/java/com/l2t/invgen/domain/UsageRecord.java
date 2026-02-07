package com.l2t.invgen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsageRecord {
    private Integer id;
    private String userId;
    private String serviceId;
    private Integer units;
    private LocalDate usageDate;
}