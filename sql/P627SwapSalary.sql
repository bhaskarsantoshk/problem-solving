# Write your MySQL query statement below
UPDATE salary 
SET sex = CASE sex
           WHEN "f" THEN "m"
           WHEN "m" THEN "f"
           END;