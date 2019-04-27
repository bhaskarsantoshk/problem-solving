# Write your MySQL query statement below
SELECT id, movie, description , rating
FROM cinema
WHERE id %2 != 0 and description != "boring"
ORDER BY rating DESC;