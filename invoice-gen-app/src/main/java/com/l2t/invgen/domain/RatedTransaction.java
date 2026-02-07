package com.l2t.invgen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RatedTransaction {
    private Integer id;
    private String userId;
    private String serviceId;
    private Integer units;
    private BigDecimal amount;
    private Boolean isBilled;
    private LocalDate txnDate;
    private BigDecimal unitPrice;
}