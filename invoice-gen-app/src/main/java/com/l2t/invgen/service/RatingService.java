package com.l2t.invgen.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class RatingService {

    private final JdbcTemplate jdbcTemplate;

    @Transactional
    public int runRating() {
        log.info("Starting rating process...");

        // Delete existing rated transactions
        int deletedCount = jdbcTemplate.update("DELETE FROM rated_transaction");
        log.info("Deleted {} existing rated transactions", deletedCount);

        // Generate new rated transactions from usage_records
        String insertSql = """
            INSERT INTO rated_transaction (user_id, service_id, units, unit_price, amount, is_billed, txn_date)
            SELECT
                ur.user_id,
                ur.service_id,
                ur.units,
                s.unit_price,
                ur.units * s.unit_price AS amount,
                FALSE,
                ur.usage_date
            FROM usage_records ur
            JOIN services s ON ur.service_id = s.service_id
            """;

        int insertedCount = jdbcTemplate.update(insertSql);
        log.info("Generated {} new rated transactions", insertedCount);

        return insertedCount;
    }
}