package com.l2t.invgen.controller;

import com.l2t.invgen.service.DatabaseInitService;
import com.l2t.invgen.service.InvoiceGenerationService;
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
    private final InvoiceGenerationService invoiceGenerationService;

    public AdminController(DatabaseInitService databaseInitService,
                          RatingService ratingService,
                          InvoiceGenerationService invoiceGenerationService) {
        this.databaseInitService = databaseInitService;
        this.ratingService = ratingService;
        this.invoiceGenerationService = invoiceGenerationService;
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
            int count = invoiceGenerationService.generateInvoices();
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