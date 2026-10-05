USE studentdb;

CREATE TABLE students (
    roll_no INT PRIMARY KEY,
    name VARCHAR(100),
    course VARCHAR(100),
    marks DOUBLE
);

INSERT INTO students VALUES
(101, 'Ali', 'BTech CSE', 85),
(102, 'Rahul', 'BTech CSE', 78),
(103, 'John', 'BTech IT', 92);

SELECT * FROM students;