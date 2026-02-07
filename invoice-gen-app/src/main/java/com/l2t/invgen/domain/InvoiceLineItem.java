package com.l2t.invgen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceLineItem {
    private Integer id;
    private Integer invoiceId;
    private String serviceId;
    private Integer units;
    private BigDecimal unitPrice;
    private BigDecimal lineTotal;
    private LocalDate itemDate;
}