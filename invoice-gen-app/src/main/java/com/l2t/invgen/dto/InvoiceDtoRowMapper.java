package com.l2t.invgen.dto;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InvoiceDtoRowMapper implements RowMapper<InvoiceDto> {
    @Override
    public InvoiceDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return InvoiceDto
                .builder()
                .totalAmount(rs.getBigDecimal("total_amount"))
                .id(rs.getInt("id"))
                .invoiceNumber(rs.getString("invoice_number"))
                .userId(rs.getString("user_id"))
                .userName(rs.getString("name"))
                .invoiceDate(rs.getDate("invoice_date").toLocalDate())
                .dueDate(rs.getDate("due_date").toLocalDate())
                .build();
    }
}
