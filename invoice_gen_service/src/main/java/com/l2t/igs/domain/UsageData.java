package com.l2t.igs.domain;

import lombok.Data;

@Data
public class UsageData {
    private String userId;
    private String serviceId;
    private long units;
}
