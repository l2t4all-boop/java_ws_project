package com.l2t.invgen.controller;

import com.l2t.invgen.service.DatabaseInitService;
import com.l2t.invgen.service.InvoiceService;
import com.l2t.invgen.service.RatingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final DatabaseInitService databaseInitService;
    private final RatingService ratingService;
    private final InvoiceService invoiceService;

    public AdminController(DatabaseInitService databaseInitService,
                          RatingService ratingService,
                          InvoiceService invoiceService) {
        this.databaseInitService = databaseInitService;
        this.ratingService = ratingService;
        this.invoiceService = invoiceService;
    }

    @PostMapping("/init")
    public ResponseEntity<Map<String, String>> initializeDatabase() {
        try {
            databaseInitService.initializeDatabase();
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Database initialized successfully"
            ));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of(
                "status", "error",
                "message", e.getMessage()
            ));
        }
    }

    @PostMapping("/rating")
    public ResponseEntity<Map<String, Object>> runRating() {
        try {
            int count = ratingService.runRating();
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Rating completed successfully",
                "ratedTransactions", count
            ));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of(
                "status", "error",
                "message", e.getMessage()
            ));
        }
    }

    @PostMapping("/generate-invoices")
    public ResponseEntity<Map<String, Object>> generateInvoices() {
        try {
            int count = invoiceService.generateInvoices();
            return ResponseEntity.ok(Map.of(
                "status", "success",
                "message", "Invoice generation completed successfully",
                "invoicesCreated", count
            ));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of(
                "status", "error",
                "message", e.getMessage()
            ));
        }
    }
}