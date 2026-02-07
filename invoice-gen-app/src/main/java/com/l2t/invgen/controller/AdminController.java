package com.l2t.invgen.controller;

import com.l2t.invgen.service.DatabaseInitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    private final DatabaseInitService databaseInitService;

    public AdminController(DatabaseInitService databaseInitService) {
        this.databaseInitService = databaseInitService;
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
}