package com.l2t.invgen.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class DatabaseInitService {

    private final JdbcTemplate jdbcTemplate;

    public DatabaseInitService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void initializeDatabase() {
        log.info("Starting database initialization...");
        try {
            ClassPathResource resource = new ClassPathResource("invoice_generation.sql");
            log.debug("Loading SQL script from: {}", resource.getPath());

            String sql = FileCopyUtils.copyToString(
                new InputStreamReader(resource.getInputStream(), StandardCharsets.UTF_8)
            );

            String[] statements = sql.split(";");
            int executedCount = 0;

            for (String statement : statements) {
                String trimmed = statement.trim();
                if (!trimmed.isEmpty() && !trimmed.startsWith("--")) {
                    log.debug("Executing statement: {}", trimmed.substring(0, Math.min(50, trimmed.length())) + "...");
                    jdbcTemplate.execute(trimmed);
                    executedCount++;
                }
            }

            log.info("Database initialization completed. Executed {} statements.", executedCount);
        } catch (Exception e) {
            log.error("Failed to initialize database: {}", e.getMessage(), e);
            throw new RuntimeException("Failed to initialize database: " + e.getMessage(), e);
        }
    }
}