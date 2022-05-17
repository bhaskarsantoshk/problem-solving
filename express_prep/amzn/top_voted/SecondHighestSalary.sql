/*
## Second highest salary

* Employee TABLE:
+-------------+------+
| Column Name | Type |
+-------------+------+
| id          | int  |
| salary      | int  |
+-------------+------+
id is the primary key column for this table.
Each row of this table contains information about the salary of an employee.
*/

SELECT MAX(Salary) AS SecondHighestSalary FROM Employee WHERE Salary < ( SELECT MAX(Salary) FROM Employee);
