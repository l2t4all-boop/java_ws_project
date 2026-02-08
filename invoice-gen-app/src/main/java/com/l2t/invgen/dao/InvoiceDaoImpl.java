package com.l2t.invgen.dao;

import com.l2t.invgen.domain.InvoiceLineItem;
import com.l2t.invgen.dto.InvoiceDto;
import com.l2t.invgen.dto.InvoiceDtoRowMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class InvoiceDaoImpl implements InvoiceDao {

    private final JdbcTemplate jdbcTemplate;

    private final String ALL_INVOICES = """
            select
            	i.id,
            	i.invoice_number,
            	i.user_id,
            	u.name,
            	i.invoice_date,
            	i.due_date,
            	i.total_amount
            from
            	invoice i
            inner join users u on
            	i.user_id = u.user_id order by i.invoice_date;
            """;


    @Override
    public List<InvoiceDto> selectAllInvoices() {
        return jdbcTemplate
                .query(ALL_INVOICES, new InvoiceDtoRowMapper());
    }

    private final String INVOICE_BY_ID = """
            select
            	i.id,
            	i.invoice_number,
            	i.user_id,
            	u.name,
            	i.invoice_date,
            	i.due_date,
            	i.total_amount
            from
            	invoice i
            inner join users u on
            	i.user_id = u.user_id
            where i.id = ?
            """;

    @Override
    public InvoiceDto selectInvoiceById(Integer id) {
        return jdbcTemplate.queryForObject(INVOICE_BY_ID, new InvoiceDtoRowMapper(), id);
    }

    private final String LINE_ITEMS_BY_INVOICE = """
            select ili.id, ili.invoice_id, ili.service_id, ili.units,
                   ili.unit_price, ili.line_total, ili.item_date
            from invoice_line_item ili
            inner join invoice i on ili.invoice_id = i.id
            where i.invoice_number = ?
            """;

    @Override
    public List<InvoiceLineItem> selectInvoiceLineItems(String invoiceNum) {
        return jdbcTemplate.query(LINE_ITEMS_BY_INVOICE,
                (rs, rowNum) -> new InvoiceLineItem(
                        rs.getInt("id"),
                        rs.getInt("invoice_id"),
                        rs.getString("service_id"),
                        rs.getInt("units"),
                        rs.getBigDecimal("unit_price"),
                        rs.getBigDecimal("line_total"),
                        rs.getObject("item_date", LocalDate.class)
                ),
                invoiceNum);
    }
}

