-- =========================================================================
-- DROP TABLES
-- =========================================================================
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS customers;

-- =========================================================================
-- CREATE TABLES
-- =========================================================================
CREATE TABLE customers (
    customer_id   INT PRIMARY KEY,
    customer_name VARCHAR(50) NOT NULL,
    city          VARCHAR(50)
);

CREATE TABLE products (
    product_id   INT PRIMARY KEY,
    product_name VARCHAR(50) NOT NULL,
    price        DECIMAL(10,2) NOT NULL
);

CREATE TABLE orders (
    order_id     INT PRIMARY KEY,
    customer_id  INT NOT NULL,
    order_date   DATE NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES customers(customer_id)
);

CREATE TABLE order_items (
    order_item_id INT PRIMARY KEY,
    order_id      INT NOT NULL,
    product_id    INT NOT NULL,
    quantity      INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES orders(order_id),
    FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- =========================================================================
-- INSERT DATA
-- =========================================================================
INSERT INTO customers (customer_id, customer_name, city) VALUES
    (1, 'Ravi Kumar',   'Bangalore'),
    (2, 'Anita Sharma', 'Mumbai'),
    (3, 'Rahul Verma',  'Delhi'),
    (4, 'Sneha Iyer',   'Chennai'),
    (5, 'Amit Singh',   'Hyderabad'),
    (6, 'Neha Patel',   'Ahmedabad');

INSERT INTO products (product_id, product_name, price) VALUES
    (101, 'Laptop',      55000.00),
    (102, 'Mobile',      25000.00),
    (103, 'Headphones',   2000.00),
    (104, 'Keyboard',     1500.00),
    (105, 'Mouse',         800.00),
    (106, 'Monitor',     12000.00);

INSERT INTO orders (order_id, customer_id, order_date) VALUES
    (1001, 1, '2024-01-10'),
    (1002, 2, '2024-01-12'),
    (1003, 1, '2024-01-15'),
    (1004, 3, '2024-01-18'),
    (1005, 4, '2024-01-20'),
    (1006, 2, '2024-01-22'),
    (1007, 5, '2024-01-25');

INSERT INTO order_items (order_item_id, order_id, product_id, quantity) VALUES
    (1,  1001, 101, 1),
    (2,  1001, 103, 2),
    (3,  1002, 102, 1),
    (4,  1003, 104, 1),
    (5,  1003, 103, 1),
    (6,  1004, 101, 1),
    (7,  1004, 105, 2),
    (8,  1005, 106, 1),
    (9,  1006, 102, 2),
    (10, 1007, 104, 1),
    (11, 1007, 105, 1);

-- =========================================================================
-- QUESTIONS
-- =========================================================================

-- Q1: Display all customers and their orders. Include customers who have not placed any orders.

-- Q2: List order id, order date, customer name, and customer city.

-- Q3: Display order details showing order id, product name, price, quantity, and total price per item.

-- Q4: Find the total order amount for each order.

-- Q5: Find the total amount spent by each customer.

-- Q6: Display customers who have placed more than one order.

-- Q7: Find the most expensive product that has been ordered.

-- Q8: Display products that have never been ordered.

-- Q9: Find the total sales amount for each product.

-- Q10: Display customer name, order id, order date, product name, and quantity. (Use all 4 tables)

-- Q11: Assign a ROW_NUMBER to each product based on price (highest price first).

-- Q12: Rank products based on price using DENSE_RANK.

-- Q13: Rank customers based on total spending using DENSE_RANK.

-- Q14: Display each customer's orders with a ROW_NUMBER per customer ordered by order date.
