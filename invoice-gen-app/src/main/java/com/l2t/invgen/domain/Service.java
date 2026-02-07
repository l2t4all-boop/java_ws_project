package com.l2t.invgen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private String serviceId;
    private String name;
    private BigDecimal unitPrice;
    private String unit;
}