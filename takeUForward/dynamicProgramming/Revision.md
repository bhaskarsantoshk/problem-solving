## House Robber II - DP on Subsequences

Given a circular array of house values, I split it into two subsequences (excluding either the first or last house). I solved it by finding the max sum of non-adjacent elements for both subsequences using recursion, memoization, and tabulation.

## Frog Jump - DP

For this problem, the goal is to find the minimum energy required for the frog to jump to the last stone, where it can jump either one or two steps. I solved it using recursion, memoization, tabulation, and space-optimized DP to minimize energy at each step.

## Fractional Knapsack - Greedy

1. Sort items by value-to-weight ratio in descending order.
2. Add full items to the knapsack as long as there's enough capacity.
3. For the remaining capacity, take a fraction of the next item's value proportional to its weight.
4. Return the total maximum value that fits within the given weight limit.

## Ninja's Training Problem

1. Recursion: For each day, choose a task that wasn't chosen the previous day and maximize the merit points.
2. Memoization: Store previously computed results in a memo table to avoid recalculating and optimize performance.
3. Tabulation: Build a DP table to track the maximum merit points for each day and task, iterating from day 1 to n-1.
4. Return the maximum merit points possible on the last day, ensuring no repeated tasks from the previous day.