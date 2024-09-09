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

## Longest Common Subsequence (LCS) - DP

1. **Recursive Approach**: Recursively compare characters from the end of both strings, adding to the LCS if they match, and explore both removal options if they don't.
2. **Memoization**: Store results of subproblems in a 2D memo array to avoid redundant calculations.
3. **Tabulation**: Build a DP table to track the LCS length at each step, iterating through both strings.
4. **Space Optimization**: Use two 1D arrays (current and previous row) instead of a full DP table to save space.
5. **Print LCS**: Backtrack through the DP table to construct and print the LCS string.

## Grid Unique Paths - DP

1. **Recursive Approach**: Start from the bottom-right corner and move either up or left, counting paths until you reach the top-left corner.
2. **Memoization**: Use a 2D memo table to store results of subproblems and avoid recalculating paths, speeding up the solution.
3. **Tabulation**: Build a DP table from the top-left corner, filling each cell with the sum of paths from the cell above and the cell to the left, returning the value in the bottom-right corner.

## Maximum Falling Path Sum - DP on Grids

1. **Recursive Approach**: Start from the last row, move upwards, and explore three possible paths (straight, left diagonal, right diagonal) for each cell. Return the maximum sum.
2. **Memoization**: Store intermediate results in a memo table to avoid recalculating values, improving the time complexity.
3. **Tabulation**: Build a DP table iteratively, where each cell stores the maximum path sum possible up to that point, and then return the maximum value from the last row.

## Top K Frequent Words

1. **Regular Approach**:
    - Count word frequencies using a hashmap.
    - Use a max-heap to sort words by frequency (alphabetically for ties).
    - Extract the top K frequent words from the heap.

2. **Memory Optimized**:
    - Count word frequencies.
    - Use a min-heap of size K to keep only the most frequent words, ensuring that less frequent words get removed.
    - Reverse the result at the end since the heap is in ascending order.