CREATE DATABASE employeedb;

USE employeedb;

CREATE TABLE employees (
    emp_id INT PRIMARY KEY,
    name VARCHAR(100),
    department VARCHAR(100),
    salary DECIMAL(10,2)
);

INSERT INTO employees VALUES
(1, 'Ahmed', 'IT', 50000.00),
(2, 'Rahul', 'HR', 45000.00),
(3, 'John', 'Finance', 55000.00);

SELECT * FROM employees;