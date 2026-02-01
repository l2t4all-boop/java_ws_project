-- =========================================================================
-- SQL SUBQUERIES ASSIGNMENT
-- =========================================================================

-- =========================================================================
-- DROP TABLES
-- =========================================================================
DROP TABLE IF EXISTS enrollments;
DROP TABLE IF EXISTS courses;
DROP TABLE IF EXISTS students;
DROP TABLE IF EXISTS departments;

-- =========================================================================
-- CREATE TABLES
-- =========================================================================
CREATE TABLE departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50) NOT NULL,
    budget DECIMAL(12,2)
);

CREATE TABLE students (
    student_id INT PRIMARY KEY,
    student_name VARCHAR(50) NOT NULL,
    dept_id INT,
    age INT,
    city VARCHAR(50),
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

CREATE TABLE courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(50) NOT NULL,
    dept_id INT,
    credits INT,
    fees DECIMAL(10,2),
    FOREIGN KEY (dept_id) REFERENCES departments(dept_id)
);

CREATE TABLE enrollments (
    enrollment_id INT PRIMARY KEY,
    student_id INT,
    course_id INT,
    enrollment_date DATE,
    marks INT,
    FOREIGN KEY (student_id) REFERENCES students(student_id),
    FOREIGN KEY (course_id) REFERENCES courses(course_id)
);

-- =========================================================================
-- INSERT DATA
-- =========================================================================
INSERT INTO departments (dept_id, dept_name, budget) VALUES
    (1, 'Computer Science', 5000000.00),
    (2, 'Electronics', 4500000.00),
    (3, 'Mechanical', 4000000.00),
    (4, 'Civil', 3500000.00),
    (5, 'Chemical', 3000000.00);

INSERT INTO students (student_id, student_name, dept_id, age, city) VALUES
    (101, 'Rahul Sharma', 1, 20, 'Delhi'),
    (102, 'Priya Singh', 1, 21, 'Mumbai'),
    (103, 'Amit Kumar', 2, 22, 'Bangalore'),
    (104, 'Sneha Patel', 2, 20, 'Ahmedabad'),
    (105, 'Vikram Reddy', 3, 23, 'Hyderabad'),
    (106, 'Anjali Gupta', 1, 21, 'Delhi'),
    (107, 'Rohan Mehta', 3, 22, 'Mumbai'),
    (108, 'Kavya Iyer', 4, 20, 'Chennai'),
    (109, 'Arjun Das', 2, 21, 'Kolkata'),
    (110, 'Pooja Verma', 1, 22, 'Pune');

INSERT INTO courses (course_id, course_name, dept_id, credits, fees) VALUES
    (201, 'Data Structures', 1, 4, 15000.00),
    (202, 'Database Systems', 1, 4, 15000.00),
    (203, 'Machine Learning', 1, 3, 20000.00),
    (204, 'Digital Electronics', 2, 4, 12000.00),
    (205, 'Microprocessors', 2, 3, 12000.00),
    (206, 'Thermodynamics', 3, 4, 10000.00),
    (207, 'Fluid Mechanics', 3, 3, 10000.00),
    (208, 'Structural Analysis', 4, 4, 11000.00),
    (209, 'Transportation Engineering', 4, 3, 11000.00),
    (210, 'Web Development', 1, 3, 18000.00);

INSERT INTO enrollments (enrollment_id, student_id, course_id, enrollment_date, marks) VALUES
    (1, 101, 201, '2024-01-10', 85),
    (2, 101, 202, '2024-01-10', 78),
    (3, 102, 201, '2024-01-11', 92),
    (4, 102, 203, '2024-01-11', 88),
    (5, 103, 204, '2024-01-12', 75),
    (6, 104, 204, '2024-01-12', 82),
    (7, 104, 205, '2024-01-12', 79),
    (8, 105, 206, '2024-01-13', 70),
    (9, 106, 201, '2024-01-14', 95),
    (10, 106, 210, '2024-01-14', 90),
    (11, 107, 206, '2024-01-15', 68),
    (12, 108, 208, '2024-01-16', 84),
    (13, 109, 205, '2024-01-17', 77),
    (14, 110, 202, '2024-01-18', 89),
    (15, 110, 210, '2024-01-18', 86);

-- =========================================================================
-- SUBQUERY QUESTIONS
-- =========================================================================

-- SINGLE ROW SUBQUERIES (Questions 1-5)
-- =========================================================================

-- Q1: Find all students who are older than the average age of all students.

-- Q2: Find the course with the highest fees.

-- Q3: Display students from the department that has the maximum budget.

-- Q4: Find enrollments where marks are greater than the average marks of all enrollments.

-- Q5: Display the student who scored the highest marks in any course.

-- MULTIPLE ROW SUBQUERIES (Questions 6-10)
-- =========================================================================

-- Q6: Find all students enrolled in 'Computer Science' department courses.

-- Q7: Display courses that have never been enrolled by any student.

-- Q8: Find students who are enrolled in more than one course.

-- Q9: List departments that offer courses with fees greater than 15000.

-- Q10: Find students who are NOT enrolled in any course.

-- CORRELATED SUBQUERIES (Questions 11-15)
-- =========================================================================

-- Q11: Find students whose age is greater than the average age of students in their own department.

-- Q12: Display courses where the fees are higher than the average fees of courses in the same department.

-- Q13: Find students who have scored above the average marks in their enrolled courses.

-- Q14: List departments where the budget is greater than the total fees of all courses in that department.

-- Q15: Find the top scorer in each department.

-- SUBQUERIES IN SELECT CLAUSE (Questions 16-20)
-- =========================================================================

-- Q16: Display student name along with the total number of courses they are enrolled in.

-- Q17: Show department name and the count of students in each department.

-- Q18: Display course name along with the average marks scored in that course.

-- Q19: Show student name and the highest marks they have scored.

-- Q20: Display department name and the total fees collected from all courses in that department.

-- SUBQUERIES WITH EXISTS (Questions 21-25)
-- =========================================================================

-- Q21: Find students who have enrolled in at least one course.

-- Q22: Display departments that have at least one student enrolled.

-- Q23: Find courses that have at least one enrollment.

-- Q24: Display students who have enrolled in courses from the 'Computer Science' department.

-- Q25: Find departments that do not have any students enrolled in their courses.

-- NESTED SUBQUERIES (Questions 26-30)
-- =========================================================================

-- Q26: Find students enrolled in courses offered by departments with budget greater than 4000000.

-- Q27: Display the name of the student who scored the highest marks in the course with maximum fees.

-- Q28: Find departments whose students have an average age greater than the overall average age.

-- Q29: List students from the department with the highest number of courses.

-- Q30: Find courses enrolled by students from the department with the maximum budget.

-- SUBQUERIES WITH IN/NOT IN (Questions 31-35)
-- =========================================================================

-- Q31: Find students enrolled in courses 'Data Structures' or 'Machine Learning'.

-- Q32: Display departments that do not offer any course with fees less than 12000.

-- Q33: Find students who are enrolled in all Computer Science courses.

-- Q34: List courses that are enrolled by students from 'Delhi' or 'Mumbai'.

-- Q35: Find students NOT enrolled in any Mechanical department courses.

-- SUBQUERIES WITH ANY/ALL (Questions 36-40)
-- =========================================================================

-- Q36: Find courses with fees greater than ANY course in the Mechanical department.

-- Q37: Display students whose marks are greater than ALL marks scored by students in the Civil department.

-- Q38: Find departments with budget less than ANY Electronics department course fees.

-- Q39: List courses with fees less than ALL Computer Science courses.

-- Q40: Find students who scored more than ANY student from the Chemical department.

-- ADVANCED SUBQUERIES (Questions 41-45)
-- =========================================================================

-- Q41: Find the second highest marks scored overall.

-- Q42: Display students who have scored marks in the top 20% of all marks.

-- Q43: Find departments where average student age is less than the overall average.

-- Q44: List the top 3 most expensive courses and students enrolled in them.

-- Q45: Find students who are enrolled in courses from at least 2 different departments.