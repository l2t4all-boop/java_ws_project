package com.l2t.igs.domain;

import lombok.Data;

@Data
public class Service {
    private String serviceId;
    private String name;
    private double unitPrice;
    private String unit;
}
