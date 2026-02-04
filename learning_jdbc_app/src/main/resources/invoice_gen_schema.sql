-- ============================================================================
-- Invoice Management System - Database Setup Script
-- Student Assignment
-- ============================================================================

-- Create Database (Run this first if database doesn't exist)
-- CREATE DATABASE invoice_db;

-- Connect to the database
-- \c invoice_db

-- ============================================================================
-- DROP EXISTING TABLES (For clean setup)
-- ============================================================================

DROP TABLE IF EXISTS invoices CASCADE;
DROP TABLE IF EXISTS usage_data CASCADE;
DROP TABLE IF EXISTS services CASCADE;
DROP TABLE IF EXISTS users CASCADE;

-- ============================================================================
-- CREATE TABLES
-- ============================================================================

-- Table 1: users
CREATE TABLE users (
    user_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    company VARCHAR(150)
);

-- Table 2: services
CREATE TABLE services (
    service_id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    code VARCHAR(50) NOT NULL UNIQUE,
    price DECIMAL(10, 2) NOT NULL
);

-- Table 3: usage_data
CREATE TABLE usage_data (
    usage_id SERIAL PRIMARY KEY,
    user_id VARCHAR(10) NOT NULL,
    service_id VARCHAR(10) NOT NULL,
    quantity INTEGER NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id),
    FOREIGN KEY (service_id) REFERENCES services(service_id)
);

-- Table 4: invoices
CREATE TABLE invoices (
    invoice_id SERIAL PRIMARY KEY,
    invoice_number VARCHAR(30) NOT NULL UNIQUE,
    user_id VARCHAR(10) NOT NULL,
    invoice_date DATE NOT NULL,
    subtotal DECIMAL(12, 2) NOT NULL,
    tax DECIMAL(12, 2) NOT NULL,
    total DECIMAL(12, 2) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- ============================================================================
-- INSERT SEED DATA
-- ============================================================================

-- Insert Users
INSERT INTO users (user_id, name, email, company) VALUES
('U1001', 'John Smith', 'john@techcorp.com', 'TechCorp Solutions'),
('U1002', 'Sarah Johnson', 'sarah@marketing.com', 'Marketing Pro'),
('U1003', 'Michael Chen', 'michael@digital.io', 'Digital Ventures'),
('U1004', 'Emily Rodriguez', 'emily@startup.com', 'StartupLab Inc'),
('U1005', 'David Park', 'david@cloud.net', 'Cloud Experts');

-- Insert Services
INSERT INTO services (service_id, name, code, price) VALUES
('S1001', 'Cloud Storage Pro', 'CLOUD-STORAGE-PRO', 15.99),
('S1002', 'Email Marketing Basic', 'EMAIL-MKT-BASIC', 29.99),
('S1003', 'Email Marketing Premium', 'EMAIL-MKT-PREMIUM', 79.99),
('S1004', 'API Calls - 1000 requests', 'API-CALLS-1K', 5.00),
('S1005', 'CDN Bandwidth - 100GB', 'CDN-BW-100GB', 12.50),
('S1006', 'Database Hosting', 'DB-HOST-STD', 45.00),
('S1007', 'SSL Certificate', 'SSL-CERT', 19.99),
('S1008', 'Video Streaming', 'VIDEO-STREAM-500H', 99.00),
('S1009', 'Support Premium', 'SUPPORT-PREMIUM', 149.00),
('S1010', 'Analytics Dashboard', 'ANALYTICS-DASH', 34.99);

-- Insert Usage Data
INSERT INTO usage_data (user_id, service_id, quantity) VALUES
('U1001', 'S1001', 2),
('U1001', 'S1004', 5),
('U1001', 'S1007', 1),

('U1002', 'S1002', 1),
('U1002', 'S1005', 3),
('U1002', 'S1010', 1),

('U1003', 'S1003', 1),
('U1003', 'S1006', 2),
('U1003', 'S1008', 1),
('U1003', 'S1009', 1),

('U1004', 'S1001', 1),
('U1004', 'S1004', 10),
('U1004', 'S1005', 2),

('U1005', 'S1002', 1),
('U1005', 'S1007', 3),
('U1005', 'S1010', 1);

-- ============================================================================
-- VERIFICATION QUERIES
-- ============================================================================

-- View all users
SELECT * FROM users;

-- View all services
SELECT * FROM services;

-- View all usage data
SELECT * FROM usage_data;

-- View usage with details (join query)
SELECT 
    u.user_id,
    u.name AS user_name,
    s.service_id,
    s.name AS service_name,
    ud.quantity,
    s.price,
    (ud.quantity * s.price) AS line_total
FROM usage_data ud
JOIN users u ON ud.user_id = u.user_id
JOIN services s ON ud.service_id = s.service_id
ORDER BY u.user_id;

-- Calculate expected invoice totals (for verification)
SELECT 
    u.user_id,
    u.name,
    u.company,
    SUM(ud.quantity * s.price) AS subtotal,
    ROUND(SUM(ud.quantity * s.price) * 0.10, 2) AS tax,
    ROUND(SUM(ud.quantity * s.price) * 1.10, 2) AS total
FROM usage_data ud
JOIN users u ON ud.user_id = u.user_id
JOIN services s ON ud.service_id = s.service_id
GROUP BY u.user_id, u.name, u.company
ORDER BY u.user_id;

-- ============================================================================
-- SETUP COMPLETE
-- ============================================================================

-- Verify table counts
SELECT 'Users' AS table_name, COUNT(*) AS record_count FROM users
UNION ALL
SELECT 'Services', COUNT(*) FROM services
UNION ALL
SELECT 'Usage Data', COUNT(*) FROM usage_data
UNION ALL
SELECT 'Invoices', COUNT(*) FROM invoices;
