package com.l2t.invgen.service;

import com.l2t.invgen.dto.InvoiceItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class InvoiceService {

    private final JdbcTemplate jdbcTemplate;

    public InvoiceService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional
    public int generateInvoices() {
        log.info("Starting invoice generation...");

        // Step 1: Generate invoice items
        List<InvoiceItemDto> invoiceItems = generateInvoiceItems();

        if (invoiceItems.isEmpty()) {
            log.info("No unbilled transactions found. Skipping invoice generation.");
            return 0;
        }

        // Step 2: Create invoices from invoice items grouped by user_id and month
        Map<String, List<InvoiceItemDto>> groupedItems = invoiceItems.stream()
            .collect(Collectors.groupingBy(item -> item.getUserId() + "-" + item.getMonthKey()));

        int invoicesCreated = 0;
        for (Map.Entry<String, List<InvoiceItemDto>> entry : groupedItems.entrySet()) {
            List<InvoiceItemDto> items = entry.getValue();
            InvoiceItemDto firstItem = items.get(0);

            String invoiceNumber = "INV-" + firstItem.getUserId() + "-" + firstItem.getMonthKey();



            // Calculate total amount from items
            BigDecimal totalAmount = items.stream()
                .map(InvoiceItemDto::getLineTotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

            // Insert invoice
            jdbcTemplate.update(
                "INSERT INTO invoice (invoice_number, user_id, invoice_date, due_date, total_amount) VALUES (?, ?, ?, ?, ?)",
                invoiceNumber,
                firstItem.getUserId(),
                firstItem.getItemDate(),
                firstItem.getItemDate().plusDays(30),
                totalAmount
            );
            invoicesCreated++;

            // Get invoice id
            Integer invoiceId = jdbcTemplate.queryForObject(
                "SELECT id FROM invoice WHERE invoice_number = ?",
                Integer.class, invoiceNumber);

            // Insert invoice line items and link rated transactions
            for (InvoiceItemDto item : items) {
                jdbcTemplate.update(
                    "INSERT INTO invoice_line_item (invoice_id, service_id, units, unit_price, line_total, item_date) VALUES (?, ?, ?, ?, ?, ?)",
                    invoiceId,
                    item.getServiceId(),
                    item.getUnits(),
                    item.getUnitPrice(),
                    item.getLineTotal(),
                    item.getItemDate()
                );

                // Get the invoice line item id
                Integer lineItemId = jdbcTemplate.queryForObject(
                    """
                    SELECT id FROM invoice_line_item
                    WHERE invoice_id = ? AND service_id = ? AND item_date = ?
                    ORDER BY id DESC LIMIT 1
                    """,
                    Integer.class, invoiceId, item.getServiceId(), item.getItemDate()
                );

                // Link rated transactions with invoice line item and mark as billed
                int updated = jdbcTemplate.update(
                    """
                    UPDATE rated_transaction
                    SET is_billed = TRUE, invoice_line_item_id = ?
                    WHERE user_id = ? AND service_id = ?
                    AND TO_CHAR(DATE_TRUNC('month', txn_date), 'YYYYMM') = ?
                    AND is_billed = FALSE
                    """,
                    lineItemId,
                    item.getUserId(),
                    item.getServiceId(),
                    item.getMonthKey()
                );
                log.debug("Linked {} transactions to line_item_id={} for user={}, service={}, month={}",
                    updated, lineItemId, item.getUserId(), item.getServiceId(), item.getMonthKey());
            }
        }

        log.info("Created {} invoices with {} line items", invoicesCreated, invoiceItems.size());

        return invoicesCreated;
    }

    private List<InvoiceItemDto> generateInvoiceItems() {
        log.info("Generating invoice items from rated transactions...");

        String sql = """
            SELECT
                rt.user_id,
                rt.service_id,
                SUM(rt.units) AS units,
                rt.unit_price,
                SUM(rt.amount) AS line_total,
                (DATE_TRUNC('month', rt.txn_date) + INTERVAL '1 month - 1 day')::DATE AS item_date,
                TO_CHAR(DATE_TRUNC('month', rt.txn_date), 'YYYYMM') AS month_key
            FROM rated_transaction rt
            WHERE rt.is_billed = FALSE
            GROUP BY rt.user_id, rt.service_id, rt.unit_price, DATE_TRUNC('month', rt.txn_date)
            ORDER BY rt.user_id, DATE_TRUNC('month', rt.txn_date), rt.service_id
            """;

        RowMapper<InvoiceItemDto> rowMapper = (rs, rowNum) -> new InvoiceItemDto(
            rs.getString("user_id"),
            rs.getString("service_id"),
            rs.getInt("units"),
            rs.getBigDecimal("unit_price"),
            rs.getBigDecimal("line_total"),
            rs.getDate("item_date").toLocalDate(),
            rs.getString("month_key")
        );

        List<InvoiceItemDto> items = jdbcTemplate.query(sql, rowMapper);
        log.info("Generated {} invoice items", items.size());

        return items;
    }
}