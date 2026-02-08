package com.l2t.invgen.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceItemDto {
    private String userId;
    private String serviceId;
    private Integer units;
    private BigDecimal unitPrice;
    private BigDecimal lineTotal;
    private LocalDate itemDate;
    private String monthKey;
}