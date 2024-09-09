## Job Sequencing Problem - Greedy

The problem was to maximize profit by scheduling jobs within their deadlines. I sorted jobs by profit in descending order and greedily allocated them to the latest possible day available before their deadline, keeping track of total profit and assigned jobs.

## Minimum Number of Platforms Required - Greedy

To solve this, I sorted the arrival and departure times separately. Then, I used two pointers to track overlapping trains and incremented or decremented the platform count accordingly. The maximum count gave the required number of platforms.

## Candy Distribution - Slope Approach

1. Start with one candy and iterate through the ratings.
2. For equal ratings, simply add 1 candy.
3. For increasing ratings, keep adding more candies as you go up the slope.
4. For decreasing ratings, add candies in reverse slope fashion, ensuring that the downhill sequence doesn't give more candies than the peak.
5. Adjust for cases where the downhill is longer than the peak by adding the difference.
6. Return the total sum of candies.

