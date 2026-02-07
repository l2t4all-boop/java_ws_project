 -- Users table
  CREATE TABLE users (
      user_id VARCHAR(10) PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      email VARCHAR(255) NOT NULL UNIQUE
  );

  -- Services table
  CREATE TABLE services (
      service_id VARCHAR(10) PRIMARY KEY,
      name VARCHAR(100) NOT NULL,
      unit_price DECIMAL(10, 2) NOT NULL,
      unit VARCHAR(50) NOT NULL
  );

  -- Usage Records table
  CREATE TABLE usage_records (
      id SERIAL PRIMARY KEY,
      user_id VARCHAR(10) NOT NULL REFERENCES users(user_id),
      service_id VARCHAR(10) NOT NULL REFERENCES services(service_id),
      units INTEGER NOT NULL,
      usage_date DATE NOT NULL
  );

    CREATE TABLE rated_transaction (
      id SERIAL PRIMARY KEY,
      user_id VARCHAR(10) NOT NULL REFERENCES users(user_id),
      service_id VARCHAR(10) NOT NULL REFERENCES services(service_id),
      units INTEGER NOT NULL,
      amount DECIMAL(12, 2) NOT NULL,
      is_billed BOOLEAN DEFAULT FALSE
  );


    CREATE TABLE invoice (
      id SERIAL PRIMARY KEY,
      invoice_number VARCHAR(50) NOT NULL UNIQUE,
      user_id VARCHAR(10) NOT NULL REFERENCES users(user_id),
      invoice_date DATE NOT NULL DEFAULT CURRENT_DATE,
      due_date DATE,
      total_amount DECIMAL(12, 2) NOT NULL
  );

     CREATE TABLE invoice_line_item (
      id SERIAL PRIMARY KEY,
      invoice_id INTEGER NOT NULL REFERENCES invoice(id),
      service_id VARCHAR(10) NOT NULL REFERENCES services(service_id),
      units INTEGER NOT NULL,
      unit_price DECIMAL(10, 2) NOT NULL,
      line_total DECIMAL(12, 2) NOT NULL
  );

    INSERT INTO users (user_id, name, email) VALUES
    ('U1', 'Rohan', 'rohan@gmail.com'),
    ('U2', 'Priya', 'priya@gmail.com'),
    ('U3', 'Arjun', 'arjun@gmail.com'),
    ('U4', 'Neha', 'neha@gmail.com'),
    ('U5', 'Vikram', 'vikram@gmail.com');


     INSERT INTO services (service_id, name, unit_price, unit) VALUES
    ('S1', 'API Calls', 0.05, 'request'),
    ('S2', 'Cloud Storage', 2.00, 'GB'),
    ('S3', 'SMS', 0.10, 'message'),
    ('S4', 'Email Service', 0.02, 'email'),
    ('S5', 'Video Streaming', 5.00, 'hour');


      INSERT INTO usage_records (user_id, service_id, units, usage_date) VALUES
    ('U1', 'S1', 300, '2025-12-05'),
    ('U2', 'S2', 4, '2025-12-07'),
    ('U3', 'S1', 500, '2025-12-10'),
    ('U4', 'S3', 40, '2025-12-15'),
    ('U5', 'S1', 200, '2025-12-20'),
    ('U1', 'S4', 60, '2025-12-28'),
    ('U1', 'S2', 5, '2026-01-03'),
    ('U2', 'S1', 250, '2026-01-06'),
    ('U3', 'S4', 120, '2026-01-10'),
    ('U4', 'S2', 8, '2026-01-15'),
    ('U5', 'S3', 30, '2026-01-20'),
    ('U2', 'S5', 1, '2026-01-27'),
    ('U1', 'S3', 25, '2026-02-02'),
    ('U2', 'S2', 6, '2026-02-06'),
    ('U3', 'S5', 2, '2026-02-10'),
    ('U4', 'S4', 140, '2026-02-14'),
    ('U5', 'S1', 180, '2026-02-20'),
    ('U1', 'S1', 350, '2026-02-26'),
    ('U1', 'S4', 90, '2026-03-03'),
    ('U2', 'S3', 35, '2026-03-06'),
    ('U3', 'S1', 450, '2026-03-10'),
    ('U4', 'S2', 9, '2026-03-14'),
    ('U5', 'S5', 2, '2026-03-18'),
    ('U2', 'S1', 300, '2026-03-25'),
     ('U1', 'S1', 300, '2025-12-05'),
        ('U2', 'S2', 4, '2025-12-07'),
        ('U3', 'S1', 500, '2025-12-10'),
        ('U4', 'S3', 40, '2025-12-15'),
        ('U5', 'S1', 200, '2025-12-20'),
        ('U1', 'S4', 60, '2025-12-28'),
        ('U1', 'S2', 5, '2026-01-03'),
        ('U2', 'S1', 250, '2026-01-06'),
        ('U3', 'S4', 120, '2026-01-10'),
        ('U4', 'S2', 8, '2026-01-15'),
        ('U5', 'S3', 30, '2026-01-20'),
        ('U2', 'S5', 1, '2026-01-27'),
        ('U1', 'S3', 25, '2026-02-02'),
        ('U2', 'S2', 6, '2026-02-06'),
        ('U3', 'S5', 2, '2026-02-10'),
        ('U4', 'S4', 140, '2026-02-14'),
        ('U5', 'S1', 180, '2026-02-20'),
        ('U1', 'S1', 350, '2026-02-26'),
        ('U1', 'S4', 90, '2026-03-03'),
        ('U2', 'S3', 35, '2026-03-06'),
        ('U3', 'S1', 450, '2026-03-10'),
        ('U4', 'S2', 9, '2026-03-14'),
        ('U5', 'S5', 2, '2026-03-18'),
        ('U2', 'S1', 300, '2026-03-25'),
         ('U3', 'S4', 120, '2026-01-10'),
                ('U4', 'S2', 8, '2026-01-15'),
                ('U5', 'S3', 30, '2026-01-20'),
                ('U2', 'S5', 1, '2026-01-27'),
                ('U1', 'S3', 25, '2026-02-02'),
                ('U2', 'S2', 6, '2026-02-06'),
                ('U3', 'S5', 2, '2026-02-10'),
                ('U4', 'S4', 140, '2026-02-14'),
                ('U5', 'S1', 180, '2026-02-20'),
                ('U1', 'S1', 350, '2026-02-26'),
                ('U1', 'S4', 90, '2026-03-03'),
                ('U2', 'S3', 35, '2026-03-06'),
                ('U3', 'S1', 450, '2026-03-10'),
                ('U4', 'S2', 9, '2026-03-14'),
                 ('U3', 'S4', 120, '2026-01-10'),
                        ('U4', 'S2', 8, '2026-01-15'),
                        ('U5', 'S3', 30, '2026-01-20'),
                        ('U2', 'S5', 1, '2026-01-27'),
                        ('U1', 'S3', 25, '2026-02-02'),
                        ('U2', 'S2', 6, '2026-02-06'),
                        ('U3', 'S5', 2, '2026-02-10'),
                        ('U4', 'S4', 140, '2026-02-14'),
                        ('U5', 'S1', 180, '2026-02-20'),
                        ('U1', 'S1', 350, '2026-02-26'),
                        ('U1', 'S4', 90, '2026-03-03'),
                        ('U2', 'S3', 35, '2026-03-06'),
                        ('U3', 'S1', 450, '2026-03-10'),
                        ('U4', 'S2', 9, '2026-03-14');

alter table rated_transaction add column if not exists txn_date date;
alter table invoice_line_item add column if not exists item_date date;
alter table rated_transaction add column if not exists unit_price DECIMAL(12, 2);